package com.liuhy.crm.post.action;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.post.domain.CrmPost;
import com.liuhy.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
    private CrmPost post = new CrmPost();
    private PostService postService;

    @Override
    public CrmPost getModel() {
        return post;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    /*
        * ajax 根据department查询并返回所有post
        * json格式的数据
        * */
    public String findAllByDepartment() throws IOException {

        Set<CrmPost> postSet = postService.findAllByDepartment(post.getDepartment());

        // 排除CrmPost中的CrmDepartment
        ExclusionStrategy strategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return CrmDepartment.class.equals(f.getDeclaredClass());

            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return CrmDepartment.class.equals(clazz);
            }
        };
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(strategy)
                .create();

        String result = gson.toJson(postSet);
        System.out.println(result);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();

        return "none";
    }

}
