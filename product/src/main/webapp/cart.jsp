<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<c:forEach items="${sessionScope.cart}" var="index">
    商品ID:${index.key}&nbsp;&nbsp;&nbsp;&nbsp;数量:${index.value} </br>
</c:forEach>
<a href="/product/order">提交订单</a>
</body>
</html>
