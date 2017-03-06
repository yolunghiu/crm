package com.liuhy.crm.coursetype.dao;

import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.page.PageBean;

import java.util.List;

public interface CourseTypeDao {

    @Deprecated
    List<CrmCourseType> findAll();

    @Deprecated
    List<CrmCourseType> findAll(String constraints, Object... args);

    /**
     * 查找所有的课程并返回分页数据
     *
     * @param currentPage 当前页码
     * @param pageSize    每页显示的记录数
     * @param constraints 查询条件
     * @param args        查询参数
     * @return 带有分页数据的查询结果
     */
    PageBean<CrmCourseType> findAll(int currentPage, int pageSize, String constraints, Object[] args);

    /**
     * 根据Id查询课程
     *
     * @param courseTypeId 课程id
     */
    CrmCourseType findById(String courseTypeId);

    /**
     * 添加课程
     *
     * @param courseType 课程id
     */
    boolean add(CrmCourseType courseType);

    boolean update(CrmCourseType courseType);
}
