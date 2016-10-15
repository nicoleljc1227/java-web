package com.exam.action;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.exam.util.Page;
import com.exam.util.PageResult;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class LikeQuerySubjectAction extends ActionSupport {
    private SubjectService subjectService = new SubjectServiceImp();
    private String subjectTitle;//试题标题
    private int currentPage;

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String execute() throws Exception{

        Page page = new Page();
        page.setEveryPage(10);
        page.setCurrentPage(currentPage);
        PageResult pageResult =
        subjectService.likeQueryBySubjectTitle(subjectTitle,page);

        List<TbSubjectEntity> subjects = pageResult.getList();//获得试题记录

        List<TbSubjectEntity> newSubjects = new ArrayList<TbSubjectEntity>();//新的记录
        //给关键字标红
        for (TbSubjectEntity subject:subjects){
            String newTitle = subject.getSubjectTitle().replaceAll(subjectTitle,"<font color='red'>"+subjectTitle+"</font>");
            subject.setSubjectTitle(newTitle);
            newSubjects.add(subject);
        }

        page= pageResult.getPage();//获得分页信息
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("subjects",newSubjects);
        request.setAttribute("page",page);
        return SUCCESS;


    }
}
