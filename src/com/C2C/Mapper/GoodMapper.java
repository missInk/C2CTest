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
	 * @param star 查询到起始位置
	 * @param size 单次查询的个数
	 * @return 一个商品集合
	 */
	List<Good> getGoodsByPositionAndPage(@Param("positionName")String positionName, @Param("range")String range, @Param("category")String category, @Param("star")int star, @Param("size")int size);

	/**
	 * 发布一个商品
	 * @param sellMen 发布这个商品的用户的id
	 * @param good 被发布的商品的实体信息
	 * @return 1：发布成功  0：发布失败
	 */
	int issueGood(@Param("sellMen")int sellMen, @Param("good")Good good);
	
	/**
	 * 根据商品的地点，范围，商品种类获得商品的数量
	 * @param positionName 商品地点
	 * @param range 范围
	 * @param category 商品种类
	 * @return 符合该条件的商品数量
	 */
	int getGoodCount(@Param("positionName")String positionName, @Param("range")String range, @Param("category")String category);
	
}
