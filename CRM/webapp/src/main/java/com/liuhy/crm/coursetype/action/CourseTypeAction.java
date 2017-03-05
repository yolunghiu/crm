package com.liuhy.crm.coursetype.action;

import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {

    private CrmCourseType courseType = new CrmCourseType();
    private CourseTypeService courseTypeService;

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    @Override
    public CrmCourseType getModel() {
        return courseType;
    }

    /*
    * 查询所有课程类别
    * */
    public String listAll() {
        /*
        * 简单查询
        * */
        // List<CrmCourseType> allCourses = courseTypeService.findAll();

        /*
        * 条件查询，如果没有条件就是简单查询
        * */
        List<CrmCourseType> allCourses = courseTypeService.findAll(courseType);
        ActionContext.getContext().put("allCourses", allCourses);

        return "list_course";
    }
}
