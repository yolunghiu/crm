package com.liuhy.crm.post.dao.impl;

import com.liuhy.crm.department.dao.DepartmentDao;
import com.liuhy.crm.post.dao.PostDao;
import com.liuhy.crm.post.domain.CrmPost;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PostDaoImpl extends JdbcDaoSupport implements PostDao {

    DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public boolean add(CrmPost post) {
        return false;
    }

    @Override
    public boolean update(CrmPost post) {
        return false;
    }

    @Override
    public boolean delete(CrmPost post) {
        return false;
    }

    @Override
    public CrmPost findByName(String postName) {
        return null;
    }

    @Override
    public CrmPost findById(String id) {
        return this.getJdbcTemplate()
                .queryForObject("SELECT * FROM crm_post WHERE postId=?",
                        (rs, rowNum) -> {
                            CrmPost crmPost = new CrmPost();
                            crmPost.setPostId(id);
                            crmPost.setPostName(rs.getString("postName"));

                            crmPost.setDepartment(departmentDao.findById(rs.getString("depId")));
                            return crmPost;
                        },
                        id);
    }
}
