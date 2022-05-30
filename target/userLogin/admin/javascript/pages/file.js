let upload = function (obj, contextPath) {
    console.log("obj : " + obj)
    if (obj != null && obj.files.length > 0) {
        console.log(obj.files.length);
        console.log(formData);
        fileUpload(formData, contextPath);
    } else {
        layer.msg('请先选择文件!', {icon: 2, time: 1000});
    }
}

//文件上传，call后台
function fileUpload(formData, contextPath) {
    console.log("contextPath : " + contextPath);
    $.ajax({
        url: contextPath + "/file/fileUtil/FileUpload",
        type: 'POST',
        cache: false,
        processData: false,
        contentType: false,
        enctype: "multipart/form-data",
        dataType: "json",
        data: formData,
        async: false,
        error: function (request) {
            layer.msg("上传失败，请重试");
        },
        success: function (data) {
            console.log(data);
            layer.msg("上传文件成功");
            file_show(contextPath, 1);
        }
    });
}

// 导航栏中的文件分页按钮对应
$(document).ready(function () {
    $('.a_files').click(function (e) {
        e.preventDefault();
        file_show(this.href, 1)
    })
})

function file_show(contextPath, pageIndex, fileName, fType) {
    this.contextPath = contextPath;
    $.ajax(contextPath + "/file/fileUtil/page", {
        type: "POST",
        contentType: "application/json",
        //参数列表
        data: JSON.stringify({
            "id": null,
            "fType": fType,
            "fileName": fileName,
            "pageIndex": pageIndex,
            "pageSize": 3
        }),
        dataType: "text",
        success: function (result) {
            $("#FormJson").val(result);
            $("#Form").attr("action", contextPath + "/file/fileUtil/show").submit();
        },
        error: function (result) {
        }
    })
}

// 删除文件 弹窗
function file_del(obj, id, contextPath) {
    layer.confirm('确认删除？（此操作不可逆）', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.get({
            url : "delete/" + id,
            success : function () {
                $(obj).parents("tr").remove();
                layer.msg('已删除!', {icon: 1, time: 1000});
                file_show(contextPath, 1);
            }
        });
    }, function () {
        console.log("no");
    });
}

