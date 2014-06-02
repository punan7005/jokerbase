<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>media index</title>
</head>
<body>


<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>媒体新增</h3>
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
          <form name="createmeida" id="createmedia" action="${ctx }/media/upload.shtml" method="post">
            <fieldset>
            <!-- 设置类”列左”或“右列”字段划分形成列 -->
            <p>
             <label>分类列表</label>
               <select name="dropdown" id="channelId">
               <c:forEach var="channel" items="${channelList}">
                      <option value="${channel.channelId }">${channel.channelName}</option>
               </c:forEach>
               </select>
            </p>
            <p>
				<input type="file" name="imgFile" id="imgFile" >
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
	<script type="text/javascript">
	$(function(){
		$('#imgFile').uploadify({
			'formData':{
				'channelId' : $("#channelId option:selected").val()
			},
			fileObjName:'imgFile',
			buttonText:'媒体上传',
            fileTypeExts:'*.gif; *.jpg; *.png',
			swf:'${ctx}/uploadify/uploadify.swf',
			uploader:'${ctx}/media/upload.shtml'
		});
	})
</script>
</body>
</html>