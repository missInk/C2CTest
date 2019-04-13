package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

public interface VerificationCodeMapper {

	/**
	 * ����ĳ���������֤��
	 * @param email �����ַ
	 * @param ecode ��֤��
	 * @return ����ɹ���true ����ʧ�ܣ�false
	 */
	boolean insertEcode(@Param("email")String email, @Param("ecode")String ecode);
	
	/**
	 * ���ĳ���������֤���Ƿ���ȷ
	 * @param email �����ַ
	 * @param ecode �û��������֤��
	 * @return ��֤����ȷ�������ַ  ��֤�����null
	 */
	String checkEcode(@Param("email")String email, @Param("ecode")String ecode);
	
	/**
	 * �����������Ƿ���֮ǰ�ͷ��͹���֤��
	 * @param email ����������
	 * @return ���͹���email û�з��͹���null
	 */
	String checkEmail(String email);
	
	/**
	 * ����ĳ���������֤��
	 * @param email �����µ�����
	 * @param ecode �µ���֤��
	 * @return �ɹ���true ʧ�ܣ�false
	 */
	boolean updateEcode(@Param("email")String email, @Param("ecode")String ecode);
}
