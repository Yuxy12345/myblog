package com.yuxy.myblog.web.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.service.user.UserService;

@Controller
public class UserManageController {
	
	@Autowired
	UserService us;
	
	@RequestMapping("/admin/user")
	public String userManage(HttpServletRequest request) {
		List<User> user = us.findAllUser();
		request.setAttribute("user", user);
		return "admin/userManage";
	}
}
