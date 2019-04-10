package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Position;

public interface PositionMapper {

	/**
	 * ��ȡ����ӵ�е��̵ĵ�ַ
	 * @return һ����������ӵ�е��̵ص�ļ���
	 */
	List<Position> getStorePositions();
	
	/**
	 * ͨ��һ���ص�����ֺͷ�Χ���ظõص��idֵ
	 * @param positionName �ص㣨���У�������
	 * @param range ��ϸ��ַ
	 * @return �õص��id����û���򷵻�null
	 */
	int getIdPositionByRange(@Param("positionName")String positionName, @Param("range")String range);
	
}
