package com.C2C.Service;

public interface StoreService {

	/**
	 * 通过用户的id来获得商店的id
	 * @param idUser 用户的id
	 * @return 商店的id
	 */
	int getIdStoreByIdUser(int idUser);
	
}
