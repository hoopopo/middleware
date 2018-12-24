package net.popo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.popo.demo.dao.DemoMapper;
import net.popo.demo.po.Demo;

@Service
public class TestServiceImpl {

	@Autowired
	private DemoMapper testMapper;
	
	public int save(Demo test) {
		return testMapper.insert(test);
	}
}
