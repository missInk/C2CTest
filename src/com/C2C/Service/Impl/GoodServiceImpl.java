package com.C2C.Service.Impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Mapper.GoodMapper;
import com.C2C.Service.GoodService;
import com.C2C.Service.StoreService;

public class GoodServiceImpl implements GoodService {

	private GoodMapper goodMapper;
	private StoreService storeService;

	public void setGoodMapper(GoodMapper goodMapper) {
		this.goodMapper = goodMapper;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
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
	public Good getGoodByIdGoods(int idGoods) {
		return goodMapper.getGoodByIdGoods(idGoods);
	}

	@Override
	public List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException {
		range = toFuzzyRange(range);
		return goodMapper.getGoodsByPositionAndPage(positionName, range, 25*(page-1));
	}
	
	/**
	 * 返回一个字符串形式的时间
	 * @return 字符串形式的时间
	 */
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	@Override
	public boolean issueGood(int idUser, String goodName, String price, String goodPhoto, String goodIntroduce, String category) {
		String issueDate = getDate();
		Good good = new Good();
		good.setGoodName(goodName);
		good.setPrice(Double.parseDouble(price));
		good.setGoodPhoto(goodPhoto);
		good.setGoodIntroduce(goodIntroduce);
		good.setCategory(category);
		good.setIssueDate(issueDate);
		int idStore = storeService.getIdStoreByIdUser(idUser);
		int result = goodMapper.issueGood(idStore, good);
		return result == 1 ? true : false;
	}

}
