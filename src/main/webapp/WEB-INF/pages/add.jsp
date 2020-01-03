<%--
  Created by IntelliJ IDEA.
  User: caoqian
  Date: 2019/12/16
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>

</head>
<body>
<form action="/book/add.do" method="post" onsubmit="return beforeSubmit(this);">
    <h1>添加电子图书</h1>
    <table border="1" cellspacing="5" cellpadding="0" width="70%">
        <tr>
            <td>图书名称</td>
            <td>
                <input type="text" name="title">
            </td>
        </tr>
        <tr>
            <td>图书摘要</td>
            <td>
                <textarea name="summary" cols="30" rows="10"></textarea>
            </td>
        </tr>
        <tr>
            <td>上传人</td>
            <td>
                <input type="text" name="uploaduser">
            </td>
        </tr>
        <tr>
            <td>上传时间</td>
            <td>
                <input type="date" name="createdate">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交" >
            </td>
        </tr>
    </table>
</form>

</body>
<script type="text/javascript">
    function beforeSubmit(form) {
        if (form.title.value == '') {
            alert('图书名称不能为空！');
            form.title.focus();
            return false;
        }
        if (form.summary.value == '') {
            alert('图书摘要不能为空！');
            form.summary.focus();
            return false;
        }
        if (form.uploaduser.value == '') {
            alert('上传人不能为空！');
            form.uploaduser.focus();
            return false;
        }
        if (form.createdate.value == '') {
            alert('日期不能为空！');
            form.createdate.focus();
            return false;
        }
    }
</script>
</html>
