<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.File" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/background/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>文件下载</title>
	<%@ include file="/WEB-INF/pages/background/common/meta.jsp"%>
	<style>
		<!--css 样式表-->
	</style>

	
	<script type="text/javascript">

	</script>
</head>
<body>
	<div title="文件下载" style="padding:10px">
		<form method="post" id="downloadText" action="${ctx}/download/download">
			文件名称：<input type="text" name="filename" />
			<input type="submit" value="下载" />
		<form>
		<%
		String time = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		String path = request.getServletContext().getRealPath("upload") + "/" + time;
		File file = null;
		file = new File(path);
		if (file.exists()) {
			File[] list = file.listFiles();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			for (File f : list) {
				String name = f.getName();
				response.getWriter().write("<a href='download?filename=" + name + "'>" + name + "</a><br/>");
			}
		} else {
			response.getWriter().write("暂无文件下载");
		}
		%>
	</div>
</body>
</html>