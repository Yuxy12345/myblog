package com.yuxy.myblog.service.type;

import java.util.List;

import com.yuxy.myblog.domain.Type;

/**
 * 文章类型服务接口
 * 
 * @author Yuxy
 * @version 2019年5月6日 下午7:23:20
 *
 */
public interface TypeService {
	
	/**
	 * 获取所有文章类型
	 * 
	 * @return 文章类型的List
	 */
	public List<Type> getAllTypes();
}
