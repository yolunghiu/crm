package com.liuhy.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {

        Object loginStaff = ActionContext.getContext().getSession().get("loginStaff");
        if (null == loginStaff) {
            ((ActionSupport) invocation.getAction()).addFieldError("", "请登录");
            return "login_fail";
        }

        return invocation.invoke();
    }
}
