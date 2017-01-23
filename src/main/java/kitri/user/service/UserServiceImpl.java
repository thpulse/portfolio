package kitri.user.service;

import java.util.List;

import kitri.user.dao.UserDAO;
import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userdao")
	UserDAO dao;
	
	
	@Override
	public int insert(UserVO user) {
		return dao.insert(user);
	}

	@Override
	public loginVO login(String id, String pass) {
		return dao.login(id, pass);
	}

	@Override
	public List<UserVO> userList() {
		return dao.userList();
	}

	@Override
	public List<UserVO> delete(String user_id) {
		System.out.println("µé¾î¿È?"+user_id);
		return dao.delete(user_id);
	}

	

	

}
