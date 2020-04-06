package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.book.BookService;
import service.book.impl.BookServiceImpl;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//字符编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//获得页面数据
		String  Name=req.getParameter("Name");
		String  Author=req.getParameter("Author");
		String  publish=req.getParameter("publish");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String publishdate=req.getParameter("publishdate");
		Date date=null;
		Date utilDate =null;
		try {
			date = format.parse(publishdate);
			utilDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int Page=Integer.parseInt(req.getParameter("Page"));
		double Price=Double.parseDouble(req.getParameter("Price"));
		String  Content=req.getParameter("Content");
		System.out.println("Name:"+Name+",Author:"+Author+",publish:"+publish+",date:"+utilDate+",Page:"+Page+",Price:"+Price+",Content:"+Content);
		//创建对象
		Book b=new Book(Name,Author,publish,utilDate,Page,Price,Content);
		//调用方法
		boolean isOk=bs.Add(b);
		if (isOk) {
			resp.sendRedirect("Index");
		}else {
			resp.sendRedirect("Add.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
