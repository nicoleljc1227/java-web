package com.exam.po;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
@Table(name = "tb_teacher", schema = "", catalog = "db_examsystem")
public class TbTeacherEntity {
    private int teacherId;
    private String password;

    @Id
    @Column(name = "teacherID")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbTeacherEntity that = (TbTeacherEntity) o;

        if (teacherId != that.teacherId) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherId;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
