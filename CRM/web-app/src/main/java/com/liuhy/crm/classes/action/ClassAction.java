package com.liuhy.crm.classes.action;

import com.liuhy.crm.base.BaseAction;
import com.liuhy.crm.classes.domain.CrmClasses;
import com.liuhy.crm.utils.DBUtils;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ClassAction extends BaseAction<CrmClasses> {

    public String listAll() {
        List<CrmClasses> classes = this.getClassService().findAll();
        put("classes", classes);
        return "list_all";
    }


    public String uploadUI() {
        CrmClasses crmClass = this.getClassService().findById(this.getModel().getClassId());
        push(crmClass);
        return "upload_ui";
    }


    // 要上传的文件
    private File schedule;
    // 文件名
    private String scheduleFileName;
    //文件类型
    private String scheduleContentType;

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    public void setScheduleContentType(String scheduleContentType) {
        this.scheduleContentType = scheduleContentType;
    }

    /*
        * 文件上传
        * */
    @InputConfig(resultName = "uploadInput")    // 当上传的文件类型错误时，返回这个结果
    public String upload() throws IOException {
        // 1.获取要保存文件的路径
        String path = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
        // 2.生成文件名（uuid）
        String fileName = DBUtils.generateUUID();
        // 3.更新数据库
        CrmClasses crmClass = this.getModel();
        crmClass.setUploadTime(new Date());
        crmClass.setUploadFileName(scheduleFileName);
        crmClass.setUploadPath(path + "/" + fileName);

        this.getClassService().upload(crmClass);
        // 4.保存文件
        FileUtils.copyFile(schedule, new File(path + fileName));
        return "upload";
    }
}
