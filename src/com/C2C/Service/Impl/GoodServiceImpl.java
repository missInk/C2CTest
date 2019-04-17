package com.C2C.Service.Impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Mapper.GoodMapper;
import com.C2C.Service.GoodService;

import net.sf.json.JSONObject;

public class GoodServiceImpl implements GoodService {

	private GoodMapper goodMapper;

	public void setGoodMapper(GoodMapper goodMapper) {
		this.goodMapper = goodMapper;
	}

	/**
	 * ��һ���ַ�����ǰ���Լ�ÿ���ַ��ļ�������'%'���������ݿ����ģ������
	 * @param range ���޸ĵ��ַ���
	 * @return �����������ݿ�ģ�����ҵ��ַ���
	 */
	private String toFuzzyRange(String range) {
		StringBuilder fuzzyRange = new StringBuilder("%");
		char[] rangeArray = range.toCharArray();
		for(char c : rangeArray) {
			fuzzyRange.append(c);
			fuzzyRange.append('%');
		}
 		return fuzzyRange.toString();
	}

	@Override
	public Good getGoodByIdGoods(int idGoods) {
		return goodMapper.getGoodByIdGoods(idGoods);
	}

	@Override
	public List<Good> getGoodsByPositionAndPage(String positionName, String range, int page) throws IOException {
		range = toFuzzyRange(range);
		return goodMapper.getGoodsByPositionAndPage(positionName, range, 25*(page-1));
	}
	
	/**
	 * ����һ���ַ�����ʽ��ʱ��
	 * @return �ַ�����ʽ��ʱ��
	 */
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	@Override
	public boolean issueGood(int idUser, String goodName, String price, String goodPhoto, String goodIntroduce, String category) {
		String issueDate = getDate();
		Good good = new Good();
		good.setGoodName(goodName);
		good.setPrice(Double.parseDouble(price));
		good.setGoodPhoto(goodPhoto);
		good.setGoodIntroduce(goodIntroduce);
		good.setCategory(category);
		good.setIssueDate(issueDate);
		return false;
	}

	@Override
	public String goodToJson(Good good) {
		JSONObject json = JSONObject.fromObject(good);
		return json.toString();
	}

}
