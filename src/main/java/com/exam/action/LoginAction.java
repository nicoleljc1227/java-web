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

    private String id ;//�û����
    private String password ; //�û�����
    private String role ;//�û���ɫ
    private StudentService studentService= new StudentServiceImp();//ѧ��ҵ���߼��������
    private TeacherService teacherService= new TeacherServiceImp();//ѧ��ҵ���߼��������


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
            //�����ѧ����ݵ�¼
            if (studentService.allowLogin(id,password)){
                TbStudentEntity studentInfo = studentService.getStudentInfo(id);
                //����ѧ����¼��session��Χ
                Map session = ActionContext.getContext().getSession();
                session.put("studentInfo",studentInfo);
                return "StudentSuccess";
            }else{
                addActionError("��ѧ����Ų����ӣ��������벻��ȷ��");
                return this.INPUT;
            }
        }else {
            if(teacherService.allowLogin(id,password)){
                return "TeacherSuccess!";
            }else{
                addActionError("�ý�ʦ�˺Ų����ڣ����벻��ȷ��");
                return this.INPUT;
            }
        }
    }
}
