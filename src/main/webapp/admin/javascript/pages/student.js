// 添加学生 带遮罩
$('.JopenMaskPanel_addStudent').click(function () {
    $('.lt-title').text("添加学生");
    $('#label_id').hide();
    $("input[name='sId']").hide().prop('disabled', true);
    $("input[name='sName']").val(null);
    $("input[name='sNickname']").val(null);
    $("input[name='sPwd']").val(null);
    $("input[name='sEmail']").val(null);
    $("input[name='sBirth']").val(null);
    // 对应 JSP 中的表单
    document.form_student.action = "addStudent";
    $('.dialog,.mask').show();
    $('.dialog').css('box-shadow', 'none');
});

// 删除学生
function del_student (obj, id) {
    layer.confirm('确认删除？（此操作不可逆）', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        console.log("yes");
        console.log("id : " + id)
        $.get("deleteStudent/"+id);
        $(obj).parents("tr").remove();
        layer.msg('已删除!',{icon:1,time:1000});
    }, function () {
        console.log("no");
    });
}

// 编辑学生 带遮罩
$('.JopenMaskPanel_updateStudent').click(function () {
    let data = null;
    $('.lt-title').text("编辑学生");
    console.log("queryStudent?sId=" + $(this).attr("id"));

    /**
     * 1. 点击编辑后，先查询对应的学生，把查询到的结果填入表单中
     * 2. 再通过表单进行 updateStudent
     * @param method
     * @param url
     * @returns {Promise<unknown>}
     */
    function ajax(method, url) { // 返回一个Promise对象
        return new Promise(function (resolve) {
            var xmlhttp = new XMLHttpRequest() // 创建异步请求 // 异步请求状态发生改变时会执行这个函数
            xmlhttp.onreadystatechange = function () { // status == 200 用来判断当前HTTP请求完成
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    resolve(JSON.parse(xmlhttp.responseText))
                    data = JSON.parse(xmlhttp.responseText);
                    console.log(data);
                    $('#label_id').show();
                    $("input[name='sId']").show().prop('disabled', false).val(data.sId);
                    $("input[name='sName']").val(data.sName);
                    $("input[name='sNickname']").val(data.sNickname);
                    $("input[name='sPwd']").val(data.sPwd);
                    $("input[name='sEmail']").val(data.sEmail);
                    $("input[name='sBirth']").val(data.sBirth);
                    // 标记已完成
                }
            }
            xmlhttp.open(method, url) // 使用GET方法获取
            xmlhttp.send() // 发送异步请求
        })
    }

    ajax("GET", "queryStudent/" + $(this).attr("id"));
    document.form_student.action = "updateStudent";
    $('.dialog,.mask').show();
    $('.dialog').css('box-shadow', 'none');
});

$('.mask').click(function () {
    $(this).hide();
    $('.dialog').hide();
});
//自动关闭消息窗口
$('.Jmsg').click(function () {
    $('dialog').show().delay(5000).hide(0);
});