package com.videoStudy.service;

import com.videoStudy.data.dao.ClassPayMapper;
import com.videoStudy.data.model.ClassPay;
import com.videoStudy.data.model.PayDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final ClassPayMapper classPayMapper;

    @Autowired
    public OrderService(ClassPayMapper classPayMapper) {
        this.classPayMapper = classPayMapper;
    }

    //获取订单分页
    public List<PayDetail> getOrderPage(int beginRow, int page){
        return classPayMapper.selectPage(beginRow, page);
    }

    //添加订单
    public String addNewOrder(int classId, int uid){
        ClassPay classPay = new ClassPay();
        classPay.setClassId(classId);
        classPay.setUid(uid);
        classPay.setTime(new Date());
        classPay.setNumber(1);
        int st = classPayMapper.insert(classPay);
        if(st > 0)
            return "SUCCESS";
        else
            return "ERROR";
    }

    //获取相应用户订单列表
    public List<PayDetail> getUserOrderList(int uid){
        return classPayMapper.selectUserOrder(uid);
    }
}
