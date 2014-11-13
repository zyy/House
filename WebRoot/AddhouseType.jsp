<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html>
  <head>
     <title>My JSP 'AddhouseType.jsp' starting page</title>
     <script type="text/javascript">
	function checkhouse()
	{
		var checkhouse=document.getElementById("type").value;
	
		if(checkhouse=="")
		{
			alert("类别不能为空");
			return false;
		}
	
	}
</script>
   </head>
  
  <body bgcolor="#00CCFF">
  <html:form action="houseType?method=addHouse" method="post" onsubmit="return checkhouse();">
   
<div align="center">
<br>
<br>
<br>
<br>
<br>
<br>
 	<table width="250" border="0" bgcolor="#00CCFF">	  
	  <tr>
		<td bgcolor="#00CCFF"><div align="center">
		  <h1>添加房屋类型</h1>
		</div></td>		
	  </tr>
	  <tr>
		<td>		 
		    <table width="250">
		        <tr> 
		           <td width="70" bgcolor="#00CCFF"><div align="center">房屋类型:</div></td>
				   <td width="168" bgcolor="#00CCFF">
				   <div align="left">
				   <input name="type" type="text">
				   </div>
				   </td>
			    </tr>
			    <tr>
			  	   <td bgcolor="#00CCFF"></td>
				   <td bgcolor="#00CCFF">
				     &nbsp;  &nbsp; 
				   <div align="left"><input type="submit" value="添加"> 
				  
				   &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; 
				   <input type="reset" value="取消">
				   	<a href="houseType.do?method=selectHouse_type">返回</a>
				   </div>  </td>
			    </tr>
	        </table>
       </td>		
	  </tr>
	</table>		
</div>  
</html:form>
  </body>
</html>
