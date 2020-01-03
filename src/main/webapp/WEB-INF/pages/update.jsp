<%--
  Created by IntelliJ IDEA.
  User: caoqian
  Date: 2019/12/16
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改图书信息</title>

</head>
<body>
<form action="/book/update.do?id=${id}" method="post" onsubmit="return beforeSubmit(this);">
    <h1>修改电子图书</h1>
    <table border="1" cellspacing="5" cellpadding="0" width="70%">
        <tr>
            <td>图书编号</td>
            <td>
                ${id}
            </td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td>
                <input type="text" name="title" value="${entryList.title}">
            </td>
        </tr>
        <tr>
            <td>图书摘要</td>
            <td>
                <textarea name="summary" cols="30" rows="10">${entryList.summary}</textarea>
            </td>
        </tr>
        <tr>
            <td>上传人</td>
            <td>
                <input type="text" name="uploaduser" value="${entryList.uploaduser}">
            </td>
        </tr>
        <tr>
            <td>上传时间</td>
            <td>
                <input type="date" name="createdate" >
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改" >
            </td>
        </tr>
    </table>
</form>

</body>
<script type="text/javascript">
    function beforeSubmit(form) {
        if (form.createdate.value == '') {
            alert('时间不能为空！');
            form.createdate.focus();
            return false;
        }
    }
</script>
</html>
