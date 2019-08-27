package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.situ.entity.Book;
import com.situ.entity.Type;

public class springtest {
	
	@Test
	public void test01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aa.xml");
		Object object = ac.getBean("book");
		Book b = (Book) object;
//		Type type = b.getP();
//		System.out.print("LPL00"+b.getId()+"号选手:");
//		System.out.println(b.getName()+"申请出战!!");
//		System.out.println(type.getName());
//		System.out.println(type.getId());
	}
	
	@Test
	public void test02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aa.xml");
		Type object = (Type) ac.getBean("type");
		System.out.println(object.getName());
	}
}
