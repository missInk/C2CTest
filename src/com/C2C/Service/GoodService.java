package com.C2C.Service;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;

public interface GoodService {

	/**
	 * 通过商家范围，商品种类，商品种类，选择的页面位置，选择的页面位置来搜索商品列表
	 * @param idposition 商店所处城市的id
	 * @param range 商家范围
	 * @param category 商品种类
	 * @param minPrice 商品的最低价格
	 * @param maxPrice 商品的最高价格
	 * @param page 选择的页面位置
	 * @param size 单个页面显示商品的数量
	 * @return 商品列表
	 * @throws IOException 
	 */
	List<Good> getGoodsByStore(int idposition, String range, String category, double minPrice, double maxPrice, int page, int size) throws IOException;
	
	/**
	 * 通过商品的ID来获得商品的实体信息
	 * @param idGoods 商品的ID
	 * @return 商品的实体
	 */
	Good getGoodByIdGoods(int idGoods);
}
