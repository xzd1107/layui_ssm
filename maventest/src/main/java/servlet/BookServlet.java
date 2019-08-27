package servlet;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import service.BookService;
import service.TypeService;

@WebServlet("/Book/index")
public class BookServlet extends BasicServlet {
	BookService service=new BookService();
	TypeService tservice=new TypeService();
	
	Book model;
	
	
	String txt;
	@Override
	protected void select(HttpServletRequest req, HttpServletResponse resp) {
		
		if(txt!=null&&txt.length()>0)txt=" where book.name like '%"+txt+"%'";
		else txt="";
		returnJson(service.select(txt,page,limit));
	}
	protected void insert(HttpServletRequest req, HttpServletResponse resp) {
		service.insert(model);
//		select(req, resp);
		returnJson(1);
	}
	protected void delete(HttpServletRequest req, HttpServletResponse resp) {
		service.delete(model);
//		select(req, resp);
		returnJson(1);
	}
	
	protected void getSexs(HttpServletRequest req, HttpServletResponse resp) {
		returnJson(Book.sexs);
	}
	protected void getTypes(HttpServletRequest req, HttpServletResponse resp) {
		returnJson(tservice.select());
	}
	protected void update(HttpServletRequest req, HttpServletResponse resp) {
		service.update(model);
//		select(req, resp);
		returnJson(1);
	}
	protected void add(HttpServletRequest req, HttpServletResponse resp) {
//		req.setAttribute("sexs", Book.sexs);
//		req.setAttribute("typelist", tservice.select());
//		Dispatcher("edit.jsp");
	}
	protected void edit(HttpServletRequest req, HttpServletResponse resp) {
//		req.setAttribute("info", service.selectByid(model.getId()));
//		add(req, resp);
		returnJson(service.selectByid(model.getId()));
	}
	
	
}
