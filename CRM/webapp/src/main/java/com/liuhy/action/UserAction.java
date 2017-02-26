package com.liuhy.action;

import com.liuhy.crm.department.domain.CrmDepartment;
import com.liuhy.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by liuhy on 2017/2/25.
 */
public class UserAction extends ActionSupport implements ModelDriven<CrmDepartment> {
    private CrmDepartment user = new CrmDepartment();
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CrmDepartment getModel() {
        return user;
    }

    public String register() {
        userService.addUser(user);
        return "success";
    }
}
