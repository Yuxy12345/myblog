package com.yuxy.myblog.mapper;

import java.util.List;

import com.yuxy.myblog.domain.User;

/**
 * 用户DAO接口
 * 
 * @author Yuxy
 * @version 2019年5月3日 下午2:03:46
 *
 */
public interface UserDAO {
	
	/**
	 * 用户登录查询
	 * @param userName 输入的用户名
	 * @param passWord 输入的密码
	 * @return 匹配则返回用户信息，不匹配返回null
	 */
	public User findUser(String userName, String passWord);
	
	/**
	 * 添加用户
	 * @param userName 用户名
	 * @param email 邮箱
	 * @param passWord 密码
	 * @param userType 用户类型
	 * @return 1成功，0失败
	 */
	public int addUser(User user);
	
	/**
	 * 查询所有用户
	 * 
	 * @return 用户列表
	 */
	public List<User> findAllUser();
}
