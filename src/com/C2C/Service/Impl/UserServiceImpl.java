package com.C2C.Service.Impl;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;
import com.C2C.Mapper.UserMapper;
import com.C2C.Service.UserService;
import com.C2C.Util.MD5Util;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper; 
	private VerificationCodeServiceImpl codeService;
	
	public void setCodeService(VerificationCodeServiceImpl codeService) {
		this.codeService = codeService;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Integer checkUser(String email, String passWord) {
		Integer iduser = userMapper.checkUser(email, MD5Util.makeStringToMD5(passWord));
		return iduser != null ? iduser : 0;
	}

	@Override
	public User getUserInfo(String email, String passWord) {
		User user = null;
		int idUser = checkUser(email, passWord);
		if(idUser != 0) {
			user = userMapper.getUserByIdUser(idUser);
		}
		return user;
	}

	@Override
	public Cookie newCookie(String email, String passWord) {
		Cookie cookie = new Cookie("autoLogin",email+"&"+passWord);
		cookie.setMaxAge(360000);
		cookie.setPath(" /login/index.jsp");
		return cookie;
	}

	@Override
	public boolean checkEmailStyle(String email) {
		if(email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkPassword(String passWord, String repassWord) {
		if(passWord.equals(repassWord)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean regist(String email, String userName, String passWord, String ecode) {
		int result = 0;
		if(checkEmailStyle(email) && checkEmailRegist(email)) {
			if(codeService.checkEcode(email, ecode)) {
				result = userMapper.regist(email, userName, MD5Util.makeStringToMD5(passWord));
			}
		}
		return result == 1 ? true : false;
	}

	@Override
	public boolean checkEmailRegist(String email) {
		return userMapper.checkEmailRegist(email) == null ? true : false;
	}

	@Override
	public User getUserByAlipay(String alipay) {
		return userMapper.getUserByAlipay(alipay);
	}

	

}
