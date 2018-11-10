$(document).ready(function () {

});

function login() {
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/login",//url
        data: $('#formLogin').serialize(),
        success: function (result) {
            console.log(JSON.stringify(result));
            if (result.success == true) {
                var user = result.model;
                alert(user.username);
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
        error: function () {
            alert("系统异常！");
        }
    });
}