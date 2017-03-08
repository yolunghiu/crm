package com.liuhy.crm.staff.action;

import com.liuhy.crm.base.BaseAction;
import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class StaffAction extends BaseAction<CrmStaff> {

    public String login() {
        // 查询此员工是否在数据库中
        boolean loginResult = this.getStaffService().login(this.getModel());

        // 1.如果存在,将此用户放入session
        if (loginResult) {
            ActionContext.getContext().getSession().put("loginStaff", this.getModel());
            return "login_success";
        }

        // 2.如果不存在，添加错误信息，返回登陆界面
        addFieldError("", "用户名和密码不匹配");
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("loginStaff", this.getModel());
        return "login_fail";
    }

    public String home() {
        return "home";
    }

    public String listAll() {
        List<CrmStaff> allStaff = this.getStaffService().findAll();
        this.put("allStaff", allStaff);
        return "list_staff";
    }

    public String editUI() {
        CrmStaff editingStaff = this.getStaffService().findStaffById(this.getModel().getStaffId());
        this.push(editingStaff);
        List<CrmDepartment> departments = this.getDepartmentService().findAll();
        this.set("departments", departments);
        return "staff_edit";
    }

    /*
    * 保存更改的员工信息（更新）
    * */
    public String saveEdit() {
        this.getStaffService().updateStaff(this.getModel());
        return "edit_success";
    }

}
