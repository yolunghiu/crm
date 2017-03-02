package com.liuhy.crm.post.dao;

import com.liuhy.crm.post.domain.CrmPost;

import java.util.Set;

public interface PostDao {
    boolean add(CrmPost post);

    boolean update(CrmPost post);

    boolean delete(CrmPost post);

    CrmPost findByName(String postName);

    CrmPost findById(String id);

    /*
    * 根据部门id查询出该部门所有的职务
    * */
    Set<CrmPost> findByDepId(String depId);

}
