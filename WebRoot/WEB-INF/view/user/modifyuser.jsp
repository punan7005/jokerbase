<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>用户修改</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab"></a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="#tab2"></a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content" id="tab2">
          <form name="" id="" action="" method="post">
          <input type="hidden" id="userId" name="userId" value="${user.userId }">
          <input type="hidden" id="createTime" name="createTime" value="${user.createTime }">
          <input type="hidden" id="userIsVal" name="userIsVal" value="${user.userIsVal }">
          <input type="hidden" id="isDelete" name="isDelete" value="${user.isDelete }">
            <fieldset>
            <!-- 设置类”列左”或“右列”字段划分形成列 -->
            <p>
              <label>用户名</label>
              <input class="text-input small-input" type="text" id="userName" name="userName" value="${user.userName }" />
              <br /></p>
            <p>
              <label>用户邮箱</label>
              <input class="text-input small-input" type="text" id="userEmail" name="userEmail" value="${user.userEmail }" />
              <br /></p>
              <!-- 
            <p>
              <label>介质形式输入</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
              <span class="input-notification error png_bg">错误消息</span> </p>
               -->
            <p>
              <input class="button" type="button" value="提交" onclick="submituser()" />
            </p>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
</body>
<script type="text/javascript">
function submituser(){
	var userName = $("#userName").val();
	var userEmail = $("#userEmail").val();
	var userId = $("#userId").val();
	var createId = $("#createId").val();
	var createTime = $("#createTime").val();
	var userIsVal=$("#userIsVal").val();
	var createTime = $("#createTime").val();
	$("#right").html("loading...");
	$("#right").load(
	"${ctx }/user/updateuser.shtml", //请求路径
	{
		"userName":userName, 
		"userEmail":userEmail,
		"userId":userId, 
		"createId":createId, 
		"createTime":createTime,
		"userIsVal":userIsVal
	}
	)
	;
}
</script>
</html>