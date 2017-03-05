package com.liuhy.crm.coursetype.action;

import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.coursetype.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

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

    /*
    * 跳转到添加课程页面
    * */
    public String addOrEditUI() {
        // 如果请求中带了id，说明是要编辑课程，而不是添加课程
        // 这样的话需要把要编辑的课程压入值栈用于回显
        if (!StringUtils.isBlank(courseType.getCourseTypeId())) {
            CrmCourseType course = courseTypeService.findById(courseType.getCourseTypeId());
            ActionContext.getContext().put("course", course);
        }
        return "addOrEdit_UI";
    }

    /*
    * 添加或编辑课程
    * */
    public String addOrEdit() {
        courseTypeService.addOrEdit(courseType);
        return "addOrEdit_success";
    }
}
