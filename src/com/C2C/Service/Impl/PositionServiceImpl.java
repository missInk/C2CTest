package com.C2C.Service.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.C2C.Entity.Position;
import com.C2C.Mapper.PositionMapper;
import com.C2C.Service.PositionService;

public class PositionServiceImpl implements PositionService {

	private PositionMapper positionMapper;
	
	public void setPositionMapper(PositionMapper positionMapper) {
		this.positionMapper = positionMapper;
	}

	/**
	 * 将一个地点List集合转换为一个以首字母为健的，以该首字母开头的地点的名字的List集合为值的map集合
	 * @param positions 被转换的List地点集合
	 * @return 一个以首字母为健的，以该首字母开头的地点的名字的List集合为值的map集合
	 */
	private Map<String, List<String>> toTreeMap(List<Position> positions) {
		Map<String, List<String>> map = new TreeMap<String, List<String>>();
		Iterator<Position> iterator = positions.iterator();
		while(iterator.hasNext()) {
			Position position = iterator.next();
			Set<String> keys = map.keySet();
			boolean addFlg = false;
			for(Iterator<String> it = keys.iterator(); it.hasNext(); ) {
				if(position.getFirstWorld().equals(it.next())) {
					map.get(position.getFirstWorld()).add(position.getPositionName());
					addFlg = true;
					break;
				}
			}
			if(!addFlg) {
				List<String> list = new ArrayList<String>();
				list.add(position.getPositionName());
				map.put(position.getFirstWorld(), list);
			}
		}
		return map;
	}
	
	private String toJson(Map<String, List<String>> map) {
		StringBuilder sb = new StringBuilder("{");
		Set<String> keys = map.keySet();
		for(Iterator<String> iterator = keys.iterator(); iterator.hasNext(); ) {
			String key = iterator.next();
			sb.append("\""+ key + "\":[");
			List<String> value = map.get(key);
			for(Iterator<String> it = value.iterator(); it.hasNext(); ) {
				sb.append("\""+it.next()+"\",");
			}
			sb.replace(sb.length()-1, sb.length(), "],");
		}
		sb.replace(sb.length()-1, sb.length(), "}");
		return sb.toString();
	}
	
	@Override
	public String getStorePositions() {
		List<Position> positions = positionMapper.getStorePositions();
		Map<String, List<String>> map = toTreeMap(positions);
		return toJson(map);
	}

}
