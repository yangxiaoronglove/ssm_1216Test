<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: caoqian
  Date: 2019/12/16
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电子图书列表</title>
</head>
<body>
<center>
<form action="/book/findAll.do" method="post">
    <select name="searchName">
        <option value="">==全部==</option>
        <c:forEach items="${ebookCategoryList}" var="ebook">
            <option value="${ebook.id}">${ebook.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="查询">
</form>
<a href="/book/goAdd.do">添加图书信息</a>
<table border="1" cellpadding="0" cellspacing="5" width="70%">
    <tr>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书摘要</th>
        <th>上传人</th>
        <th>上传时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.summary}</td>
            <td>${book.uploaduser}</td>
            <td><fmt:formatDate value="${book.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
            <td>
                <a href="/book/goUpdate?id=${book.id}">修改||</a>
                <a href="javascript:toDel(${book.id})">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>
    <%--分页查询数据展示--%>
    <p>
        <a href="${pageContext.request.contextPath}/book/findAll.do?page=1&size=${pageInfo.pageSize}"
           aria-label="Previous">首页</a>

        <a href="${pageContext.request.contextPath}/book/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
            <a href="${pageContext.request.contextPath}/book/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
        </c:forEach>

        <a href="${pageContext.request.contextPath}/book/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>

        <a href="${pageContext.request.contextPath}/book/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
           aria-label="Next">尾页</a>
    </p>
</center>
</body>
<script>
    function toDel(id) {
        if (confirm("是否确认删除")){
            location.href="${pageContext.request.contextPath}/book/del.do?id="+id;

        }
    }
</script>
</html>
