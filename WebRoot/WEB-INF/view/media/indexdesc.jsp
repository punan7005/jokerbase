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
        <h3>媒体列表</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab"></a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="javascript:void(0);" onclick="tocreatemedia()">新增媒体</a></li>
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
                <th>预览</th>
                <th>媒体名称</th>
                <th>媒体描述</th>
                <th>创建人</th>
                <th>创建时间</th>
                <th>创建状态</th>
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
            <c:if test="${medias!=null}">
            	<c:forEach var="media" items="${medias}" varStatus="status">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td ><img src="${REALMEDIAURL}${media.mediaPath}" width="30px" height="30px" ></td>
                <c:if test="${fn:length(media.mediaName) > 6}">
               	 <td><c:out value="${fn:substring(media.mediaName, 0, 6)}..."></c:out></td>
                </c:if>
                <td>${media.mediaDesc}</td>
                <td>${media.createUserName }</td>
                <td>${media.createTime }</td>
                <c:if test="${media.mediaStatus == 0 }">
                <td>正常</td>
                </c:if>
                <td>
                  <!-- Icons -->
                  <a href="javascript:void(0);" onclick="delmedia('${media.mediaId}')">删除</a></td>
              </tr>
              </c:forEach>
              </c:if>
              <c:if test="${medias==null}">
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
function tocreatemedia(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/media/createindexdesc.shtml"	//请求路径
		);
	}
function jump(pageNo){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/media/index.shtml",	//请求路径
	{"pageNo":pageNo});
}
function delmedia(mediaId){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/media/del.shtml",	//请求路径
	{"mediaId":mediaId},
	function(responseText, textStatus, XMLHttpRequest){
		$("#right").load("${ctx}/media/indexdesc.shtml");
	});
}
</script>
</html>