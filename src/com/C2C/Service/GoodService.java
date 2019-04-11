package com.C2C.Service;

import java.io.IOException;
import java.util.List;

import com.C2C.Entity.Good;

public interface GoodService {

	/**
	 * 通过位置信息和当前的页数来返回一个商品集合
	 * @param positionName 位置信息的一部分（城市名）
	 * @param range 位置信息的一部分（详细位置）
	 * @param page 当前页数
	 * @return 一个商品集合
	 */
	List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException;
	
	/**
	 * 通过商品的ID来获得商品的实体信息
	 * @param idGoods 商品的ID
	 * @return 商品的实体
	 */
	Good getGoodByIdGoods(int idGoods);
	
	/**
	 * 上传一个商品
	 * @param idUser 上传人的id（必填）
	 * @param goodName 商品的名字（必填）
	 * @param price 商品的价格（必填）
	 * @param goodPhoto 商品的图片
	 * @param goodIntroduce 商品的描述
	 * @param category 商品的种类（必填）
	 * @return 成功：true 失败：false
	 */
	boolean issueGood(int idUser, String goodName, String price, String goodPhoto, String goodIntroduce, String category);
	
}
