package com.liuhy.crm.coursetype.service;

import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.page.PageBean;

import java.util.List;

public interface CourseTypeService {
    /*
    * 第一个版本简单查询的用法，加了条件查询之后没用了
    * */
    @Deprecated
    List<CrmCourseType> findAll();

    /*
    * 第二个版本，加了条件查询的方法
    * 将被第三个版本的带分页的方法替换
    * */
    @Deprecated
    List<CrmCourseType> findAll(CrmCourseType courseType);

    /*
    * 第三个版本，带查询条件，且返回分页数据的查询所有
    * */
    PageBean<CrmCourseType> findAll(CrmCourseType courseType, int currentPage, int pageSize);

    /*
    * 根据Id查询课程
    * */
    CrmCourseType findById(String courseTypeId);

    /*
    * 添加或编辑course
    * */
    boolean addOrEdit(CrmCourseType courseType);
}
