package com.liuhy.crm.department.service.impl;

import com.liuhy.crm.department.dao.DepartmentDao;
import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.department.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<CrmDepartment> findAll() {
        List<CrmDepartment> departments = null;
        departments = departmentDao.findAll(true);
        return departments;
    }
}
