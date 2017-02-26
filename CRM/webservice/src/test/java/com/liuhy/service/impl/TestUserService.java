package com.liuhy.service.impl;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.service.UserService;
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
@ContextConfiguration("classpath:serviceBeans.xml")
public class TestUserService {
    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testAddUser() {
        CrmDepartment user = new CrmDepartment();
        user.setUsername("zhangsan");
        user.setPassword("123");

        userService.addUser(user);
    }
}
