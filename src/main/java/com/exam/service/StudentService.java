package com.exam.service;

import com.exam.po.TbStudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface StudentService {
    //�ж��Ƿ��ǺϷ���ѧ��
    public boolean allowLogin(String studentID,String password);
    //���ѧ����Ϣ
    public TbStudentEntity getStudentInfo(String studentID);
    //����ѧ���ɼ�

    public void setStudentResult(String studentID, int result);
    //����ѧ������s����ѧ��
    public List<TbStudentEntity> getStudentByName(String studentName);
    //���ݰ༶����ѧ��
    public List<TbStudentEntity> getStudentByClass(String sclass);

}
