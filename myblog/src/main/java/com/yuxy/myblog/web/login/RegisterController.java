package com.yuxy.myblog.web.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuxy.myblog.service.user.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService us;
	
	@RequestMapping(value = "/userRegist", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> register(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, 
			@RequestParam("email") String email) {
		Map<String, Object> m = new HashMap<String, Object>();
		if(us.registReader(userName, passWord, email) == 1) {
			m.put("result", 1);
		} else {
			m.put("result", 0);
		}
		return m;
	}
}
