package service.user.impl;
import org.apache.ibatis.session.SqlSession;

import Dao.user.UserMapper;
import commons.MyBatisUtils;
import service.user.UserService;
public class UserServiceImpl implements UserService {

	SqlSession sqlSession;
	@Override
	public boolean login(String name, String pwd) {
		sqlSession=MyBatisUtils.createSqlSession();
		int num=sqlSession.getMapper(UserMapper.class).login(name,pwd);
		if (num>0) {
			return true;
		}
		MyBatisUtils.close(sqlSession);
		return false;
	}

}
