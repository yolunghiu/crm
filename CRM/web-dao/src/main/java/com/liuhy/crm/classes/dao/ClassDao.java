package com.liuhy.crm.classes.dao;

import com.liuhy.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassDao {
    List<CrmClasses> findAll();

    CrmClasses findById(String classId);

    void updateUpload(CrmClasses crmClass);
}
