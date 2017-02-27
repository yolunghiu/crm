package com.liuhy.crm.coursetype.domain;

/*
    CREATE TABLE `crm_course_type` (
      `courseTypeId` varchar(255) NOT NULL PRIMARY KEY,
      `courseCost` double DEFAULT NULL,
      `total` int(11) DEFAULT NULL,
      `courseName` varchar(500) DEFAULT NULL,
      `remark` varchar(5000) DEFAULT NULL
    );
* */

import com.liuhy.crm.classes.domain.CrmClasses;

import java.util.HashSet;
import java.util.Set;

public class CrmCourseType {
    private String courseTypeId;
    private double courseCost;
    private int total;
    private String courseName;
    private String remark;

    private Set<CrmClasses> classSet = new HashSet<CrmClasses>();

    public Set<CrmClasses> getClassSet() {
        return classSet;
    }

    public void setClassSet(Set<CrmClasses> classSet) {
        this.classSet = classSet;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(double courseCost) {
        this.courseCost = courseCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
