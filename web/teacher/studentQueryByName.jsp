<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="/WEB-INF/images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">

</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="/WEB-INF/images/mail_leftbg.gif"><img src="/WEB-INF/images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="/WEB-INF/images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">ѧ���ɼ�</div></td>
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
			<div id="queryForm" align="center"><!--��ѯ��-->
				<form action="queryStudentByName.action" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
				  <tr>
					<td>ѧ������:</td>
					<td><input type="text" name="studentName" size="20" ></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="��ѯ">				  	  
				  	  <input type="reset" value="����">
			  	  </div>				</td>
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
