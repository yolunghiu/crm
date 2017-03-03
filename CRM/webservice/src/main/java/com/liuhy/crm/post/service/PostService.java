package com.liuhy.crm.post.service;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.post.domain.CrmPost;

import java.util.Set;

public interface PostService {

    Set<CrmPost> findAllByDepartment(CrmDepartment department);
}
