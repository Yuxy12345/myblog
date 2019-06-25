package com.yuxy.myblog.mapper;

import java.util.List;

import com.yuxy.myblog.domain.Setting;

/**
 * 设置DAO接口
 * @author Yuxy
 * @version 2019年5月27日 下午3:45:19
 *
 */
public interface SettingDAO {

	/**
	 * 获取所有设置
	 * 
	 * @return
	 */
	public List<Setting> getAllSettings();
	
	/**
	 * 寻找某设置项对应的值
	 * 
	 * @param Item
	 * @return
	 */
	public String findSetting(String Item);
	
	/**
	 * 添加设置
	 * 
	 * @param s
	 * @return
	 */
	public int addSetting(Setting s);
	
	/**
	 * 修改设置
	 * 
	 * @param s
	 * @return
	 */
	public int setSetting(Setting s);
}
