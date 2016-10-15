package com.exam.service;

import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;
import com.exam.util.PageResult;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface SubjectService {


   //添加试题 首先判断试题标题是否已经存在 如果存在不能添加
    public boolean saveSubject(TbSubjectEntity subject);

    //按照分页信息查询试题

    public PageResult querySubjectByPage(Page page);

    //查看试题详细信息
    public TbSubjectEntity showSubjectParticular(int subjectID);

    //删除试题

    public void deleteSubject(int subjectID);

    //更新试题
    public void updateSubject(TbSubjectEntity subject);

    //模糊查询试题信息
    public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);

    //随机查询试题记录

    public List<TbSubjectEntity> randomFindSubject(int number);

    //计算学生得分
    public int accountResult(List<Integer> subjectID,List<String> studentAnswers);


}
