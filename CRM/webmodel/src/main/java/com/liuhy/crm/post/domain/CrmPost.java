package com.liuhy.crm.post.domain;

/*
    CREATE TABLE `crm_post` (
      `postId` varchar(255) NOT NULL PRIMARY KEY,
      `postName` varchar(100) DEFAULT NULL,
      `depId` varchar(255) DEFAULT NULL,
      CONSTRAINT FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
    );
* */


import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.staff.domain.CrmStaff;

import java.util.HashSet;
import java.util.Set;

public class CrmPost {
    private String postId;
    private String postName;
    private String depId;

    private CrmDepartment department;   // 一个职务对应一个部门
    private Set<CrmStaff> staffSet = new HashSet<CrmStaff>(0);     // 一个职务对应多个员工

    public Set<CrmStaff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<CrmStaff> staffSet) {
        this.staffSet = staffSet;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public CrmDepartment getDepartment() {
        return department;
    }

    public void setDepartment(CrmDepartment department) {
        this.department = department;
    }
}
