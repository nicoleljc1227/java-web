package com.exam.service;

import com.exam.po.TbSubjectEntity;
import com.exam.util.Page;
import com.exam.util.PageResult;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public interface SubjectService {


   //������� �����ж���������Ƿ��Ѿ����� ������ڲ������
    public boolean saveSubject(TbSubjectEntity subject);

    //���շ�ҳ��Ϣ��ѯ����

    public PageResult querySubjectByPage(Page page);

    //�鿴������ϸ��Ϣ
    public TbSubjectEntity showSubjectParticular(int subjectID);

    //ɾ������

    public void deleteSubject(int subjectID);

    //��������
    public void updateSubject(TbSubjectEntity subject);

    //ģ����ѯ������Ϣ
    public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);

    //�����ѯ�����¼

    public List<TbSubjectEntity> randomFindSubject(int number);

    //����ѧ���÷�
    public int accountResult(List<Integer> subjectID,List<String> studentAnswers);


}
