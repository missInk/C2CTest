<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息展示</title>
	<!-- setStyle start -->
   <link rel="stylesheet" href="css/tit-tail.css">
   <link rel="stylesheet" href="css/commons.css">
   <link rel="stylesheet" href="css/shopping-info.css">
   <!-- setStyle end -->
   <script src="js/shoppingInfo.js"></script>
</head>
<body>
<!-- 导航栏开始 -->
<div class="wrap">
    <div class="wrap-box">
        <a href="">
            <img class="logo-header" src="images/logo.png" alt="赚赚">
        </a>
        <div class="location-header">
            <div class="location-header-box">
                <img class="location-header-img" src="images/positionLogo.png" alt="定位">
                <span>南昌</span>
                <img class="location-header-img" src="images/lowPositionLogo.png" alt="箭头">
                <span>&nbsp;江西农业大学</span>
                <img class="location-header-img" src="images/lowPositionLogo.png" alt="箭头">
            </div>
        </div>
        <div class="recommend-header">
            <div class="recommend-header-box">
                <a href="#" class="recommend-header-a">首页</a>
            </div>
        </div>
        <div class="right-header">
            <div class="right-header-box">
                <span>我的交易</span>
            </div>
            <div class="right-header-box">
                <span>我的消息</span>
            </div>
            <div class="right-header-box">
                <img class="right-header-img" src="images/user.png">
                <span>登录</span>
            </div>
        </div>
        <div class="search-header">
            <img class="search-header-img" src="images/search.png" alt="搜索">
            <input class="search-header-input" placeholder="输入商品名称搜索商品">
            <span class="search-header-button">搜索</span>
        </div>
    </div>
</div>
<!-- 导航栏结束 -->

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
                <div class="perform-order-buy-btn">我想要</div>
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
                            <textarea class="sendMessageValue"></textarea>
                            <div class="sendBtnContent">
                                <a class="sendLessMessageBtn" href="#">发送留言</a>
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

<!-- 尾部开始 -->
<div class="footer">
    <div class="footer-container">
        <span style="display: inline-block; margin-top: 10px;">@版权所有</span>
    </div>
</div>
<!-- 尾部结束 -->
</body>
</html>