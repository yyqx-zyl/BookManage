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
 * Servlet implementation class look
 */
@WebServlet("/findByid")
public class findByid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();      
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findByid() {
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
			
		//获得数据
		int id=Integer.parseInt(req.getParameter("id"));
		
		List<Book> bbs=bs.findByid(id);
		if (bbs!=null) {
			req.setAttribute("bbs",bbs);
			req.getRequestDispatcher("show.jsp").forward(req,resp);
			//resp.sendRedirect("show.jsp");
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
