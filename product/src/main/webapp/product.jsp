<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<c:forEach var="index" items="${list}">
    商品名称:${index.productName} &nbsp;&nbsp;&nbsp; 单价:${index.productPrice} &nbsp;
    <a href="${pageContext.request.contextPath}/product/add?id=${index.productId}">添加到购物车</a>
    </br>
</c:forEach>


</body>
</html>
