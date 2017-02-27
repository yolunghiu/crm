package com.liuhy.crm.staff.dao.impl;

import com.liuhy.crm.staff.dao.StaffDao;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.liuhy.crm.utils.MD5Utils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StaffDaoImpl extends JdbcDaoSupport implements StaffDao {

    @Override
    public boolean add(CrmStaff staff) {
        return false;
    }

    @Override
    public boolean update(CrmStaff staff) {
        return false;
    }

    @Override
    public boolean delete(CrmStaff staff) {
        return false;
    }

    @Override
    public CrmStaff findByName(String staffName) {
        return null;
    }

    /*
    * 根据传来员工的登录名和密码判断其是否存在
    * */
    @Override
    public boolean isExists(CrmStaff staff) {
        // 获取加密后的密码
        String loginPwd = MD5Utils.getMD5Value(staff.getLoginPwd());

        Integer count = this.getJdbcTemplate()
                .queryForObject("SELECT COUNT(*) FROM crm_staff WHERE loginName=? AND loginPwd=?",
                        new String[]{staff.getLoginName(), loginPwd},
                        Integer.class);
        if (1 == count) {
            return true;
        }
        return false;
    }
}
