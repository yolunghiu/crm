package com.liuhy.crm.classes.dao.impl;

import com.liuhy.crm.classes.dao.ClassDao;
import com.liuhy.crm.classes.domain.CrmClasses;
import com.liuhy.crm.coursetype.dao.CourseTypeDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ClassDaoImpl extends JdbcDaoSupport implements ClassDao {
    private CourseTypeDao courseTypeDao;

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CrmClasses> findAll() {
        List<CrmClasses> classes = new ArrayList<CrmClasses>(0);

        // 返回 List<Map<String,Object>>
        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_classes");
        for (int i = 0; i < result.size(); i++) {

            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmClasses crmClass = new CrmClasses();
            crmClass.setClassId((String) row.get("classId"));
            crmClass.setName((String) row.get("name"));
            Date beginTime = new Date(((Timestamp) row.get("beginTime")).getTime());
            Date endTime = new Date(((Timestamp) row.get("endTime")).getTime());
            crmClass.setBeginTime(beginTime);
            crmClass.setEndTime(endTime);
            crmClass.setTotalCount((Integer) row.get("totalCount"));
            crmClass.setUpgradeCount((Integer) row.get("upgradeCount"));
            crmClass.setChangeCount((Integer) row.get("changeCount"));
            crmClass.setRunoffCount((Integer) row.get("runoffCount"));
            crmClass.setRemark((String) row.get("remark"));
            crmClass.setCourseType(courseTypeDao.findById((String) row.get("courseTypeId")));

            Date uploadTime = new Date(((Timestamp) row.get("uploadTime")).getTime());
            crmClass.setUploadTime(uploadTime);
            crmClass.setUploadFileName((String) row.get("uploadFileName"));
            crmClass.setUploadPath((String) row.get("uploadPath"));

            classes.add(crmClass);
        }

        return classes;
    }

    @Override
    public CrmClasses findById(String classId) {
        return this.getJdbcTemplate().queryForObject("SELECT * FROM crm_classes WHERE classId=?", (rs, rowNum) -> {
            CrmClasses crmClass = new CrmClasses();

            crmClass.setClassId(classId);
            crmClass.setName(rs.getString("name"));
            Date beginTime = new Date(rs.getDate("beginTime").getTime());
            Date endTime = new Date(rs.getDate("endTime").getTime());
            crmClass.setBeginTime(beginTime);
            crmClass.setEndTime(endTime);
            crmClass.setTotalCount(rs.getInt("totalCount"));
            crmClass.setUpgradeCount(rs.getInt("upgradeCount"));
            crmClass.setChangeCount(rs.getInt("changeCount"));
            crmClass.setRunoffCount(rs.getInt("runoffCount"));
            crmClass.setRemark(rs.getString("remark"));
            crmClass.setCourseType(courseTypeDao.findById(rs.getString("courseTypeId")));

            Date uploadTime = new Date( rs.getDate("uploadTime").getTime());
            crmClass.setUploadTime(uploadTime);
            crmClass.setUploadFileName(rs.getString("uploadFileName"));
            crmClass.setUploadPath(rs.getString("uploadPath"));

            return crmClass;
        }, classId);
    }

    @Override
    public void updateUpload(CrmClasses crmClass) {
        this.getJdbcTemplate().update("UPDATE crm_classes SET uploadTime=?, uploadFileName=?, uploadPath=? WHERE classId=?",
                crmClass.getUploadTime(),
                crmClass.getUploadFileName(),
                crmClass.getUploadPath(),
                crmClass.getClassId());
    }

}
