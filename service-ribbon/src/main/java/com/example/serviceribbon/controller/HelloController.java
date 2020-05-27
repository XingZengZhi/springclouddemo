package com.example.serviceribbon.controller;

import com.example.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:</br>
 * date:  </br>
 *
 * @author </br>
 */
@RestController
public class HelloController {
	@Autowired
	HelloService helloService;

	@RequestMapping("/hi")
	public String hi(@RequestParam("name") String name) {
		return helloService.hiService(name);
	}
}
