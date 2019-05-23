package com.yuxy.myblog.web.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.service.user.UserService;

/**
 * 登录控制器
 * 
 * @author Yuxy
 * @version 2019年5月5日 下午3:29:35
 *
 */
@Controller
@SessionAttributes(value = "user")
public class LoginController {
	
	@Autowired
	UserService us;
	/**
	 * 处理登录请求
	 * 
	 * @param model session里的资料
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 1成功，0失败
	 */
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(Model model, @RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
		User user = us.loginUser(userName, passWord);
		Map<String, Object> m = new HashMap<String, Object>();
		if(user != null) {
			m.put("result", 1);
			model.addAttribute("user", user);
		} else {
			m.put("result", 0);
		}
		return m;
	}
	
	/**
	 * 处理退出登录请求
	 * 
	 * @param session 服务器session
	 * @return 1成功
	 */
	@RequestMapping(value = "/userlogout", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> logout(HttpSession session) {
		session.invalidate();
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("result", 1);
		return m;
	}
}
