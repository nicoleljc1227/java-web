package com.exam.dao;

import com.exam.hibernate.HibernateSessionFactory;
import com.exam.po.TbStudentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public class StudentDaoImp implements StudentDao{


    public TbStudentEntity findByStudentID(String studentID) {
        Session session = HibernateSessionFactory.getSession();//获得Session对象
        TbStudentEntity student = session.get(TbStudentEntity.class,studentID);
        HibernateSessionFactory.closeSession();//关闭session对象
        return student;
    }

    public void updateStudent(TbStudentEntity student) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;//声明一个事物对象
        try{
            transaction = session.beginTransaction();//开启事物
            session.update(student);//更新学生信息
            transaction.commit();//提交事物
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//事物回滚

        }
        HibernateSessionFactory.closeSession();//关闭session对象

    }

    public List<TbStudentEntity> findByStudentName(String studentName) {
        Session session = HibernateSessionFactory.getSession();//获得Session对象
        Query query = session.createQuery("from TbStudentEntity as stu where stu.studentName=?");
        query.setString(0,studentName);

        return null;
    }

    public List<TbStudentEntity> findByStudentClass(String sclass) {
        return null;
    }
}
