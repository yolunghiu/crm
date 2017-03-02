package com.liuhy.crm.staff.dao.impl;

import com.liuhy.crm.staff.dao.StaffDao;
import com.liuhy.crm.staff.domain.CrmStaff;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by liuhy on 2017/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoBeans.xml")
public class TestStaffDao {
    private StaffDao staffDao;

    @Autowired
    @Qualifier("staffDao")
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Test
    public void testIsExists() {
        CrmStaff falseStaff = new CrmStaff();
        falseStaff.setLoginName("aaa");
        falseStaff.setLoginPwd("aaa");

        CrmStaff trueStaff = new CrmStaff();
        trueStaff.setLoginName("jack");
        trueStaff.setLoginPwd("81dc9bdb52d04dc20036dbd8313ed055");

        Assert.assertEquals(false, staffDao.isExists(falseStaff));
        Assert.assertEquals(true, staffDao.isExists(trueStaff));
    }

    @Test
    public void testFindAll() {
        List<CrmStaff> all = staffDao.findAll();

        System.out.println(all.get(0));
    }

    @Test
    public void testFindById() {
        System.out.println(staffDao.findById("1"));
    }

}
