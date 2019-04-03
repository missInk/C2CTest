package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;

public interface GoodMapper {

	/**
	 * ͨ����Ʒ�����̵����Ϣ�Լ�ҳ���λ�ú�ÿһҳչʾ����Ʒ��Ŀ������һ����Ʒ�б�
	 * 
	 * @param store
	 *            ��Ʒ�����̵�
	 * @param page
	 *            ��ѯ��ҳ��
	 * @param size
	 *            ҳ��չʾ��Ʒ����Ŀ
	 * @return һ����Ʒ����
	 */
	List<Good> getGoodsByStore(@Param("good")Good good, @Param("page")int page, @Param("size")int size);

	/**
	 * ͨ����Ʒ��ID�������Ʒ��ʵ����Ϣ
	 * @param idGoods ��Ʒ��ID
	 * @return ��Ʒ��ʵ��
	 */
	Good getGoodByIdGoods(int idGoods);
	
}
