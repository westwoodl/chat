//获取消息
function receive(){
    $.ajax({
        type:"post",
        url:"receive",
        dataType : "json",
        success:function(result){
            showAllMsg(result);
        },
        error:function(){
            alert("服务器异常，稍后重试！");
        }
    });
}
function showAllMsg(result){
    console.log(result);
    $("#msg_div").empty();
    for (var n=0;n<result.length;n++) {
        if (result[n].who==getCookie("user")) {
            var a = '<div class="self" id="border" style="width: 54px;left: 836px;">';
            var content = result[n].msg;



            var b = '</div>';
            var s_px = content.length*17+14;

            $("#msg_div").append(a+content+b);
            $("div#border:last").attr("style","width:"+s_px+"px")

        }else{
            var a = '<div class="other" id="border" style="width: 54px;left: 836px;">';
            var content = result[n].msg;


            var b = '</div>';
            var s_px = content.length*17+14;

            $("#msg_div").append(a+content+b);
            $("div#border:last").attr("style","width:"+s_px+"px")
        }
    }
    $("div#border:last").after('<div style="width: 100%;height:150px;border: hidden; "></div>');
    /*滚底*/
    var h = $(document).height()-$(window).height();
    $(document).scrollTop(h);
    //选中
    $("#input").focus();
}



//发送消息
function send() {
    var content = $("#input").val();
    if(content==""){
        return 0;
    }
    $.ajax({
        type:"post",
        url:"send",
        data:{
            "msg":$("#input").val(),
            "user":getCookie("user")
        },
        dataType : "json",
        success:function(result){
            console.log(result);
            addMsg();
        },
        error:function(){
            alert("服务器异常，稍后重试！");
        }
    });
}
//显示输入的消息
function addMsg(){
    var a = '<div class="self" id="border" style="width: 54px;left: 836px;">';
    var content = $("#input").val();
    //选中
    $("#input").val("");
    $("#input").focus();

    var b = '</div>';
    var s_px = content.length*17+14;
    if(content==""){
        return 0;
    }
    $("#msg_div").append(a+content+b);
    $("div#border:last").attr("style","width:"+s_px+"px");
    /*滚底*/
    var h = $(document).height()-$(window).height();
    $(document).scrollTop(h);
}