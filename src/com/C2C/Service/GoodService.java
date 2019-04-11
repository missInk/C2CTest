package com.C2C.Service;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;

public interface GoodService {

	/**
	 * ͨ��λ����Ϣ�͵�ǰ��ҳ��������һ����Ʒ����
	 * @param positionName λ����Ϣ��һ���֣���������
	 * @param range λ����Ϣ��һ���֣���ϸλ�ã�
	 * @param page ��ǰҳ��
	 * @return һ����Ʒ����
	 */
	List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException;
	
	/**
	 * ͨ����Ʒ��ID�������Ʒ��ʵ����Ϣ
	 * @param idGoods ��Ʒ��ID
	 * @return ��Ʒ��ʵ��
	 */
	Good getGoodByIdGoods(int idGoods);
	
	/**
	 * �ϴ�һ����Ʒ
	 * @param idUser �ϴ��˵�id�����
	 * @param goodName ��Ʒ�����֣����
	 * @param price ��Ʒ�ļ۸񣨱��
	 * @param goodPhoto ��Ʒ��ͼƬ
	 * @param goodIntroduce ��Ʒ������
	 * @param category ��Ʒ�����ࣨ���
	 * @return �ɹ���true ʧ�ܣ�false
	 */
	boolean issueGood(int idUser, String goodName, String price, String goodPhoto, String goodIntroduce, String category);
	
}
