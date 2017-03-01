<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [javaee crm](#javaee-crm)
	- [MD5加密](#md5加密)
	- [Struts2拦截器](#struts2拦截器)

<!-- /TOC -->

# javaee crm

## MD5加密
	```
	public static String getMD5Value(String value) {

			try {
					//1 获得jdk提供消息摘要算法工具类
					MessageDigest messageDigest = MessageDigest.getInstance("MD5");
					//2 加密的结果10进制
					byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
					//3将10进制 转换16进制
					BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);

					return bigInteger.toString(16);
			}
			catch (Exception e) {
					throw new RuntimeException(e);
			}
	}
	```

## Struts2拦截器

- ![interceptor](./assets/interceptor.png)
- 实现类
	```
		public class LoginInterceptor extends MethodFilterInterceptor {
			@Override
			protected String doIntercept(ActionInvocation invocation) throws Exception {

					Object loginStaff = ActionContext.getContext().getSession().get("loginStaff");
					if (null == loginStaff) {
							((ActionSupport) invocation.getAction()).addFieldError("", "请登录");
							return "login_fail";
					}

					return invocation.invoke();
			}
		}
	```
- 配置拦截器
	```
	<package name="common" namespace="/" extends="struts-default" strict-method-invocation="false">
			<!-- 拦截器配置
					* 先声明
					* 配置
							方法1：每一个action单独使用,需要多次引用，否则默认将被覆盖
									<action name="">
											<interceptor-ref name="defaultStack"></interceptor-ref>
											<interceptor-ref name="loginInterceptor"></interceptor-ref>
									</action>
							方法2：将多个拦截器打包生成自定义栈，action使用栈
									* 自定义拦截器栈
									<interceptor-stack name="loginStack">
											<interceptor-ref name="defaultStack"></interceptor-ref>
											<interceptor-ref name="loginInterceptor"></interceptor-ref>
									</interceptor-stack>
									* action引用
									<action name="">
											<interceptor-ref name="loginStack"></interceptor-ref>
									</action>
							方法3：将自定义栈，把默认栈覆盖
									<default-interceptor-ref name="loginStack"></default-interceptor-ref>
	-->

			<interceptors>
					<interceptor name="loginInterceptor" class="com.liuhy.crm.web.interceptor.LoginInterceptor">
							<param name="excludeMethods">login</param>
					</interceptor>
					<!-- 自定义拦截器栈-->
					<interceptor-stack name="loginStack">
							<interceptor-ref name="defaultStack"></interceptor-ref>
							<interceptor-ref name="loginInterceptor"></interceptor-ref>
					</interceptor-stack>
			</interceptors>

			<!-- 修改默认的拦截器栈-->
			<default-interceptor-ref name="loginStack"/>

			<global-results>
					<!-- 如果拦截到用户没有登录，跳转到登录页面-->
					<result name="login_fail">index.jsp</result>
			</global-results>

			<!--
					action.class默认值：ActionSupport
					action.method默认值：execute
					result.name默认值
			-->
			<action name="uiAction_*_*">
					<result>WEB-INF/pages/{1}/{2}.jsp</result>
			</action>
	</package>
	```

## Struts2在Action中将数据放入值栈的几种方法
- 方式1：context (map)存放 put(key ,value) ，jsp页面获得 “#key” 。
	`ActionContext.getContext().put(key, value)`
- 方式2：root (值栈) ，push(obj) ，一般数据为JavaBean 或 Map ，jsp页面获得“属性名” 或“key”  。
- 方式3：root (值栈) ，set(key ,value) ,一般数据为List ，jsp页面获得“key”
	set() 底层 new Map(key,value) ，将 push(map )

## 在jsp中从值栈取值
	```
	<s:iterator value="#allStaff" status="vs">
			<tr class="<s:property value="#vs.even ? 'tabtd2' : 'tabtd1'"/>">
					<td align="center"><s:property value="staffName"/></td>
					<td align="center"><s:property value="gender"/></td>
					<td align="center"><s:property value="onDutyDate"/></td>
					<td align="center"><s:property value="post.department.depName"/></td>
					<td align="center"><s:property value="post.postName"/></td>
					<td width="7%" align="center">
							<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img
											src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
					</td>
			</tr>
	</s:iterator>
	```
