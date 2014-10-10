<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>"/>
<title>登录注册bundle</title>
<meta charset="UTF-8" />
<meta content="width=device-width, user-scalable=0;" name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<style type="text/css">
  .t {
    width: 320px;
    height: 320px;
    background: red;
  }
  body {
    margin: 0;
  }
</style>
</head>
<body>
  <div class="t">
    <img alt="" src="resources/images/1.jpg" style="width: 160px;">
  </div>
</body>
</html>
