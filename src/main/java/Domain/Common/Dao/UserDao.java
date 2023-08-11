package Domain.Common.Dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Domain.Common.Dto.UserDto;

public interface UserDao {

	int insert(UserDto dto) throws Exception;

	List<UserDto> selectAll() throws Exception;

	UserDto select(String id) throws Exception;

	int update(UserDto dto) throws Exception;

	int delete(String id) throws Exception;
	
	int isDupulicate(String id);

}
	
