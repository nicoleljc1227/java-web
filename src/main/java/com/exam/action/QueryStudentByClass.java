package com.exam.action;

import com.exam.po.TbStudentEntity;
import com.exam.service.StudentService;
import com.exam.service.StudentServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class QueryStudentByClass extends ActionSupport {

    private String sclass;
    private StudentService studentService = new StudentServiceImp();


    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String excute() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        List<TbStudentEntity> students= studentService.getStudentByClass(sclass);
        request.setAttribute("students",students);
        return this.SUCCESS;
    }
}
