package com.exam.po;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
@Table(name = "tb_student", schema = "", catalog = "db_examsystem")
public class TbStudentEntity {
    private String studentId;
    private String password;
    private String studentName;
    private Integer result;
    private String sclass;

    @Id
    @Column(name = "studentID")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "studentName")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "result")
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "sclass")
    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbStudentEntity that = (TbStudentEntity) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (sclass != null ? !sclass.equals(that.sclass) : that.sclass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = studentId != null ? studentId.hashCode() : 0;
        result1 = 31 * result1 + (password != null ? password.hashCode() : 0);
        result1 = 31 * result1 + (studentName != null ? studentName.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (sclass != null ? sclass.hashCode() : 0);
        return result1;
    }
}
