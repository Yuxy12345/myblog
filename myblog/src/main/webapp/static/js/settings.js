/**
 * 
 */
$("#changeEmailButton").click(function() {
	$.ajax({
		type: "post",
		url: context + "admin/changeEmail", 
		data: { email: $("#changeEmail").val() },
        dataType: "json",
        success: function(data) {  
            if(data.result == 1) {  
                alert("修改成功");
            } else {
                alert("修改失败");
            }
        },  
        error: function(data) {  
            alert("服务器出错"); 
        } 
	})
})

$("#changeSiteSettings").click(function() {
	$.ajax({
		type: "post",
		url: context + "admin/changeSiteSettings", 
		data: { siteName: $("#siteName").val(), welcomeWord: $("#welcomeWord").val() },
        dataType: "json",
        success: function(data) {  
            if(data.result == 1) {  
                alert("修改成功");
            } else {
                alert("修改失败");
            }
        },
        error: function(data) {  
            alert("服务器出错"); 
        } 
	})
})