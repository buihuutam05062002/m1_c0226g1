<%--
  Created by IntelliJ IDEA.
  User: huutam
  Date: 7/3/2026
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table>
  <tr>
    <th>Tên</th>
    <th>Ngày sinh</th>
    <th>Địa chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${customers}" var="customer">
    <tr>
      <td>${customer.name}</td>
      <td>${customer.born}</td>
      <td>${customer.place}</td>
      <td>
        <img src="${pageContext.request.contextPath}/${customer.url}" width="100">
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
