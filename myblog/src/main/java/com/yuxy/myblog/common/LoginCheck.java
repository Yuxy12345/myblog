package com.yuxy.myblog.common;

import javax.servlet.http.HttpSession;

public class LoginCheck {
	private HttpSession session;
	
	public LoginCheck(HttpSession session) {
		this.session = session;
	}
	
	public boolean isLogin() {
		return session.getAttribute("user") != null;
	}
}
