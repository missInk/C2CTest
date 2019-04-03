package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;

public interface GoodMapper {

	/**
	 * 通过商品所属商店的信息以及页面的位置和每一页展示的商品数目来返回一个商品列表
	 * 
	 * @param store
	 *            商品所属商店
	 * @param page
	 *            查询的页数
	 * @param size
	 *            页面展示商品的数目
	 * @return 一个商品集合
	 */
	List<Good> getGoodsByStore(@Param("good")Good good, @Param("page")int page, @Param("size")int size);

	/**
	 * 通过商品的ID来获得商品的实体信息
	 * @param idGoods 商品的ID
	 * @return 商品的实体
	 */
	Good getGoodByIdGoods(int idGoods);
	
}
