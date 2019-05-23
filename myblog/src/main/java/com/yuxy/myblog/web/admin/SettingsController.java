package com.yuxy.myblog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingsController {
	
	@RequestMapping("/admin/settings")
	public String Settings() {
		return "admin/settings";
	}
}
