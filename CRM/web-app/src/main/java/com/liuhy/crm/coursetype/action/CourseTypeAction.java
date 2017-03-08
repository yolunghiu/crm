package com.liuhy.crm.coursetype.action;

import com.liuhy.crm.base.BaseAction;
import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.coursetype.service.CourseTypeService;
import com.liuhy.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

public class CourseTypeAction extends BaseAction<CrmCourseType> {

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
        // List<CrmCourseType> allCourses = courseTypeService.findAll(courseType);
        // ActionContext.getContext().put("allCourses", allCourses);

        /*
        * 带分页的条件查询
        * */
        PageBean<CrmCourseType> allCourses = super.getCourseTypeService().findAll(this.getModel(), this.getCurrentPage(), this.getPageSize());
        super.put("allCourses", allCourses);

        return "list_course";
    }

    /*
    * 跳转到添加课程页面
    * */
    public String addOrEditUI() {
        // 如果请求中带了id，说明是要编辑课程，而不是添加课程
        // 这样的话需要把要编辑的课程压入值栈用于回显
        if (!StringUtils.isBlank(this.getModel().getCourseTypeId())) {
            CrmCourseType course = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
            this.put("course", course);
        }
        return "addOrEdit_UI";
    }

    /*
    * 添加或编辑课程
    * */
    public String addOrEdit() {
        this.getCourseTypeService().addOrEdit(this.getModel());
        return "addOrEdit_success";
    }
}
