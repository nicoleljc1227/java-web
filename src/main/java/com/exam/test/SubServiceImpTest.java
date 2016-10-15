package com.exam.test;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.exam.util.Page;
import com.exam.util.PageResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/14.
 */
public class SubServiceImpTest {
    SubjectService subjectService = new SubjectServiceImp();

    public void testSaveSubject(){
        TbSubjectEntity subjectEntity = new TbSubjectEntity();
        subjectEntity.setSubjectId(18);
        subjectEntity.setSubjectTitle("hehe");

        System.out.println(subjectService.saveSubject(subjectEntity));

    }

    public void testQuerySubjectByPage(){
        Page page = new Page(3,6,3,1,1,true,true);
        PageResult result = subjectService.querySubjectByPage(page);
        for (int i = 0; i <result.getList().size() ; i++) {
            System.out.println(result.getList().get(i).toString());
        }
        System.out.println(result.getPage().getCurrentPage());


    }

    public void testAccountResult(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(54);
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("D");
        int sum = subjectService.accountResult(list,list1);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        SubServiceImpTest subServiceImpTest = new SubServiceImpTest();
        //subServiceImpTest.testSaveSubject();
        //subServiceImpTest.testQuerySubjectByPage();

        subServiceImpTest.testAccountResult();
    }
}
