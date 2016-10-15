package com.exam.dao;

import com.exam.hibernate.HibernateSessionFactory;
import com.exam.po.TbTeacherEntity;
import org.hibernate.Session;

/**
 * Created by Administrator on 2016/10/14.
 */
public class TeacherDaoImp  implements TeacherDao{
    public TbTeacherEntity findByTeacherID(String teacherID) {

        Session session = HibernateSessionFactory.getSession();
        TbTeacherEntity teacher = session.get(TbTeacherEntity.class,teacherID);
        HibernateSessionFactory.closeSession();//πÿ±’Session∂‘œÛ
        return teacher;
    }
}
