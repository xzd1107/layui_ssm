package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.situ.entity.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:bb.xml"})
public class springtest04 {
	
	@Autowired
	Type type;
	
	@Test
	public void test01() {
		System.out.println(type.getName());
	}
	
}
