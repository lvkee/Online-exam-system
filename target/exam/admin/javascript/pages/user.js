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

function user_window() {
    $('.lt-title').text("添加用户");
    $('#label_id').hide();
    $("input[name='userName']").val(null);
    $("input[name='password']").val(null);
    $("input[name='realName']").val(null);
    $("#select_sex").val(null);
    $("input[name='birthDay']").val(null);
    $("input[name='phone']").val(null);
    $("#select_level").val(null);
    $('.dialog,.mask').show();
    $('.dialog').css('box-shadow', 'none');
}

function userAdd(contextPath, userName, password, realName, sex, birthDay, phone, userLevel, role) {
    console.log()
    layer.load(1);
    $.ajax(contextPath + "/admin/user/add", {
        type: "POST",
        contentType: "application/json",
        //参数列表
        data: JSON.stringify({
            "userName": userName,
            "password": password,
            "realName": realName,
            "sex": sex,
            "birthDay": birthDay,
            "phone": phone,
            "userLevel": userLevel,
            "role": role
        }),
        dataType: "text",
        success: function (result) {
            console.log(result);
            layer.closeAll('loading');
            layer.msg("添加成功");
            user_show(contextPath, 1);
        },
        error: function (result) {
            console.log(result);
            layer.closeAll('loading');
            layer.msg("添加失败,请检查后重试");
        }
    })
}