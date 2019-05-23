package com.yuxy.myblog.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理控制器
 * @author Yuxy
 * @version 2019年5月5日 下午3:28:58
 *
 */
@Controller
public class AdminController {
	
	/**
	 * 后台管理入口请求
	 * 
	 * @return
	 */
	@RequestMapping("/admin")
	public String admin() {
		return "admin/overview";
	}
}
