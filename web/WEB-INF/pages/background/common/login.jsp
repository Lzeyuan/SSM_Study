<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/background/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理系统</title>
	
	<%@ include file="/WEB-INF/pages/background/common/meta.jsp"%>

 	<script type="text/javascript">
 		//javascript代码
 		
 	</script>
</head>
<body onload="javascript:document.loginForm.username.focus();" style="text-align:center;padding-top:50px;">
	<form name="loginForm" method="post" action="${ctx}/login">
		<div id="logo" >
	      	 <div style="marign-top:40px;margin-bottom:10px;font-size:30px;">后台管理系统</div>
	     </div>
	     <div style="border:2px solid #cccccc;width:300px;margin:auto;padding:5px;">
	     	 <div>
	        	用户名：<input type="text" class="text" name="username" maxlength="20"/>
	         </div>
	         <div style="margin:10px;">
	         	密&nbsp;&nbsp;&nbsp;码：<input type="password" class="text" name="password" />
	         </div>
		     <div>
		         <input type="submit" class="submit" title="登录" value="登录" />
		         <input type="submit" class="reset" title="重置" value="重置" />
		     </div>
	     </div>
	</form>
</body>
</html>