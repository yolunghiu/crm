package com.liuhy.crm.coursetype.dao.impl;

import com.liuhy.crm.coursetype.dao.CourseTypeDao;
import com.liuhy.crm.coursetype.domain.CrmCourseType;
import com.liuhy.crm.page.PageBean;
import com.liuhy.crm.utils.DBUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.lang.annotation.Inherited;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    @Deprecated
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

    @Override
    public PageBean<CrmCourseType> findAll(int currentPage, int pageSize, String constraints, Object[] args) {
        PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(currentPage, pageSize, DBUtils.getTotalRecrods("crm_course_type", this.getJdbcTemplate()));

        // 拼接mysql分页语句
        String limitSql = " LIMIT " + pageBean.getStartIndex() + "," + pageSize;

        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_course_type WHERE 1=1 " + constraints + limitSql, args);
        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmCourseType course = new CrmCourseType();
            course.setCourseCost((Double) row.get("courseCost"));
            course.setCourseName((String) row.get("courseName"));
            course.setTotal((Integer) row.get("total"));
            course.setCourseTypeId((String) row.get("courseTypeId"));
            course.setRemark((String) row.get("remark"));

            pageBean.getData().add(course);
        }

        return pageBean;
    }

    @Override
    public CrmCourseType findById(String courseTypeId) {
        return this.getJdbcTemplate().queryForObject("SELECT * FROM crm_course_type WHERE courseTypeId=?", new RowMapper<CrmCourseType>() {
            @Override
            public CrmCourseType mapRow(ResultSet rs, int rowNum) throws SQLException {
                CrmCourseType course = new CrmCourseType();

                course.setCourseTypeId(courseTypeId);
                course.setRemark(rs.getString("remark"));
                course.setCourseName(rs.getString("courseName"));
                course.setTotal(rs.getInt("total"));
                course.setCourseCost(rs.getDouble("courseCost"));

                return course;
            }
        }, courseTypeId);
    }

    @Override
    public boolean add(CrmCourseType courseType) {
        String sql = "INSERT INTO crm_course_type(courseTypeId,courseCost,total,courseName,remark) values(?,?,?,?,?)";
        Object[] args = {DBUtils.generateUUID(), courseType.getCourseCost(), courseType.getTotal(), courseType.getCourseName(), courseType.getRemark()};

        this.getJdbcTemplate().update(sql, args);

        return true;
    }

    @Override
    public boolean update(CrmCourseType courseType) {
        String sql = "UPDATE crm_course_type SET courseCost=?, total=?, courseName=?, remark=? WHERE courseTypeId=?";
        Object[] args = {courseType.getCourseCost(), courseType.getTotal(), courseType.getCourseName(), courseType.getRemark(), courseType.getCourseTypeId()};

        this.getJdbcTemplate().update(sql, args);

        return false;
    }
}
