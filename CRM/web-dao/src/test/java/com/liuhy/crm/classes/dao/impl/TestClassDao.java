package com.liuhy.crm.classes.dao.impl;

import com.liuhy.crm.classes.dao.ClassDao;
import com.liuhy.crm.classes.domain.CrmClasses;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoBeans.xml")
public class TestClassDao {
    private ClassDao classDao;

    @Autowired
    @Qualifier("classDao")
    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Test
    public void testFindById() {
        CrmClasses crmClasses = classDao.findById("2c9091c14c78e58b014c78e8cc62000a");
        System.out.println(crmClasses);
    }
}
