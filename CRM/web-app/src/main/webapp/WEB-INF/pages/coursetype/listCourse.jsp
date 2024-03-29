<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[课程类别]</td>

        <td width="57%" align="right">
            <a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/>
            </a>
            <%--编辑前：添加类别 --%>
            <s:a namespace="/" action="courseTypeAction_addOrEditUI">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </s:a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>


<%--条件查询 start --%>
<s:form namespace="/" action="courseTypeAction_listAll">
    <s:hidden name="currentPage" value="%{#allCourses.currentPage}" id="currentPage"></s:hidden>
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td width="10%">课程类别：</td>
            <td><s:textfield name="courseName" size="30"/></td>
        </tr>
        <tr>
            <td>课程简介：</td>
            <td><s:textfield name="remark" size="12"/></td>
        </tr>
        <tr>
            <td>总学时：</td>
            <td>
                <s:textfield name="totalMin" size="12"/>
                至
                <s:textfield name="totalMax" size="12"/>
            </td>
        </tr>
        <tr>
            <td>课程费用：</td>
            <td>
                <s:textfield name="costMin" size="12"/>
                至
                <s:textfield name="costMax" size="12"/>
            </td>
        </tr>
    </table>
</s:form>
<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>
<table width="97%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="14%" align="center">名称</td>
        <td width="33%" align="center">简介</td>
        <td width="13%" align="center">总学时</td>
        <td width="18%" align="center">收费标准</td>
        <td width="11%" align="center">编辑</td>
    </tr>
    <s:iterator value="#allCourses.data" var="course" status="vs">
        <tr class="<s:property value="#vs.even ? 'tabtd2' : 'tabtd1'"/>">
            <td align="center"><s:property value="#course.courseName"/></td>
            <td align="center"><s:property value="#course.remark"/></td>
            <td align="center"><s:property value="#course.total"/></td>
            <td align="center"><s:property value="#course.courseCost"/></td>
            <td width="11%" align="center">
                <s:a namespace="/" action="courseTypeAction_addOrEditUI">
                    <s:param name="courseTypeId" value="#course.courseTypeId"></s:param>
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
                </s:a>
            </td>
        </tr>
    </s:iterator>
</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第<s:property value="#allCourses.currentPage"/>/<s:property value="#allCourses.totalPages"/>页</span>
            <span>
                <s:if test="#allCourses.currentPage > 1">
                    <a href="#" onclick="switchPage(1)">[首页]</a>&nbsp;&nbsp;
                    <a href="#" onclick="switchPage(<s:property
                            value="#allCourses.currentPage - 1 < 1 ? 1 : #allCourses.currentPage - 1"/>)">[上一页]</a>&nbsp;&nbsp;
                </s:if>
                <s:if test="#allCourses.currentPage < #allCourses.totalPages">
                    <a href="#" onclick="switchPage(<s:property
                            value="#allCourses.currentPage + 1 > #allCourses.totalPages ? #allCourses.totalPages : #allCourses.currentPage + 1"/>)">[下一页]</a>&nbsp;&nbsp;
                    <a href="#" onclick="switchPage(<s:property value="#allCourses.totalPages"/>)">[尾页]</a>
                </s:if>
            </span>
        </td>
    </tr>
</table>
<script>
    function switchPage(num) {
        document.getElementById("currentPage").value = num;
        document.forms[0].submit();
    }
</script>
</body>
</html>
