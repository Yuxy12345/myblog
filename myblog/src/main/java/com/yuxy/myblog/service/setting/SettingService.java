package com.yuxy.myblog.service.setting;

import java.util.List;

import com.yuxy.myblog.domain.Setting;

public interface SettingService {
	/**
	 * 获取所有设置
	 * 
	 * @return
	 */
	public List<Setting> getAllSettings();
	
	/**
	 * 添加设置
	 * 
	 * @param s
	 * @return
	 */
	public int addSetting(String item, String value);
	
	/**
	 * 修改设置
	 * 
	 * @param s
	 * @return
	 */
	public int setSetting(String item, String value);
}
