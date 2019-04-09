package com.C2C.Service.Impl;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;
import com.C2C.Mapper.UserMapper;
import com.C2C.Service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper; 
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Integer checkUser(String email, String password) {
		Integer iduser = userMapper.checkUser(email, password);
		return iduser != null ? iduser : 0;
	}

	@Override
	public User getUserInfo(String email, String password) {
		User user = null;
		int idUser = checkUser(email, password);
		if(idUser != 0) {
			user = userMapper.getUserByIdUser(idUser);
		}
		return user;
	}

	@Override
	public Cookie newCookie(String email, String password) {
		Cookie cookie = new Cookie("autoLogin",email+"&"+password);
		cookie.setMaxAge(360000);
		cookie.setPath(" /login/index.jsp");
		return cookie;
	}

}
