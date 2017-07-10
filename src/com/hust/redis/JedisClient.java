package com.hust.redis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;


public class JedisClient {

	@Test
	public void jedisClient() {

		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("s2", "222");
		String result = jedis.get("s2");
		System.out.println(result);
		jedis.close();
	}

	@Test
	public void jedisPool() {

		JedisPool pool = new JedisPool("127.0.0.1", 6379);

		Jedis jedis = pool.getResource();

		jedis.set("s4", "444");

		String result = jedis.get("s3");
		System.out.println(result);

		jedis.close();

		pool.close();
	}

	@Test
	public void jedisCluster() {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		nodes.add(new HostAndPort("127.0.0.1", 7006));
		nodes.add(new HostAndPort("127.0.0.1", 7007));

		JedisCluster cluster = new JedisCluster(nodes);

		cluster.set("s4", "444");

		String result = cluster.get("s4");
		System.out.println(result);

		cluster.close();
	}
}
