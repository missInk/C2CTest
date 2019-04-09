package com.C2C.Entity;

public class Order {

	private long idOrder;
	private String payAccount;
	private Good good;
	private String amount;
	private int state;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Order(){
		idOrder = System.currentTimeMillis();
	}

	public long getidOrder() {
		return idOrder;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", payAccount=" + payAccount + ", idGood=" + good.getIdGoods() + ", goodName=" + good.getGoodName() + ", price=" + good.getPrice() + ", amount=" + amount
				+ "]";
	}
	
}
