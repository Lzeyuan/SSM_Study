<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
</head>
<body>
	<div style="padding:20px;padding-left:50px;width:500px;text-align:center;">
		<table class="easyui-datagrid" title="用户列表" style="width:472px;height:450px"
					data-options="rownumbers:true,singleSelect:true,collapsible:true,url:'${ctx}/userList',method:'post'">
			<thead>
				<tr>
					<th data-options="field:'code',width:80">用户编号</th>
					<th data-options="field:'name',width:100">用户名</th>
					<th data-options="field:'age',width:80">年龄</th>
					<th data-options="field:'birthday',width:180">出生年月</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${rows}">
				<tr>
					<td>${book.code}</td>
					<td>${book.name}</td>
					<td>${book.age}</td>
					<td><fmt:formatDate type="date" value="${book.birthday}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="padding:20px;padding-left:50px;width:250px;text-align:center;display: inline-block">
				<a href="${ctx}/userList/previous">上一页</a>
				<a href="${ctx}/userList/next">下一页</a>
		</div>
	</div>
</body>
</html>