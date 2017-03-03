package com.liuhy.crm.post.service.impl;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.post.domain.CrmPost;
import com.liuhy.crm.post.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:serviceBeans.xml")
public class TestPostService {
    private PostService postService;

    @Autowired
    @Qualifier("postService")
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Test
    public void testFindAllByDepartment() {
        CrmDepartment department = new CrmDepartment();
        department.setDepId("2c9091c14c78e58b014c78e68ded0002");
        Set<CrmPost> postSet = postService.findAllByDepartment(department);
        System.out.println(postSet);
    }
}
