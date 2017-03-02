package com.liuhy.crm.department.dao.impl;

import com.liuhy.crm.department.dao.DepartmentDao;
import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.post.dao.PostDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentDaoImpl extends JdbcDaoSupport implements DepartmentDao {

    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public boolean add(CrmDepartment department) {
        return false;
    }

    @Override
    public boolean update(CrmDepartment department) {
        return false;
    }

    @Override
    public boolean delete(CrmDepartment department) {
        return false;
    }

    @Override
    public CrmDepartment findById(String id) {
        return this.getJdbcTemplate()
                .queryForObject("SELECT * FROM crm_department WHERE depId=?",
                        (rs, rowNum) -> {
                            CrmDepartment department = new CrmDepartment();
                            department.setDepId(id);
                            department.setDepName(rs.getString("depName"));

                            department.setPostSet(postDao.findByDepId(id));
                            return department;
                        },
                        id);
    }

    @Override
    public List<CrmDepartment> findAll(boolean cascadeQueryCrmPost) {
        List<CrmDepartment> departments = new ArrayList<CrmDepartment>(0);

        List result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_department");
        for (int i = 0; i < result.size(); i++) {
            Map<String, Object> row = (Map<String, Object>) result.get(i);
            CrmDepartment department = new CrmDepartment();
            String depId = (String) row.get("depId");
            department.setDepId(depId);
            department.setDepName((String) row.get("depName"));

            // 如果要级联查询出post信息
            if (cascadeQueryCrmPost) {
                department.setPostSet(postDao.findByDepId(depId));
            }

            departments.add(department);
        }

        return departments;
    }
}
