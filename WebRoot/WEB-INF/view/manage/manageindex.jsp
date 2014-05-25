<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>jokerbase</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="${ctx }/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="${ctx }/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="${ctx }/css/invalid.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${ctx }/css/welcome.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="${ctx }/scripts/jquery-1.7.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="${ctx }/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="${ctx }/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="${ctx }/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="${ctx }/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="${ctx }/scripts/jquery.date.js"></script>

<script charset="utf-8" src="${ctx }/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${ctx }/kindeditor/lang/zh_CN.js"></script>

<script type="text/javascript" src="${ctx }/uploadify/jquery.uploadify.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx }/uploadify/uploadify.css">
</head>

<body>
<div id="body-wrapper">
  <!-- 包装为径向渐变背景 -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- 在侧边栏显示徽标和菜单 -->
      <h1 id="sidebar-title"><a href="#">Simpla管理</a></h1>
      <!-- Logo (221px wide) -->
      <a href="#"> <img id="logo" src="images/logo-web.png" width="218" height="90"></a>
      <!-- 栏概要链接 -->
      <div id="profile-links">${currentUser.userName} 你好<br />
        <br />
        <a href="#" title="View the Site">查看网站</a> | <a href="#" title="Sign Out">离开</a> </div>
      <ul id="main-nav">
        <!-- 手风琴菜单  -->
        <li> <a href="#" class="nav-top-item">
          <!-- 添加类“当前”到当前菜单项 -->
          内容</a>
          <ul>
            <li><a href="javascript:void(0);" onclick="tocontentlist()">管理文章</a></li>
            <li><a href="javascript:void(0);" onclick="tocommentlist()">管理评论</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          <!-- 添加类“当前”到当前菜单项 -->
          分类</a>
          <ul>
            <li><a href="javascript:void(0);" onclick="tochannellist()">分类目录</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          <!-- 添加类“当前”到当前菜单项 -->
          媒体</a>
          <ul>
            <li><a href="javascript:void(0);" onclick="tomedialist()">管理媒体(无描述)</a></li>
            <li><a href="javascript:void(0);" onclick="tomediaindexdesc()">管理媒体(带描述)</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item">
          <!-- 添加类“当前”到当前菜单项 -->
          用户</a>
          <ul>
            <li><a href="javascript:void(0);" onclick="touserlist()">管理用户</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
      <div id="messages" style="display: none">
        <!-- 消息显示当一个链接被单击时利用这些属性: href="#messages" rel="modal"  -->
        <h3>3 条信息</h3>
        <p> <strong>17th May 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>2nd May 2009</strong> by Jane Doe<br />
          Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>25th April 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <form action="#" method="post">
          <h4>New Message</h4>
          <fieldset>
          <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
          </fieldset>
          <fieldset>
          <select name="dropdown" class="small-input">
            <option value="option1">Send to...</option>
            <option value="option2">Everyone</option>
            <option value="option3">Admin</option>
            <option value="option4">Jane Doe</option>
          </select>
          <input class="button" type="submit" value="Send" />
          </fieldset>
        </form>
      </div>
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- 主要内容部分的一切 -->
    <noscript>
    <!-- 显示一个通知如果用户禁用了javascript -->
    <div class="notification error png_bg">
      <div> Javascript被禁用或不支持您的浏览器。 <a href="http://browsehappy.com/" title="Upgrade to a better browser">升级</a>你的浏览器或 <a href="http://www.google.com/support/bin/answer.py?answer=23852" title="Enable Javascript in your browser">enable</a> Javascript导航界面正确。
        下载 <a href="http://www.exet.tk">exet.tk</a></div>
    </div>
    </noscript>
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
   	<div id="right">
   	<div class="welcome-box">
      <!-- Start Content Box -->
	  <div class="mark">
 	<div class="welcome-left "><a href="javascript:void(0);" onclick="tocontentlist()"> 写一篇文章</a></div>
	<div class="welcome-right"> 
    	<div class="welcome-rtop"><a href="javascript:void(0);" onclick="tomedialist()"> 添加媒体</a></div>
        <div class="welcome-rdown">
        	<div class="welcome-rdown-left"><a href="javascript:void(0);" onclick="tocommentlist()"> 评论查看</a></div>
            <div class="welcome-rdown-right"><a href="javascript:void(0);" onclick="touserlist()"> 用户管理</a></div>
        </div>
    </div>
	</div>
    </div>
 
    <div class="clear"></div>
    <!-- End Notifications -->
    <div id="footer"> <small>
      <!-- Remove this notice or replace it with whatever you want -->
      &#169; Copyright 2010 Your Company | Powered by <a href="#">admin templates</a> | <a href="#">Top</a> </small> </div>
    <!-- End #footer -->
  </div>
  <!-- End #main-content -->
</div>
</body>
</body>
<script type="text/javascript">
	//jquery load加载右侧显示内容
	function tocommentlist(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/comment/tocommentlist.shtml"	//请求路径
		);
	}
	function tocontentindex(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/content/index.shtml"
		);
		
	}
	function tocontentlist(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/content/tocontentlist.shtml"
		);
	}
	function tomedialist(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/media/tomedialist.shtml"
		);
	}
	function tomediaindexdesc(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/media/indexdesc.shtml"
		);
	}
	
	function tochannellist(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/channel/tochannellist.shtml"	//请求路径
		);
	}
	function touserlist(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/user/touserlist.shtml"	//请求路径
		);
	}
</script>
</html>
