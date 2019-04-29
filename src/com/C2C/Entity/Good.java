package com.C2C.Entity;

public class Good {

	private int idGoods;
	/**
	 * ��Ʒ����
	 */
	private String category;
	private String goodName;
	private double price;
	/**
	 * ��Ʒ����
	 */
	private String goodIntroduce;
	private String goodPhoto;
	/**
	 * ��Ʒ��״̬
	 * 1�������У������Ϊ�����У�
	 * 2��������ɣ�ȷ���ջ���Ϊ������ɣ�
	 * 0��δ�۳���û���˹���δ�۳���
	 */
	private String state;
	private User sellMen;
	private User buyMen;
	private String issueDate;

	public Good(int idGoods) {
		super();
		this.idGoods = idGoods;
	}

	public Good() {
		super();
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGoodPhoto() {
		return goodPhoto;
	}

	public void setGoodPhoto(String goodPhoto) {
		this.goodPhoto = goodPhoto;
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

	public User getSellMen() {
		return sellMen;
	}

	public void setSellMen(User sellMen) {
		this.sellMen = sellMen;
	}

	public User getBuyMen() {
		return buyMen;
	}

	public void setBuyMen(User buyMen) {
		this.buyMen = buyMen;
	}

	
	
	@Override
	public String toString() {
		return "Good [idGoods=" + idGoods + ", goodName=" + goodName + ", price=" + price + ", goodPhoto=" + goodPhoto
				+ ", sellMen=" + sellMen + "]";
	}

	
}
