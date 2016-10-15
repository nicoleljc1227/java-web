package com.exam.service;

import com.exam.dao.SubjectDao;
import com.exam.dao.SubjectDaoImp;
import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;
import com.exam.util.PageResult;
import com.exam.util.PageUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class SubjectServiceImp implements SubjectService {

    private SubjectDao subjectDao = new SubjectDaoImp();
    public boolean saveSubject(TbSubjectEntity subject) {

        String subjectTitle = subject.getSubjectTitle();
        if(subjectDao.findSubjectByTitle(subjectTitle)==null){
            subjectDao.addSubject(subject);
            return true;
        }else {
            return false;

        }
    }

    public PageResult querySubjectByPage(Page page) {
        //根据总记录数 创建分页信息
        page = PageUtil.createPage(page.getEveryPage(),subjectDao.findSubjectCount(),page.getCurrentPage());
        List<TbSubjectEntity> list = subjectDao.findSubjectByPage(page);//通过分页信息取得试题
        PageResult result = new PageResult(page,list);//封装分页信息和记录信息 返回给调用处
        return result;
    }

    public TbSubjectEntity showSubjectParticular(int subjectID) {


        return subjectDao.findBySubjectID(subjectID);
    }

    public void deleteSubject(int subjectID) {
        subjectDao.deleteSubject(subjectID);

    }

    public void updateSubject(TbSubjectEntity subject) {
        subjectDao.updateSubject(subject);
    }

    public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {

        page = PageUtil.createPage(page.getEveryPage(),subjectDao.findSubjectCount(),page.getCurrentPage());

        List<TbSubjectEntity> list = subjectDao.likeQueryByTitle(subjectTitle,page);
        PageResult result = new PageResult(page,list);
        return result;
    }

    public List<TbSubjectEntity> randomFindSubject(int number) {
        return  subjectDao.randomFindSubject(number);
    }

    public int accountResult(List<Integer> subjectIDs, List<String> studentAnswers) {
        int GeneralPoint =0;
        for (int i = 0; i <subjectIDs.size() ; i++) {
            String rightAnswer = subjectDao.findBySubjectID(subjectIDs.get(i)).getSubjectAnswer();
            //
            if (rightAnswer.equals(studentAnswers.get(i))){
                GeneralPoint += 5;//加5分
            }
        }
        return GeneralPoint;
    }
}
