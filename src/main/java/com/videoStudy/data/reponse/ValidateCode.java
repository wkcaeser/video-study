package com.videoStudy.data.reponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class ValidateCode {
    private String code;
    private BufferedImage image;
    private boolean hasUse;

    public ValidateCode(String code,BufferedImage image)
    {
        this.code=code;
        this.image=image;
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(image, "png", sos);
        sos.close();
    }

    public String getCode() {
        return code;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean getHasUse()
    {
        return hasUse;
    }

    public void setHasUse(boolean hasUse)
    {
        this.hasUse=hasUse;
    }
}
