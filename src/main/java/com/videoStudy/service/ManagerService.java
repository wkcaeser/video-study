package com.videoStudy.service;

import com.videoStudy.data.dao.ClassPayMapper;
import com.videoStudy.data.dao.LicenseMapper;
import com.videoStudy.data.dao.UsersMapper;
import com.videoStudy.data.model.License;
import com.videoStudy.data.model.LicenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private final UsersMapper usersMapper;
    private final ClassPayMapper classPayMapper;
    private final LicenseMapper licenseMapper;
    @Autowired
    public ManagerService(UsersMapper usersMapper, ClassPayMapper classPayMapper, LicenseMapper licenseMapper) {
        this.usersMapper = usersMapper;
        this.classPayMapper = classPayMapper;
        this.licenseMapper = licenseMapper;
    }

    //修改订单状态
    public String changeOrderStatusById(int status, int id){
        int st = classPayMapper.updateStatusById(status, id);
        if(st>0)
            return "SUCCESS";
        else
            return "ERROR";
    }

    //获取证书申请列表
    public List<LicenseDetail> getLicensePage(int beginRow, int pageSize){
        return licenseMapper.selectPage(beginRow, pageSize);
    }

    //修改证书申请状态----发放证书
    public int changeLicenseStatus(int status, int id){
        return licenseMapper.update(status, id);
    }
}
