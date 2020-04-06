package Dao.book;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Book;

public interface BookMapper {
	//获得图书信息
	List<Book> getList();
	//添加
	int Add(Book b);
	//删除
	int deleteByid(@Param("id") int id);
	//查找
	List<Book> findByid(@Param("id") int id);
	//修改
	int saveByid(Book b);
	//数据总条数
	int getCount();
	List<Book> getpageLists(@Param("start")int start,@Param("pageSize") int pageSize);

}
