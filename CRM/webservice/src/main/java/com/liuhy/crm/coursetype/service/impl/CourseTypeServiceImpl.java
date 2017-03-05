package com.liuhy.crm.coursetype.service.impl;

import com.liuhy.crm.coursetype.dao.CourseTypeDao;
import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.coursetype.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CourseTypeServiceImpl implements CourseTypeService {
    private CourseTypeDao courseTypeDao;

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Deprecated
    @Override
    public List<CrmCourseType> findAll() {
        return courseTypeDao.findAll();
    }

    @Override
    public List<CrmCourseType> findAll(CrmCourseType courseType) {
        // 查询条件
        String constraints = "";
        // 参数
        List<Object> params = new ArrayList<Object>();

        StringBuilder builder = new StringBuilder();
        // 判断课程名是否为空
        if (!StringUtils.isBlank(courseType.getCourseName())) {
            builder.append(" and courseName like ? ");
            params.add("%" + courseType.getCourseName() + "%");
        }
        // 判断课程介绍是否为空
        if (!StringUtils.isBlank(courseType.getRemark())) {
            builder.append(" and remark like ? ");
            params.add("%" + courseType.getRemark() + "%");
        }
        if (!StringUtils.isBlank(courseType.getTotalMin())) {
            builder.append(" and total >= ? ");
            params.add(courseType.getTotalMin());
        }
        if (!StringUtils.isBlank(courseType.getTotalMax())) {
            builder.append(" and total <= ? ");
            params.add(courseType.getTotalMax());
        }
        if (!StringUtils.isBlank(courseType.getCostMin())) {
            builder.append(" and courseCost >= ? ");
            params.add(courseType.getCostMin());
        }
        if (!StringUtils.isBlank(courseType.getCostMax())) {
            builder.append(" and courseCost <= ? ");
            params.add(courseType.getCostMax());
        }

        constraints = builder.toString();
        Object[] args = params.toArray();
        return courseTypeDao.findAll(constraints, args);
    }

    /*
    * 根据Id查询课程
    * */
    @Override
    public CrmCourseType findById(String courseTypeId) {
        return courseTypeDao.findById(courseTypeId);
    }

    /*
    * 添加或编辑course
    * */
    @Override
    public boolean addOrEdit(CrmCourseType courseType) {
        // 如果id是空的，说明是添加课程
        if (StringUtils.isBlank(courseType.getCourseTypeId())) {
            courseTypeDao.add(courseType);
        } else {
            courseTypeDao.update(courseType);
        }

        return true;
    }
}
