<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="common/head.jsp" %>
<body>

<%@ include file="common/header_nav.jsp" %>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Shop</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <c:forEach items="${requestScope.products}" var="product">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <a href="${path}/product/${product.pid}">
                                <img src="${product.imgUrl}" />
                            </a>
                        </div>
                        <div class="name">
                            <h2><a href="${path}/product/${product.pid}" title="${product.name}" >${product.name}</a></h2>
                        </div>
                        <div class="product-carousel-price">
                            <ins>$${product.price}</ins>
                            <del>$${product.originalPrice}</del>
                        </div>
                        <div class="product-option-shop">
                            <a class="add_to_cart_button" quantity="1" href="${path}/cart/add?pid=${product.pid}&quantity=1" rel="nofollow">Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <%--<div class="col-md-3 col-sm-6">--%>
                <%--<div class="single-shop-product">--%>
                    <%--<div class="product-upper">--%>
                        <%--<img src="img/product-2.jpg" alt="">--%>
                    <%--</div>--%>
                    <%--<h2><a href="">Apple new mac book 2015 March :P</a></h2>--%>
                    <%--<div class="product-carousel-price">--%>
                        <%--<ins>$899.00</ins>--%>
                        <%--<del>$999.00</del>--%>
                    <%--</div>--%>

                    <%--<div class="product-option-shop">--%>
                        <%--<a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="/canvas/shop/list.jsp?add-to-cart=70">Add to cart</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="product-pagination text-center">
                    <nav>
                        <ul class="pagination">
                            <c:forEach begin="1" end="${requestScope.pageCount}" varStatus="status">
                                <li <c:if test="${requestScope.page == status.index}">class="active"</c:if>>
                                    <a href="${path}/list?page=${status.index}<c:if test="${param.cid != null}">&cid=${param.cid}</c:if><c:if test="${param.bid != null}">&bid=${param.bid}</c:if><c:if test="${param.name != null}">&name=${param.name}</c:if>">${status.index}</a>
                                </li>
                            </c:forEach>
                            <%--<li>--%>
                            <%--<a href="#" aria-label="Previous">--%>
                            <%--<span aria-hidden="true">&laquo;</span>--%>
                            <%--</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="#">1</a></li>--%>
                            <%--<li><a href="#">2</a></li>--%>
                            <%--<li><a href="#">3</a></li>--%>
                            <%--<li><a href="#">4</a></li>--%>
                            <%--<li><a href="#">5</a></li>--%>
                            <%--<li>--%>
                            <%--<a href="#" aria-label="Next">--%>
                            <%--<span aria-hidden="true">&raquo;</span>--%>
                            <%--</a>--%>
                            <%--</li>--%>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
</body>
</html>