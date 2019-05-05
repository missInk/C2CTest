package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;

public interface GoodMapper {

	/**
	 * ͨ����Ʒ��ID�������Ʒ��ʵ����Ϣ
	 * @param idGoods ��Ʒ��ID
	 * @return ��Ʒ��ʵ��
	 */
	Good getGoodByIdGoods(int idGoods);
	
	/**
	 * ͨ��λ����Ϣ�͵�ǰ��ҳ��������һ����Ʒ����
	 * @param positionName λ����Ϣ��һ���֣���������
	 * @param range λ����Ϣ��һ���֣���ϸλ�ã�
	 * @param star ��ѯ����ʼλ��
	 * @param size ���β�ѯ�ĸ���
	 * @return һ����Ʒ����
	 */
	List<Good> getGoodsByPositionAndPage(@Param("positionName")String positionName, @Param("range")String range, @Param("category")String category, @Param("star")int star, @Param("size")int size);

	/**
	 * ����һ����Ʒ
	 * @param sellMen ���������Ʒ���û���id
	 * @param good ����������Ʒ��ʵ����Ϣ
	 * @return 1�������ɹ�  0������ʧ��
	 */
	int issueGood(@Param("sellMen")int sellMen, @Param("good")Good good);
	
	/**
	 * ������Ʒ�ĵص㣬��Χ����Ʒ��������Ʒ������
	 * @param positionName ��Ʒ�ص�
	 * @param range ��Χ
	 * @param category ��Ʒ����
	 * @return ���ϸ���������Ʒ����
	 */
	int getGoodCount(@Param("positionName")String positionName, @Param("range")String range, @Param("category")String category);
	
}
