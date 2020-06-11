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

	</script>
</head>
<body>
	<div title="文件上传" style="padding:10px">
		<p style="font-size:14px">${upload_messages}</p>
		
		<form  method="post"  enctype="multipart/form-data" action="${ctx}/upload/upload">
		    <input type="file" name="upLoadFile" />
		    <input type="submit" value="上传文件">
		</form>
	</div>
</body>
</html>