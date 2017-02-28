package com.liuhy.crm.department.dao.impl;


import com.liuhy.crm.department.dao.DepartmentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoBeans.xml")
public class TestDepartmetnDao {
    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Test
    public void testFindById() {
        System.out.println(departmentDao.findById("2c9091c14c78e58b014c78e67de10001"));
    }
}
