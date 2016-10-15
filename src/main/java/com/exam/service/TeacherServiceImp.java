package com.exam.service;

import com.exam.dao.TeacherDao;
import com.exam.dao.TeacherDaoImp;
import com.exam.po.TbTeacherEntity;

/**
 * Created by Administrator on 2016/10/14.
 */
public class TeacherServiceImp implements TeacherService{
    public boolean allowLogin(String teacherID, String password) {
        TeacherDao teacherDao = new TeacherDaoImp();
        TbTeacherEntity teacher = teacherDao.findByTeacherID(teacherID);
        if (teacher==null){
            return false;

        }else {
            if ((teacher.getPassword()).equals(password)){
                return true;
            }
        }
        return false;
    }
}
