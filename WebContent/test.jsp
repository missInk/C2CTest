<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="javaScript:void(0);" onclick="getPositions()">测试显示地点</a>
<div id="position_div"></div>

<script type="text/javascript">
	function getPositions() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "${pageContext.request.contextPath }/PositionServlet?method=getAllPositions", true);
		xhttp.send();
		xhttp.onreadystatechange = function(){
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(xhttp.responseText);
			    var arrJson = jsonToArray(json);
			    innerToHtml(arrJson);
		    }
		};
	}
	function jsonToArray(obj){
	    var r = {key:[],value:[]};
	    for(var k in obj){
	        if(!obj.hasOwnProperty(k)){
	            continue;
	        }
	        r.key.push(k);
	        r.value.push(obj[k]);
	    }
	    return r;
	}
	function innerToHtml(arrJson){
		var str = "";
		for(let i = 0; i < arrJson.key.length; i++){
			str += "<dl><dt>"+arrJson.key[i]+"</dt>"
			for(let j = 0; j < arrJson.value[i].length; j++){
				str += "<dd>"+arrJson.value[i][j]+"</dd>";
			}
			str+="</dl>";
		}
	    document.getElementById("position_div").innerHTML = str;
	}
</script>

</body>
</html>