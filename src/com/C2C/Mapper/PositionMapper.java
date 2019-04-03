package com.C2C.Mapper;

import java.util.List;

import com.C2C.Entity.Position;

public interface PositionMapper {

	/**
	 * 获取所有拥有店铺的地址
	 * @return 一个包含所有拥有店铺地点的集合
	 */
	List<Position> getStorePositions();
	
}
