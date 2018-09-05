<%--
  Created by IntelliJ IDEA.
  User: ica_dv
  Date: 2018/7/13
  Time: 下午6:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <c:choose>
                            <c:when test="${sessionScope.member != null}">
                                <li> <a href="#"><i class="fa fa-user"></i>${sessionScope.member.name}</a> </li>
                                <li> <a href="${path}/account/logout">退出</a> </li>
                                <li><a href="${path}/cart/list"><i class="fa fa-shopping-cart"></i> 购物车</a> </li>
                                <li><a href="${path}/checkout"><i class="fa fa-dollar"></i> 结算</a> </li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${path}/account"><i class="fa fa-user"></i> 我的账号</a></li>
                            </c:otherwise>
                        </c:choose>
                        <%--<li><a href="#"><i class="fa fa-user"></i> My Account</a></li>--%>
                        <%--<li><a href="cart"><i class="fa fa-user"></i> My Cart</a></li>--%>
                        <%--<li><a href="checkout"><i class="fa fa-user"></i> Checkout</a></li>--%>
                        <%--<li><a href="#"><i class="fa fa-user"></i> Login</a></li>--%>
                    </ul>
                </div>
            </div>

            <%--<div class="col-md-4">--%>
                <%--<div class="header-right">--%>
                    <%--<ul class="list-unstyled list-inline">--%>
                        <%--<li class="dropdown dropdown-small">--%>
                            <%--<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <%--<li><a href="#">USD</a></li>--%>
                                <%--<li><a href="#">INR</a></li>--%>
                                <%--<li><a href="#">GBP</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>

                        <%--<li class="dropdown dropdown-small">--%>
                            <%--<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>--%>
                            <%--<ul class="dropdown-menu">--%>
                                <%--<li><a href="#">English</a></li>--%>
                                <%--<li><a href="#">French</a></li>--%>
                                <%--<li><a href="#">German</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
    </div>
</div> <!-- End header area -->

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="logo">
                    <h1><a href="${path}/index"><img src="${path}/static/img/logo.png"></a></h1>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="search-item">
                    <form action="list" method="get">
                        <input type="text" name="name" value="${param.name}" class="input" required placeholder="Search here"/>
                        <input type="hidden" name="page" value="1"/>
                        <button type="submit" class="search-btn">Search</button>
                    </form>
                </div>
            </div>

            <div class="col-sm-4">
                <div class="shopping-item">

            <a href="${path}/cart/list">Cart - <span class="cart-amunt">购物车</span> <i class="fa fa-shopping-cart"></i> <span class="product-count"></span></a>

                </div>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->

<div class="mainmenu-area" id="menu">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${path}/index">首页</a></li>
                    <c:forEach items="${requestScope.nav}" var="nav">
                        <li class="dropdown"><a href="${path}/list?cid=${nav.cid}&page=1" >${nav.name}</a>
                            <div class="dropdown-menu">
                                <div class="dropdown-inner">
                                    <ul class="list-unstyled">
                                        <c:forEach items="${nav.brands}" var="brand" varStatus="status">
                                        <li><a href="${path}/list?cid=${nav.cid}&bid=${brand.bid}&page=1">${brand.name}</a></li>
                                        <c:if test="${status.count % 4 == 0}">
                                    </ul>
                                    <ul class="list-unstyled">
                                        </c:if>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                    <li><a href="${path}/list">全部商品</a></li>
                    <%--<li class="active"><a href="index">Home</a></li>--%>
                    <%--<li><a href="shop">Shop page</a></li>--%>
                    <%--<li><a href="single-product">Single product</a></li>--%>
                    <%--<li><a href="cart">Cart</a></li>--%>
                    <%--<li><a href="checkout">Checkout</a></li>--%>
                    <%--<li><a href="#">Category</a></li>--%>
                    <%--<li><a href="#">Others</a></li>--%>
                    <%--<li><a href="#">Contact</a></li>--%>
                </ul>
            </div>
        </div>
    </div>
</div> <!-- End mainmenu area -->
