package com.liuhy.crm.coursetype.dao;

import com.liuhy.crm.coursetype.domain.CrmCourseType;

import java.util.List;

public interface CourseTypeDao {

    @Deprecated
    List<CrmCourseType> findAll();

    List<CrmCourseType> findAll(String constraints, Object... args);

    CrmCourseType findById(String courseTypeId);

    boolean add(CrmCourseType courseType);

    boolean update(CrmCourseType courseType);
}
