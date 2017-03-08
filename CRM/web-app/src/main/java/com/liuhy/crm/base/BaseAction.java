package com.liuhy.crm.base;

import com.liuhy.crm.coursetype.service.CourseTypeService;
import com.liuhy.crm.department.service.DepartmentService;
import com.liuhy.crm.post.service.PostService;
import com.liuhy.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.lang.reflect.ParameterizedType;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    /*
    * 将Model提取
    * */
    private T t;

    @Override
    public T getModel() {
        return t;
    }

    public BaseAction() {
        try {
            // 获得泛型T的Class对象
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
            // 实例化Model
            t = clazz.newInstance();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /*
    * 注入所有的Service，因为Service是Spring产生的单例
    * */
    private StaffService staffService;
    private DepartmentService departmentService;
    private PostService postService;
    private CourseTypeService courseTypeService;

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    /*
    * 分页数据
    * */
    private int currentPage = 1;    // 当前页码，默认为1
    private int pageSize = 2;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /*
    * 值栈操作
    * */
    public void push(Object o) {
        ActionContext.getContext().getValueStack().push(o);
    }

    public void set(String key, Object o) {
        ActionContext.getContext().getValueStack().set(key, o);
    }

    public void put(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }

    public void putToSession(String key, Object value) {
        ActionContext.getContext().getSession().put(key, value);
    }


}
