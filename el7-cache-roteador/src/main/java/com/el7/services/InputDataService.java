package com.el7.services;

import com.el7.dao.CacheDAO;

public class InputDataService {
	
	public void inputData(String appid, String chave, String data){	
		
		String cache_id = appid + "." + chave;

		CacheDAO dao = new CacheDAO();
		dao.insert( cache_id, data );
		
		//generate hashkey
		//get corret connection
		//input data into cache
		
	}

}
