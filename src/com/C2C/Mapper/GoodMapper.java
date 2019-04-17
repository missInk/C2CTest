package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;

public interface GoodMapper {

	/**
	 * 通过商品的ID来获得商品的实体信息
	 * @param idGoods 商品的ID
	 * @return 商品的实体
	 */
	Good getGoodByIdGoods(int idGoods);
	
	/**
	 * 通过位置信息和当前的页数来返回一个商品集合
	 * @param positionName 位置信息的一部分（城市名）
	 * @param range 位置信息的一部分（详细位置）
	 * @param page 当前页数
	 * @return 一个商品集合
	 */
	List<Good> getGoodsByPositionAndPage(@Param("positionName")String positionName, @Param("range")String range, @Param("page")int page);

	/**
	 * 发布一个商品
	 * @param sellMen 发布这个商品的用户的id
	 * @param good 被发布的商品的实体信息
	 * @return 1：发布成功  0：发布失败
	 */
	int issueGood(@Param("sellMen")int sellMen, @Param("good")Good good);
	
}
