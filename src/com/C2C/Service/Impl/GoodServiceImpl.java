package com.C2C.Service.Impl;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Entity.Position;
import com.C2C.Entity.Store;
import com.C2C.Mapper.GoodMapper;
import com.C2C.Service.GoodService;

public class GoodServiceImpl implements GoodService {

	private GoodMapper goodMapper;

	public void setGoodMapper(GoodMapper goodMapper) {
		this.goodMapper = goodMapper;
	}
	
	/**
	 * ��һ���ַ�����ǰ���Լ�ÿ���ַ��ļ�������'%'���������ݿ����ģ������
	 * @param range ���޸ĵ��ַ���
	 * @return �����������ݿ�ģ�����ҵ��ַ���
	 */
	private String toFuzzyRange(String range) {
		StringBuilder fuzzyRange = new StringBuilder("%");
		char[] rangeArray = range.toCharArray();
		for(char c : rangeArray) {
			fuzzyRange.append(c);
			fuzzyRange.append('%');
		}
 		return fuzzyRange.toString();
	}

	@Override
	public Good getGoodByIdGoods(int idGoods) {
		return goodMapper.getGoodByIdGoods(idGoods);
	}

	@Override
	public List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException {
		range = toFuzzyRange(range);
		return goodMapper.getGoodsByPositionAndPage(positionName, range, 25*(page-1));
	}

}
