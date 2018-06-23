package com.videoStudy.data.dao;

import com.videoStudy.data.model.ClassPay;
import com.videoStudy.data.model.PayDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassPayMapper {
    int insert(ClassPay classPay);
    //根据订单id修改订单状态
    int updateStatusById(@Param("status") int status, @Param("id") int id);
    //根据订单id获取订单
    ClassPay selectById(@Param("id") int id);
    //获取订单分页
    List<PayDetail> selectPage(@Param("beginRow") int beginRow, @Param("pageSize") int pageSize);
    //获取用户订单列表
    List<PayDetail> selectUserOrder(@Param("uid") int uid);
}
