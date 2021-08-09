<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/8/2021
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


    <h2>Show Product</h2>
    <a href="/product?action=create" class="btn btn-success">Create</a>
    <br>
    <form action="/product" method="get">
        <input type="text" placeholder="Enter the id you want to find" name ="findName">
        <input type="text" hidden name="action" value="findName">
        <button type="submit" class="btn btn-info">Find by name</button>
    </form>
    <br>
    <form action="/product?action=find" method="post">
        <input type="text" placeholder="Enter the id you want to find" name ="idfind">
        <button class="btn btn-info" type="submit">Search by id</button>
    </form>
    <br>
    <br>
    <table class="table" border="2px">
        <thead>
        <tr>
            <th>id</th>
            <th> tên sản phẩm</th>
            <th>giá</th>
            <th>số lượng</th>
            <th>màu sắc</th>
            <th>mô tả</th>
            <th>danh mục</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ListProduct}" var="product" varStatus="loop">
            <tr>
                <td>${product.id}</td>
                <td>${product.tensp}</td>
                <td>${product.gia}</td>
                <td>${product.soluong}</td>
                <td>${product.mausac}</td>
                <td>${product.mota}</td>
                <td>${product.danhmuc}</td>
                <td><a href="/product?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a href="/product?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <a href="/product" type="submit" class="btn btn-success">Home</a>
</div>
</body>
</html>
