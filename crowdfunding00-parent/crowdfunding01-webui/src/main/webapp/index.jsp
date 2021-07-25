<%--
  Created by IntelliJ IDEA.
  User: Steven.Yin
  Date: 2021/7/24
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Title</title>
</head>
<body>
HELLO!
<a href="test/ssm.html">${pageContext.request.contextPath}</a>
</body>
</html>
