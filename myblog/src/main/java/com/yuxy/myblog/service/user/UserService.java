package com.yuxy.myblog.service.user;

import java.util.List;

import com.yuxy.myblog.domain.User;

/**
 * 用户信息服务接口
 * @author Yuxy
 * @version 2019年5月3日 下午2:29:01
 *
 */
public interface UserService {
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param passWord 密码
	 * @return 匹配则返回用户信息，不匹配返回null
	 */
	public User loginUser(String userName, String passWord);
	
	/**
	 * 注册读者用户
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param email 邮箱
	 * @return 1成功，0失败
	 */
	public int registReader(String userName, String passWord, String email);

	/**
	 * 添加用户通用方法，可由其他添加具体类型用户的方法调用
	 * 
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param email 邮箱
	 * @param userType 用户类型
	 * @return 1成功，0失败
	 */
	public int addUser(String userName, String passWord, String email, String userType);
	
	public List<User> findAllUser();
}
