package kitri.user.dao;

import java.util.List;

import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

public interface UserDAO {
	
	loginVO login(String id, String pass);//로그인
	int insert(UserVO user);//회원가입
	List<UserVO> userList();//user리스트
	List<UserVO> delete(String user_id);//회원삭제
		
		

}
