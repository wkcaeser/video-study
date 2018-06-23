<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/addQuestion" method="post">
        问题：<input name="description" type="text"/><br>
        A选项：<input name="answerA" type="text"/><br>
        B选项：<input name="answerB" type="text"/><br>
        C选项：<input name="answerC" type="text"/><br>
        D选项：<input name="answerD" type="text"/><br>
        正确答案：<input name="answer" type="text"/><br>
        分类：<input name="parent" type="text"/><br>
        <input type="submit"><br>
    </form>
</body>
</html>
