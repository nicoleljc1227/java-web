package com.exam.action;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2016/10/15.
 */
//该Action用来接收试题参数，并调用业务逻辑组件SubjectService来完成试题添加

public class SubjectAddAction extends ActionSupport {

    //private String subjectID; 因为添加内容时候 id会自动增长

    private String subjectTitle;
    private String subjectOptionA;
    private String subjectOptionB;
    private String subjectOptionC;
    private String subjectOptionD;
    private String subjectAnswer;
    private String subjectPrase;

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectOptionA() {
        return subjectOptionA;
    }

    public void setSubjectOptionA(String subjectOptionA) {
        this.subjectOptionA = subjectOptionA;
    }

    public String getSubjectOptionB() {
        return subjectOptionB;
    }

    public void setSubjectOptionB(String subjectOptionB) {
        this.subjectOptionB = subjectOptionB;
    }

    public String getSubjectOptionC() {
        return subjectOptionC;
    }

    public void setSubjectOptionC(String subjectOptionC) {
        this.subjectOptionC = subjectOptionC;
    }

    public String getSubjectOptionD() {
        return subjectOptionD;
    }

    public void setSubjectOptionD(String subjectOptionD) {
        this.subjectOptionD = subjectOptionD;
    }

    public String getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(String subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    public String getSubjectPrase() {
        return subjectPrase;
    }

    public void setSubjectPrase(String subjectPrase) {
        this.subjectPrase = subjectPrase;
    }

    private TbSubjectEntity subject;
    private SubjectService subjectService = new SubjectServiceImp();


    public String execute() throws Exception{
        subject.setSubjectTitle(subjectTitle);
        subject.setSubjectParse(subjectPrase);
        subject.setSubjectOptionA(subjectOptionA);
        subject.setSubjectOptionB(subjectOptionB);
        subject.setSubjectOptionC(subjectOptionC);
        subject.setSubjectOptionD(subjectOptionD);
        subject.setSubjectAnswer(subjectAnswer);

        if(subjectService.saveSubject(subject)){//save这个方法是booblean值
            return SUCCESS;
        }else {
            this.addActionError("该试题已经添加过了，请不要重复添加");
            return INPUT;
        }
    }

}
