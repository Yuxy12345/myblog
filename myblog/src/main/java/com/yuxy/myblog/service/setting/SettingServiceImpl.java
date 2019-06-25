package com.yuxy.myblog.service.setting;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuxy.myblog.domain.Setting;
import com.yuxy.myblog.mapper.SettingDAO;

@Service
public class SettingServiceImpl implements SettingService {

	@Resource
	SettingDAO sd;
	
	@Override
	public List<Setting> getAllSettings() {
		return sd.getAllSettings();
	}

	@Override
	public int addSetting(String item, String value) {
		Setting s = new Setting(item, value);
		return sd.addSetting(s);
	}

	@Override
	public int setSetting(String item, String value) {
		int res = 0;
		Setting s = new Setting(item, value);
		if(sd.findSetting(item) == null) {
			res = sd.addSetting(s);
			
		} else {
			res = sd.setSetting(s);
		}
		return res;
	}

}
