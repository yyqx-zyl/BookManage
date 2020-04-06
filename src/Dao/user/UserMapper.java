package Dao.user;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//登录
	int login(@Param("name") String name,  @Param("pwd") String pwd);
}
