<%@page import="java.util.Iterator"%>
<%@page import="com.C2C.Entity.Good"%>
<%@page import="java.util.List"%>
<%@page import="com.C2C.Entity.Position"%>
<%@page import="com.C2C.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>赚赚在线校园闲置交易网</title>
<link rel="stylesheet" href="./css/cssreset.css">
<link rel="stylesheet" href="./css/index.css">
<script src="js/zhuan.js"></script>
</head>
<body>
	<div class="top">
       <div class="tl">
           <span>
                <h1>赚赚</h1>
           </span>
       </div>
       <div class="tr">
            <span>
                <a href="${pageContext.request.contextPath }/login.jsp">登陆</a>
            </span>
            <span>
                <a href="./login.html">取消</a>
            </span>
       </div>
    </div>
    <%
    if(session.getAttribute("user") != null){
    	User user = (User)session.getAttribute("user");
    	out.println(" 用户ID："+user.getIdUser());
    	out.println(" 用户名："+user.getUserName());
    	out.println(" 性别："+user.getSex());
    	out.println(" 学校："+user.getSchool());
    	out.println(" 头像："+user.getHeadPortrait());
    }
    /* if(session.getAttribute("position") != null){
       	Position position = (Position)session.getAttribute("position");
       	out.println(position.getPositionName() +":" +position.getRange());
    } */
    if(session.getAttribute("goods") != null){
    	List<Good> goods = (List<Good>)session.getAttribute("goods");
    	Iterator<Good> iterator = goods.iterator();
       	while(iterator.hasNext()){
       		Good good = (Good)iterator.next();
       		out.println("<br/>"+good.getGoodPhoto()+good.getGoodName()+"<br/>");
       	}
    }
    %>
    <!-- S 网站头部 -->
    <div class="h-header">
        <!-- S 左侧logo -->
        <div class="logo">
            <!-- h1标题仅仅用于网站SEO优化，不用于显示给用户看 -->
            <h1>赚赚在线校园闲置交易网</h1>
            <a href="#">
                <img src="./img/logo.png" alt="logo" title="赚赚在线校园闲置交易网">
            </a>
        </div>
        <div class="current-page">
            <a href="#" class="home-page">首页</a>
        </div>
        <!-- E 左侧logo -->
        <!-- S 顶部导航栏 -->
        <div class="top-nav">
            <a href="#" class="user-msg">
                <img src="./img/avatar.png" class="avatar" alt="默认头像" title="头像" width="50px" height="50px">
            </a>
            <div class="user-mine">我的交易
                <ul class="trade-list">
                    <li>出售中</li>
                    <li>已卖出</li>
                    <li>我的关注</li>
                </ul>
            </div>
            <a href="#" class="user-mine">我的消息</a>
            <a href="" class="login">登录/注册</a>
        </div>
        <!-- E 顶部导航栏 -->
    </div>
    <!-- E 网站头部 -->
    <!-- S 网站主要内容区 -->
    <div class="h-main">
        <!-- S 主要导航栏 -->
        <div class="main-nav">
            <div class="location-header">
                <div class="location-header-box">
                    <img class="location-header-img" src="./img/positionLogo.png" alt="定位">
                    <span>南昌</span>
                    <img class="location-header-img" src="./img/lowPositionLogo.png" alt="箭头">
                    <span>&nbsp;江西农业大学</span>
                    <img class="location-header-img" src="./img/lowPositionLogo.png" alt="箭头">
                </div>
            </div>
            <div class="search-header">
                <img class="search-header-img" src="./img/search.png" alt="搜索">
                <input class="search-header-input" placeholder="输入商品名称搜索商品">
                <span class="search-header-button">搜索</span>
            </div>
            <div class="publish">
                <a href="">
                    <div class="icon-pub">
                        <img class="publish-img" src="./img/publish.png" alt="发布闲置">
                    </div>
                    <span class="publish-span">发布我的闲置</span>
                </a>

            </div>
        </div>
        <!-- E 主要导航栏 -->
        <!-- S 商品分类栏 -->
        <div class="main-cate">
            <ul class="main-cate-list">
                <li><a href="javascript:void(0);" class="main-cate-list-a act">随便看看</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">男女服饰</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">美妆洗护</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">生活日用</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">零食</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">书籍试卷</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">办公用品</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">运动器材</a></li>
                <li><a href="javascript:void(0);" class="main-cate-list-a">关注</a></li>
            </ul>
        </div>
        <!-- E 商品分类栏 -->
        <!-- S 商品信息 -->
        <div class="main-goodsinfo">
            <div class="info-detail">
                <img class="info-img" src="./img/shop.jpg" alt="">
                <div class="good-brief">匡威CONVERSE☆拼接短袖匡威CONVERSE☆拼接E☆拼接</div>
                <div class="good-price">￥999999</div>
                <div class="good-user">
                    <img class="user-img" src="./img/avatar.png" alt="">
                    <span>用户名用户名</span>
                    <img class="user-img" src="./img/u=2606411160,3011540467&fm=58&bpow=600&bpoh=598.jpg" alt="">
                </div>
            </div>
        </div>
        <div class="page-index">
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">1</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">2</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">3</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">4</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">5</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">6</a>
            </div>
            <div class="good-page-index">
                <img class="index-circle" src="./img/圆形.png" alt="">
                <a class="index-number" href="">7</a>
            </div>
        </div>
        <!-- E 商品信息 -->
    </div>
    <!-- E 网站主要内容区 -->
    <!-- S 网站底部 -->
    <div class="h-footer">
    </div>
    <!-- E 网站底部 -->
</body>
</html>