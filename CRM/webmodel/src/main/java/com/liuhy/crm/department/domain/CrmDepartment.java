package com.liuhy.crm.department.domain;

/*
    CREATE TABLE `crm_department` (
      `depId` varchar(255) NOT NULL PRIMARY KEY,
      `depName` varchar(50) DEFAULT NULL
    );
* */


import com.liuhy.crm.post.domain.CrmPost;

import java.util.Set;

public class CrmDepartment {
    private String depId;
    private String depName;

    private Set<CrmPost> postSet;   // 一个部门对应多个职务

    public Set<CrmPost> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<CrmPost> postSet) {
        this.postSet = postSet;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
