package com.itn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itn.dao.BookDao;
import com.itn.model.Book;
import com.sun.webkit.ContextMenu.ShowContext;

/**
 * Servlet implementation class BookStoreServlet
 */
@WebServlet("/BookStoreServlet")
public class BookStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDao bookDao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookStoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init Block");
		String userName = "root";
		String password = "timus85";
		String url = "jdbc:mysql://localhost:3306/Bookstore";
		bookDao = new BookDao(userName, password, url);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * PrintWriter out = response.getWriter(); out.print("Inside BookStoreServlet");
		 * String title= request.getParameter("title"); String author =
		 * request.getParameter("author"); String pri = request.getParameter("price");
		 * float price = Float.valueOf(pri); Book b = new Book(title,author,price);
		 * bookDao.insert(b);
		 */

		String action = request.getServletPath();
		System.out.println("url is" + action);
		try {
			switch (action) {
			case "/addBook":
				System.out.println("New Tab");
				showNewForm(request, response);
				break;
	/*		case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;

			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;*/
			default:
				System.out.println("Default Message");
				//listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
