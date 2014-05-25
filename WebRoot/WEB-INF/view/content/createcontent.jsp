<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>create content</title>
<script>
	KindEditor.create('#editor_id',{
		uploadJson : '/content/upload.shtml',
		items : ['source', 'code','|', 'justifyleft', 'justifycenter', 'justifyright','justifyfull', '|',
		         'forecolor', 'bold', 'italic', 'underline', 'strikethrough',  '|',
		         'image', 'insertfile', 'link', 'unlink'],
		afterBlur: function(){
			this.sync();
		}
	});
</script>
</head>
<body>
<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>内容新增</h3>
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
          <form name="createcomment" id="createcomment" action="${ctx }/content/create.shtml" method="post">
            <fieldset>
            <!-- 设置类”列左”或“右列”字段划分形成列 -->
            <p>
              <label>内容标题</label>
              <input class="text-input small-input" type="text" id="contentTitle" name="contentTitle" />
              <br />
              <!-- 
            <p>
              <label>介质形式输入</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
              <span class="input-notification error png_bg">错误消息</span> </p>
               -->
             <p>
             <label>分类列表</label>
               <select name="dropdown" id="channelId">
               <c:forEach var="channel" items="${channellist}">
                      <option value="${channel.channelId }">${channel.channelName}</option>
               </c:forEach>
               </select>
            </p>
            <p>
              <label>文章内容</label>
              <textarea class="text-input textarea wysiwyg" id="editor_id" name="content" cols="79" rows="15"></textarea>
            </p>
            <p>
              <input class="button" type="button" value="提交" onclick="submitcontent()" />
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
function submitcontent(){
	var contentTitle = $("#contentTitle").val();
	var editor_id = $("#editor_id").val();
	var channelId = $("#channelId option:selected").val();
	$("#right").html("loading...");
	$("#right").load(
	"${ctx }/content/create.shtml", //请求路径
	{
		"contentTitle":contentTitle,
		"content":editor_id,
		"channelId": channelId
	}
	)
	;
}
</script>
</html>

