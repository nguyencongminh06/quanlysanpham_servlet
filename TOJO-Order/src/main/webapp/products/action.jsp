<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<jsp:include page="../layout/header.jsp"></jsp:include>

<c:set var="action" value="${pageContext.request.contextPath }/products/ActionController"></c:set>
<c:if test="${product != null }">
	<c:set var="action" value="${pageContext.request.contextPath }/products/EditController"></c:set>

</c:if>

<form method="post" action="${action }">
	<div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">Id</label>
    	<div class="col-sm-10">
      		<input type="number" name="id" class="form-control" id="id" value="${product.id }"
      			placeholder="Id">
    	</div>
  	</div>
  	<div class="form-group row">
    <label for="title" class="col-sm-2 col-form-label">Mã</label>
    	<div class="col-sm-10">
      		<input type="text" name="title" class="form-control" id="Tiều đề" value="${product.title }"
      			placeholder="Tiêu đề">
    	</div>
  	</div>
  	<div class="form-group row">
    <label for="description" class="col-sm-2 col-form-label">Mô tả</label>
    	<div class="col-sm-10">
      		<input type="text" name="description" class="form-control" id="description" value="${product.description }"
      			placeholder="Mô tả">
    	</div>
  	</div>
  	<div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Giá</label>
    	<div class="col-sm-10">
      		<input type="text" name="price" class="form-control" id="price" value="${product.price }"
      			placeholder="Giá">
    	</div>
  	</div>
  	<button type="submit" class="btn btn-primary">Lưu</button>
</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>