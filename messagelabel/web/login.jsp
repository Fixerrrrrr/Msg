<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 2017/10/25
  Time: 下午3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<div class="login">
    <form role="form" action="LoginServlet" method="post">
        <div class="form-group">
            <p>您的姓名</p>
            <input type="text" class="form-control" placeholder="username" name="name">
        </div>
        <button type="submit" class="btn btn-default btn-md"><span>开 始</span></button>
    </form>
</div>
</body>
</html>
