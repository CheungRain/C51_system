
function fun1(){
    let targetUrl = '/login/check';
    $.ajax({
        url: targetUrl,
        data: {
            number:$("#number").val(),
            password:$("#password").val()
        },
        type: "POST",
        dataType: "text",
        success: function (data) {
            let obj=eval("("+data+")");
            if(obj.code==200){
                window.location.href="/index";
            }else{
                document.getElementById("msg").style.visibility = 'visible';
            }
        },
        error: function (data) {
        }
    });
}
