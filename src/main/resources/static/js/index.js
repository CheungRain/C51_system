
function fun() {
    let targetUrl='/index/send';
    //let obj = "+IPD+"+($("#tem_top").text()).toString()+"+"+($("#hum_top").text()).toString();
    console.log("请求地址是：" + targetUrl)
    $.ajax({
        url: targetUrl,
        data:
        {
            tem_top:$("#tem_top").text(),
            hum_top:$("#hum_top").text()
        },
        type: "GET",
        dataType: "text",
        success: function (data) {
            //alert(11);
            let ajaxobj=eval("("+data+")");
            $("#tem").text(ajaxobj.tem);
            $("#hum").text(ajaxobj.hum);
            let x = $("#tem_top").text();
            let y = $("#hum_top").text();
            //let audio = new Audio('../music/music.wav');
            let audio = new Audio('../music/bee.mp3');
            if(ajaxobj.tem>x){
                //alert("温度超过阈值!");
                $("#tem").css("color","#ff0051");
                audio.play();
            }else{
                $("#tem").css("color","rgb(0,0,0)");
            }
            if(ajaxobj.hum>y){
                //alert("湿度超过阈值!");
                $("#hum").css("color","#ff0051");
                audio.play();
            }else{
                $("#hum").css("color","rgb(0,0,0)");
            }
            fun();
            },
        error: function (data) {
            // alert(data.status);
            // alert(data.readyState);
            // alert(data.responseText);
            console.log('ajax失败',data)
            fun();
        }
    });
};


$("#b1").click(
    function () {
        let x = $("#in1").val();
        $("#tem_top").text(x);
        let y = document.getElementById("tem").value;
        let z = $("#tem_top").text();
        if($("#tem").text()>z){
            //alert("温度超过阈值!");
            $("#tem").css("color","#ff0051");
        }else{
            $("#tem").css("color","#000000");
        }
})

$("#b2").click(
    function () {
    let x = $("#in2").val();
    $("#hum_top").text(x);
    let z = $("#hum_top").text();
    if($("#hum").text()>z){
        //alert("温度超过阈值!");
        $("#hum").css("color","#ff0051");
    }else{
        $("#hum").css("color","#000000");
    }
})

window.onload = function (){
    fun();
    setInterval(function() {
        let now = (new Date()).toLocaleString();
        $('#time').text(now);
    }, 1000);
};
