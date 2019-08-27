package dao;

import java.util.List;

import model.Type;

public class TypeDao {
	public List select() {
		return  DbHelper.executeQuery("select * from type ", Type.class);
	}
}
