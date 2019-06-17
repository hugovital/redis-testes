package com.el7.dao;

import java.util.ArrayList;

import com.el7.utils.EL7Utils;

public class CacheDAO {
	
	private static int numShards = 2;
	private ArrayList<Object> connections = new  ArrayList<Object>();
	
	public void insert(String id, String data){
		
		Object o = getConnection(id);
		//grava o conteúdo
		
	}
	
	private Object getConnection(String id){
		
		int shard = getShard(id);
		Object o = connections.get(shard);
		return o;
		
	}
	
	private int getShard(String id){
		
		long hash = EL7Utils.gerarHash(id);
		Long shard = new Long ( hash % numShards );
		
		return shard.intValue();
		
	}
	

	
}