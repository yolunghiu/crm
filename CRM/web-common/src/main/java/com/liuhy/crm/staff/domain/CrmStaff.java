package com.liuhy.crm.staff.domain;

/*
    CREATE TABLE `crm_staff` (
      `staffId` varchar(255) NOT NULL PRIMARY KEY,
      `loginName` varchar(100) DEFAULT NULL,
      `loginPwd` varchar(100) DEFAULT NULL,
      `staffName` varchar(100) DEFAULT NULL,
      `gender` varchar(20) DEFAULT NULL,
      `onDutyDate` datetime DEFAULT NULL,
      `postId` varchar(255) DEFAULT NULL,
      CONSTRAINT FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
    );
* */

import com.liuhy.crm.post.domain.CrmPost;

import java.util.Date;

public class CrmStaff {
    private String staffId;
    private String loginName;
    private String loginPwd;
    private String gender;
    private Date onDutyDate;
    private String staffName;

    private CrmPost post;   // 一个员工对应一个职务


    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public CrmPost getPost() {
        return post;
    }

    public void setPost(CrmPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "CrmStaff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                ", staffName='" + staffName + '\'' +
                ", post=" + post +
                '}';
    }
}
