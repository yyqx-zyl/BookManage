package service.book;

import java.util.List;

import entity.Book;

public interface BookService {
	//获得全部图书信息
	List<Book> getList();

	boolean Add(Book b);

	boolean deleteByid(int id);

	List<Book> findByid(int id);

	boolean saveByid(Book b);
	//获得总条数
	int getCount();
	
	List getpageLists(int start, int pageSize);

}
