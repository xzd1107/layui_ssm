package com.situ.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("type")
public class TypeController {
	
	@DeleteMapping("de")
	public void del() {
		System.out.println("del方法");
	}
}
