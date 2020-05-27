package com.example.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Description:</br>
 * date:  </br>
 *
 * @author </br>
 */
@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;

	/**
	 * 当服务不可用时，则调用hiError方法
	 * @param name
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "hiError")
	public String hiService(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/index/test?name=" + name, String.class);
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
