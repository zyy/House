<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
  <head>
    
    <title>用户个人资料</title>
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

<SCRIPT language=JavaScript src="files/Validator.js"></SCRIPT>


<SCRIPT language=javascript src="files/HouseAdd.js"></SCRIPT>

<SCRIPT language=javascript src="files/fajax.js"></SCRIPT>

<SCRIPT language=javascript src="files/comm.js"></SCRIPT>

<script type="text/javascript">
   function logout(){
     if(confirm("你确定要退出吗？")){
       window.location="users.do?method=logout&fromto=user";
     }
   }
   
  function checkupdate(){
    var email=document.getElementById("email").value;
    var phone=document.getElementById("phone").value;
    var truename=document.getElementById("truename").value;
    var address=document.getElementById("address").value;
    var file=document.getElementById("file").value;
    var remark=document.getElementById("remark").value;
    
    var patrnP=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9})$|(15[0-9]{9})$/; 
    
    if(truename==""&& address==""&& file==""&& remark==""){
       alert("请认真填写你的资料!");
       return false;
    }
    
    
    if(phone=="")
    {
        alert("联系电话不能为空");
        return false;
    }
    if(!patrnP.exec(phone)){
       alert("联系电话输入格式不正确");
       return false;
    }
       
    var patrnE=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    if(email!="" && !patrnE.exec(email))
    {
       alert("电子邮箱输入格式不正确");
       return false;
    }
    if(!confirm("是否保存你的资料？")){
       return false;
    } 
    return true ;
  }
 
</script>

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
 <font color="#0000FF">个人资料</font>

</div>
</DIV></DIV></DIV>
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
  class=ico1>个人房源管理</SPAN></A> 
  <br><br>
  </DD>
  </DL><DIV class=adorn_bottom></DIV></DIV>
<DIV id=right5>
<UL class=tab>
  <LI class=active>用户详细信息 </LI>
  <LI class=normal><A href=update_pwd.jsp>修改密码</A> </LI>
  </UL>
<DIV class=wrap>
<DIV class=public>
<html:form action="usersInfo?method=AddUsersinfo" method="post" onsubmit="return checkupdate();" enctype="multipart/form-data">
<input type="hidden" name="uid" value="${users.uid }">
<DIV class=information>
<DIV class="info individual">
<TABLE>
  <TBODY>
  <TR>
    <TH align="right" width="100">用户名：</TH>
    <TD align="left">${users.uname}
     <input type="hidden" value="${users.uname}" name="uname">
    </TR>
   <TR>
    <TH>电子邮箱：</TH>
    <TD align="left"><INPUT name=email id="email" value="${users.email}"></TD></TR> 
     <TR>
    <TH>联系电话：</TH>
    <TD align="left"><INPUT name="phone" id="phone" value="${users.phone }"></TD></TR>
  <TR>
    <TH>真实姓名：</TH>
    <TD align="left">
    <logic:notEmpty name="users" property="info">
      <INPUT name=truename id="truename" value="${users.info.truename }">
    </logic:notEmpty>
    <logic:empty name="users" property="info">
      <INPUT name=truename id="truename" value="">
    </logic:empty>
    </TD></TR>
  <TR>
    <TH>性别： </TH>
    <TD class=label align="left">
    <INPUT type=radio  value=0  name=sex>保密 
      <INPUT type=radio CHECKED value=1 name=sex id="sex1">男 <INPUT 
      type=radio value=2 name=sex id="sex2">女 </TD></TR>
  <TR>
    <TH>地   址：  </TH>
    <TD align="left">
    <logic:notEmpty name="users" property="info">
      <INPUT name=address id="address" value="${users.info.address }" size="30"> 
    </logic:notEmpty>
    <logic:empty name="users" property="info">
      <INPUT name=address id="address" value="" size="30"> 
    </logic:empty>
    </TD></TR>
  <TR>
    <TH>头像：</TH>
    <td align="left">
     <logic:notEmpty name="users" property="info"> 
            <c:if test="${users.info.image!='' }">
              <IMG alt="" src="uploadIMG/${users.info.image }" width=120 height=120><br>
            </c:if> 
            <INPUT id="file"  type="file" name=image value="${users.info.image }">   
     </logic:notEmpty>
     <logic:empty name="users" property="info"> 
         <INPUT id="file"  type="file" name=image">   
     </logic:empty>
    </TD></TR> 
  <TR>
    <TH valign="top">备注：</TH>
    <TD align="left"><textarea rows="5" cols="50" name="remark" id="remark">${users.info.remark}</textarea></TD></TR>
  <TR>
    <TH></TH>
    <TD align="left"><INPUT class=btn style="background-color:#CC66FF" type=submit value=保存修改>&nbsp;
    <INPUT class=btn style="background-color:#CC66FF" type=submit onclick="reset();return false;" value="重        置">
    </TD></TR></TBODY></TABLE></DIV></DIV></html:form></DIV>
<DIV class=wrap_bottom></DIV></DIV></DIV>
<DIV class=clear></DIV>
<DIV class=footer>
<DIV style="HEIGHT: 10px"><SPAN></SPAN></DIV>
<DIV id=topic 
style="BORDER-TOP: rgb(224,224,224) 1px solid; PADDING-TOP: 10px; TEXT-ALIGN: center"> </DIV>
<DIV style="PADDING-TOP: 5px; TEXT-ALIGN: center" align=center><SPAN><A 
href="http://www.miibeian.gov.cn/">沪ICP备05026813号</A></SPAN></DIV></DIV></DIV></BODY></HTML>