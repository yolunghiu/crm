package com.liuhy.crm.staff.service.impl;

import com.liuhy.crm.staff.dao.StaffDao;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.liuhy.crm.staff.service.StaffService;

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
        return false;
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

}
