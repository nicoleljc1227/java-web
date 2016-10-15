package com.exam.action;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class GetRandomSubject extends ActionSupport {
    private SubjectService subjectService = new SubjectServiceImp();

    public String execute() throws Exception{
        List<TbSubjectEntity> subjects= subjectService.randomFindSubject(20);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("subjects",subjects);
        return SUCCESS;

    }
}
