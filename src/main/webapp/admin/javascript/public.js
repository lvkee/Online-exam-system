
$(function(){
	'use strict';
	//左侧导航菜单效果
	$('.side-menu li dt').click(function(){
		$(this).parents('li').addClass('open');
		$(this).parents('.side-menu').find('.InitialPage').removeClass('active');
		$(this).parents('li').siblings().removeClass('open');
		
	});
	$('.side-menu dd a').click(function(){
		$(this).parents('li').addClass('open');
		$(this).parents('li').siblings().removeClass('open')
	});
	$('.side-menu li').each(function(){
		//判断链接相当（当前页面导航样式）
		if($(this).find('a').attr('href') == window.location.pathname){
			$(this).addClass('open');
			$(this).siblings().find('.InitialPage').removeClass('active');
			$('.InitialPage').removeClass('active');
		}else if($('.side-menu h2 a').attr('href') == window.location.pathname){
			$('.InitialPage').addClass('active');
		}   
	});
    //Tab选项卡.
    $('.tab-nav li').click(function(){
    	var liIndex = $('.tab-nav li').index(this);
    	$(this).addClass('active').siblings().removeClass('active');
    	$('.tab-cont').eq(liIndex).fadeIn().siblings('.tab-cont').hide();
    });
    //Button下拉菜单
    $('.btn-drop-group .btn').click(function(e){
    	$(this).siblings('.drop-list').show();
    	$(this).parent().siblings().find('.drop-list').hide();
    	$(document).one('click', function(){
	        $('.btn-drop-group .drop-list').hide();
	    });
	    e.stopPropagation();
    });
    	//点击list将当前值复制于button
	    $('.btn-drop-group .drop-list li').click(function(){
	    	$(this).parent().parent().hide();
	    });
	//左侧菜单收缩
	$('.top-hd .hd-lt').click(function(){
		$('.side-nav').toggleClass('hide');
		$('.top-hd,.main-cont,.btm-ft').toggleClass('switchMenu');
		$('.top-hd .hd-lt a').toggleClass('icon-exchange');
		localStorage.setItem('setLayOut1','hide');
		localStorage.setItem('setLayOut2','switchMenu');
		localStorage.setItem('setLayOut3','icon-exchange');
		if(!$('.side-nav').hasClass('hide')){
			localStorage.removeItem('setLayOut1');
			localStorage.removeItem('setLayOut2');
			localStorage.removeItem('setLayOut3');
		}
	});
	$('.side-nav').addClass(localStorage.getItem('setLayOut1'));
	$('.top-hd,.main-cont,.btm-ft').addClass(localStorage.getItem('setLayOut2'));
	$('.top-hd .hd-lt a').addClass(localStorage.getItem('setLayOut3'));
	

	//弹出层基础效果（确认/取消/关闭）
	$('.JyesBtn').click(function(){
		$(this).parents('.dialog').hide();
		if($('.mask').attr('display','block')){
			$('.mask').hide();
		}
	});
	$('.JnoBtn,.JclosePanel').click(function(){
		$(this).parents('.dialog').hide();
		if($('.mask').attr('display','block')){
			$('.mask').hide();
		}
	});
	//基础弹出窗
	$('.JopenPanel').click(function(){
		$('.dialog').show();
		$('.dialog').css('box-shadow','0 0 30px #d2d2d2');
	});
	// 添加学生 带遮罩
	$('.JopenMaskPanel_addStudent').click(function(){
		$('.lt-title').text("添加学生");
		$('#label_id').hide();
		$("input[name='sId']").hide().prop('disabled', true);
		$("input[name='sName']").val(null);
		$("input[name='sNickname']").val(null);
		$("input[name='sPwd']").val(null);
		$("input[name='sEmail']").val(null);
		$("input[name='sBirth']").val(null);
		document.form_student.action = "addStudent";
		$('.dialog,.mask').show();
		$('.dialog').css('box-shadow','none');
	});

	// 删除学生 弹窗
	$('.a_delete').click(function(){
		layer.confirm('确认删除？（此操作不可逆）', {
			btn: ['确定','取消'] //按钮
		}, function(){
			console.log("yes");
			var str = "deleteStudent?sId=" + $('.JopenMaskPanel_updateStudent').attr("id");
			window.location.href = str;
		}, function(){
			console.log("no");
		});
	});

	// 编辑学生 带遮罩
	$('.JopenMaskPanel_updateStudent').click(function(){
		let data = null;
		$('.lt-title').text("编辑学生");
		console.log("queryStudent?sId=" + $(this).attr("id"));
		// document.form_student.action = "queryStudent?sId=" + $('#s_id');
		function ajax ( method,url ) { // 返回一个Promise对象
			return new Promise(function (resolve) {
				var xmlhttp = new XMLHttpRequest() // 创建异步请求 // 异步请求状态发生改变时会执行这个函数
				xmlhttp.onreadystatechange = function () { // status == 200 用来判断当前HTTP请求完成
					if ( xmlhttp.readyState == 4 && xmlhttp.status == 200 ) {
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
					} }
				xmlhttp.open(method,url) // 使用GET方法获取
				xmlhttp.send() // 发送异步请求
			})
		}
		ajax("GET", "queryStudent?sId=" + $(this).attr("id"));
		document.form_student.action = "updateStudent";
		$('.dialog,.mask').show();
		$('.dialog').css('box-shadow','none');
	});

	$('.mask').click(function(){
		$(this).hide();
		$('.dialog').hide();
	});
	//自动关闭消息窗口
	$('.Jmsg').click(function(){
		$('dialog').show().delay(5000).hide(0);
	});	
	//安全退出
	$('#JsSignOut').click(function(){
		layer.confirm('确定登出管理中心？', {
		  title:'系统提示',
		  btn: ['确定','取消']
		}, function(){
		  location.href = 'java/teacherLogin';
		});
	});
});

//捐赠
function reciprocate(){
	layer.open({
	  type: 1,
	  skin: 'layui-layer-demo',
	  closeBtn:1,
	  anim: 2,
	  shadeClose: false,
	  title:'喝杯咖啡O(∩_∩)O',
	  content: '<div class="pl-20 pr-20">'
		  +'<table class="table table-bordered table-striped mt-10">'
		  	+'<tr>'
		  		+'<td><img src="images/wechat_qrcode.jpg" style="width:auto;max-width:100%;height:120px;"/></td>'
		  		+'<td><img src="images/alipay_qrcode.jpg" style="width:auto;max-width:100%;height:120px;"/></td>'
		  	+'</tr>'
		  	+'<tr class="cen">'
		  		+'<td class="text-primary">微信打赏</td>'
		  		+'<td class="text-primary">支付宝打赏</td>'
		  	+'</tr>'
		  +'</table>'
	  +'</div>'
	});
}
