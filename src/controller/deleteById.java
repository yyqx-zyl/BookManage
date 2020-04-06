package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.book.BookService;
import service.book.impl.BookServiceImpl;

/**
 * Servlet implementation class deleteById
 */
@WebServlet("/deleteById")
public class deleteById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bs=new BookServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteById() {
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
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		boolean isOk=bs.deleteByid(id);
		if (isOk) {
			resp.sendRedirect("Index");
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
