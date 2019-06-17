package com.el7.utils;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class EL7Utils {
	
	public static long gerarHash(String id){
		
		Checksum checksum = new CRC32();		
        byte bytes[] = id.getBytes();                 
        checksum.update(bytes, 0, bytes.length);         
        long checksumValue = checksum.getValue();
        
        return checksumValue;

	}

}
