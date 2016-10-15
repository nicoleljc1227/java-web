package com.exam.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2016/9/26.
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();//����ThreadLocal����
    //����configuration����
    private static Configuration configuration= new Configuration();
    private static SessionFactory sessionFactory ;

    private static String configeFile = CONFIG_FILE_LOCATION;
    static {
        try{
            //��ȡ�����ļ�
            configuration.configure(configeFile);
            sessionFactory = configuration.buildSessionFactory();//���������ļ�����sessionFactory
        }catch (Exception e){
            System.err.println("Error create sessionFactory!");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory(){

    }

    public static Session getSession()throws HibernateException{
        //��ThreadLocal�����л�ȡsession����
        Session session = threadLocal.get();
        if(session==null||!session.isOpen()){
            //�жϻ�õ�session�����Ƿ�Ϊ�ջ���δ��
            if (sessionFactory==null)//���û�д���SessionFactory�������ȴ���
            {
                rebuildSessionFactory();
            }
            //���SessionFactory��Ϊ�� �������openSession��������session����
            session = (sessionFactory!=null)?sessionFactory.openSession():null;
            threadLocal.set(session);//��ThreadLocal�����б����Session����
        }
        return session;
    }


    public static void rebuildSessionFactory(){
        try{
            configuration.configure(configeFile);
            sessionFactory =
                    configuration.buildSessionFactory();

        }catch (Exception e){
            System.err.println("Error create sessionFactory!");
            e.printStackTrace();
        }

    }

    public static void closeSession() throws HibernateException{
        Session session = threadLocal.get();//��ThreadLocal�����л��Session����
        threadLocal.set(null);//����ǰ�߳� session ����� ThreadLocal���Ƴ�

        if(session!=null){
            session.close();
        }
    }
    public static SessionFactory getSessionFactory(){//���췽��get
        return sessionFactory;
    }

    public static Configuration getConfiguration(){//���췽��get
        return configuration;
    }

    public static void setConfigeFile(String configeFile){//���췽��set
        //�����µ������ļ�
        HibernateSessionFactory.configeFile= configeFile;
        sessionFactory= null;
    }


}
