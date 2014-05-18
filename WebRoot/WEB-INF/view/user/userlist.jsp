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
        <h3>用户列表</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab"></a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="javascript:void(0)" onclick="tocreateuser()">新增用户</a></li>
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
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>用户验证状态</th>
                <th>注册时间</th>
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
              <c:if test="${userlist!=null}">
            	<c:forEach var="user" items="${userlist}" varStatus="status">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td>${user.userName }</td>
                <td>${user.userEmail }</td>
                <c:if test="${user.userIsVal == 0 }">
                <td>未验证</td>
                </c:if>
                <c:if test="${user.userIsVal == 1 }">
                <td>通过验证</td>
                </c:if>
                <td>${user.createTime }</td>
                <td>
                  <!-- Icons -->
                  <a href="javascript:void(0);" onclick="toupdateuser('${user.userId}')" title="Edit">修改</a> <a href="javascript:void(0);" onclick="deluser('${user.userId}')" title="Delete">删除</a></td>
              </tr>
              </c:forEach>
              </c:if>
              <c:if test="${userList==null}">
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
function tocreateuser(){
		$("#right").html("loading...");
		$("#right").load(
		"${ctx}/user/tocreateuser.shtml"	//请求路径
		);
	}
function jump(pageNo){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/user/touserlist.shtml",	//请求路径
	{"pageNo":pageNo});
}
function deluser(userid){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/user/deleteuser.shtml",	//请求路径
	{"userId":userid});
}
function toupdateuser(userid){
	$("#right").html("loading...");
	$("#right").load(
	"${ctx}/user/toupdateuser.shtml",	//请求路径
	{"userId":userid});
}
</script>
</html>