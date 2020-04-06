<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加图书</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.css">
<!-- 引用js，先引用jQuery，在引用bootstarp -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/wangEditor.min.js"></script>
	<style type="text/css">
		.red{
			color: red;
		}
	</style>
</head>
<body>
	<div class="container" align="center" >
        <h2 class="text-center vitar">图书增加页面</h2><br/>
        
        <form method="post" class="form-inline" role="form" action="saveByid"  >
        	<c:forEach items="${bbs}" var="b">
			<input type="hidden" value="${b.id}"  name="id"/>
        	<table >
        		<tr>
        			<td>书名:<span class="red">*</span></td>
        			<td>
        				<div class="form-group">
        					<input type="text"  class="form-control" id="author" name="Name" value="${b.name}">
        				</div>
        			</td>
        		</tr>
        		<tr>
        			<td>作者:<span class="red">*</span></td>
        			<td>
        				<div class="form-group">
        					<input type="text" class="form-control" id="author" name="Author" value="${b.author}">
        				</div>
        			</td>
        		</tr>
        		<tr>
        			<td>出版社:<span class="red">*</span></td>
        			<td>
        				<div class="form-group">
        					<input type="text" class="form-control" id="author" name="publish" value="${b.publish}">
        				</div>
        			</td>
        		</tr>
        		<%-- <tr>
        			<td>出版日期:<span class="red">*</span></td>
        			<td>
        				<div class="form-group">
        					<input type="text" class="form-control" id="author" name="publish" value="${b.publish}">
        				</div>
        			</td>
        		</tr> --%>
        		<tr>
        			<td>页数:</td>
        			<td>
        				<div class="form-group">
        					<input type="text" class="form-control" id="author" name="Page" value="${b.page}">
        				</div>
        			</td>
        		</tr>
        		<tr>
        			<td>价格:</td>
        			<td>
        				<div class="form-group">
        					<input type="text" class="form-control" id="author" name="Price" value="${b.price}">
        				</div>
        			</td>
        		</tr>
        		<tr>
        			<td>摘要内容:</td>
        			<td>
						<div id="editor"><p>${b.content}</p></div>
						<textarea  hidden="none" name="Content" id="text" ></textarea>
					</td>
        		</tr>
        		<tr>
        			<td><a href="Index">返回图书信息页面</a></td>
        			<td class="text-center" > 
        			<input value="修改"   type="submit"  class="form-control btn-primary ">
        			</td>
        		</tr>
        	</table>
           	</c:forEach>	
        </form>
        <script type="text/javascript">
			//创建wangeditor对象
			var E=window.wangEditor;
			//创建编辑对象
			var editor=new E("#editor");
			//获得多行文本框
			var text=$("#text");
			//让富文本框与多行文本框绑定在一起
			editor.customConfig.onchange = function(html){
				text.val(html);
			}
			editor.create();
		</script>
	</div>
</body>
</html>