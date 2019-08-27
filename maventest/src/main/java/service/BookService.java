package service;

import java.util.List;

import dao.BookDao;
import dao.DbHelper;
import model.Book;
import utils.ReturnInfo;

public class BookService {
	BookDao dao=new BookDao();
	public ReturnInfo select(String where,Integer page,Integer max) {
		boolean canpage=page!=null;
		ReturnInfo info = new ReturnInfo();
		info.setList(dao.select(where,ReturnInfo.getLimit(page, max)));
		if(canpage)info.setCount(dao.select(where));
		  return info;
	}
	
	public Book selectByid(int id) {
		return  (Book) dao.select(" where book.id="+id," limit 1").get(0);
	}
	
	public int insert(Book b) {
		return dao.insert(b);
	}
	public int update(Book b) {
		return dao.update(b);
	}
	public int delete(Book b) {
		return dao.delete(b);
	}
}
