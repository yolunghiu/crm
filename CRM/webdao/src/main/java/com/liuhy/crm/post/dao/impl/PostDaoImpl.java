package com.liuhy.crm.post.dao.impl;

import com.liuhy.crm.department.dao.DepartmentDao;
import com.liuhy.crm.post.dao.PostDao;
import com.liuhy.crm.post.domain.CrmPost;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.*;

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

    /*
    * 这个方法查出来的CrmPost对象不级联查询它的Department对象
    * 因为是根据depId查询所有的CrmPost，所以查出来也没什么用
    * */
    @Override
    public Set<CrmPost> findByDepId(String depId) {
        Set<CrmPost> postSet = new HashSet<CrmPost>(0);
        List<Map<String, Object>> result = this.getJdbcTemplate().queryForList("SELECT * FROM crm_post WHERE depId=?", depId);

        for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
            Map<String, Object> row = (Map<String, Object>) iterator.next();

            CrmPost post = new CrmPost();
            post.setPostName((String) row.get("postName"));
            post.setPostId((String) row.get("postId"));

            postSet.add(post);
        }

        return postSet;
    }

}
