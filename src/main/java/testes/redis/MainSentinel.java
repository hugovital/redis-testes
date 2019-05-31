package testes.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

public class MainSentinel {
	
	public static void main(String[] args) throws Exception {
		
		escrever();
		while ( true ) {
			
			ler();
			
			Thread.sleep(3 * 1000);
			
		}
		
		
	}
	
	public static void ler() throws Exception {
		
		String MASTER_NAME = "mymaster";

		Set<String> sentinels = new HashSet<>();
		sentinels.add("13.58.64.223:6379");
		sentinels.add("18.191.112.112:6379");
		sentinels.add("18.222.49.17:6379");

		JedisSentinelPool pool = new JedisSentinelPool(MASTER_NAME, sentinels);
		Jedis jedis = null;
		try {
			printer("Fetching connection from pool");
			jedis = pool.getResource();
			printer("Authenticating...");
			//jedis.auth(PASSWORD);
			printer("auth complete...");
//			Socket socket = jedis.getClient().getSocket();
//			printer("Connected to " + socket.getRemoteSocketAddress());
			printer("Reading...");
			String s = jedis.get("java-key-999");
			System.out.println("Read: " + s);
		} catch (JedisException e) {
			printer("Connection error of some sort!");
			printer(e.getMessage());
			e.printStackTrace();
			Thread.sleep(2 * 1000);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
			System.out.println("Done.");
		}

	}

	public static void escrever() throws Exception {

		String MASTER_NAME = "mymaster";

		Set<String> sentinels = new HashSet<>();
		sentinels.add("13.58.64.223:6379");
		sentinels.add("18.191.112.112:6379");
		sentinels.add("18.222.49.17:6379");

		JedisSentinelPool pool = new JedisSentinelPool(MASTER_NAME, sentinels);
		Jedis jedis = null;
		try {
			printer("Fetching connection from pool");
			jedis = pool.getResource();
			printer("Authenticating...");
			//jedis.auth(PASSWORD);
			printer("auth complete...");
//			Socket socket = jedis.getClient().getSocket();
//			printer("Connected to " + socket.getRemoteSocketAddress());
			printer("Writing...");
			jedis.set("java-key-999", "java-value-999");
		} catch (JedisException e) {
			printer("Connection error of some sort!");
			printer(e.getMessage());
			e.printStackTrace();
			Thread.sleep(2 * 1000);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
			System.out.println("Done.");
		}
		
	}
	
	public static void printer(String s) {
		System.out.println(s);
	}

}
