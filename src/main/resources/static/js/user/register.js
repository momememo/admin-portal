$(document).ready(function () {


});

function register() {
    alert(111);
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/user/add",//url
        data: $('#formUserRegister').serialize(),
        success: function (result) {
            console.log(JSON.stringify(result));
            if (result.success == true) {
                window.location.href="/index";
            } else {
                // var msg = result.message.errorMessage;
                var msg = "";
                if (result.model != null) {
                    var errors = result.model;
                    for (var i = 0; i < errors.length; i++) {
                        msg += errors[i].message + "\n";
                    }
                } else {
                    msg = result.message.errorMessage;
                }
                alert(msg);
            }
            ;
        },
        error: function (result) {
            console.log(JSON.stringify(result));
            alert("系统异常！");
        }
    });
}