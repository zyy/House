<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
	<head>

		<title>用户注册</title>

		<LINK href="files/eeju.css" type=text/css rel=stylesheet>

		<script type='text/javascript' src='/House/dwr/interface/user.js'></script>
		<script type='text/javascript' src='/House/dwr/engine.js'></script>

<script type="text/javascript">
 function checkReg()
 {   
		var uname=document.getElementById("uname").value;
		
		var upwd=document.getElementById("upwd").value;
		
		var qr_pwd=document.getElementById("qr_pwd").value;
		
	    var email=document.getElementById("email").value;
	    
	    var phone=document.getElementById("phone").value;
		if(uname=="")
		{
			alert("用户名不能为空");
			return false;
		}
		if(uname.length<3 || uname.length>16)
		{
			alert("用户名长度不正确");
			return false;
		}
		if(upwd=="")
		{
			alert("密码不能为空");
			return false;
		}
		if(upwd.length<6 || upwd.length>16)
		{
			alert("密码长度不正确");
			return false;
		}
		
		if(qr_pwd=="")
		{
			alert("请输入确认密码");
			return false;
		}
	    if(upwd!=qr_pwd)
		{
		
			alert("密码输入不一致！");
			return false;
		}
		
	  var patrnP=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9})$|(15[0-9]{9})$/; 
       if(phone=="")
       {
         alert("请输入联系电话");
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
    return true;
  
  }
function checkUser(){
   
   var uname=document.getElementById("uname").value;
   var sub=document.getElementById("sub");
   
   user.getUsers(uname,function(isuser){
       if(isuser!=null){
         alert("该用户已存在");
        sub.disabled=true;
      }else{
          sub.disabled=false;
      }
   });
}
 	
</script>
</head>

	<BODY leftMargin=0 topMargin=0>
		<DIV align=center>
			<TABLE height=70 cellSpacing=0 cellPadding=0 width="100%"
				background=images/bg.gif border=0>
				<TBODY>
					<TR>
						<TD height=70>
							<TABLE height="100%" cellSpacing=0 cellPadding=0 width=750
								align=center border=0>
								<TBODY>
									<TR>
										<TD align=right width=200 rowSpan=2>
											&nbsp;
										</TD>
										<TD align=right height=30>
											<IMG height=12 src="images/dot_circle.gif" width=12
												align=absMiddle>
											<A href="index.jsp" target=_blank><FONT color=#00ae57>首页</FONT>
											</A>&nbsp;&nbsp;
									<TR>
										<TD class=shadow1 align=middle>
											&nbsp;
										</TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD bgColor=#000000 height=1></TD>
					</TR>
				</TBODY>
			</TABLE>
			<TABLE cellSpacing=0 cellPadding=0 width=777 bgColor=#ffffff border=0>
				<TBODY>
					<TR>
						<TD height=50></TD>
					</TR>
					<TR>
						<TD vAlign=top>
							<TABLE cellSpacing=0 cellPadding=0 width=700 align=center border=0 
      valign="bottom">
        <TBODY>
        <TR>
          <TD width=100 height=26>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD width=10 height=8><IMG height=8 
                  src="images/tab_01.gif" width=10></TD>
                <TD background=images/tab_02.gif><IMG height=8 
                  src="images/tab_02.gif" width=80></TD>
                <TD width=17><IMG height=8 src="images/tab_03.gif" 
                  width=17></TD></TR>
              <TR>
                <TD background=images/tab_04.gif height=19>&nbsp;</TD>
                <TD align=middle bgColor=#f4f4f4>
                <DIV align=center><FONT color=#666666><A 
                  href="userLogin.jsp">用户登录</A></FONT></DIV>
                </TD>
                <TD width=17 
              background=images/tab_06.gif>&nbsp;</TD></TR></TBODY></TABLE></TD>
          <TD width=100>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" align=center 
            border=0>
              <TBODY>
              <TR>
                <TD width=10 height=8><IMG height=8 
                  src="images/tab_01.gif" width=10></TD>
                <TD width=80 background=images/tab_02.gif><IMG height=8 
                  src="images/tab_02.gif" width=80></TD>
                <TD width=12><IMG height=8 src="images/tab_03.gif" 
                  width=17></TD></TR>
              <TR>
                <TD background=images/tab_04.gif height=17>&nbsp;</TD>
                <TD align=middle bgColor=#f4f4f4>
                 <DIV align=center><FONT color=#ff0000>用户注册</FONT></DIV>
                </TD>
                <TD 
            background=images/tab_06.gif>&nbsp;</TD></TR></TBODY></TABLE></TD>
          <TD width=100>&nbsp; </TD>
          <TD width=100>&nbsp; </TD>
          <TD width=100>&nbsp;</TD>
          <TD width=100>&nbsp;</TD>
          <TD width=100>&nbsp;</TD></TR></TBODY></TABLE>
							<TABLE style="BORDER-LEFT: #bcbcbc 1px solid" cellSpacing=0
								cellPadding=0 width=700 align=center border=0>
								<TBODY>
									<TR>
										<TD width=93 background=images/img_title2.gif height=58>
											&nbsp;
										</TD>
										<TD
											style="FONT-WEIGHT: bold; FONT-SIZE: 26px; COLOR: #ff3300; LINE-HEIGHT: 100%; PADDING-TOP: 10px"
											vAlign=center align=left width=395
											background=images/img_title2.gif>
											用户免费注册
										</TD>
										<TD style="BORDER-RIGHT: #bcbcbc 1px solid" align=right
											width=211 background=images/img_title2.gif>
											&nbsp;
										</TD>
									</TR>
									<TR>
										<TD colSpan=3>
											<TABLE
												style="BORDER-RIGHT: #bcbcbc 1px solid; BORDER-TOP: #bcbcbc 1px; BORDER-BOTTOM: #bcbcbc 1px solid"
												height=280 cellSpacing=0 cellPadding=0 width="100%"
												align=center bgColor=#f4fff8 border=0>
												<TBODY>
													<TR>
														<TD vAlign=center align=middle>
															<TABLE align=center>
																<TBODY>
																	<TR>
																		<TD></TD>
																	</TR>
																</TBODY>
															</TABLE>

															<FORM name=form1 action="users.do?method=addUsers"
																method="post" onsubmit="return checkReg();">


																<TABLE cellSpacing=4 cellPadding=0 width=649 border=0>
																	<TBODY>
																		<TR>
																			<TD style="PADDING-LEFT: 25px; FONT-SIZE: 14px"
																				align=left height=31>
																				用户注册(注: 打
																				<FONT color=#ff0000>*</FONT> 必须填写)
																			</TD>
																		</TR>
																		<TR>
																			<TD class=z02 align=middle>
																				<TABLE cellSpacing=3 cellPadding=0 width=599
																					border=0>
																					<TBODY>
																						<TR vAlign=center align=left>
																							<TD width=100 height=30>
																								&nbsp;用 户 名：
																								
																							</TD>
																							<TD>
																							<DIV class=errMsgDiv id=ErrMsg1>
																							<INPUT class=txtinput1 maxLength=16 size=26
																									name=uname id="uname" onblur="checkUser();">
																								<FONT class=font_deep>*</FONT>
																									<FONT color=#999999>(3-16位,
																										请不要用空格、全角字母和特殊字符)</FONT>
																								</DIV>
																							</TD>
																						</TR>
																						<TR vAlign=center align=left>
																							<TD width=100 height=30>
																								&nbsp;密 码：
																								
																							</TD>
																							<TD>
																								<DIV>
																								<INPUT class=txtinput1 type=password
																									maxLength=16 size=28 name=upwd id="upwd">
																								<FONT class=font_deep>*</FONT>
																									<FONT color=#999999>(6-16位的数字、字母)</FONT>
																								</DIV>
																							</TD>
																						</TR>
																						<TR vAlign=center align=left>
																							<TD width=100 height=30>
																								&nbsp;确认密码：
																								
																							</TD>
																							<TD>
																								<DIV>
																								<INPUT class=txtinput1 type=password
																									maxLength=20 size=28 name=qr_pwd id="qr_pwd">
																								<FONT class=font_deep>*</FONT>
																									<FONT color=#999999>(重复输入以上密码)</FONT>
																								</DIV>
																							</TD>
																						</TR>
																						<TR vAlign=center align=left>
																							<TD width=100 height=30>
																								&nbsp;电 话：
																							</TD>
																							<TD>
																								<INPUT class=txtinput1 maxLength=15 size=26
																									name=phone id="phone">
																									<FONT class=font_deep>*</FONT>
																									<FONT color=#999999>(移动手机或固定电话)</FONT>
																							</TD>
																						</TR>
																						<TR>
																							<TD height=30 width=100>
																								&nbsp;Ｅ－mail：
																							</TD>
																							<TD >
																							<INPUT class=txtinput1 maxLength=50 size=26
																									name=email id="email">
																								&nbsp;
																							</TD>
																						</TR>
																						<TR vAlign=center align=left>
																						<TR vAlign=top align=left>
																							<TD colSpan=2 height=35>
																								<TABLE cellSpacing=0 cellPadding=0 width=567
																									border=0>
																									<TBODY>
																										<TR>
																											<TD vAlign=top align=left width=72>
																												&nbsp;
																											</TD>
																											<TD vAlign=center align=left width=495>
																												<DIV align=center></DIV>
																											</TD>
																										</TR>
																										<TR>
																											<TD vAlign=top align=left>
																												&nbsp;
																											</TD>
																											<TD vAlign=center align=left>
																												<DIV align=center>
																													&nbsp;&nbsp;&nbsp;
																												</DIV>
																											</TD>
																										</TR>
																									</TBODY>
																								</TABLE>
																							</TD>
																						</TR>
																					</TBODY>
																				</TABLE>
																				<BR>
																				<INPUT type=submit value="确认提交" 
																					id="sub">
																					<input type="reset" value="取消">
																			</TD>
																		</TR>
																	</TBODY>
																</TABLE>
															</FORM>
															<TABLE height=14 width=16 align=center>
																<TBODY>
																	<TR>
																		<TD></TD>
																	</TR>
																</TBODY>
															</TABLE>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<P>
								&nbsp;
							</P>
						</TD>
					</TR>
					<TR>
						<TD height=30></TD>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
	</BODY>
</HTML>