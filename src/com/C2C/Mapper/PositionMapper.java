package com.C2C.Mapper;

import java.util.List;

import com.C2C.Entity.Position;

public interface PositionMapper {

	/**
	 * ��ȡ����ӵ�е��̵ĵ�ַ
	 * @return һ����������ӵ�е��̵ص�ļ���
	 */
	List<Position> getStorePositions();
	
}
