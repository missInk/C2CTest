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
	 * 在一个字符串的前面以及每个字符的间隔处添加'%'，便于数据库进行模糊查找
	 * @param range 被修改的字符串
	 * @return 可以用于数据库模糊查找的字符串
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
