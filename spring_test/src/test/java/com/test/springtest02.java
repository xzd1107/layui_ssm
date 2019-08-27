package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.situ.entity.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:aa.xml"})
public class springtest02 {
	@Resource(name="book")
	Book b;
	
	@Test
	public void test01() {
		System.out.println(b.getName());
	}
	
}
