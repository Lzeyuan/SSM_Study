<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/pages/background/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户管理系统</title>
	<%@ include file="/WEB-INF/pages/background/common/meta.jsp"%>
	<style>
		<!--css 样式表-->
	</style>

	
	<script type="text/javascript">
		<!-- javascript 脚本 -->
		
		var data = [{
	        state: 'open',
	        children: [{
	            text: '文件上传',
	        },{
	            text: '文件下载'
	            
	        },{
	            text: '用户信息管理'
	        },{
	        	text: '用户信息列表'
	        }]
	    }];
		
		
		function selectItem(item){
	        if(item.text == "文件上传"){
	        	addTab(1,"文件上传",'${ctx}/upload/view');
	        } else if(item.text == "文件下载") {
	        	addTab(2,"文件下载",'${ctx}/download/view');
	        } else if(item.text == "用户信息管理") {
	        	addTab(3,"用户信息管理",'${ctx}/user');
	        } else if(item.text == "用户信息列表") {
				addTab(3,"用户信息管理",'${ctx}/userList');
			}
	    }
		
		//-- 增加标签
		function addTab(tabid,title,url){
			if($('#tabs_bar').tabs('exists',title)){
				$('#tabs_bar').tabs('select',title);
				$('#tabs_bar').tabs('getSelected').find('iframe').attr('src',url);
			}
			else{
				$('#tabs_bar').tabs('add',{
					id:tabid,
    				title:title,
					content:createFrame(url),
    				closable:true,
    				selected:true
				});
			}
		}
		
		//-- 创建frame
		function createFrame(url,frameId){
			var frameIdPart = '';
			if(frameId)
				frameIdPart = 'id=' + frameId;
			var s = '<iframe scrolling="auto" frameborder="0"  '+ frameIdPart + ' src="'+url+'" style="width:100%;height:100%;"></iframe>';
			return s;
		}
	</script>
</head>
<body class="easyui-layout">
	<div region="north" border="false" style="height:60px;background-color:#fff;">
		<div class="page-head">
	    	<div class="page-btn">
	    		<span class="left">欢迎您: [ ${sessionScope.username} ]</span>
	    		<span class="right">
	    			<a class="repwd" href="#">修改密码</a>
	    			<a class="store" onClick="window.external.addFavorite(location.href,document.title)" rel="sidebar"  href="#">收藏</a>
	    			<a class="helf" href="#">帮助</a>
	    			<a class="logout" href="${ctx}/manage/loginout">注销</a>
	    		</span>
	    	</div>
	    	<div class="t_logo_title">管理系统</div>
		</div>
	</div>
	<div region="west" split="true" style="width:180px;" title="功能菜单" id="west_area">
		<div id="sm" class="easyui-sidemenu" style="width:90%;" data-options="data:data,onSelect:selectItem" ></div>
	</div>
	<div region="center"  iconCls="icon-reload" id="center_area" style="overflow-x:hidden;overflow-y:hidden;">
	 	<div class="easyui-tabs" fit="true" id="tabs_bar">
	 	</div>
	</div>
	<div region="south" split="false" style="border-bottom:0px;height:30px;overflow:hidden" id="south_area" >
		<div style="width:220px;height:28px;line-height:28px;left:20px;position:absolute;">© 1997-2030 韶关科技公司版权所有</div>
		<div style="width:200px;height:28px;line-height:28px;right:40px;position:absolute;">网址：<a href="http://www.baidu.com" style="color:#000">http://www.baidu.com</a></div>
		<div style="height:28px;line-height:28px;margin:auto;width:560px;"> <a>公司简介</a> | <a>联系方法</a> | <a>招聘信息</a> | <a>客户服务</a> | <a>广告服务</a> | <a>意见反馈</a> | <a>不良信息举报</a></div>
	</div>
</body>
</html>