<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>试题添加页面</title>
    <style type="text/css">
    </style>
    <link href="/WEB-INF/images/skin.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="17" valign="top" background="/WEB-INF/images/mail_leftbg.gif"><img src="/WEB-INF/images/left-top-right.gif" width="17" height="29" /></td>
        <td valign="top" background="/WEB-INF/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
            <tr>
                <td height="31"><div class="titlebt">录入试题</div></td>
            </tr>
        </table></td>
        <td width="16" valign="top" background="/WEB-INF/images/mail_rightbg.gif"><img src="/WEB-INF/images/nav-right-bg.gif" width="16" height="29" /></td>
    </tr>
    <tr>
        <td valign="middle" background="/WEB-INF/images/mail_leftbg.gif">&nbsp;</td>
        <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="53%" valign="top">&nbsp;</td>
            </tr>
            <tr>
                <td valign="middle"><span class="left_txt">
			<div id="addSubjectForm" align="center"><!--录入试题表单-->
                <form action="subjectAdd.action" method="post">
                    <table border="0" cellspacing="10" cellpadding="0">
                        <tr>
                            <td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
                        </tr>
                        <tr>
                            <td>试题题目:</td>
                            <td><input type="text" name="subjectTitle" size="80" ></td>
                        </tr>
                        <tr>
                            <td>选项A:</td>
                            <td><input type="text" name="subjectOptionA" size="20" ></td>
                        </tr>
                        <tr>
                            <td>选项B:</td>
                            <td><input type="text" name="subjectOptionB" size="20" ></td>
                        </tr>
                        <tr>
                            <td>选项C:</td>
                            <td><input type="text" name="subjectOptionC" size="20" ></td>
                        </tr>
                        <tr>
                            <td>选项D:</td>
                            <td><input type="text" name="subjectOptionD" size="20" ></td>
                        </tr>
                        <tr>
                            <td>答案:</td>
                            <td>
                                <input name="subjectAnswer" type="radio" value="A" checked>A
                                <input name="subjectAnswer" type="radio" value="B">B
                                <input name="subjectAnswer" type="radio" value="C">C
                                <input name="subjectAnswer" type="radio" value="D">D
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">试题解析:</td>
                            <td>
                                <textarea name="subjectParse" cols="76" rows="10"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><div align="center">
                                <input type="submit" value="录入">
                                <input type="reset" value="重置">
                            </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
                </td>
            </tr>

        </table></td>
        <td background="/WEB-INF/images/mail_rightbg.gif">&nbsp;</td>
    </tr>
    <tr>
        <td valign="bottom" background="/WEB-INF/images/mail_leftbg.gif"><img src="/WEB-INF/images/buttom_left2.gif" width="17" height="17" /></td>
        <td background="/WEB-INF/images/buttom_bgs.gif"><img src="/WEB-INF/images/buttom_bgs.gif" width="17" height="17"></td>
        <td valign="bottom" background="/WEB-INF/images/mail_rightbg.gif"><img src="/WEB-INF/images/buttom_right2.gif" width="16" height="17" /></td>
    </tr>
</table>

</body>
</html>