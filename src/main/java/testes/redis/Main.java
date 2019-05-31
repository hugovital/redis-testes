package testes.redis;

import redis.clients.jedis.Jedis;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String remote_ip = "13.58.64.223";
		
		// Connecting to Redis on localhost		
		//jedis.auth("forefather");
		
		// adding a new key
		Jedis jedis = new Jedis( remote_ip );
		jedis.set("key", "COWABANGA IT IS!!!!");
		jedis.disconnect();

		while ( true ) {
			
			try {
			
				jedis = new Jedis( remote_ip );
				System.out.println(jedis.get("key"));
							
			} catch (Exception ex) {
				
				System.out.println( ex.getMessage() );
				
			} finally {
				
				jedis.disconnect();				
				
				Thread.sleep(1000);
				
			}
				
			
		}

		//System.out.println("Done.");
	}

}
