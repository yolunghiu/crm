package com.liuhy.dao.impl;

import com.liuhy.dao.UserDao;
import com.liuhy.crm.department.domain.CrmDepartment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuhy on 2017/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoBeans.xml")
public class TestUserDao {

    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    public void testSave() {
        CrmDepartment user = new CrmDepartment();
        user.setUsername("mashiyu");
        user.setPassword("111");
        userDao.save(user);
    }
}
