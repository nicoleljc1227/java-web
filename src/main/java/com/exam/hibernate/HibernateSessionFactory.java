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
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();//定义ThreadLocal对象
    //定义configuration对象
    private static Configuration configuration= new Configuration();
    private static SessionFactory sessionFactory ;

    private static String configeFile = CONFIG_FILE_LOCATION;
    static {
        try{
            //读取配置文件
            configuration.configure(configeFile);
            sessionFactory = configuration.buildSessionFactory();//根据配置文件创建sessionFactory
        }catch (Exception e){
            System.err.println("Error create sessionFactory!");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory(){

    }

    public static Session getSession()throws HibernateException{
        //从ThreadLocal对象中获取session对象
        Session session = threadLocal.get();
        if(session==null||!session.isOpen()){
            //判断获得的session对象是否为空或者未打开
            if (sessionFactory==null)//如果没有创建SessionFactory对象则先创建
            {
                rebuildSessionFactory();
            }
            //如果SessionFactory不为空 则调用其openSession方法创建session对象
            session = (sessionFactory!=null)?sessionFactory.openSession():null;
            threadLocal.set(session);//在ThreadLocal对象中保存改Session对象
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
        Session session = threadLocal.get();//从ThreadLocal对象中获得Session对象
        threadLocal.set(null);//将当前线程 session 对象从 ThreadLocal中移除

        if(session!=null){
            session.close();
        }
    }
    public static SessionFactory getSessionFactory(){//构造方法get
        return sessionFactory;
    }

    public static Configuration getConfiguration(){//构造方法get
        return configuration;
    }

    public static void setConfigeFile(String configeFile){//构造方法set
        //设置新的配置文件
        HibernateSessionFactory.configeFile= configeFile;
        sessionFactory= null;
    }


}
