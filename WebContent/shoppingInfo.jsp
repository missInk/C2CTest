<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
<%
if(request.getAttribute("good") == null){
%>
alert("请通过正常渠道进入该界面");
<%
}
%>    
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息展示</title>
	<!-- setStyle start -->
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/tit-tail.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/commons.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/shopping-info.css">
   <!-- setStyle end -->
   <script src="${pageContext.request.contextPath }/js/shoppingInfo.js"></script>
   <script src="${pageContext.request.contextPath }/js/tit.js"></script>
</head>
<body>
<%@include file="tit.jsp" %>

<!-- 商品信息开始 -->
<div class="shopping">
    <!-- 售卖信息开始 -->
    <div class="shopping-box">
        <div class="shopping-box-info">
            <img class="shopping-info-img" src=${good.goodPhoto }>
            <div class="shopping-info">
                <div class="shopping-info-tit"> ${good.goodName }</div>
                <div class="shopping-info-owner">出售人：${good.sellMen.userName }</div>
                <div class="shopping-info-category">商品类别：${good.category }</div>
                <div class="shopping-info-place">交易范围：${position.positionName }-${position.range }</div>
                <div class="shopping-info-price">商品价格：<span style="color: red;">￥${good.price }</span></div>
                <div class="perform-order-buy-btn" onclick="javaScript:alert('开发ing，别点了')">我想要</div>
            </div>
        </div>
    </div>
    <!-- 售卖信息结束 -->

    <!-- 相关信息开始 -->
    <div class="perform__bd">
        <ul class="perform__bd__menu tabs-nav">
            <li class="perform__bd__menu__list selected">
                <a href="javascript:void(0);" onclick="changeTab('about_good', this)">商品介绍</a>
            </li>
            <li class="perform__bd__menu__list">
                <a href="javascript:void(0);" onclick="showLeaveMessage(${good.idGoods }, this)">商品留言</a>
            </li>
        </ul>
        <div class="perform__bd__cont tabs-content">
            <div class="about_good tab" style="display: block;">
                <div class="perform__bd__cont__list">
                    <div class="perform__bd__title">商品介绍</div>
                    <div class="perform__bd__note">
                        <div class="good_news">${good.goodIntroduce }</div>
                    </div>
                  </div>
            </div>
            <div class="good_leave_message tab" style="display: none;">
                <div class="perform__bd__cont__list">
                    <div class="perform__bd__title">商品留言</div>
                    <div class="perform__bd__note">
                        <div id="leaveMessage"></div>
                        <div class="sendLessMessage">
                            <div class="sendLessMessageTit">发表留言</div>
                            <textarea class="sendMessageValue" id="sendMessageValue"></textarea>
                            <div class="sendBtnContent">
                                <a class="sendLessMessageBtn" href="#" onclick="sendLeaveMessage('${good.idGoods }','${user.idUser }')">发送留言</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 相关信息结束 -->
</div>
<!-- 商品信息结束 -->

<%@include file="tail.jsp" %>
</body>
</html>