<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list content</title>
</head>
<body>
<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>文章列表</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab"></a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="javascript:void(0)" onclick="tocreatecontent()">新增文章</a></li> 
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
                <th>文章标题</th>
                <th>文章内容</th>
                <th>创建人</th>
                <th>创建时间</th>
                <th>文章状态</th>
                <th>操作</th>
                <th>排序</th>
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
            <c:if test="${contents!=null}">
            	<c:forEach var="content" items="${contents}" varStatus="status">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <c:if test="${fn:length(content.contentTitle) > 10}">
                <td><c:out value="${fn:substring(content.contentTitle, 0, 10)}..."></c:out></td>
                </c:if>
                <c:if test="${fn:length(content.contentTitle) <= 10}">
                <td>${content.contentTitle }</td>
                </c:if>
                 <c:if test="${fn:length(content.contentMain) > 10}">
                <td><c:out value="${fn:substring(content.contentMain, 0, 10)}..."></c:out></td>
                </c:if>
                <c:if test="${fn:length(content.contentMain) <= 10}">
                <td>${content.contentMain }</td>
                </c:if>
                <td>${content.createUserName }</td>
                <td>${content.createTime }</td>
                <c:if test="${content.contentStatus == 0 }">
                <td>正常</td>
                </c:if>
                <td>
                  <!-- Icons -->
                  <a href="javascript:void(0);" onclick="editContent('${content.contentId}')">编辑</a>
                  <a href="javascript:void(0);" onclick="delContent('${content.contentId}')">删除</a></td>
                  <td>
                  	<select name="contentSort" id="contentSort">
                  		<option value="5" <c:if test="${content.contentSort == 5 }" > selected="selected" </c:if>>5</option>
                  		<option value="4" <c:if test="${content.contentSort == 4 }" > selected="selected" </c:if>>4</option>
                  		<option value="3" <c:if test="${content.contentSort == 3 }" > selected="selected" </c:if>>3</option>
                  		<option value="2" <c:if test="${content.contentSort == 2 }" > selected="selected" </c:if>>2</option>
                  		<option value="1" <c:if test="${content.contentSort == 1 }" > selected="selected" </c:if>>1</option>
                  		<option value="0" <c:if test="${content.contentSort == 0 }" > selected="selected" </c:if>>0</option>
                  	</select>
                  	<a href="javascript:void(0);" onclick="sortContent('${content.contentId}')">保存</a>
                  </td>
              </tr>
              </c:forEach>
              </c:if>
              <c:if test="${contents==null}">
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
function tocreatecontent(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/content/index.shtml"	//请求路径
		);
}
function editContent(contentId){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/content/edit.shtml",	//请求路径
	{"contentId":contentId}
	);
}
function delContent(contentId){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/content/del.shtml",	//请求路径
	{"contentId":contentId}
	);
}
function sortContent(contentId){
	var contentSort = $("#contentSort option:selected").val();
	alert(contentSort);
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/content/sort.shtml",	//请求路径
	{"contentId":contentId,"contentSort":contentSort}
	);
}
function jump(pageNo){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/content/list.shtml",	//请求路径
	{"pageNo":pageNo});
}
</script>
</html>