package kitri.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kitri.user.vo.SecurityLoginVO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityLoginService implements UserDetailsService{
	
	@Autowired
	SqlSession sqlsession;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Map<String,Object> user = 
				sqlsession.selectOne("kitri.perform.user.securityLogin", username);
		System.out.println("user==>"+user);
		UserDetails loginUser = null;
		List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
		gas.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString()));
		
		if(user.get("USER_NAME")==null){
			new SecurityLoginVO(
					user.get("USERNAME").toString(),
					user.get("PASSWORD").toString(),
					true,
					true,
					true,
					true,
					gas,
					user.get("USER_NAME").toString());
			
		}else{
			loginUser = 
				new SecurityLoginVO(
						user.get("USERNAME").toString(),
						user.get("PASSWORD").toString(),
						true,
						true,
						true,
						true,
						gas,
						user.get("USER_PASS2").toString(),
						user.get("USER_NAME").toString(),
						user.get("USER_SSN").toString(),
						user.get("USER_TEL").toString(),
						user.get("USER_EMAIL").toString(),
						user.get("USER_GENDER").toString(),
						user.get("USER_GERNE").toString(),
						user.get("DEL_FLG").toString(),
						user.get("AUTHORITY").toString());
		System.out.println("loginUser==>"+loginUser);
		}
		return loginUser;
	}

}
