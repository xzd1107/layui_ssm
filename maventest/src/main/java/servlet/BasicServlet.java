package servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;



public  class BasicServlet extends GenericServlet{
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public Integer page;
	public Integer limit;
	
	
	protected  void select(HttpServletRequest req,HttpServletResponse resp) {
		
	}
	protected  void nodef(HttpServletRequest req,HttpServletResponse resp) {
		
	}
	public void returnJson(int status) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write("{\"status\":"+status+"}");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void returnJson(Object o) { 
		try {
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(objectMapper.writeValueAsString(o));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Dispatcher(String name) {
		try {
			req.getRequestDispatcher(name).include(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		req=(HttpServletRequest) arg0;
		 resp=(HttpServletResponse) arg1;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//初始化
		
		
		//根据全部参数，注入到变量中
		Enumeration<String> e=req.getParameterNames();
		while(e.hasMoreElements()) {
			String key=e.nextElement();
			try {
				//赋值类变量
			Field f=this.getClass().getDeclaredField(key);
			setval(f,req.getParameter(key),this);
			}catch (Exception e1) {
				try {
				Field f=this.getClass().getField(key);
				setval(f,req.getParameter(key),this);
				}catch (Exception e4) {
				}
			}
			
			try {
				//赋值model变量
			Field f=this.getClass().getDeclaredField("model");
			f.setAccessible(true);
			Object ml=f.get(this);
			if(ml==null) {
				f.set(this, f.getType().newInstance());
			}
			Field ff=f.getType().getDeclaredField(key);
			setval(ff,req.getParameter(key),ml);
			
			}catch (Exception e1) {
//				e1.printStackTrace();
			}
		}
		
		//根据cmd参数找到指定方法
		String cmd=req.getParameter("cmd");
		if(cmd==null||cmd.length()==0) {
			select(req, resp);
		}else {
			try {
				Method m=this.getClass().getDeclaredMethod(cmd,HttpServletRequest.class,HttpServletResponse.class );
				m.setAccessible(true);
				m.invoke(this, req,resp);
			} catch (Exception e2) {
				nodef(req, resp);
			}
		}
	}
	private void setval(Field f, String val,Object o)throws Exception {
		f.setAccessible(true);
		if(f.getType().equals(int.class)||f.getType().equals(Integer.class)) {
			f.set(o, Integer.valueOf(val));
		}else if(f.getType().equals(Double.class)||f.getType().equals(double.class)) {
			f.set(o, Double.valueOf(val));
		}else {
			f.set(o,val);
		}
	}

}
