function getPositions() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "PositionServlet?method=getAllPositions", true);
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