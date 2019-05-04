window.onload = function () {
    var cateList = document.getElementsByClassName("main-cate-list-a");
    for(let i = 0; i < cateList.length; i++){
        cateList[i].onclick = changToAct(cateList[i]);
    }
}


function changToAct(This) {
    let cateList = document.getElementsByClassName("main-cate-list-a");
    cateList.classList.remove("act");
    This.classList.add("act");
}
