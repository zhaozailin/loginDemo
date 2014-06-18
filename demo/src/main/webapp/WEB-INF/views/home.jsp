<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp" %>
<%@ include file="common/CommonUI.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>"/>
<title>登录注册bundle</title>

<link rel="stylesheet/less" href="resources/styles/app/app.less">
<link rel="stylesheet" href="resources/styles/libs/bootstrap/bootstrap.min.css">

<script src="resources/scripts/libs/less/less-1.7.1.min.js"></script>
<script data-main="resources/scripts/app/main/main.js" src="resources/scripts/libs/require/require.js"></script>

</head>
<body>

  <!-- 登录页面 -->
  <c:if test="${error}">
    <center>用户名或密码错误</center>
  </c:if>
  
  <form action="login" method="post">
    <table class="my-login-table" id="loginTable">
      <tr>
        <td>用户名</td>
        <td><input class="form-control" type="text" name="username" placeholder="请输入用户名"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input class="form-control" type="text" name="password" placeholder="请输入密码"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <a class="btn btn-info" id="goRegisterBtn" href="javascript:void(0)">去注册</a>
          &emsp;
          <button class="btn btn-info" type="submit">登录</button>
        </td>
      </tr>
    </table>
  </form>
  
  <!-- 注册页面 -->
  <table class="my-login-table" id="registerTable">
    <tr>
      <td>用户名</td>
      <td><input class="form-control" type="text" name="username" placeholder="请输入用户名"></td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input class="form-control" type="text" name="password" placeholder="请输入密码"></td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button class="btn btn-info" id="registerBtn">注册</button>
        &emsp;
        <button class="btn btn-info" id="backBtn">返回登录</button>
      </td>
    </tr>
  </table>
  
</body>
</html>
