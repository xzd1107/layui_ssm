package com.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.situ.entity.Book;
import com.situ.entity.Type;

public class springtest03 {
	
	@Test
	public void test01() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("aa.xml");
		Book b = (Book) ac.getBean("book");
		Type p = b.getP();
		System.out.println(p.getName());
	}
}
