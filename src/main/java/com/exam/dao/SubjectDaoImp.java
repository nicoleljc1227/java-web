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
        TbSubjectEntity subject = session.get(TbSubjectEntity.class,subjectID);//�־û��������
        HibernateSessionFactory.closeSession();

        return subject;
    }

    public TbSubjectEntity findSubjectByTitle(String subjectTitle) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle=?");
        query.setString(0,subjectTitle);
        List list = query.list();//��ѯ������浽list��
        HibernateSessionFactory.closeSession();
        if (list.size()==0){
            return null;
        }else {
            return (TbSubjectEntity) list.get(0);//���ص�һ�����⣿������Ϊɶ�ǵ�һ��
        }

    }

    public void addSubject(TbSubjectEntity subject) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        try {
            transaction=session.beginTransaction();//��������
            session.save(subject);
            transaction.commit();//�ύ����
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();//����ع�
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
            transaction.rollback();//����ع�
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
            transaction.rollback();//����ع�
        }
        HibernateSessionFactory.closeSession();


    }

    public List<TbSubjectEntity> findSubjectByPage(Page page) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity ");
        query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
        List list = query.list();//��ѯ���������list��
        HibernateSessionFactory.closeSession();//�ر�



        return list;
    }

    public int findSubjectCount() {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity ");
        List list = query.list();//��ѯ���������list��
        int count =list.size();
        HibernateSessionFactory.closeSession();//�ر�


        return count;
    }

    public List<TbSubjectEntity> likeQueryByTitle(String subjectTitle, Page page) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle like:title");

        query.setString("title","%"+subjectTitle+"%");
        query.setMaxResults(page.getEveryPage());//���ò�ѯ��¼��
        query.setFirstResult(page.getBeginIndex());//���ò�ѯ��¼��ʼλ��
        List list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }

    public int findLikeQueryCount(String subjectTitle) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from TbSubjectEntity as sub where sub.subjectTitle like:title");
        query.setString("title","%"+subjectTitle+"%");
        List list = query.list();					//��ѯ������浽list��
        int count = list.size();
        HibernateSessionFactory.closeSession();//
        return count;
    }

    /*
    * ����ӱ��в�ѯnumber����¼
    * */

    public List<TbSubjectEntity> randomFindSubject(int number) {
        Session session = HibernateSessionFactory.getSession();//���Session����
        Query query = session.createQuery("from TbSubjectEntity as sub order by rand()");
        query.setMaxResults(number);//���ò�ѯ��¼��
        List list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
