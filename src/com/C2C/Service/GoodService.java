package com.C2C.Service;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;

public interface GoodService {

	/**
	 * ͨ���̼ҷ�Χ����Ʒ���࣬��Ʒ���࣬ѡ���ҳ��λ�ã�ѡ���ҳ��λ����������Ʒ�б�
	 * @param idposition �̵��������е�id
	 * @param range �̼ҷ�Χ
	 * @param category ��Ʒ����
	 * @param minPrice ��Ʒ����ͼ۸�
	 * @param maxPrice ��Ʒ����߼۸�
	 * @param page ѡ���ҳ��λ��
	 * @param size ����ҳ����ʾ��Ʒ������
	 * @return ��Ʒ�б�
	 * @throws IOException 
	 */
	List<Good> getGoodsByStore(int idposition, String range, String category, double minPrice, double maxPrice, int page, int size) throws IOException;
	
	/**
	 * ͨ����Ʒ��ID�������Ʒ��ʵ����Ϣ
	 * @param idGoods ��Ʒ��ID
	 * @return ��Ʒ��ʵ��
	 */
	Good getGoodByIdGoods(int idGoods);
}
