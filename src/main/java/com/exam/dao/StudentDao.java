package com.exam.dao;

import com.exam.po.TbStudentEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public interface StudentDao {

    public TbStudentEntity findByStudentID(String studentID);//��ѯ���� ����I�Ĳ�ѯ��

    public void updateStudent(TbStudentEntity student);//����ѧ����Ϣ

    public List<TbStudentEntity> findByStudentName(String studentName);
        //����ѧ����������
    public List<TbStudentEntity> findByStudentClass(String sclass);



}
