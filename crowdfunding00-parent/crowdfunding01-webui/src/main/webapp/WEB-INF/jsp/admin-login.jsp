<%--
  Created by IntelliJ IDEA.
  User: Steven.Yin
  Date: 2021/7/26
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <jsp:include page="include/include-head-tag.jsp" ></jsp:include>
  <style>
  </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
    </div>
  </div>
</nav>

<div class="container">
  <form:form method="post" class="form-signin" modelAttribute="admin" action="admin/login.json" role="form">
    <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 管理员登录</h2>
    <div class="form-group has-success has-feedback">
      <form:input path="loginAcct" type="text" class="form-control" id="loginAcct" placeholder="请输入登录账号" autofocus="true"></form:input>
      <form:label path="loginAcct" class="glyphicon glyphicon-user form-control-feedback"></form:label>
    </div>
    <div class="form-group has-success has-feedback">
      <form:input path="userPswd" type="text" class="form-control" id="userPswd" placeholder="请输入登录密码" style="margin-top:10px;"></form:input>
      <form:label path="userPswd" class="glyphicon glyphicon-lock form-control-feedback"></form:label>
    </div>
    <button id="btn-login" type="submit" class="btn btn-primary">Login</button>
  </form:form>
</div>
</body>
<script>
</script>
</html>