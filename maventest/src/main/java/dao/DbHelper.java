package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Vector;



public class DbHelper {
	public static String connstr = "jdbc:mysql://127.0.0.1:3306/situxzd?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	public static String username = "root";
	public static String userpass = "root";
//	private static BasicDataSource ds=new BasicDataSource();
	
	
	
	static {
		try {
			Properties  p = new Properties();
			try {
				p.load(new FileInputStream("db.properties"));
			} catch (Exception e) {
			}
			connstr=p.getProperty("connstr",connstr);
			username=p.getProperty("username",username);
			userpass=p.getProperty("userpass",userpass);
			String driver=p.getProperty("driver","com.mysql.jdbc.Driver");
			
			
//			ds.setDriverClassName(driver);
//			ds.setUsername(username);
//			ds.setPassword(userpass);
//			ds.setUrl(connstr);
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() throws Exception {
		
		return DriverManager.getConnection(connstr, username, userpass);
//		return ds.getConnection();
	}

	private static void closeAll(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
		}
	}

	
	public static int executeUpdate(String sql, Object... vals) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			
			for (int i = 1; i <= vals.length; i++) {
				st.setObject(i, vals[i - 1]);
			}
			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		} finally {
			closeAll(conn, st, null);
		}
	}

	
	public static List executeQuery(String sql,Class cls, Object... vals) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs=null;
		List list = new Vector();
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 1; i <= vals.length; i++) {
				st.setObject(i, vals[i - 1]);
			}
			 rs= st.executeQuery();
			ResultSetMetaData m= rs.getMetaData();    
			while(rs.next()) {
				Object o=cls.newInstance();     //创建实例
				for(int i=1;i<=m.getColumnCount();i++) {
					String colname=m.getColumnLabel(i);  //获取列标名
					try {
					Field f=cls.getDeclaredField(colname);   //获取字段
					f.setAccessible(true);                   //忽略权限
					f.set(o, rs.getObject(i));              //赋值
					}catch (Exception e) {
					}
				}
				list.add(o);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return new Vector();
		} finally {
			closeAll(conn, st, rs);
		}
	}
	
	
	public static int executeCount(String sql, Object... vals) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs=null;
		try {
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for (int i = 1; i <= vals.length; i++) {
				st.setObject(i, vals[i - 1]);
			}
			 rs= st.executeQuery();
			 rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			closeAll(conn, st, rs);
		}
	}
	
}
