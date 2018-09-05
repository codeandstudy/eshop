<%--
  Created by IntelliJ IDEA.
  User: ica_dv
  Date: 2018/7/15
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/head.jsp"%>
</head>
<body>
<%@ include file="common/header_nav.jsp"%>

<div id="page-content" class="single-page">
    <div class="container" style="margin-top: 30px;margin-bottom: 30px;">
        <div class="row">
            <div class="col-md-6">
                <div class="heading"><h2>登录</h2></div>
                <form name="form1" id="form-login" method="post" action="${path}/account/login">
                    <c:if test='${param.callBack != null}'>
                        <input type="hidden" name="callBack" value="${param.callBack}<c:if test='${param.quantity != null}'>&quantity=${param.quantity}</c:if>">
                    </c:if>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="用户名 :" name="name" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="密码 :" name="pass" required>
                    </div>
                    <button type="submit" class="btn btn-1" name="login" id="login">登录</button>
                    <a href="#">忘记密码？</a>
                </form>
            </div>
            <div class="col-md-6">
                <div class="heading"><h2>新用户？注册一个账号。</h2></div>
                <form name="form2" id="ff2" method="post" action="#">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="用户名 :" name="username" required>
                    </div>
                    <div class="form-group">
                        <input type="tel" class="form-control" placeholder="邮箱 :" name="email" required>
                    </div>
                    <div class="form-group">
                        <input type="tel" class="form-control" placeholder="手机号 :" name="phone" required>
                    </div>
                    <div class="form-group">
                        <input name="gender" type="radio" value="male"> 男 <input name="gender" type="radio" value="female"> 女
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="密码 :" name="password" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="确认密码 :" name="repassword" required>
                    </div>
                    <div class="form-group">
                        <input name="agree" id="agree" type="checkbox" > 我已阅读并同意<a href="#">XXX协议</a>！
                    </div>
                    <button type="submit" class="btn btn-1">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp"%>

</body>
</html>
