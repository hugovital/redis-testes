package com.teste;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class TesteCRC32 {
	
	private static Checksum checksum = new CRC32();

	public static void main(String[] args) {

        String input = "Java Code Geeks - Java Examples";
        
        HashMap<Long, Integer> count = new HashMap<Long, Integer>();
        
        for(int i = 0; i < 50000; i++){
        	
        	input = gerarString();
        	System.out.println(input);
        	
        	String s = input + "_" + i;
        	long h = gerarHash(s);        	
        	
        	long key = h % 11;        
        	
        	if (count.containsKey( key ) ){
        		Integer n = count.get(key);
        		n++;
        		count.put(key, n);
        	} else {
        		
        		count.put(key, 1);
        		
        	}
       	
        	
        	//System.out.println(key);
        	
        }
        
        
        System.out.println(Collections.singletonList(count));

	}
	
	private static String gerarString(){
				
		Random r = new Random();
		int n = r.nextInt(10);
		n += 8;
		
		String s = "";
		
		for (int i = 0; i <= n; i++){
			Random r2 = new Random();
			char c = (char)(r2.nextInt(26) + 'a');
			s += c;
		}
		
		return s;
		
	}
	
	private static long gerarHash(String input){
		
        // get bytes from string
        byte bytes[] = input.getBytes();                 

        // update the current checksum with the specified array of bytes
        checksum.update(bytes, 0, bytes.length);
          
        // get the current checksum value
        long checksumValue = checksum.getValue();
        
        return checksumValue;
		
	}

}
