<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="">
    <script type="text/javascript"></script>
</head>
<body>
hello
<form action="${pageContext.request.contextPath}/userAction_register" method="post">
    username:<input type="text" name="username">
    password:<input type="password" name="password">
    <input type="submit" value="submit">
</form>
</body>
</html>
