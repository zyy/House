<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>添加区域</title>


<script type="text/javascript">
	function checkarea()
	{
		var checkarea=document.getElementById("area").value;
	
		if(checkarea=="")
		{
			alert("区域不能为空");
			return false;
		}
	
	}
</script>
  </head>
  
  <body>
   	
   	<html:form action="/areaType?method=addArea" method="post" onsubmit="return checkarea();">
   	
   	
   	<hr>
   	<font color="red"><H1 align="center">添加区域</H1></font>
   	<hr>
   		<div align="center">
   		<html:text property="area" ></html:text><br>
   		<html:submit>添加</html:submit>&nbsp;&nbsp;&nbsp;<html:reset>重置</html:reset>
		</div>
   		
   	<a href="areaType.do?method=selectArea">返回</a>
   	</html:form>
	
  </body>
</html:html>
