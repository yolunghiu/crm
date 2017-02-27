package com.liuhy.crm.staff.service;

import com.liuhy.crm.staff.domain.CrmStaff;

public interface StaffService {
    boolean addStaff(CrmStaff staff);

    boolean updateStaff(CrmStaff staff);

    boolean deleteStaff(CrmStaff staff);

    CrmStaff findStaff(String staffName);

    boolean login(CrmStaff staff);

}
