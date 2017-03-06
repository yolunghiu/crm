package com.liuhy.crm.department.service;

import com.liuhy.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentService {
    List<CrmDepartment> findAll();
}
