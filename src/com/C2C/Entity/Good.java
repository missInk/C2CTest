package com.C2C.Entity;

import java.util.List;

public class Good {

	private int idGoods;
	/**
	 * 商品分类
	 */
	private String category;
	private String goodName;
	private double price;
	/**
	 * 商品描述
	 */
	private String goodIntroduce;
	private String goodPhoto1;
	private String goodPhoto2;
	private String goodPhoto3;
	private Store owner;
	/**
	 * 商品的状态
	 * 1：已经售出
	 * 2：未售出
	 */
	private String state;
	private int buyMen;
	private List<GoodLeaveMessage> leaveMessages;

	public List<GoodLeaveMessage> getLeaveMessages() {
		return leaveMessages;
	}

	public void setLeaveMessages(List<GoodLeaveMessage> leaveMessages) {
		this.leaveMessages = leaveMessages;
	}

	public int getBuyMen() {
		return buyMen;
	}

	public void setBuyMen(int buyMen) {
		this.buyMen = buyMen;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Store getOwner() {
		return owner;
	}

	public void setOwner(Store owner) {
		this.owner = owner;
	}

	public String getGoodPhoto1() {
		return goodPhoto1;
	}

	public void setGoodPhoto1(String goodPhoto1) {
		this.goodPhoto1 = goodPhoto1;
	}

	public String getGoodPhoto2() {
		return goodPhoto2;
	}

	public void setGoodPhoto2(String goodPhoto2) {
		this.goodPhoto2 = goodPhoto2;
	}

	public String getGoodPhoto3() {
		return goodPhoto3;
	}

	public void setGoodPhoto3(String goodPhoto3) {
		this.goodPhoto3 = goodPhoto3;
	}

	public int getIdGoods() {
		return idGoods;
	}

	public void setIdGoods(int idGoods) {
		this.idGoods = idGoods;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoodIntroduce() {
		return goodIntroduce;
	}

	public void setGoodIntroduce(String goodIntroduce) {
		this.goodIntroduce = goodIntroduce;
	}

	@Override
	public String toString() {
		return "Good [idGoods=" + idGoods + ", goodName=" + goodName + ", price=" + price + ", goodPhoto1=" + goodPhoto1
				+ ", owner=" + owner + "]";
	}

	
}
