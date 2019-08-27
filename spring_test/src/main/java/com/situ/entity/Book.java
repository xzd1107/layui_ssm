package com.situ.entity;

public class Book {
	private int id;
	private String name;
	public Type p;
	
	
	public Book(Type p) {
		super();

		this.p = p;
	}
	public Book() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getP() {
		return p;
	}
	public void setP(Type p) {
		this.p = p;
	}
	
	
}
