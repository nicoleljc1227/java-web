package com.exam.service;

/**
 * Created by Administrator on 2016/10/14.
 */
public interface TeacherService {
    //判断是否为合法老师，从而决定是否允许登录
    public boolean allowLogin(String teacherID,String password);
}
