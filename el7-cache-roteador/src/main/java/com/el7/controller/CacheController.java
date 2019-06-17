package com.el7.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	
	@RequestMapping("/get_data")
	public String get(){
		return "COWABANGA";
	}
	
	@RequestMapping(value="/post_data", method = RequestMethod.POST)
	public String post(@RequestBody String payload){
		
		//separa dados
		//validacoes
		//cria objeto de service
		//invoka o servico
		
		System.out.println( payload );
		
		return "COWABANGA from Post";
	}

}
