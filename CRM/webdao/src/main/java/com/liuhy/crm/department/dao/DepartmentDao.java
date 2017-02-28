package com.liuhy.crm.department.dao;

import com.liuhy.crm.department.domain.CrmDepartment;

public interface DepartmentDao {
    boolean add(CrmDepartment department);

    boolean update(CrmDepartment department);

    boolean delete(CrmDepartment department);

    CrmDepartment findById(String id);

}
