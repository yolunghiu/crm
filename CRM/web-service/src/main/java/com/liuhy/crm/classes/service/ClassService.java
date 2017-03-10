package com.liuhy.crm.classes.service;

import com.liuhy.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassService {
    List<CrmClasses> findAll();

    CrmClasses findById(String classId);

    void upload(CrmClasses crmClass);
}
