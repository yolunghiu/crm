package com.liuhy.crm.staff.service.impl;

import com.liuhy.crm.staff.dao.StaffDao;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.liuhy.crm.staff.service.StaffService;

import java.util.List;

public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public boolean addStaff(CrmStaff staff) {
        return false;
    }

    @Override
    public boolean updateStaff(CrmStaff staff) {
        staffDao.update(staff);
        return true;
    }

    @Override
    public boolean deleteStaff(CrmStaff staff) {
        return false;
    }

    @Override
    public CrmStaff findStaff(String staffName) {
        return null;
    }

    /*
    * 判断传来的员工是否可以登录
    * */
    @Override
    public boolean login(CrmStaff staff) {
        boolean exists = staffDao.isExists(staff);
        if (exists)
            return true;
        else
            return false;
    }

    /*
    * 查询所有员工
    * */
    @Override
    public List<CrmStaff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public CrmStaff findStaffById(String id) {
        return staffDao.findById(id);
    }

}
