package com.example.servicefeign.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description: 通过@FeignClient指定调用哪个服务
 * date:  </br>
 *
 * @author </br>
 */
@FeignClient("service-hi")
public interface SchedualServiceHi {
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam("name") String name);
}
