package com.exam.action;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.exam.util.Page;
import com.exam.util.PageResult;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15.
 */
public class QuerySubjectAction extends ActionSupport
{
    //�漰����ҳ
    private int currentPage ;//
    private SubjectService subjectService = new SubjectServiceImp();

    public String excute() throws Exception{
        Page page = new Page();
        page.setEveryPage(10);
        page.setCurrentPage(currentPage);
        PageResult pageResult = subjectService.querySubjectByPage(page);

        List<TbSubjectEntity> subjects = pageResult.getList();//��������¼
        page = pageResult.getPage();//��÷�ҳ��Ϣ

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("subjects",subjects);
        request.setAttribute("page",page);

        return SUCCESS;
    }
}
