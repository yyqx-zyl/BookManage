package service.book.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import Dao.book.BookMapper;
import commons.MyBatisUtils;
import entity.Book;
import service.book.BookService;

public class BookServiceImpl implements BookService {
	private SqlSession sqlSession;
	//显示
	@Override
	public List<Book> getList() {
		sqlSession=MyBatisUtils.createSqlSession();
		List<Book> list=sqlSession.getMapper(BookMapper.class).getList();
		sqlSession.close();
		return list;
	}
	//添加
	@Override
	public boolean Add(Book b) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).Add(b);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	//删除
	@Override
	public boolean deleteByid(int id) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).deleteByid(id);
		System.out.println(num);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	//根据id查找
	@Override
	public List<Book> findByid(int id) {
		sqlSession=MyBatisUtils.createSqlSession();
		List<Book> list=sqlSession.getMapper(BookMapper.class).findByid(id);
		sqlSession.close();
		return list;
	}
	//修改
	@Override
	public boolean saveByid(Book b) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).saveByid(b);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}
	/**
	 * 数据总条数
	 */
	@Override
	public int getCount() {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(BookMapper.class).getCount();
		MyBatisUtils.close(sqlSession);
		return num;
	}
	//获得分页数据
	@Override
	public List getpageLists(int start, int pageSize) {
		sqlSession=MyBatisUtils.createSqlSession();
		List<Book> pageLists=sqlSession.getMapper(BookMapper.class).getpageLists(start,pageSize);
		sqlSession.close();
		return pageLists;
	}

}
