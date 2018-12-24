package net.popo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.popo.demo.po.Demo;
import net.popo.demo.service.TestServiceImpl;
import net.popo.util.SnowFlakeOrder;

@RestController
public class TestController {
	
	@Autowired
	private TestServiceImpl testServiceImpl;
	
	@RequestMapping("/test")
	public int test() {
		Demo test = new Demo();
		test.setId(SnowFlakeOrder.getUniqueId("13364221022", 3));
		test.setMobile(13364221022l);
		System.out.println(test.getId());
		System.out.println("该条数据应该落在 ：" + test.getMobile() % 3 + " 的表中");
		test.setName("hoopopo");
		return testServiceImpl.save(test);
	}
}
