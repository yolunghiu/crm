package com.liuhy.crm.post.dao.impl;

import com.liuhy.crm.post.dao.PostDao;
import com.liuhy.crm.post.domain.CrmPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:daoBeans.xml")
public class TestPostDao {

    private PostDao postDao;

    @Autowired
    @Qualifier("postDao")
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Test
    public void testFindById() {
        CrmPost post = postDao.findById("2c9091c14c78e58b014c78e6d4510004");
        System.out.println(post);
    }

    @Test
    public void testFindByDepId() {
        System.out.println(postDao.findByDepId("2c9091c14c78e58b014c78e67de10001"));
    }
}
