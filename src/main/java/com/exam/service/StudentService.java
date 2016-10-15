package com.exam.service;

import com.exam.po.TbStudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface StudentService {
    //判断是否是合法的学生
    public boolean allowLogin(String studentID,String password);
    //获得学生信息
    public TbStudentEntity getStudentInfo(String studentID);
    //设置学生成绩

    public void setStudentResult(String studentID, int result);
    //根据学生姓名s搜索学生
    public List<TbStudentEntity> getStudentByName(String studentName);
    //根据班级查找学生
    public List<TbStudentEntity> getStudentByClass(String sclass);

}
