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
        <h3>分类列表</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab"></a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="javascript:void(0)" onclick="tocreatechannel()">新增分类</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>分类标题</th>
                <th>分类类型</th>
                <th>所属分类</th>
                <th>添加人</th>
                <th>添加时间</th>
                <th>操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="bulk-actions align-left">
                    <select name="dropdown">
                      <option value="option1">Choose an action...</option>
                      <option value="option2">Edit</option>
                      <option value="option3">Delete</option>
                    </select>
                    <a class="button" href="#">适用于选定的</a> </div>
                  <div class="pagination">
                  	${pagestring }
                  </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
            
              <c:if test="${channelList!=null}">
            	<c:forEach var="channel" items="${channelList}" varStatus="status">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>${channel.channelName }</td>
                <c:if test="${channel.channelType == 0 }">
                <td>图文</td>
                </c:if>
                <c:if test="${channel.channelType == 1 }">
                <td>媒体</td>
                </c:if>
                <c:if test="${channel.channelType == 2 }">
                <td>内容型分类</td>
                </c:if>
                <c:if test="${channel.channelParentName != null }">
                <td>${channel.channelParentName }</td>
                </c:if>
                <c:if test="${channel.channelParentName == null }">
                <td>无上级分类</td>
                </c:if>
                <td>${channel.createUserName }</td>
                <td>${channel.createTime }</td>
                <td>
                  <!-- Icons -->
                  <a href="javascript:void(0);" onclick="toupdatechannel('${channel.channelId}')" title="Edit">修改</a> <a href="javascript:void(0);" onclick="delchannel('${channel.channelId}')" title="Delete">删除</a></td>
              </tr>
              </c:forEach>
              </c:if>
              <c:if test="${channelList==null}">
              <tr>
              	<td>
              暂无数据
              	</td>
              </tr>
              </c:if>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
        
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
</body>
<script type="text/javascript">
function tocreatechannel(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/channel/tocreatechannel.shtml"	//请求路径
		);
	}
function jump(pageNo){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/channel/tochannellist.shtml",	//请求路径
	{"pageNo":pageNo});
}
function delchannel(channelid){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/channel/deletechannel.shtml",	//请求路径
	{"channelId":channelid});
}
function toupdatechannel(channelid){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/channel/toupdatechannel.shtml",	//请求路径
	{"channelId":channelid});
}
</script>
</html>
