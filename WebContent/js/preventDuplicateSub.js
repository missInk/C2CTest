//防止表单重复提交
window.onload = function() {
	var sub = document.getElementsByClassName("submit")[0];
	sub.onclick = function() {
		this.disabled = true;
		document.getElementsByClassName("form")[0].submit();
	};
};
