package com.C2C.Entity;

import java.util.List;

public class Store {

	private int idStore;
	private User storeOwner;
	private String storeName;
	private List<Good> goods;
	private Position position;

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public int getIdStore() {
		return idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}


	public User getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(User storeOwner) {
		this.storeOwner = storeOwner;
	}

	@Override
	public String toString() {
		return "Store [idStore=" + idStore + ", storeOwner=" + storeOwner + ", storeName="
				+ storeName + ", goods=" + goods + ", position=" + position + "]";
	}

	

}
