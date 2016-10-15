package com.exam.dao;


import com.exam.hibernate.HibernateSessionFactory;
import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class SubjectDaoImp implements SubjectDao{

    public TbSubjectEntity findBySubjectID(Integer subjectID) {
        Session session = HibernateSessionFactory.getSession();
        TbSubjectEntity subject = session.get(TbSubjectEntity.class,subjectID);//持久化类加主键
        HibernateSessionFactory.closeSession();

        return subject;
    }

    public TbSubjectEntity findSubjectByTitle(String subjectTitle) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle=?");
        query.setString(0,subjectTitle);
        List list = query.list();//查询结果保存到list中
        HibernateSessionFactory.closeSession();
        if (list.size()==0){
            return null;
        }else {
            return (TbSubjectEntity) list.get(0);//返回第一个试题？？？？为啥是第一个
        }

    }

    public void addSubject(TbSubjectEntity subject) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        try {
            transaction=session.beginTransaction();//开启事物
            session.save(subject);
            transaction.commit();//提交事物
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//事务回滚
        }
        HibernateSessionFactory.closeSession();

    }

    public void updateSubject(TbSubjectEntity subject) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.update(subject);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//事务回滚
        }
        HibernateSessionFactory.closeSession();



    }

    public void deleteSubject(Integer subjectID) {
        Session session = HibernateSessionFactory.getSession();
        TbSubjectEntity subject = session.get(TbSubjectEntity.class,subjectID);
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.delete(subject);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//事务回滚
        }
        HibernateSessionFactory.closeSession();


    }

    public List<TbSubjectEntity> findSubjectByPage(Page page) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity ");
        query.setMaxResults(page.getEveryPage());//设置查询记录数
        List list = query.list();//查询结果保存在list中
        HibernateSessionFactory.closeSession();//关闭



        return list;
    }

    public int findSubjectCount() {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity ");
        List list = query.list();//查询结果保存在list中
        int count =list.size();
        HibernateSessionFactory.closeSession();//关闭


        return count;
    }

    public List<TbSubjectEntity> likeQueryByTitle(String subjectTitle, Page page) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle like:title");

        query.setString("title","%"+subjectTitle+"%");
        query.setMaxResults(page.getEveryPage());//设置查询记录数
        query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
        List list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }

    public int findLikeQueryCount(String subjectTitle) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle like:title");
        query.setString("title","%"+subjectTitle+"%");
        List list = query.list();					//查询结果保存到list中
        int count = list.size();
        HibernateSessionFactory.closeSession();//
        return count;
    }

    /*
    * 随机从表中查询number条记录
    * */

    public List<TbSubjectEntity> randomFindSubject(int number) {
        Session session = HibernateSessionFactory.getSession();//获得Session对象
        Query query = session.createQuery("from TbSubjectEntity as sub order by rand()");
        query.setMaxResults(number);//设置查询记录数
        List list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
