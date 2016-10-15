package com.exam.dao;

import com.exam.po.TbStudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface StudentDao {

    public TbStudentEntity findByStudentID(String studentID);//查询方法 根据IＤ查询　

    public void updateStudent(TbStudentEntity student);//更新学生信息

    public List<TbStudentEntity> findByStudentName(String studentName);
        //根据学生姓名查找
    public List<TbStudentEntity> findByStudentClass(String sclass);



}
