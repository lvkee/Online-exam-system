// 题目分页视图中分页组件对应
let toPage = function (p) {
    let contextPath = "http://localhost:8080/javaEE_SSM/admin/questions/show";
    $.ajax("http://localhost:8080/javaEE_SSM/admin/questions/page", {
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "id": null,
            "questionType": null,
            "level": null,
            "subjectId": null,
            "pageIndex": p,
            "pageSize": 3
        }),
        dataType: "text",
        success: function (result) {
            $("#questionFormJson").val(result);
            $("#questionForm").attr("action", contextPath).submit();
        },
        error: function (result) {
        }
    })
}

// 导航栏中的题目分页按钮对应
$(document).ready(function () {
    $('.a_questions').click(function (event) {
        let contextPath = this.href + "";
        //使 a 自带的方法失效，即无法跳转到href中的URL
        event.preventDefault();
        $.ajax(contextPath + "/admin/questions/page", {
            type: "POST",
            contentType: "application/json",
            //参数列表
            data: JSON.stringify({
                "id": null,
                "questionType": null,
                "level": null,
                "subjectId": null,
                "pageIndex": 1,
                "pageSize": 3
            }),
            dataType: "text",
            success: function (result) {
                $("#questionFormJson").val(result);
                $("#questionForm").attr("action", contextPath + "/admin/questions/show").submit();
            },
            error: function (result) {
            }
        })
    })
})
