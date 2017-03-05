package com.liuhy.crm.coursetype.service;

import com.liuhy.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeService {
    /*
    * 第一个版本简单查询的用法，加了条件查询之后没用了
    * */
    @Deprecated
    List<CrmCourseType> findAll();

    List<CrmCourseType> findAll(CrmCourseType courseType);

    CrmCourseType findById(String courseTypeId);

    boolean addOrEdit(CrmCourseType courseType);
}
