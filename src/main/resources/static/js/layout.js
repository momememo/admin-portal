$(document).ready(function () {

});

function logout() {
    $.ajax({
        //几个参数需要注意一下
        type: "GET",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/logout",//url
        success: function (result) {
            console.log(JSON.stringify(result));
            if (result.success == true) {
            } else {
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
            window.location.href="/";
        },
        error: function () {
            alert("系统异常！");
        }
    });
}