package kitri.user.service;

import java.util.List;

import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

public interface UserService {
	
	loginVO login(String id, String pass);//�α���	
	void insert(UserVO user);//ȸ������
	List<UserVO> userList();//user����Ʈ

}
