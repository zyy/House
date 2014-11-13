<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">

<HTML>
<HEAD>
<TITLE>修改密码</TITLE>
<logic:empty name="users">
   <logic:redirect href="userLogin.jsp"></logic:redirect>
</logic:empty>
<LINK href="files/public.css" type=text/css rel=stylesheet>
<LINK href="files/user.css" type=text/css rel=stylesheet>
<LINK href="files/style.css" type=text/css rel=stylesheet>
<LINK href="files/page.css" type=text/css rel=stylesheet>

<logic:empty name="users">
   <logic:redirect href="userLogin.jsp"></logic:redirect>
</logic:empty>




<SCRIPT language=javascript src="files/Zly.js"></SCRIPT>

<SCRIPT language=javascript src="files/ajax.js"></SCRIPT>

<script type="text/javascript">
	 function checkpwd()
	{
		
		var upwd=document.getElementById("upwd").value;
	    var upwd1=document.getElementById("upwd1").value;
		if(upwd=="")
		{
			alert("请输入原密码");
			return false;
		}
		if(upwd!=upwd1)
		{
		   alert("原密码输入不正确");
		   return false;
		}
		var newpwd=document.getElementById("newpwd").value;
		if(newpwd=="")
		{
			alert("请输入新密码");
			return false;
		}
		var confirm=document.getElementById("confirm").value;
		if(confirm=="")
		{
			alert("请输入确认密码");
			return false;
		}
		if(newpwd!=confirm)
		{
		   alert("两次输入密码不一致");
		   return false;
		}
	}
 	
</script>

<SCRIPT language=JavaScript src="files/Validator.js"></SCRIPT>

<SCRIPT language=javascript src="files/HouseAdd.js"></SCRIPT>

<SCRIPT language=javascript src="files/fajax.js"></SCRIPT>

<SCRIPT language=javascript src="files/comm.js"></SCRIPT>

<META content="MSHTML 6.00.2900.5945" name=GENERATOR>
</HEAD>
<BODY>
<DIV id="header">
<DIV style="HEIGHT: 40px">
<DIV style="FLOAT: left; WIDTH: 300px">
<H1 title=eeju><A href="http://xa.eeju.com/user/index.php"><IMG alt=eeju 
src="images/logo-esf.gif"></A></H1></DIV>
<DIV style="PADDING-RIGHT: 10px; FLOAT: right; TEXT-ALIGN: right">您好,<b>${users.uname }</b> [<A 
href="javascript:logout();">退出</A>]  <SPAN>|</SPAN> <A class=home 
style="MARGIN-TOP: 3px" href="index.jsp">返回首页</A>
<script type="text/javascript">
   function logout(){
     if(confirm("你确定要退出吗？")){
       window.location="users.do?method=logout&fromto=user";
     }
   }
</script>
</DIV>

<div><br></div>
<DIV class=header_BottomC1>
<DIV class=nav_second>
<UL>
  <LI class=nav_second1 style="WIDTH: 130px">&nbsp;</LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="index.jsp">租房首页</A> </LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="index.jsp">出 租</A></LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A onClick="window.location='qzindex.jsp';" href="javascript:">求 租</A></LI>
  <LI class=nav_second1 style="WIDTH: 130px"><A href="user.jsp">个人中心</A> </LI>
</UL>
</DIV>
<div align="left">&nbsp;&nbsp;
<A href="index.jsp">首页</A> &gt;
<A href="user.jsp">用户中心</A> &gt;&gt;
 <font color="#0000FF">修改个人密码</font>

</div>
</DIV> </DIV></DIV>
<DIV class=content>
 

<DIV id="left" align="left" style="border-style:solid;border-width:1px; border-color:#CCCCCC">
<H2><STRONG title=用户中心></STRONG>
<DIV class=adorn1></DIV>
<DIV class=adorn2></DIV></H2>
<DL>
  <DT>我的账户 </DT>
  <DD><A class=normal href="user.jsp"><SPAN 
  class=ico16>个人信息</SPAN></A> </DD>
  <DD><A class=active href="userInfo.jsp"><SPAN 
   class=ico2>个人资料</SPAN></A> </DD>
   </DL>
<DL>
  <DT>我要找房 </DT>
  
  <DD><A class=normal href="chooseroom.jsp"><SPAN 
  class=ico23>选房单</SPAN></A> </DD></DL>
<DL>
  <DT>我要发布房源 </DT>
  <DD><A class=normal href="usercz.jsp"><SPAN 
  class=pub>发布出租</SPAN></A> </DD>
  
  <DD><A class=normal href="userqz.jsp"><SPAN 
  class=pub>发布求租</SPAN></A> </DD>
  
  </DL>
<DL>
  <DT>房源管理 </DT>
  <DD><A class=normal href="room.jsp"><SPAN 
  class=ico1>个人房源管理</SPAN></A><br><br></DD>
  </DL>
<DIV class=adorn_bottom></DIV></DIV>
<DIV id=right5>
<UL class=tab>
  <LI class=normal><A 
  href="userInfo.jsp">用户详细信息</A> </LI>
  <LI class=active>修改密码 </LI>
  </UL>
<DIV class=wrap>
<DIV class=public>
<form action="users.do?method=updatePwd" method="post" onsubmit="return checkpwd();">
<DIV class=information>
<DIV class="info individual">
<TABLE>
  <TBODY>
  <TR>
    <TH width="100">用户名：</TH>
    <TD align="left">${users.uname}
     
    </TR>
  <TR>
    <TH>原密码： </TH>
    <TD align="left"><INPUT type=password id="upwd" name=upwd></TD></TR>
  <TR>
    <TH>新密码： </TH>
    <TD align="left"><INPUT id=newpwd type=password name=newpwd></TD></TR>
  <TR>
    <TH>确认密码： </TH>
    <TD align="left"><INPUT type=password name=confirm id="confirm"></TD></TR>
  <TR>
    <TH></TH>
    <TD align="left">
    <input type="hidden" name="upwd1" id="upwd1" value="${users.upwd}">
   
    <INPUT class=btn style="background-color:#CC66FF" type=submit value="提 交">
        
    </TD></TR></TBODY></TABLE></DIV></DIV></form></DIV></DIV></DIV>
<DIV class=clear></DIV></DIV>
<DIV class=footer>
<DIV style="HEIGHT: 10px"><SPAN></SPAN></DIV>
<DIV id=topic 
style="BORDER-TOP: rgb(224,224,224) 1px solid; PADDING-TOP: 10px; TEXT-ALIGN: center">
</DIV>
<DIV style="PADDING-TOP: 5px; TEXT-ALIGN: center">Copyright 2010 WWW.EEJU.COM 
All Rights Reserved </DIV>
<DIV style="PADDING-TOP: 5px; TEXT-ALIGN: center" align=center><SPAN><A 
href="http://www.miibeian.gov.cn/">沪ICP备05026813号</A></SPAN></DIV></DIV></BODY></HTML>
