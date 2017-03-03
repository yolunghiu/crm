package com.liuhy.crm.staff.action;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.crm.department.service.DepartmentService;
import com.liuhy.crm.staff.domain.CrmStaff;
import com.liuhy.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;
import java.util.Map;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
    private CrmStaff staff = new CrmStaff();

    @Override
    public CrmStaff getModel() {
        return staff;
    }

    private StaffService staffService;
    private DepartmentService departmentService;

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String login() {
        // 查询此员工是否在数据库中
        boolean loginResult = staffService.login(staff);

        // 1.如果存在,将此用户放入session
        if (loginResult) {
            ActionContext.getContext().getSession().put("loginStaff", staff);
            return "login_success";
        }

        // 2.如果不存在，添加错误信息，返回登陆界面
        addFieldError("", "用户名和密码不匹配");
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("loginStaff", staff);
        return "login_fail";
    }

    public String home() {
        return "home";
    }

    public String listAll() {
        List<CrmStaff> allStaff = staffService.findAll();
        ActionContext.getContext().put("allStaff", allStaff);
        return "list_staff";
    }

    public String editUI() {
        CrmStaff editingStaff = staffService.findStaffById(staff.getStaffId());
        ActionContext.getContext().getValueStack().push(editingStaff);
        List<CrmDepartment> departments = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("departments", departments);
        return "staff_edit";
    }

}
