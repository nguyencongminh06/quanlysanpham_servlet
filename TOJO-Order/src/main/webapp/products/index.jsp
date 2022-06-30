<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<%@ page isELIgnored = "false" %>
<jsp:include page="../layout/header.jsp"></jsp:include>
<a href="${pageContext.request.contextPath }/products/ActionController" class="btn btn-primary">Thêm Mới</a>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tiều đề</th>
      <th scope="col">Mô tả</th>
      <th scope="col">Giá</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="item" items="${products }" varStatus="loop">
  		<tr>
	      <th scope="row">${ loop.index + 1 }</th>
	      <td>${item.title }</td>
	      <td>${item.description }</td>
	      <td>${item.price }</td>
	      <td>
	      <a href="${pageContext.request.contextPath }/products/ActionController?id=${item.id}" class="btn btn-primary">Sửa</a> |&nbsp;
	      <a onclick="if (confirm('Bạn có muốn xóa không ?')){window.location.href='${pageContext.request.contextPath }/products/ActionController?action=delete&id=${item.id}';}" href="javascript:void()" class="btn btn-primary">Xóa</a>
	      </td> 
	    </tr>
  	</c:forEach>
    
  </tbody>
</table>
<jsp:include page="../layout/footer.jsp"></jsp:include>