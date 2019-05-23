package com.yuxy.myblog.mapper;

import java.util.List;

import com.yuxy.myblog.domain.Type;

/**
 * 文章类型DAO接口
 * 
 * @author Yuxy
 * @version 2019年5月6日 下午6:32:08
 *
 */
public interface TypeDAO {
	
	/**
	 * 查询所有类型
	 * 
	 * @return 类型的List
	 */
	public List<Type> getAllTypes();
	
}
