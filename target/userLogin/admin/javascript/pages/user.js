// 导航栏中的学生管理分页按钮对应
$(document).ready(function () {
    $('.a_users').click(function (e) {
        e.preventDefault();
        user_show(this.href, 1, null, 1);
    })
})

function user_show(contextPath, pageIndex, userName, role) {
    layer.load(1);
    $.ajax(contextPath + "/admin/user/page/list", {
        type: "POST",
        contentType: "application/json",
        //参数列表
        data: JSON.stringify({
            "userName": userName,
            "role": role,
            "pageIndex": pageIndex,
            "pageSize": 3
        }),
        dataType: "text",
        success: function (result) {
            $("#FormJson").val(result);
            $("#Form").attr("action", contextPath + "/admin/user/show").submit();
            console.log(result);
            layer.closeAll('loading');
        },
        error: function (result) {
            console.log(result);
            layer.closeAll('loading');
        }
    })
}