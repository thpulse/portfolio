package kitri.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kitri.user.vo.UserVO;
import kitri.user.vo.loginVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int insert(UserVO user) {
		System.out.println(user);
		return sqlSession.insert("kitri.perform.user.insert", user);
	
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
		System.out.println("들어왓냐 새꺄"+user_id);
		return sqlSession.selectList("kitri.perform.user.delete", user_id);
	}

	@Override
	public String idsearch(String user_name, String user_tel) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_name", user_name);
		map.put("user_tel", user_tel);
		System.out.println("아이디 찾아주냐???"+map);
		return sqlSession.selectOne("kitri.perform.user.idsearch", map);
	}

	@Override
	public String passsearch(String user_id, String user_ssn) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_ssn", user_ssn);
		System.out.println("비밀번호 찾는중이냐???"+map);
		return sqlSession.selectOne("kitri.perform.user.passsearch", map);
	}



	
}
