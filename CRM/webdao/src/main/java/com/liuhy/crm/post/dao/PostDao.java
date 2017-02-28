package com.liuhy.crm.post.dao;

import com.liuhy.crm.post.domain.CrmPost;

public interface PostDao {
    boolean add(CrmPost post);

    boolean update(CrmPost post);

    boolean delete(CrmPost post);

    CrmPost findByName(String postName);

    CrmPost findById(String id);

}
