package com.liuhy.crm.staff.dao;

import com.liuhy.crm.staff.domain.CrmStaff;

public interface StaffDao {
    boolean add(CrmStaff staff);

    boolean update(CrmStaff staff);

    boolean delete(CrmStaff staff);

    CrmStaff findByName(String staffName);

    boolean isExists(CrmStaff staff);
}
