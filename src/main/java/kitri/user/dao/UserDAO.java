package kitri.user.dao;

import java.util.List;

import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

public interface UserDAO {
	
	loginVO login(String id, String pass);//�α���
	void insert(UserVO user);//ȸ������
	List<UserVO> userList();//user����Ʈ
	List<UserVO> delete(String user_id);//ȸ������
		
		

}
