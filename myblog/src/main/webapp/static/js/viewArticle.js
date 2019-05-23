function submitCommentAjax(){
	var params = {};
	params.content = $("#content").innerText;
	params.articleID = $("#articleID").val();
    $.ajax({  
        type: "POST",  
        url: context + "submitComment", 
        data: params,
        dataType: "json",
        success: function(data) {  
            if(data.result == 1) {  
                alert("评论提交成功");  
                window.location.reload();
            } else if(data.result == -1) {
            	alert("您还没有登录或登录信息失效，请重新登录");
            	showLoginForm();
            }
        },  
        error: function(data) {  
            alert("服务器出错"); 
        }  
    });
}

var testEditor;
$(function() {
    testEditor = editormd.markdownToHTML("doc-content", {//注意：这里是上面DIV的id
        htmlDecode : "style,script,iframe",
        emoji : true,
        taskList : true,
        tex : true, // 默认不解析
        flowChart : true, // 默认不解析
        sequenceDiagram : true, // 默认不解析
        codeFold : true
    });
});