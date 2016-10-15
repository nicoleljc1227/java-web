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
public class QueryStudentByName extends ActionSupport {

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        studentName = studentName;
    }

    private String studentName;
    private StudentService studentService = new StudentServiceImp();

    public String execute() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        List<TbStudentEntity> students = studentService.getStudentByName(studentName);
        request.setAttribute("students",students);
        return this.SUCCESS;
    }

}
