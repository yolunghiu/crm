package com.liuhy.crm.department.dao;

import com.liuhy.crm.department.domain.CrmDepartment;

import java.util.List;

public interface DepartmentDao {
    boolean add(CrmDepartment department);

    boolean update(CrmDepartment department);

    boolean delete(CrmDepartment department);

    CrmDepartment findById(String id);

    /*
    * cascadeQueryCrmPost: 是否级联查询出每个部门下属的所有职位信息
    * */
    List<CrmDepartment> findAll(boolean cascadeQueryCrmPost);
}
