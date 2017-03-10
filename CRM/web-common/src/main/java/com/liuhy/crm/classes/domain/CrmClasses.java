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
    private String name;
    private Date beginTime;
    private Date endTime;
    private String status;
    private Integer totalCount;
    private Integer upgradeCount;
    private Integer changeCount;
    private Integer runoffCount;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
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

    @Override
    public String toString() {
        return "CrmClasses{" +
                "classId='" + classId + '\'' +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", courseType=" + courseType +
                '}';
    }
}
