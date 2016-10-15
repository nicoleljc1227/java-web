package com.exam.service;

import com.exam.dao.StudentDao;
import com.exam.dao.StudentDaoImp;
import com.exam.po.TbStudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public class StudentServiceImp implements StudentService {

    private StudentDao studentDao = new StudentDaoImp();
    public boolean allowLogin(String studentID, String password) {

        TbStudentEntity student;
        student=studentDao.findByStudentID(studentID);
        if(student.getStudentId()!=null){
            if((student.getPassword()).equals(password)){
                return true;
            }else
                return false;
        }
        return false;
    }

    public TbStudentEntity getStudentInfo(String studentID) {

        TbStudentEntity student=studentDao.findByStudentID(studentID);

        return student;
    }

    public void setStudentResult(String studentID,int result) {
        TbStudentEntity student = studentDao.findByStudentID(studentID);
        student.setResult(result);//设置学生成绩
        studentDao.updateStudent(student);//更新学生成绩
    }

    public List<TbStudentEntity> getStudentByName(String studentName) {
        return studentDao.findByStudentName(studentName);
    }

    public List<TbStudentEntity> getStudentByClass(String sclass) {

        return studentDao.findByStudentClass(sclass);
    }
}
