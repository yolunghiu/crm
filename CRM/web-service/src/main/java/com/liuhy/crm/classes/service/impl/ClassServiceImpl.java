package com.liuhy.crm.classes.service.impl;

import com.liuhy.crm.classes.dao.ClassDao;
import com.liuhy.crm.classes.domain.CrmClasses;
import com.liuhy.crm.classes.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<CrmClasses> findAll() {
        return classDao.findAll();
    }

    @Override
    public CrmClasses findById(String classId) {
        return classDao.findById(classId);
    }

    @Override
    public void upload(CrmClasses crmClass) {
        classDao.updateUpload(crmClass);
    }
}
