package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.Pager;
import service.book.BookService;
import service.book.impl.BookServiceImpl;
import service.user.UserService;
import service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private BookService bs=new BookServiceImpl();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/hmtl;UTF-8");
		
		//获得主页面的当前页
		String pageIndex=req.getParameter("pageIndex");
		//如果pageIndex为空
		int currpage=1;//当前页
		//创建分页对象
		Pager pg=new Pager();
		//获得数据总条数
		int totalCount=bs.getCount();
		pg.setTotalCount(totalCount);
		if (pageIndex==null || "".equals(pageIndex)) {
			currpage=1;
		}else {
			int pIndex=Integer.parseInt(pageIndex);
			if (pIndex<=0) {
				currpage=1;
			}else if (pIndex>pg.getTotalPages()) {
				currpage=pg.getTotalPages();
			}else {
				currpage=pIndex;
			}
		}
		pg.setCurrPage(currpage);
		//从哪里开始查询   如果是第一页   (1-1)*显示的数据条数   从0开始查询
		/**
		 * select * from persons limit  A,  B;
			A，查询起点
			B，你需要的行数
		 */
		int start=(currpage-1)*pg.getPageSize();//?有点模糊
		List pageLists=bs.getpageLists(start,pg.getPageSize());
		pg.setPageLists(pageLists);
		req.getSession().setAttribute("pg", pg);
		//req.getRequestDispatcher("index.jsp").forward(req,resp);
		resp.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
