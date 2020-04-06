<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书系统首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
<!-- 引用js，先引用jQuery，在引用bootstarp -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 class="text-center">${name }欢迎你！</h3>
	<div class="container"><!--  vitar -->
		<h2 class="text-center">图书详细信息列表</h2>
		<table class="table table-hover  table-striped">
			<tr>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>出版时间</th>
				<th>页数</th>
				<th>价格</th>
				<th>内容摘要</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pg.pageLists }" var="b">
					<tr>
						<td>${b.name }</td>
						<td>${b.author }</td>
						<td>${b.publish }</td>
						<td><fmt:formatDate value="${b.publishdate }" pattern="YYYY-MM-dd HH:mm:ss"/></td>
						<td>${b.page }</td>
						<td>${b.price }</td>
						<td>${b.content }</td>
						<td><a href="findByid?id=${b.id }">修改</a>&nbsp;&nbsp;
						<a href="deleteById?id=${b.id }">删除</a></td>
				  	</tr>
			</c:forEach>
		</table>
		<a href="Add.jsp" type="button" class="btn btn-info" >添加图书</a>
		 <div class="row text-center">
			<ul class="pagination">
				<li><a href="Index?pageIndex=${pg.currPage-1 }">&laquo;</a></li><!-- 上一页 -->
						<c:forEach begin="1" end="${pg.totalPages}" varStatus="i">
							<li><a href="Index?pageIndex=${i.index} ">${i.index }</a></li>
						</c:forEach> 
				<li><a href="Index?pageIndex=${pg.currPage+1}">&raquo;</a></li><!--下一页  -->
				<li>共${pg.totalPages}页||当前${pg.currPage}页</li>
			</ul>
		</div> 
	</div>
</body>
</html>