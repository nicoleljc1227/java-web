package com.exam.action;

import com.exam.po.TbStudentEntity;
import com.exam.service.StudentService;
import com.exam.service.StudentServiceImp;
import com.exam.service.TeacherService;
import com.exam.service.TeacherServiceImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 */
public class LoginAction extends ActionSupport {

    private String id ;//用户编号
    private String password ; //用户密码
    private String role ;//用户角色
    private StudentService studentService= new StudentServiceImp();//学生业务逻辑组件引用
    private TeacherService teacherService= new TeacherServiceImp();//学生业务逻辑组件引用


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String execute() throws Exception{
        if("student".equals(role)){
            //如果以学生身份登录
            if (studentService.allowLogin(id,password)){
                TbStudentEntity studentInfo = studentService.getStudentInfo(id);
                //保存学生记录到session范围
                Map session = ActionContext.getContext().getSession();
                session.put("studentInfo",studentInfo);
                return "StudentSuccess";
            }else{
                addActionError("该学生编号不村子，或者密码不正确！");
                return this.INPUT;
            }
        }else {
            if(teacherService.allowLogin(id,password)){
                return "TeacherSuccess!";
            }else{
                addActionError("该教师账号不存在，密码不正确！");
                return this.INPUT;
            }
        }
    }
}
