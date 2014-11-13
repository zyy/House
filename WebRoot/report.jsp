<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
     
    <title>举报房源</title>
<LINK rev=stylesheet href="files/public.css" type=text/css rel=stylesheet></LINK>
<LINK rev=stylesheet href="files/rent.css" type=text/css rel=stylesheet></LINK>

</HEAD>
<BODY>
<DIV class=header>
<DIV class=top>
<DIV class=loginBar>
<DIV class=loginList>
<LI>您好${users.uname }！欢迎来到易缘居找房！ </LI>
<LI><A title=登录 href="userLogin.jsp" target=_blank>[登录]</A></LI>
<LI><A title=免费注册 href="regUsers.jsp">[免费注册]</A> </LI>
</DIV>
</DIV>
<DIV class=logo><A href="index.html"><IMG height=45 alt=''
src="images/logo-esf.gif" width=140></A></DIV>
</DIV>
<DIV class=header_BottomL></DIV>
<DIV class=header_BottomC>

<DIV class=nav_second>
<UL>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="index.jsp">租房首页</A> </LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="">出 租</A></LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="">求 租</A></LI>

  <LI class=nav_second1 style="BACKGROUND: none transparent scroll repeat 0% 0%; WIDTH: 130px"><A 
  href="http://bbs.xa.eeju.com/group/en_broker">个人中心</A> </LI>
</UL>
</DIV>
<DIV class=seach_box> 

 

</DIV>
</DIV>

<SCRIPT type=text/javascript src="files/jquery-1.3.min.js"></SCRIPT>


<script type="text/javascript">
 function checkdata(){
    var type1=document.getElementById("type1");
    var type2=document.getElementById("type2");
    if(!type1.checked && !type2.checked){
       alert("请选择举报内容");
       return false;
    }
    return true;
 }
 function back(id){
    window.location="leaseRoom.do?method=getleaseRoom&id="+id;
 }
</script>
 


<DIV style="PADDING-BOTTOM: 60px; PADDING-TOP: 60px" align=center>
<FORM id=reportform onSubmit="return checkdata();" method=post name=reportform action="actTable.do?method=addAct">
<DIV style="WIDTH: 600px" align=center>
<DIV style="FLOAT: left"><IMG src="images/report.gif"></DIV>
<DIV style="FLOAT: left" align=center>

<DIV style="PADDING-BOTTOM: 8px; PADDING-LEFT: 70px; FONT-SIZE: 14px" 
align=left><INPUT value="房源已租或不存在" type=radio name=type id="type1">房源不存在 </DIV>
<input type="hidden" name="rid" value="${actTableForm.rid }">
<DIV style="PADDING-BOTTOM: 8px; PADDING-LEFT: 70px; FONT-SIZE: 14px" 
align=left><INPUT value="价格不真实" type=radio name=type id="type2">价格不真实 </DIV>

<DIV style="PADDING-BOTTOM: 8px; PADDING-LEFT: 70px; FONT-SIZE: 14px" 
align=left>其他举报信息： <textarea rows="" cols="" name="remark"></textarea> </DIV>

<DIV 
style="PADDING-BOTTOM: 8px; PADDING-LEFT: 3px"><STRONG>您确认要举报该房源？</STRONG></DIV>
<DIV style="MARGIN: 10px 0px 50px 80px; WIDTH: 300px" align=center>
<input type="image" src="images/sale2.gif">
<input type="image" src="images/sale1.gif" onclick="reset();back(${actTableForm.rid });return false;">
</DIV>
<DIV style="CLEAR: left"></DIV> </FORM></DIV>
<DIV class=footer>
<DIV style="HEIGHT: 10px"><SPAN></SPAN></DIV>
<DIV 
style="TEXT-ALIGN: center; BORDER-TOP: rgb(224,224,224) 1px solid; PADDING-TOP: 10px" 
id=topic></DIV>
<DIV style="TEXT-ALIGN: center; PADDING-TOP: 5px">Copyright 2010 WWW.EEJU.COM 
All Rights Reserved </DIV>
<DIV style="TEXT-ALIGN: center; PADDING-TOP: 5px" align=center><SPAN><A 
href="http://www.miibeian.gov.cn/">备05026813号</A></SPAN></DIV>
</DIV>
</BODY>
</html:html>
