package service;

import java.util.List;

import dao.TypeDao;

public class TypeService {
	TypeDao dao=new TypeDao();
	public List select() {
		return dao.select() ;
	}
}
