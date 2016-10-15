package com.exam.dao;

import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface SubjectDao {

    public TbSubjectEntity findBySubjectID(Integer subjectID);//��������ID����������
    public TbSubjectEntity findSubjectByTitle(String subjectTitle);//���������������������
    public void  addSubject(TbSubjectEntity subject);//¼������

    public void updateSubject(TbSubjectEntity subject);//��������

    //public TbSubjectEntity fingAllSubject();//

    public void deleteSubject(Integer subjectID);//��������ɣ���ɾ������

   // public void modifySubject(String subjectID);//



    //----------------------------------------------------------------

    public List<TbSubjectEntity> findSubjectByPage(Page page);//��ҳ��ѯ����

    public int findSubjectCount();//��ѯ��������

    public List<TbSubjectEntity> likeQueryByTitle(String subjectTitle,Page page);//�����������ģ����ѯ����

    public int findLikeQueryCount(String subjectTitle);//��ѯģ����¼��

    public List<TbSubjectEntity> randomFindSubject(int number);//��ʱȡ����¼��

}
