package com.C2C.Service.Impl;

import com.C2C.Mapper.StoreMapper;
import com.C2C.Service.StoreService;

public class StoreServiceImpl implements StoreService{

	private StoreMapper storeMapper;
	
	public StoreMapper getStoreMapper() {
		return storeMapper;
	}

	public void setStoreMapper(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}

	@Override
	public int getIdStoreByIdUser(int idUser) {
		return storeMapper.getIdStoreByIdUser(idUser);
	}

}
