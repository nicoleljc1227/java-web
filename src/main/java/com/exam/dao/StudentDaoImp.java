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
        Session session = HibernateSessionFactory.getSession();//���Session����
        TbStudentEntity student = session.get(TbStudentEntity.class,studentID);
        HibernateSessionFactory.closeSession();//�ر�session����
        return student;
    }

    public void updateStudent(TbStudentEntity student) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;//����һ���������
        try{
            transaction = session.beginTransaction();//��������
            session.update(student);//����ѧ����Ϣ
            transaction.commit();//�ύ����
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//����ع�

        }
        HibernateSessionFactory.closeSession();//�ر�session����

    }

    public List<TbStudentEntity> findByStudentName(String studentName) {
        Session session = HibernateSessionFactory.getSession();//���Session����
        Query query = session.createQuery("from TbStudentEntity as stu where stu.studentName=?");
        query.setString(0,studentName);

        return null;
    }

    public List<TbStudentEntity> findByStudentClass(String sclass) {
        return null;
    }
}
