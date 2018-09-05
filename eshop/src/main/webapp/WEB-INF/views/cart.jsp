<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="common/head.jsp"%>
    <script src="${path}/static/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript">
        <%--$(".btn-icon").click(function () {--%>
            <%--var url;--%>
            <%--var quantityInput = $(this).siblings("input[name='qty']");--%>
            <%--var quantity = quantityInput.val();--%>
            <%--var id = $(this).siblings("input:hidden").val();--%>
            <%--if ($(this).hasClass("minus")) {--%>
                <%--if (quantity == 1) {--%>
                    <%--layer.alert("不能再减了", {icon: 0});--%>
                    <%--return;--%>
                <%--}--%>
                <%--url = "${path}/cart/minus/" + id;--%>
                <%----quantity;--%>
            <%--} else {--%>
                <%--url = "${path}/cart/plus/" + id;--%>
                <%--++quantity;--%>
            <%--}--%>
            <%--layer.load(1);--%>
            <%--$.ajax({--%>
                <%--url: url,--%>
                <%--method: "get",--%>
                <%--success: function (res) {--%>
                    <%--if (res.success) {--%>
                        <%--quantityInput.val(quantity);--%>
                        <%--$("#totalPrice").text("￥" + res.total.totalPrice);--%>
                        <%--layer.closeAll('loading');--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>
        <%--});--%>

        $(function () {
            $(".btn-icon").click(function () {
                var url;
                var quantityInput = $(this).siblings("input[name='quantitys']");
                var quantity = quantityInput.val();
                var id = $(this).parent().next("div").children("input:hidden").val();
                if ($(this).hasClass("fa-minus-circle")) {
                    if (quantity == 1) {
                        layer.alert("不能再减了", {icon: 0});
                        return;
                    }
                    url = "${path}/cart/minus/" + id;
                    --quantity;
                } else {
                    url = "${path}/cart/plus/" + id;
                    ++quantity;
                }
                layer.load(1);
                $.ajax({
                    url: url,
                    method: "get",
                    success: function (res) {
                        if (res.success) {
                            quantityInput.val(quantity);
                            $("#totalPrice").text("￥" + res.total.totalPrice);
                            $("#totalCount").text("" + res.total.totalCount);
                            layer.closeAll('loading');
                        }
                    }
                });
            });
        });
    </script>
  </head>
  <body>

    <%@ include file="common/header_nav.jsp"%>
    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <%@ include file="common/sidebar.jsp"%>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="post" action="#">
                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-remove">&nbsp;</th>
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">品牌</th>
                                            <th class="product-price">单价</th>
                                            <th class="product-quantity">数量</th>
                                            <th class="product-subtotal">类型</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.carts}" var="cart">
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                                <a title="Remove this item" class="remove" href="${path}/cart/delete/${cart.id}">×</a>
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="${path}/product/${cart.pid}"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="${path}/${cart.imgUrl}"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="${path}/list?bid=${cart.bid}">${cart.bname}</a>
                                            </td>

                                            <td class="product-price">
                                                <span class="amount">￥：${cart.price}</span>
                                            </td>

                                            <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <%--<input type="button" class="btn-icon minus" value="-">--%>
                                                    <%--<input type="number" size="4" class="input-text qty text" title="Qty" value="${cart.quantity}" min="0" step="1">--%>
                                                    <%--<input type="button" class="btn-icon plus" value="+">--%>
                                                    <%--<input type="hidden" name="id" value="${cart.id}">--%>
                                                        <span class="btn-icon fa fa-lg fa-minus-circle"></span>
                                                        <input readonly name="quantitys" class="form-inline quantitys" type="text" style="width: 50px;" value="${cart.quantity}"/>
                                                        <span class="btn-icon fa fa-lg fa-plus-circle"></span>
                                                </div>
                                                <div>
                                                    <input type="hidden" name="id" value="${cart.id}">
                                                </div>

                                            </td>

                                            <td class="product-subtotal">
                                                <span class="amount"><a href="${path}/list?cid=${cart.cid}">${cart.cname}</a></span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <div class="coupon">
                                                    <%--<label for="coupon_code">Coupon:</label>--%>
                                                    <%--<input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">--%>
                                                    <%--<input type="submit" value="Apply Coupon" name="apply_coupon" class="button">--%>
                                                </div>
                                                <%--<input type="submit" value="更新购物车" name="update_cart" class="button" style="margin-left: 500px;">--%>
                                                <%--<a href="${path}/checkout">--%>
                                                <%--</a>--%>

                                                <input onclick="window.location.href='/checkout'" type="button" value="结算" name="proceed" class="checkout-button button alt wc-forward" style="margin-left: 650px;">

                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>

                            <div class="cart-collaterals">


                            <div class="cross-sells">
                                <h2>你可能感兴趣的...</h2>
                                <ul class="products">
                                    <li class="product">
                                        <a href="product">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="${path}/static/img/product-2.jpg">
                                            <h3>Ship Your Idea</h3>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="product">选择参数</a>
                                    </li>

                                    <li class="product">
                                        <a href="product">
                                            <img width="325" height="325" alt="T_4_front" class="attachment-shop_catalog wp-post-image" src="${path}/static/img/product-4.jpg">
                                            <h3>Ship Your Idea</h3>
                                            <span class="price"><span class="amount">£20.00</span></span>
                                        </a>

                                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="22" rel="nofollow" href="product">选择参数</a>
                                    </li>
                                </ul>
                            </div>


                            <div class="cart_totals ">
                                <h2>价格明细</h2>

                                <table cellspacing="0">
                                    <tbody>
                                        <tr class="cart-subtotal">
                                            <th>商品数量</th>
                                            <td id="totalCount"><span class="amount"></span>${requestScope.total.totalCount}</td>
                                        </tr>

                                        <%--<tr class="shipping">--%>
                                            <%--<th>Shipping and Handling</th>--%>
                                            <%--<td>Free Shipping</td>--%>
                                        <%--</tr>--%>

                                        <tr class="order-total">
                                            <th>总价</th>
                                            <td><strong id="totalPrice">￥${requestScope.total.totalPrice}<span class="amount"></span></strong> </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>


                            </div>
                        </div>                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>

    <%@ include file="common/footer.jsp"%>
  </body>
</html>