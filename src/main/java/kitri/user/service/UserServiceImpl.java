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
		System.out.println("들어옴?"+user_id);
		return dao.delete(user_id);
	}

	@Override
	public String idsearch(String user_name, String user_tel) {
		System.out.println("서비스 들어옴"+user_name+user_tel);
		return dao.idsearch(user_name, user_tel);
	}

	@Override
	public String passsearch(String user_id, String user_ssn) {
		System.out.println("비번찾으러 서비스"+user_id+user_ssn);
		return dao.passsearch(user_id, user_ssn);
	}
	
	

}
