<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-05-26
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="suibian/addUsers4">
        用户姓名：<input type="text" name="username"><br/>
        爱好：<br/>
        体育<input type="checkbox" value="Sport" name="userlike"/>
        音乐<input type="checkbox" value="Music" name="userlike"/>
        艺术<input type="checkbox" value="Art" name="userlike"/><br/>
        <input type="submit" value="ok"/>
    </form>
</body>
</html>
