package com.itn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itn.model.Book;

public class BookDao {
	String userName;
	String password;
	String url;
	Connection conn;

	public BookDao(String userName, String password, String url) {
		System.out.println("Inside BookDao");
		this.userName = userName;
		this.password = password;
		this.url = url;
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("Failed To Connect to Database" + e.getMessage());
		}
	}
	protected void disconnect() throws SQLException{
		if(conn != null && conn.isClosed()) {
			conn.close();
		}
		
	}

	public void insert(Book book) {
		String sql = "insert into bookstore(title,author,price) values(?,?,?)";
		connect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setFloat(3, book.getPrice());
			int i = ps.executeUpdate();
			ps.close();
			disconnect();
			System.out.println("insertion response" + i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
