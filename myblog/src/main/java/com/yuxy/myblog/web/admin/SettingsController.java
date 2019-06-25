package com.yuxy.myblog.web.admin;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.service.setting.SettingService;
import com.yuxy.myblog.service.user.UserService;
import com.yuxy.myblog.web.common.CommonController;

@Controller
public class SettingsController extends CommonController {

	@Autowired
	SettingService ss;
	
	@Autowired
	UserService us;

	@RequestMapping("/admin/settings")
	public String Settings() {
		return "admin/settings";
	}

	@RequestMapping(value = "/admin/changeEmail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changeEmail(HttpSession session, @RequestParam("email") String email) {
		Map<String, Object> m = new HashMap<>();
		BigInteger userID = ((User) session.getAttribute("user")).getUserID();
		m.put("result", us.changeEmail(userID, email));
		return m;
	}
	
	@RequestMapping(value = "/admin/changeSiteSettings", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changeSetting(HttpSession session, @RequestParam("siteName") String siteName, @RequestParam("welcomeWord") String welcomeWord) {
		Map<String, Object> m = new HashMap<>();
		m.put("result", 0);
		if(siteName != null || siteName != "") {
			m.put("result", ss.setSetting("siteName", siteName));
		}
		if(welcomeWord != null || welcomeWord != "") {
			m.put("welcomeWord", ss.setSetting("welcomeWord", welcomeWord));
		}
		return m;
	}
}