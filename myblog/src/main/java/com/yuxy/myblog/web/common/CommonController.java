package com.yuxy.myblog.web.common;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yuxy.myblog.domain.Setting;
import com.yuxy.myblog.service.setting.SettingService;

@SessionAttributes(value = { "siteName", "welcomeWord" })
public class CommonController {

	@Autowired
	private SettingService ss;

	public void setSiteName(HttpSession session) {
		List<Setting> settings = ss.getAllSettings();
		for (Setting s : settings) {
			switch (s.getItem()) {
			case "siteName":
			case "welcomeWord":
				session.setAttribute(s.getItem(), s.getValue());
				break;
			}
		}
	}
}
