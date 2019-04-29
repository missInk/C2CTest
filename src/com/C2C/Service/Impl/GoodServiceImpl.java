package com.C2C.Service.Impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Mapper.GoodMapper;
import com.C2C.Service.GoodService;
import com.C2C.Util.MyCacheUtil;

import net.sf.json.JSONObject;

public class GoodServiceImpl implements GoodService {

	private GoodMapper goodMapper;
	private static final int SIZE = 25;
	
	public void setGoodMapper(GoodMapper goodMapper) {
		this.goodMapper = goodMapper;
	}

	@Override
	public Good getGoodByIdGoods(int idGoods) {
		return goodMapper.getGoodByIdGoods(idGoods);
	}

	@Override
	public List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException {
		List<Good> goods = null;
		
		//检索缓存
		String key = positionName + "_" + range;
		goods = MyCacheUtil.getList(key, Good.class);
		
		if(goods == null || goods.size() == 0) {
			//检索mysql数据库
			goods = goodMapper.getGoodsByPositionAndPage(positionName, range, SIZE*(page-1));
			//将搜索结果同步到redis
			MyCacheUtil.addList(key, goods);
		}
		return goods;
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
		return false;
	}

	@Override
	public String goodToJson(Good good) {
		JSONObject json = JSONObject.fromObject(good);
		return json.toString();
	}

}
