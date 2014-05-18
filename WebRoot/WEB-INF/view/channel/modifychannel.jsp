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
        <h3>分类新增</h3>
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
          <form name="createchannel" id="createchannel" action="${ctx }/channel/createchannel.shtml" method="post">
          <input type="hidden" id="channelId" name="channelId" value="${channel.channelId }">
          <input type="hidden" id="createId" name="createId" value="${channel.createId }">
          <input type="hidden" id="createTime" name="createTime" value="${channel.createTime }">
          <input type="hidden" id="channelStatus" name="channelStatus" value="${channel.channelStatus }">
          <input type="hidden" id="isDelete" name="isDelete" value="${channel.isDelete }">
          <input type="hidden" id="channelLevel" name="channelLevel" value="${channel.channelLevel }">
            <fieldset>
            <!-- 设置类”列左”或“右列”字段划分形成列 -->
            <p>
              <label>分类名称</label>
              <input class="text-input small-input" type="text" id="channelName" name="channelName" value="${channel.channelName }" />
              <br /></p>
            <p>
              <label>分类样式</label>
              <input class="text-input small-input" type="text" id="channelCss" name="channelCss" value="${channel.channelCss }" />
              <br /></p>
              <!-- 
            <p>
              <label>介质形式输入</label>
              <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
              <span class="input-notification error png_bg">错误消息</span> </p>
               -->
            <select name="channelType" id="channelType" class="small-input">
            <c:if test="${channel.channelType == 0  }">
                <option value="0" selected="selected">图文</option>
            </c:if>
            <c:if test="${channel.channelType != 0  }">
                <option value="0">图文</option>
            </c:if>
            <c:if test="${channel.channelType == 1  }">
                <option value="1" selected="selected">媒体</option>
            </c:if>
            <c:if test="${channel.channelType != 1  }">
                <option value="1">媒体</option>
            </c:if>
            <c:if test="${channel.channelType == 2  }">
                <option value="2" selected="selected">图片加描述</option>
            </c:if>
            <c:if test="${channel.channelType != 2  }">
                <option value="2">内容型分类</option>
            </c:if>
            <c:if test="${channel.channelType == 3  }">
                <option value="3" selected="selected">图片加描述</option>
            </c:if>
            <c:if test="${channel.channelType != 3  }">
                <option value="3">图片加描述</option>
            </c:if>
              </select>
            <p>
              <input class="button" type="button" value="提交" onclick="submitchannel()" />
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
function submitchannel(){
	var channelName = $("#channelName").val();
	var channelType = $("#channelType").val();
	var channelId = $("#channelId").val();
	var createId = $("#createId").val();
	var createTime = $("#createTime").val();
	var channelLevel=$("#channelLevel").val();
	var channelStatus=$("#channelStatus").val();
	var isDelete=$("#isDelete").val();
	var channelCss=$("#channelCss").val();
	$("#right").html("loading...");
	$("#right").load(
	"${ctx }/channel/updatechannel.shtml", //请求路径
	{
		"channelId":channelId, 
		"channelName":channelName,
		"channelType":channelType, 
		"createTime":createTime, 
		"createId":createId,
		"isDelete":isDelete,
		"channelLevel":channelLevel,
		"channelCss":channelCss,
		"channelStatus":channelStatus
	}
	)
	;
}
</script>
</html>