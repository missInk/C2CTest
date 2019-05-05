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
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/cssreset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css">
<script src="${pageContext.request.contextPath }/js/zhuan.js"></script>
</head>
<body>
    <!-- S 网站头部 -->
    <div class="h-header">
        <!-- S 左侧logo -->
        <div class="logo">
            <!-- h1标题仅仅用于网站SEO优化，不用于显示给用户看 -->
            <h1>赚赚在线校园闲置交易网</h1>
            <a href="#">
                <img src="${pageContext.request.contextPath }/images/logo.png" alt="logo" title="赚赚在线校园闲置交易网">
            </a>
        </div>
        <div class="current-page">
            <a href="alert('待开发')" class="home-page">首页</a>
        </div>
        <!-- E 左侧logo -->
        <!-- S 顶部导航栏 -->
        <div class="top-nav">
        <%
		    if(session.getAttribute("user") != null){
		    	User user = (User)session.getAttribute("user");
		%>
            <a href="alert('待开发')" class="user-msg">
                <img src=${user.headPortrait } class="avatar" alt="默认头像" title="头像" width="50px" height="50px">
            </a>
		 	<div>
		 		<a>${user.userName }</a>
		 	</div>
		 <%
		    }
		 %>
            <div class="user-mine">我的交易
                <ul class="trade-list">
                    <li>出售中</li>
                    <li>已卖出</li>
                    <li>我的关注</li>
                </ul>
            </div>
            <a href="alert('待开发')" class="user-mine">我的消息</a>
            <a href="alert('待开发')" class="user-mine">我的信息</a>
            <% if(session.getAttribute("user") == null){ %>
            <a href="${pageContext.request.contextPath }/login.jsp" class="login">登录/注册</a>
            <%} %>
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
                    <img class="location-header-img" src="${pageContext.request.contextPath }/images/positionLogo.png" alt="定位">
                    <span>${position.positionName }</span>
                    <img class="location-header-img" src="${pageContext.request.contextPath }/images/lowPositionLogo.png" alt="箭头">
                    <span>&nbsp;${position.range }</span>
                    <img class="location-header-img" src="${pageContext.request.contextPath }/images/lowPositionLogo.png" alt="箭头">
                </div>
            </div>
            <div class="search-header">
                <img class="search-header-img" src="${pageContext.request.contextPath }/images/search.png" alt="搜索">
                <input class="search-header-input" placeholder="输入商品名称搜索商品">
                <span class="search-header-button">搜索</span>
            </div>
            <div class="publish">
                <a href="">
                    <div class="icon-pub">
                        <img class="publish-img" src="${pageContext.request.contextPath }/images/publish.png" alt="发布闲置">
                    </div>
                    <span class="publish-span">发布我的闲置</span>
                </a>

            </div>
        </div>
        <!-- E 主要导航栏 -->
        <!-- S 商品分类栏 -->
        <div class="main-cate">
            <ul class="main-cate-list">
                <li><a href="alert('待开发')" class="main-cate-list-a act">随便看看</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">男女服饰</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">美妆洗护</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">生活日用</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">零食</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">书籍试卷</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">办公用品</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">运动户外</a></li>
                <li><a href="alert('待开发')" class="main-cate-list-a">关注</a></li>
            </ul>
        </div>
        <!-- E 商品分类栏 -->
        <!-- S 商品信息 -->
        <%
	    if(session.getAttribute("goods") != null){
	    	List<Good> goods = (List<Good>)session.getAttribute("goods");
	    	Iterator<Good> iterator = goods.iterator();
	       	while(iterator.hasNext()){
	       		Good good = (Good)iterator.next();
	    %>
	    
	     <div class="main-goodsinfo">
            <div class="info-detail">
                <img class="info-img" src=<%=good.getGoodPhoto() %> alt="">
                <div class="good-brief"><a href="${pageContext.request.contextPath }/GoodServlet?method=getGoodByIdGoods&idGoods=<%=good.getIdGoods() %>"><%=good.getGoodName() %></a></div>
                <div class="good-price"><%=good.getPrice() %></div>
                <div class="good-user">
                    <img class="user-img" src=<%=good.getSellMen().getHeadPortrait() %> alt="">
                    <span><%=good.getSellMen().getUserName() %></span>
                </div>
            </div>
        </div>
	    
	    <%
	       	}
	    }
    	%>
        <div class="page-index">
       	   <div class="good-page-index">
                <img class="index-circle" src="${pageContext.request.contextPath }/images/圆形.png" alt="">
                <a class="index-number act" href="">1</a>
            </div>
        <%
	    if(session.getAttribute("pageSize") != null){
	    	int pageSize = Integer.parseInt((String)session.getAttribute("pageSize"));
	    	for(int i = 1; i < pageSize; i++){
	    %>
            <div class="good-page-index">
                <img class="index-circle" src="${pageContext.request.contextPath }/images/圆形.png" alt="">
                <a class="index-number" href="alert('待开发')"><%=i+1 %></a>
            </div>
       <%
	       	}
	    }
    	%>
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