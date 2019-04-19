<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                <a href="${pageContext.request.contextPath }/index.jsp" class="recommend-header-a">首页</a>
            </div>
        </div>
        <div class="right-header">
            <div class="right-header-box">
                <span>我的交易</span>
            </div>
            <div class="right-header-box">
                <span>我的消息</span>
            </div>
            <%
            if(request.getSession().getAttribute("user")==null){
            %>
            <div class="right-header-box">
                <img class="right-header-img" src="images/user.png">
                <span onclick="login()">登录</span>
            </div>
            <div class="right-header-box">
                <span onclick="regist()">注册</span>
            </div>
            <%
            }else{
            %>
            <div class="right-header-box">
                <img src="headPortrait/head.jpg"  class="right-header-img">
                <span onclick="javaScript:alert('该功能未开发')">${user.userName }</span>
            </div>
            <div class="right-header-box">
                <span onclick="loginOut()">登出</span>
            </div>
            <%
            }
            %>
        </div>
        <div class="search-header">
            <img class="search-header-img" src="images/search.png" alt="搜索">
            <input class="search-header-input" placeholder="输入商品名称搜索商品">
            <span class="search-header-button" onclick="javaScript:alert('开发ing')">搜索</span>
        </div>
    </div>
</div>
<!-- 导航栏结束 -->