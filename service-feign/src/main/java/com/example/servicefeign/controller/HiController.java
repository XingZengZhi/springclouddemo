package com.example.servicefeign.controller;

import com.example.servicefeign.inter.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:</br>
 * date:  </br>
 *
 * @author </br>
 */
@RestController
public class HiController {
	@Autowired
	private SchedualServiceHi schedualServiceHi;

	@GetMapping("/hi")
	public String sayHi(@RequestParam String name) {
		return schedualServiceHi.sayHiFromClientOne(name);
	}
}
