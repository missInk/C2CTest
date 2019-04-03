<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 样式导入开始 -->
    <link href="${pageContext.request.contextPath }/css/search.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/showPosition.js"></script>
    <!-- 样式导入结束 -->
    <title>搜索框</title>
    
</head>
<body>
    <!-- 导航栏开始 -->
    <div class="top">
        <div class="top-box">
            <div class="top-value">
                <img src="./images/icon1.png" alt="" class="icon1">
                <div class="top-right">
                <span>
                    <a href="#">登陆</a>
                </span>
                    <span>|</span>
                    <span>
                    <a href="#">注册</a>
                </span>
                    <img src="./images/woyaokaidian.png" alt="" class="icon2">
                </div>
            </div>
        </div>
    </div>
    <!-- 导航栏结束 -->
    <!-- 内容开始 -->
    <div class="main">
        <div class="main-box">
            <span class="main_top">
                <img src="./images/icon2.png">
            </span>
            <div class="main-search">
	            <div class="search-position">
	            	<a href="javaScript:void(0)" onclick="getPositions()">南昌</a>
	            	<div id="position_div"></div>
	            </div>
                <!-- 不要用value，提示用placeholder -->
                <input type="text" placeholder="请输入你的收货地址（写字楼、小区或街道）" >
                <img src="./images/search.png" class="search">
            </div>
       </div>
    </div>
    <!-- 内容开始 -->
    <!-- 尾部开始 -->
    <div class="bg" id="tit_bg">
        <div class="wrap">
            <div class="item item1">
                <img src="">
                <div><a href="" target="_blank" class="p2">关于我们</a></div>
                <div><a href="" target="_blank" class="p2">用户协议</a></div>
            </div>
            <div class="item item2">
                <p class="p1" color="white">支持单位</p>
                <p class="p2">主办单位：</p>
                <p class="p2">工业和信息化部人才交流中心</p>
                <p class="p2">技术支持：</p>
                <p class="p2">院学生工作办公室</p>
            </div>
            <div class="item item3">
                <p class="p1">联系我们</p>
                <p class="p2">地址：东区</p>
                <p class="p2">qq:2453671898</p>
            </div>
            <div class="item item4">
                <img width="140" src="">
                <p>扫一扫加入官方QQ群</p>
            </div>
        </div>
    </div>
    <!-- 尾部开始 -->
</body>
</html>