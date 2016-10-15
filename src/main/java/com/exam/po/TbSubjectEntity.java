package com.exam.po;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/12.
 */
@Entity
@Table(name = "tb_subject", schema = "", catalog = "db_examsystem")
public class TbSubjectEntity {
    private int subjectId;
    private String subjectTitle;
    private String subjectOptionA;
    private String subjectOptionB;
    private String subjectOptionC;
    private String subjectOptionD;
    private String subjectAnswer;
    private String subjectParse;

    @Id
    @Column(name = "subjectID")
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "subjectTitle")
    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    @Basic
    @Column(name = "subjectOptionA")
    public String getSubjectOptionA() {
        return subjectOptionA;
    }

    public void setSubjectOptionA(String subjectOptionA) {
        this.subjectOptionA = subjectOptionA;
    }

    @Basic
    @Column(name = "subjectOptionB")
    public String getSubjectOptionB() {
        return subjectOptionB;
    }

    public void setSubjectOptionB(String subjectOptionB) {
        this.subjectOptionB = subjectOptionB;
    }

    @Basic
    @Column(name = "subjectOptionC")
    public String getSubjectOptionC() {
        return subjectOptionC;
    }

    public void setSubjectOptionC(String subjectOptionC) {
        this.subjectOptionC = subjectOptionC;
    }

    @Basic
    @Column(name = "subjectOptionD")
    public String getSubjectOptionD() {
        return subjectOptionD;
    }

    public void setSubjectOptionD(String subjectOptionD) {
        this.subjectOptionD = subjectOptionD;
    }

    @Basic
    @Column(name = "subjectAnswer")
    public String getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(String subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    @Basic
    @Column(name = "subjectParse")
    public String getSubjectParse() {
        return subjectParse;
    }

    public void setSubjectParse(String subjectParse) {
        this.subjectParse = subjectParse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbSubjectEntity that = (TbSubjectEntity) o;

        if (subjectId != that.subjectId) return false;
        if (subjectTitle != null ? !subjectTitle.equals(that.subjectTitle) : that.subjectTitle != null) return false;
        if (subjectOptionA != null ? !subjectOptionA.equals(that.subjectOptionA) : that.subjectOptionA != null)
            return false;
        if (subjectOptionB != null ? !subjectOptionB.equals(that.subjectOptionB) : that.subjectOptionB != null)
            return false;
        if (subjectOptionC != null ? !subjectOptionC.equals(that.subjectOptionC) : that.subjectOptionC != null)
            return false;
        if (subjectOptionD != null ? !subjectOptionD.equals(that.subjectOptionD) : that.subjectOptionD != null)
            return false;
        if (subjectAnswer != null ? !subjectAnswer.equals(that.subjectAnswer) : that.subjectAnswer != null)
            return false;
        if (subjectParse != null ? !subjectParse.equals(that.subjectParse) : that.subjectParse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectId;
        result = 31 * result + (subjectTitle != null ? subjectTitle.hashCode() : 0);
        result = 31 * result + (subjectOptionA != null ? subjectOptionA.hashCode() : 0);
        result = 31 * result + (subjectOptionB != null ? subjectOptionB.hashCode() : 0);
        result = 31 * result + (subjectOptionC != null ? subjectOptionC.hashCode() : 0);
        result = 31 * result + (subjectOptionD != null ? subjectOptionD.hashCode() : 0);
        result = 31 * result + (subjectAnswer != null ? subjectAnswer.hashCode() : 0);
        result = 31 * result + (subjectParse != null ? subjectParse.hashCode() : 0);
        return result;
    }
}
