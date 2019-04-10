package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Position;

public interface PositionMapper {

	/**
	 * 获取所有拥有店铺的地址
	 * @return 一个包含所有拥有店铺地点的集合
	 */
	List<Position> getStorePositions();
	
	/**
	 * 通过一个地点的名字和范围返回该地点的id值
	 * @param positionName 地点（城市）的名字
	 * @param range 详细地址
	 * @return 该地点的id，若没有则返回null
	 */
	int getIdPositionByRange(@Param("positionName")String positionName, @Param("range")String range);
	
}
