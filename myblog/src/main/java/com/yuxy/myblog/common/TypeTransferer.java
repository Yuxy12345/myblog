package com.yuxy.myblog.common;

public class TypeTransferer {
	
	public String toChinese(String status) {
		switch(status) {
		case "edit":
			return "草稿";
		case "publish":
			return "已发布";
		case "check":
			return "待审核";
		default:
			return status;
		}
	}
}
