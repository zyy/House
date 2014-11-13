<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>用户房源信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script language="javascript">
function selAll()
{
    var boxs=document.getElementById("boxs");
    alert(boxs.length)
	for(var i=0;i<boxs.length;i++)
	{
		if(boxs[i].checked)
		{
			boxs[i].checked=true;
		}
	}
}
function noSelAll()
{
    var boxs=document.getElementById("");
	for(i=0;i<document.form2.id.length;i++)
	{
		if(document.form2.id[i].checked)
		{
			document.form2.id[i].checked=false;
		}
	}
}


function del(id,rid)
{
	if(confirm("是否删除举报信息?"))
	{
		
		window.location="actTable.do?method=delAct&id="+id+"&rid="+rid;
	}
}



</script>
  </head>
  
  <body>
    <!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center" width=""> 
  <span class="c">房源举报信息</span>
 </td>
 <td align="right" width="80"><a href="leaseRoom.do?method=showRoomAdmin&showPage=1" class="coolbg"><img src="images/back.gif">返回</a>&nbsp;</td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp;房源标题：${rtitle} &nbsp;<font color="red">共${ size}条举报信息</font></td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">序号</td>
	<td width="4%">选择</td>
	<td width="20%">举报内容</td>
	<td width="12%">举报时间</td>
	<td width="8%">发布人</td>
	<td width="8%">举报人</td>
	<td width="6%">操作</td>
</tr>
<logic:notEmpty name="rList">
 <logic:iterate id="room" name="rList" indexId="i">
 <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>${i+1 }</td>
	<td><input name="boxs" type="checkbox" id="boxs" value="${room.id }" class="np"></td>
	
	<td>${room.act }</td>
	<td>${room.time }</td>
	<td>
     <c:if test="${room.leaseRoom.users.info!=null }">
            <c:if test="${room.leaseRoom.users.info.truename=='' }">
              ${room.leaseRoom.users.uname}
            </c:if>
            <c:if test="${room.leaseRoom.users.info.truename!='' }">
              ${room.leaseRoom.users.info.truename }
            </c:if>
      </c:if>
       <c:if test="${room.leaseRoom.users.info==null }">
         ${room.leaseRoom.users.uname }
       </c:if>

  </td>
  	
  	<td>
     <c:if test="${room.users.info!=null }">
            <c:if test="${room.users.info.truename=='' }">
              ${room.users.uname}
            </c:if>
            <c:if test="${room.users.info.truename!='' }">
              ${room.users.info.truename }
            </c:if>
      </c:if>
       <c:if test="${room.users.info==null }">
         ${room.users.uname }
       </c:if>

  </td>

	<td><a href="javascript:del(${room.id },${rlid });" >删除</a> </td>
</tr>
 </logic:iterate>


</logic:notEmpty>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="10">
	&nbsp;
	

</td>
</tr>

</table>


  </body>
</html:html>
