package com.exam.action;

import com.exam.po.TbSubjectEntity;
import com.exam.service.SubjectService;
import com.exam.service.SubjectServiceImp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/15.
 * �鿴�����
 */
public class ShowSubjectAnswer extends ActionSupport {


    private SubjectService subjectService = new SubjectServiceImp();
    private String subjectAnswer;
    private int subjectID;

    public String execute() throws Exception{

        List<TbSubjectEntity> subjects = new ArrayList<TbSubjectEntity>();//���濼������Ŀ
        HttpServletRequest request = ServletActionContext.getRequest();

        Map session = ActionContext.getContext().getSession();

        List<Integer> subjectIDs = (List<Integer>) session.get("subjectIDs");
        for (Integer subjectID:subjectIDs){
            TbSubjectEntity subject = subjectService.showSubjectParticular(subjectID);//ͨ�������Ų�������
            subjects.add(subject);
        }
        request.setAttribute("subjects",subjects);
        return SUCCESS;


    }
}
