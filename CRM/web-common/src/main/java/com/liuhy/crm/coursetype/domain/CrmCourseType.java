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

public class CrmCourseType {
    private String courseTypeId;
    private double courseCost;
    private int total;
    private String courseName;
    private String remark;

    /*
    * 下面的几个属性不持久化到数据库，而是在listCourse.jsp进行高级检索时传来的条件
    * 相当于将VO类融合到了这里
    * */
    private String totalMin;
    private String totalMax;
    private String costMin;
    private String costMax;

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

    public String getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(String totalMin) {
        this.totalMin = totalMin;
    }

    public String getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(String totalMax) {
        this.totalMax = totalMax;
    }

    public String getCostMin() {
        return costMin;
    }

    public void setCostMin(String costMin) {
        this.costMin = costMin;
    }

    public String getCostMax() {
        return costMax;
    }

    public void setCostMax(String costMax) {
        this.costMax = costMax;
    }
}
