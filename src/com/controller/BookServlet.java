package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.BooksBO;
import com.entity.UsersBO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static List<UsersBO> usersList = new ArrayList<UsersBO>();
    public static int userId=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<BooksBO> booksList = new ArrayList<BooksBO>();
		booksList.add(new BooksBO("Fiction", 1,0));
		booksList.add(new BooksBO("Comic", 2,0));
		booksList.add(new BooksBO("Horror", 3,0));
		booksList.add(new BooksBO("Romantic", 4,0));
		booksList.add(new BooksBO("Suspense", 5,0));
		
		request.setAttribute("booksList", booksList);
		
		if(null != request.getParameter("action")) {
			for(BooksBO bo: booksList) {
				if(request.getParameter(bo.getBookName())!=null) {
					usersList.add(new UsersBO(userId++, request.getParameter("userName"),
							new BooksBO(bo.getBookName(), bo.getISBNId(),Integer.parseInt(request.getParameter("quantity")))));
				}
			}
		}
		if(request.getParameter("id")!=null && request.getParameter("button").equals("return")) {
			usersList.remove(Integer.parseInt(request.getParameter("id")));
		}else if(request.getParameter("id")!=null && request.getParameter("button").equals("modify")) {
			for(UsersBO bo:usersList) {
				if(bo.getUserId()==Integer.parseInt(request.getParameter("id"))) {
					request.setAttribute("userName", bo.getUserName());
				}
			}
			
		}
		
		session.setAttribute("usersList", usersList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
