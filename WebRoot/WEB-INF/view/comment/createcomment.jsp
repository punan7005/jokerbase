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
        <h3>评论新增</h3>
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
          <form name="createcomment" id="createcomment" action="${ctx }/comment/createcomment.shtml" method="post">
            <fieldset>
            <!-- 设置类”列左”或“右列”字段划分形成列 -->
            <p>
              <label>评论标题</label>
              <input class="text-input small-input" type="text" id="commentTitle" name="commentTitle" />
              <br /></p>
              <!-- 
            <p>
              <label>介质形式输入</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
              <span class="input-notification error png_bg">错误消息</span> </p>
               -->
            <p>
              <label>评论内容</label>
              <textarea class="text-input textarea wysiwyg" id="commentContent" name="commentContent" cols="79" rows="15"></textarea>
            </p>
            <p>
              <input class="button" type="button" value="提交" onclick="submitcomment()" />
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
function submitcomment(){
	var commentTitle = $("#commentTitle").val();
	var commentContent = $("#commentContent").val();
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/comment/createcomment.shtml", //请求路径
	{
		"commentTitle":commentTitle,
		"commentContent":commentContent	
	}
	)
	;
}
</script>
</html>