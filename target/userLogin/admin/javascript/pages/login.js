$(function () {
    $('#entry').click(function () {
        if ($('#adminName').val() == '') {
            $('.mask,.dialog').show();
            $('.dialog .dialog-bd p').html('请输入管理员账号');
        } else if ($('#adminPwd').val() == '') {
            $('.mask,.dialog').show();
            $('.dialog .dialog-bd p').html('请输入管理员密码');
        } else {
            $('.mask,.dialog').hide();
            // location.href = 'index.jsp';
            var xhr = new XMLHttpRequest();
            // we defined the xhr
            xhr.onreadystatechange = function () {
                if (this.readyState !== 4) return;
                if (this.status === 200) {
                    var data = JSON.parse(this.responseText);
                    // we get the returned data
                }
                // end of state change: it can be after some time (async)
            };
            xhr.open('POST', "/userLogin/user/checkLogin?username=" + $('#adminName').val() + "&password=" + $('#adminPwd').val(), true);
            xhr.send();
        }
    });
});
