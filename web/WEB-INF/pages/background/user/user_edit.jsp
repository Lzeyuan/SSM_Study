<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/background/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文件上传</title>
	<%@ include file="/WEB-INF/pages/background/common/meta.jsp"%>
	<style>
		<!--css 样式表-->
	</style>

	<script type="text/javascript">
		//新增操作
		function createUser(){
		    jQuery.ajax({
		        type : 'POST',
		        url : '${ctx}/user',
				data : $("#editForm").serialize(),
		        dataType : 'json',
        		beforeSend:function(){},
        		complete:function(){},
		        success : function(data){
		        	$.messager.alert("提示",data.msg);
		        },
		    });
		}
		
		//更新操作
		function updateUser(){
			jQuery.ajax({
				type : 'PUT',
				url : '${ctx}/user',
				data : $("#editForm").serialize(),
				dataType : 'json',
				beforeSend:function(){},
				complete:function(){},
				success : function(data){
					$.messager.alert("提示",data.msg);
				}
			});
		}
		//删除操作
		function deleteUser(){
			jQuery.ajax({
				type : 'DELETE',
				url : '${ctx}/user',
				data : $("#editForm").serialize(),
				dataType : 'json',
				beforeSend:function(){},
				complete:function(){},
				success : function(data){
					$.messager.alert("提示",data.msg);
				}
			});
		}
	</script>
</head>
<body>
	<div style="padding:20px;padding-left:50px;width:400px;text-align:center;">
		<p style="font-size:20px;text-align:center;color:blue;">用户信息编辑</p>
		
		<form method="GET" id="editForm">
		          用户编号：<input type="text" name="code" /><br>
		          用户密码：<input type="password" name="password" /><br>
            &nbsp;&nbsp;&nbsp;用户名：  <input type="text" name="name" /><br>
		          用户年龄：<input type="text" name="age" /><br>
		           出生年月：<input type="text" name="birthday" /><br>
		    <input type="button" value="新增" onclick="createUser()"/>
		    <input type="button" value="更新" onclick="updateUser()"/>
		    <input type="button" value="删除" onclick="deleteUser()"/>
		    <input type="reset" value="重置"/>
		</form>
	</div>
</body>
</html>