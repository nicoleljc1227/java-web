package com.exam.dao;

import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface SubjectDao {

    public TbSubjectEntity findBySubjectID(Integer subjectID);//根据试题ID来查找试题
    public TbSubjectEntity findSubjectByTitle(String subjectTitle);//根据试题标题来查找试题
    public void  addSubject(TbSubjectEntity subject);//录入试题

    public void updateSubject(TbSubjectEntity subject);//更新试题

    //public TbSubjectEntity fingAllSubject();//

    public void deleteSubject(Integer subjectID);//根据试题ＩＤ来删除试题

   // public void modifySubject(String subjectID);//



    //----------------------------------------------------------------

    public List<TbSubjectEntity> findSubjectByPage(Page page);//分页查询试题

    public int findSubjectCount();//查询试题总量

    public List<TbSubjectEntity> likeQueryByTitle(String subjectTitle,Page page);//根据试题标题模糊查询试题

    public int findLikeQueryCount(String subjectTitle);//查询模糊记录数

    public List<TbSubjectEntity> randomFindSubject(int number);//随时取出记录数

}
