package com.liuhy.crm.coursetype.dao.impl;

import com.liuhy.crm.coursetype.dao.CourseTypeDao;
import com.liuhy.crm.coursetype.domain.CrmCourseType;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseTypeDaoImpl extends JdbcDaoSupport implements CourseTypeDao {

    @Deprecated
    @Override
    public List<CrmCourseType> findAll() {
        List<CrmCourseType> courses = new ArrayList<CrmCourseType>(0);

        // 返回 List<Map<String,Object>>
        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_course_type");
        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmCourseType course = new CrmCourseType();
            course.setCourseCost((Double) row.get("courseCost"));
            course.setCourseName((String) row.get("courseName"));
            course.setCourseTypeId((String) row.get("courseTypeId"));
            course.setRemark((String) row.get("remark"));

            courses.add(course);
        }

        return courses;
    }

    @Override
    public List<CrmCourseType> findAll(String constraints, Object... args) {
        List<CrmCourseType> courses = new ArrayList<CrmCourseType>(0);

        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_course_type WHERE 1=1 " + constraints, args);
        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmCourseType course = new CrmCourseType();
            course.setCourseCost((Double) row.get("courseCost"));
            course.setCourseName((String) row.get("courseName"));
            course.setTotal((Integer) row.get("total"));
            course.setCourseTypeId((String) row.get("courseTypeId"));
            course.setRemark((String) row.get("remark"));

            courses.add(course);
        }

        return courses;
    }
}
