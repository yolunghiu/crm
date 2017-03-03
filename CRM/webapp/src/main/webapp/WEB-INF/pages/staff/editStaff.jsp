<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<s:form action="staffAction_saveEdit" method="POST">
    <s:textfield name="staffId" type="hidden"/>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><s:textfield name="loginName"/></td>
            <td>密码：</td>
            <td><s:password name="loginPwd" showPassword="true" disabled="true"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><s:textfield name="staffName"/></td>
            <td>性别：</td>
            <td>
                <s:radio list="{'男', '女'}" name="gender"/>
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <s:select list="departments"
                          listValue="depName" listKey="depId"
                          name="post.department.depId"
                          onchange="getPostSet(this)"/>
            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <s:select list="post.department.postSet" listKey="postId" listValue="postName" name="post.postId"
                          id="postSelect"/>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <s:date name="onDutyDate" var="onDutyDate" format="yyyy-MM-dd"/>
                <s:textfield name="onDutyDate" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</s:form>
<script>
    var postSelect = document.getElementById("postSelect");

    function getPostSet(obj) {
        var xhr = null;

        // 第一步：首先创建xhr对象
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }

        if (null != xhr) {
            var url = "${pageContext.request.contextPath}/postAction_findAllByDepartment?department.depId=" + obj.value;

            // 第二步：准备发送请求-配置发送请求的一些行为
            xhr.open("GET", url, true);

            // 第三步：指定一些回调函数
            xhr.onreadystatechange = ajaxCallback;

            // 第四步：执行发送的动作(null是为了兼容低版本浏览器)
            // get方式直接附加数据在上面的url中，post方式加在参数里
            xhr.send();
        }

        function ajaxCallback() {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var textData = xhr.responseText;
                    // 将字符串手动转换成json对象
                    var jsonData = eval("(" + textData + ")");

                    // 向postSelect中填数据
                    for (var i = postSelect.options.length - 1; i >= 0; i--) {
                        postSelect.remove(i);
                    }
                    for (var i = 0; i < jsonData.length; i++) {
                        var postId = jsonData[i].postId;
                        var postName = jsonData[i].postName;

                        var item = new Option(postName,postId);
                        postSelect.options.add(item);
                    }
                }
            }
        }
    }
</script>
</body>
</html>