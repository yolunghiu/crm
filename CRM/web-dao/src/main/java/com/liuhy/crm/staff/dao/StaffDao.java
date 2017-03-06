package com.liuhy.crm.staff.dao;

import com.liuhy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface StaffDao {
    boolean add(CrmStaff staff);

    boolean update(CrmStaff staff);

    boolean delete(CrmStaff staff);

    CrmStaff findByName(String staffName);

    boolean isExists(CrmStaff staff);

    List<CrmStaff> findAll();

    CrmStaff findById(String id);
}
