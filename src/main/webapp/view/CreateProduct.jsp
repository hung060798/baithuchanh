<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/8/2021
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Table Create Student</h2>
    <form action="/product?action=create" method="post">
        <table class="table">
            <tbody>
            <tr>
                <td>id</td>
                <td>tên sản phẩm</td>
                <td>giá</td>
                <td>số lượng</td>
            </tr>
            <tr>
                <td><input placeholder="Enter the id" name="id"></td>
                <td><input placeholder="Enter the tên" name="tensp"></td>
                <td><input placeholder="Enter the gia" name="gia"></td>
                <td><input placeholder="số lượng" name="soluong"></td>
            </tr>
            <tr>
                <td>màu sắc</td>
                <td>mô tả</td>
                <td>danh mục</td>
            </tr>
            <tr>
                <td><input placeholder="màu sắc" name="mausac"></td>
                <td><input placeholder="mô tả" name="mota"></td>
                <td><input placeholder="danhmuc" name="danhmuc"></td>
            </tr>

            </tbody>
        </table>
        <c:if test="${checkNull}">
            <h4 style="text-align: center; color: red; font-weight: 600;">Bạn phải nhập đủ trường dữ liệu</h4>
        </c:if>
        <button type="submit" class="btn btn-success">Create Product</button>

    </form>
</div>
</body>
</html>
