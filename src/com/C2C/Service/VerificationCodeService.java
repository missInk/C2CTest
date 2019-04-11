package com.C2C.Service;

public interface VerificationCodeService {

	/**
	 * �����������Ƿ���֮ǰ�ͷ��͹���֤��
	 * @param email ����������
	 * @return ���͹���true û�з��͹���false
	 */
	boolean checkEmail(String email);
	
	/**
	 * ���ĳ���������֤���Ƿ���ȷ
	 * @param email �����ַ
	 * @param ecode �û��������֤��
	 * @return ��֤����ȷ��true ��֤�����false
	 */
	boolean checkEcode(String email, String ecode);
	
	/**
	 * ����ĳ���������֤��
	 * @param email �����µ�����
	 * @param ecode �µ���֤��
	 * @return �ɹ���true ʧ�ܣ�false
	 */
	boolean updateEcode(String email, String ecode);
	
	/**
	 * ����ĳ���������֤��
	 * @param email �����ַ
	 * @param ecode ��֤��
	 * @return ����ɹ���true ����ʧ�ܣ�false
	 */
	boolean insertEcode(String email, String ecode);
	
	/**
	 * ����������֤�뵽ָ������
	 * @param email �����ַ
	 * @param ecode ��֤�������
	 */
	void sendEamil(String email, String ecode);
	
}
