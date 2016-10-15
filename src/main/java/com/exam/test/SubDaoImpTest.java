package com.exam.test;

import com.exam.dao.SubjectDao;
import com.exam.dao.SubjectDaoImp;
import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public class SubDaoImpTest {

    private SubjectDao subjectDao = new SubjectDaoImp();

    public void testFindBySubjectID() throws Exception {
//TODO: Test goes here...

        TbSubjectEntity subject = subjectDao.findBySubjectID(54);
        System.out.println(subject.getSubjectTitle());


    }

    public void testFindSubjectByTitle() throws Exception {
//TODO: Test goes here...
        TbSubjectEntity subject = subjectDao.findSubjectByTitle("二叉树中序遍历");
        System.out.println(subject.getSubjectAnswer());
        subject=subjectDao.findSubjectByTitle("的风格");
        System.out.println(subject.getSubjectAnswer());

    }

    public void testAddSubject() throws Exception {
//TODO: Test goes here...
        TbSubjectEntity subjectEntity = new TbSubjectEntity();
        subjectEntity.setSubjectId(13);
        subjectEntity.setSubjectTitle("nicole");
        subjectEntity.setSubjectOptionA("火龙果");
        subjectEntity.setSubjectOptionB("蛋糕");
        subjectEntity.setSubjectOptionC("枣夹核桃");
        subjectEntity.setSubjectOptionD("啥都吃");
        subjectEntity.setSubjectAnswer("D");

        subjectDao.addSubject(subjectEntity);


    }

    public void testUpdateSubject() throws Exception {
//TODO: Test goes here...

        TbSubjectEntity subject = subjectDao.findSubjectByTitle("二叉树中序遍历");
        subject.setSubjectParse("改变一下下");
        subjectDao.updateSubject(subject);
        System.out.println(subject.getSubjectParse());


    }

    /**
     *
     * Method: deleteSubject(String subjectID)
     *
     */
    public void testDeleteSubject() throws Exception {
//TODO: Test goes here...

    }

    /**
     *
     * Method: findSubjectByPage(Page page)
     *
     */

    public void testFindSubjectByPage() throws Exception {
//TODO: Test goes here...
        Page page1 = new Page(3,4,3,1,1,false,true);//应该加个 构造器 只有一个参数 new Page（3）
        List<TbSubjectEntity> list =new ArrayList<TbSubjectEntity>();
        list = subjectDao.findSubjectByPage(page1);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getSubjectTitle());
        }


    }

    /**
     *
     * Method: findSubjectCount()
     *
     */

    public void testFindSubjectCount() throws Exception {
//TODO: Test goes here...

        System.out.println(subjectDao.findSubjectCount());
    }

    /**
     *
     * Method: likeQueryByTitle(String subjectTitle, Page page)
     *
     */
    public void testLikeQueryByTitle() throws Exception {
//TODO: Test goes here...
        Page page1 = new Page(2,4,3,1,1,false,true);
        List<TbSubjectEntity> list =subjectDao.likeQueryByTitle("喜欢", page1);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getSubjectTitle());
        }

    }

    /**
     *
     * Method: findLikeQueryCount(String subjectTitle)
     *
     */
    public void testFindLikeQueryCount() throws Exception {
//TODO: Test goes here...

        Page page1 = new Page(2,4,3,1,1,false,true);
        int list =subjectDao.findLikeQueryCount("喜欢");
        System.out.println(list);
    }

    /**
     *
     * Method: randomFindSubject(int number)
     *
     */
    public void testRandomFindSubject() throws Exception {
//TODO: Test goes here...
        List<TbSubjectEntity> list =subjectDao.randomFindSubject(2);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getSubjectTitle());
        }

    }

    public static void main(String[] args) throws Exception {
        SubDaoImpTest subDaoImpTest = new SubDaoImpTest();
       /* subDaoImpTest.testFindBySubjectID();
        subDaoImpTest.testFindSubjectByTitle();
        subDaoImpTest.testAddSubject();*/
       /* subDaoImpTest.testUpdateSubject();
        subDaoImpTest.testDeleteSubject();*/

        //subDaoImpTest.testLikeQueryByTitle();
        //subDaoImpTest.testFindLikeQueryCount();
        subDaoImpTest.testRandomFindSubject();



    }

}
