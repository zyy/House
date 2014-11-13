<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    
    <title>My JSP 'ajax_upimage.jsp' starting page</title>
  <SCRIPT language=javascript src="files/jquery-1.3.min.js"></SCRIPT>

<SCRIPT>
function upsave(){
   var status = window.parent.$('#create_album').attr('checked');
   if(status){
     window.parent.create_album();
   }else{
     window.parent.alert1 = 0;
     $('#upform').submit();
   }
}
</SCRIPT>

<STYLE>#upform {
	BACKGROUND: #f5f5f5
}
</STYLE>

<META name=GENERATOR content="MSHTML 8.00.7600.16588"></HEAD>
<BODY>
<FORM id=upform encType=multipart/form-data method=post action=ajax_ImageUp.php 
target=iframeUpload>
<IFRAME style="DISPLAY: none" height=35 src="about:blank" frameBorder=0 
width=350 name=iframeUpload scrolling=no></IFRAME><INPUT id=albumname value=0 
type=hidden name=albumname> <INPUT id=albumid value=-1 type=hidden name=albumid> 
<INPUT id=sn_up_img onchange=upsave() type=file name=sn_up_img> 
</FORM>
</BODY></HTML>