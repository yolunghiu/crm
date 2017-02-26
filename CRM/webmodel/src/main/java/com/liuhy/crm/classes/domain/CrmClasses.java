package com.liuhy.crm.classes.domain;

/*
    CREATE TABLE `crm_classes` (
      `classId` varchar(50) NOT NULL PRIMARY KEY,
      `courseTypeId` varchar(255) DEFAULT NULL,
      `name` varchar(50) DEFAULT NULL,
      `beginTime` datetime DEFAULT NULL,
      `endTime` datetime DEFAULT NULL,
      `status` varchar(20) DEFAULT NULL,
      `totalCount` int(11) DEFAULT NULL,
      `upgradeCount` int(11) DEFAULT NULL,
      `changeCount` int(11) DEFAULT NULL,
      `runoffCount` int(11) DEFAULT NULL,
      `remark` varchar(500) DEFAULT NULL,
      `uploadTime` datetime DEFAULT NULL,
      `uploadPath` varchar(200) DEFAULT NULL,
      `uploadFilename` varchar(100) DEFAULT NULL,
      CONSTRAINT FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`)
    );
* */

import com.liuhy.crm.coursetype.domain.CrmCourseType;

import java.util.Date;

public class CrmClasses {
    private String classId;
    private String courseTypeId;
    private String name;
    private Date beginTime;
    private Date endTime;
    private String status;
    private int totalCount;
    private int upgradeCount;
    private int changeCount;
    private int runoffCount;
    private String remark;
    private Date uploadTime;
    private String uploadPath;
    private String uploadFileName;

    private CrmCourseType courseType;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public CrmCourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CrmCourseType courseType) {
        this.courseType = courseType;
    }
}
