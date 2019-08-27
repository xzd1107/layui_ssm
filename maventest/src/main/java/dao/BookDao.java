package dao;

import java.util.List;

import model.Book;

public class BookDao {

	public int select(String where) {
		return  DbHelper.executeCount("select count(1) from book inner join type on type.id=book.typeid "+where);
	}
	public List select(String where,String limit) {
		return  DbHelper.executeQuery("select book.*,type.name typename from book inner join type on type.id=book.typeid "+where +limit, Book.class);
	}
	
	public int insert(Book b) {
		return DbHelper.executeUpdate("insert into book(name,sex,typeid) values(?,?,?)", b.getName(),b.getSex(),b.getTypeid());
	}
	public int update(Book b) {
		return DbHelper.executeUpdate("update book set name=?,sex=?,typeid=? where id=?", b.getName(),b.getSex(),b.getTypeid(),b.getId());
	}
	public int delete(Book b) {
		return DbHelper.executeUpdate("delete from book  where id=?",b.getId());
	}
}
