package com.liuhy.crm.post.service.impl;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.post.dao.PostDao;
import com.liuhy.crm.post.domain.CrmPost;
import com.liuhy.crm.post.service.PostService;

import java.util.Set;

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }


    /*
    * 根据depId查询出所有的CrmPost
    * */
    @Override
    public Set<CrmPost> findAllByDepartment(CrmDepartment department) {
        return postDao.findByDepId(department.getDepId());
    }
}
