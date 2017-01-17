package kitri.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public void insert(UserVO user) {
		System.out.println(user);
		sqlSession.insert("kitri.perform.user.insert", user);
	
	}

	@Override
	public loginVO login(String user_id, String user_pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", user_id);
		map.put("pass", user_pass);
		System.out.println(map);
		return sqlSession.selectOne("kitri.perform.user.login", map);
	}

	@Override
	public List<UserVO> userList() {
		return sqlSession.selectList("kitri.perform.user.list");
	}

	@Override
	public List<UserVO> delete(String user_id) {
		System.out.println("µé¾î¿Ó³Ä »õ²¥"+user_id);
		return sqlSession.selectList("kitri.perform.user.delete", user_id);
	}

	

	
}
