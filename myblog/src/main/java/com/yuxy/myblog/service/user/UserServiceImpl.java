package com.yuxy.myblog.service.user;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuxy.myblog.domain.User;
import com.yuxy.myblog.mapper.UserDAO;

/**
 * 用户信息服务实现类
 * 
 * @author Yuxy
 * @version 2019年5月3日 下午2:29:47
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDAO ud;
	
	public User loginUser(String userName, String passWord) {
		return ud.findUser(userName, passWord);
	}

	public int addUser(String userName, String passWord, String email, String userType) {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassWord(passWord);
		user.setUserType(userType);
		return ud.addUser(user);
	}
	
	public int registReader(String userName, String passWord, String email) {
		return addUser(userName, passWord, email, "reader");
	}

	@Override
	public List<User> findAllUser() {
		List<User> l = ud.findAllUser();
		for(User u : l) {
			switch(u.getUserType()) {
			case "admin":
				u.setUserType("管理员");
				break;
			case "reader":
				u.setUserType("读者");
				break;
			}
		}
		return l;
	}

	@Override
	public int changeEmail(BigInteger userID, String email) {
		User user = new User();
		user.setUserID(userID);
		user.setEmail(email);
		return ud.updateEmail(user);
	}

}
