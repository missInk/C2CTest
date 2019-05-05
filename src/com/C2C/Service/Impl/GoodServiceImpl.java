package com.C2C.Service.Impl;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Mapper.GoodMapper;
import com.C2C.Service.GoodService;
import com.C2C.Util.DateUtil;
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
	public List<Good> getGoodsByPositionAndPage(String positionName, String range, int page, String category) throws IOException {
		List<Good> goods = null;
		
		//检索缓存
		String key = positionName + "_" + range;
		if(category != null) {
			key += ("_" + category);
		}
		goods = MyCacheUtil.getList(key, Good.class, SIZE*(page-1), SIZE);
		
		if(goods == null || goods.size() == 0) {
			//检索mysql数据库
			goods = goodMapper.getGoodsByPositionAndPage(positionName, range, category, SIZE*(page-1), SIZE);
			//将搜索结果同步到redis
			CacheGood cacheGood = new CacheGood(positionName, range, page, category, 250);
			cacheGood.start();
		}
		return goods;
	}
	
	class CacheGood extends Thread{
		
		String positionName;
		String range;
		int page;
		String category;
		int size;
		
		public CacheGood(String positionName, String range, int page, String category, int size) {
			this.category = category;
			this.page = page;
			this.positionName = positionName;
			this.range = range;
			this.size = size;
		}
		
		public void run() {
			String key = positionName + "_" + range;
			if(category != null) {
				key += ("_" + category);
			}
			List<Good> cacheGood = goodMapper.getGoodsByPositionAndPage(positionName, range, category, SIZE*(page-1), size);
			MyCacheUtil.addList(key, cacheGood);
		}
	}
	
	@Override
	public boolean issueGood(int idUser, String goodName, String price, String goodPhoto, String goodIntroduce, String category) {
		String issueDate = DateUtil.getNowDate();
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

	@Override
	public int getGoodPageSize(String positionName, String range, String category) {
		int goodCount = goodMapper.getGoodCount(positionName, range, category);
		return goodCount%SIZE==0 ? goodCount/SIZE : (goodCount/SIZE+1);
	}

}
