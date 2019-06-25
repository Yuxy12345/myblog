/*
 * 初始化Editor.md
 */
$(function() {
	md_edit = editormd("blog_mdedit", { // 注意1：这里的就是上面的DIV的id属性值
		placeholder : '输入Markdown格式的内容',
		width : "90%",
		height : 400,
		syncScrolling : "single",
		emoji : true,
		path : "../static/editor.md-master/lib/", // 注意2：你的路径
		saveHTMLToTextarea : true,
		tocm : true, // Using [TOCM]
		tex : true, // 开启科学公式TeX语言支持，默认关闭
		flowChart : true, // 开启流程图支持，默认关闭
		/* 上传图片配置 */
		imageUpload : true,
		imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
		imageUploadURL : "../userRes", // 注意你后端的上传图片服务地址
	});
});

function preSubmit() {
	$("#formBlog")[0].reset();// 清空表单数据，避免上次数据干扰
	$("#blog_title").val($("#art-head").val());
	$("#blog_md").val(md_edit.getMarkdown());// md格式内容，使用md的js获取
}

/*
 * 上传文章
 */
$('.btn-blog-publish').click(function() {
	preSubmit();
	$.ajax({
		type: "POST",
		url: "submitArticle",
		data: {title: $("#blog_title").val(), content: $("#blog_md").val(), type: $("#typeSelect").val()},
		dataType: "json",
		success: function(data) {
			if(data.result == 1) {
				alert("上传成功，等待管理员审核！");
			}
		},
		error: function(data) {
			alert("上传失败！")
		}
	})
})

/*
 * 保存文章
 */
$('.btn-blog-save').click(function() {
	preSubmit();
	$.ajax({
		type: "POST",
		url: "addArticle",
		data: {title: $("#blog_title").val(), content: $("#blog_md").val(), type: $("#typeSelect").val()},
		dataType: "json",
		success: function(data) {
			if(data.result == 1) {
				alert("保存成功！");
			}
		},
		error: function(data) {
			alert("保存失败！")
		}
	})
});

$('.deleteArticle').click(function(id) {
	return confirm("确定要删除这篇文章吗？");
})