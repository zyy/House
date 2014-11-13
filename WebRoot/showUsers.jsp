<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

 
<html>
  <head>
    <html:base />
    
    <title>用户信息</title>

<link rel="stylesheet" type="text/css" href="skin/css/base.css">	 
  </head>
  
  <body>
     <!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
    <input type='button' class="coolbg np" onClick="location='';" value='用户信息' />
     
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   --> 

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp; &nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="6%">序号</td> 
	<td width="20%">用户名</td>
	<td width="10%">密码</td>
	<td width="">联系电话</td>
	<td width="">电子邮箱</td>
	<td width="">详细资料</td> 
	<td width="10%">操作</td>
</tr>

<logic:notEmpty name="ulist">
  <logic:iterate id="user" name="ulist" indexId="i">
  <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>${i+1 }</td> 
	<td>${user.uname}</td>
	<td>******</td>
	<td>${user.phone }</td>
	<td>${user.email }</td>
	<td>
	 <logic:empty name="user" property="info">
	    无
	 </logic:empty>
	 <logic:notEmpty name="user" property="info">
	    <a href='users.do?method=getUser&uid=${user.uid }'><u>点击查看</u></a>
	 </logic:notEmpty>
	</td>
	<td><a href="101">删除</a></td>
</tr>
  </logic:iterate>
</logic:notEmpty>
 
<tr bgcolor="#FAFAF1">
<td height="28" colspan="10">
	&nbsp;
	 
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="right"><!--翻页代码 -->
	 共有${allCount }条记录，当前第${showPage }页，共${allPage }页&nbsp;
					<a href="users.do?method=showUsers&showPage=1"
						class="coolbg">首页</a>
					<logic:notEqual name="showPage" value="1">
						<a
							href="users.do?method=showUsers&showPage=${showPage-1 }"
							class="coolbg">上一页</a>
					</logic:notEqual>
					<logic:lessThan name="showPage" value="${allPage}">
						<a
							href="users.do?method=showUsers&showPage=${showPage+1 }"
							class="coolbg">下一页</a>
					</logic:lessThan>
					<a href="users.do?method=showUsers&showPage=${allPage}"
						class="coolbg">尾页</a>
	</td>
</tr>
</table>
 

<!--  搜索表单  -->
<html:form  action='users.do?method=showUsers&showPage=1' method='post'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr><td>
          请输入用户名关键字：
        </td>
        <td width='160'>
        <html:text property="uname"></html:text>
        </td>
       
        <td>
          <input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
         
        </td>
        <td>
         <logic:notEmpty name="usersForm" property="uname">
             &nbsp;&nbsp;<a href="users.do?method=showUsers&showPage=1" class="coolbg"><img src="images/back.gif">返回所有数据</a>
          </logic:notEmpty>
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</html:form>
  </body>
</html>
