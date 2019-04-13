package com.C2C.Service.Impl;

import com.C2C.Mapper.VerificationCodeMapper;
import com.C2C.Service.VerificationCodeService;
import com.C2C.Util.EmailUtil;

public class VerificationCodeServiceImpl implements VerificationCodeService {

	private VerificationCodeMapper verificationCodeMapper;
	
	public void setVerificationCodeMapper(VerificationCodeMapper verificationCodeMapper) {
		this.verificationCodeMapper = verificationCodeMapper;
	}

	@Override
	public boolean checkEmail(String email) {
		return verificationCodeMapper.checkEmail(email) == null ? false : true;
	}

	@Override
	public boolean updateEcode(String email, String ecode) {
		return verificationCodeMapper.updateEcode(email, ecode);
	}

	@Override
	public boolean insertEcode(String email, String ecode) {
		return verificationCodeMapper.insertEcode(email, ecode);
	}

	@Override
	public void sendEamil(String email, String ecode) {
		String message = "ÄãµÄ×¬×¬¼¤»îÂëÊÇ£º" + ecode;
		String subject = "×¬×¬¼¤»îÂë";
		new Thread(new EmailUtil(email, message, subject)).start();
	}

	@Override
	public boolean checkEcode(String email, String ecode) {
		return verificationCodeMapper.checkEcode(email, ecode) == null ? false : true;
	}

}
