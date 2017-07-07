package com.videoStudy.service;

import com.videoStudy.data.reponse.ValidateCode;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service
public class ValidateCodeFactory {
    // 图片的宽度。
    private int width;
    // 图片的高度。
    private int height;
    // 验证码字符个数
    private int codeCount;
    // 验证码干扰线数
    private int lineCount;

    // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private ValidateCode validateCode;

    /**
     * 默认构造函数,设置默认参数
     */
    public ValidateCodeFactory() {
        setPropertiesToDefault();
        validateCode=createCode();
    }

    private void setPropertiesToDefault()
    {
        setWidth(120);
        setHeight(40);
        setCodeCount(5);
        setLineCount(100);
    }

    private ValidateCode createCode() {
        int x, fontHeight, codeY;
        int red, green, blue;

        x = width / (codeCount + 2);//每个字符的宽度(左右各空出一个字符)
        fontHeight = height - 2;//字体的高度
        codeY = height - 4;

        // 图像buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 生成随机数
        Random random = new Random();
        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // 创建字体,可以修改为其它的
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
//        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);
        g.setFont(font);

        for (int i = 0; i < lineCount; i++) {
            // 设置随机开始和结束坐标
            int xs = random.nextInt(width);//x坐标开始
            int ys = random.nextInt(height);//y坐标开始
            int xe = xs + random.nextInt(width / 8);//x坐标结束
            int ye = ys + random.nextInt(height / 8);//y坐标结束

            // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs, ys, xe, ye);
        }

        // randomCode记录随机产生的验证码
        StringBuilder randomCode = new StringBuilder();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x, codeY);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        String code = randomCode.toString();
        return new ValidateCode(code,buffImg);
    }

    public void refresh()
    {
        if(!validateCode.getHasUse()) return;
        validateCode=createCode();
    }

    public ValidateCode getValidateCode()
    {
        validateCode.setHasUse(true);
        return validateCode;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCodeCount() {
        return codeCount;
    }

    public int getLineCount() {
        return lineCount;
    }

}
