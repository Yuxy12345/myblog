/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: #
 * 
 */
function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('注册');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        
        $('.modal-title').html('登录');
    });       
     $('.error').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}

function loginAjax(){
	var params = {};
	params.userName = $('#userName').val();
	params.passWord = $('#passWord').val();
    $.ajax({  
        type: "POST",  
        url: context + "userlogin", 
        data: params,
        dataType: "json",
        success: function(data) {  
            if(data.result == 1) {  
                alert("登录成功");  
                window.location.reload();
            } else {
            	shakeModal();
            }
        },  
        error: function(data) {  
            alert("服务器出错"); 
            
        }  
    });
}

function logoutAjax(){
	if (confirm("确定要退出吗？")) {
		var params = {};
		params._method = "DELETE";
	    $.ajax({  
	        type: "POST",  
	        url: context + "userlogout", 
	        data: params,
	        dataType: "json",
	        success: function(data) {  
	            if(data.result == 1) {  
	                window.location.replace(context + "home");
	            }
	        },  
	        error:function(data) {  
	            alert("服务器出错");
	        }  
	    });
	}
}

function regist() {
	var params = {};
	params.userName = $('#userName-reg').val();
	params.passWord = $('#passWord-reg').val();
	params.email = $('#email').val();
    $.ajax({  
        type: "POST",  
        url: context + "userRegist", 
        data: params,
        dataType: "json",
        success: function(data) {  
            if(data.result == 1) {  
                alert("注册成功");  
                showLoginForm();
            } else {
            	alert("服务器出错");
            }
        },  
        error:function(data) {  
            alert("服务器出错"); 
        }  
    });
}

function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.error').addClass('alert alert-danger').html("用户名或密码错误");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}

   