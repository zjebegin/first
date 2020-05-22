$(document).ready(function(){
    $.ajax({
        url: '/menus',
        type: 'GET',
        dataType: 'json',
        timeout: 1000,
        cache: false,
        error: errorFunction,  //错误执行方法
        success: successFunction //成功执行方法
    })

});
function successFunction(result){
    $.each(result, function(i, field){
        var jsonArr = eval(result); //数组
        console.log(jsonArr[i].menuName+"   "+jsonArr[i].menuName);
        var menu='<li><a href="#" onclick="getUrl(\''+jsonArr[i].menuUrl+'\',\''+jsonArr[i].menuName+'\')"><span class="menu-text">'+jsonArr[i].menuName+'</span></a></li>';
        $("ul").append(menu);
    });

}
function errorFunction(result){
    console.log(result.toString());
}
function getUrl(url, name) {
    console.log("我点击了" + name)
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        timeout: 1000,
        cache: false,
        error: errorFunction,  //错误执行方法
        success: successMainPage //成功执行方法
    })

    //var main = document.getElementById('main');
    //main.innerHTML = "<iframe border='none' style='border:0; padding:15px' scrolling='no' width='100%' height='100%' src='" + url + "'></iframe>";
}
function successMainPage(result) {
    console.log("in main");
    $.each(result, function(i, field){
        var jsonArr = eval(result); //数组
        //设置标题
        if(i==0){
            for(var key in jsonArr[i]) {
                console.log(key);
                $("#infoTitle").append("<th>"+key+"</th>");
            }
        }
        //设置内容
        var content="<tr>";
        for(var key in jsonArr[i]) {
            console.log(jsonArr[i][key]);
            content+="<th>"+jsonArr[i][key]+"</th>";
        }
        content+="</tr>";
        $("#infoContent").append(content);
        console.log("out main");
    });

}