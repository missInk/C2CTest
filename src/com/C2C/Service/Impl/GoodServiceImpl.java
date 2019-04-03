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
	public List<Good> getGoodsByStore(int idposition, String range, String category, double minPrice, double maxPrice, int page, int size) throws IOException {
		Store store = new Store();
		Position position = new Position();
		position.setIdposition(idposition);
		store.setPosition(position);
		store.setRange(toFuzzyRange(range));
		Good good = new Good();
		good.setCategory(category);
		good.setPriceRange(minPrice, maxPrice);
		good.setOwner(store);
		List<Good> goods = goodMapper.getGoodsByStore(good, page-1, size);
		return goods;
	}

	@Override
	public Good getGoodByIdGoods(int idGoods) {
		return goodMapper.getGoodByIdGoods(idGoods);
	}

}
