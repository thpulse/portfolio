package kitri.user.controller;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;

public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	SecurityLoginService securityService;
	private ShaPasswordEncoder encoder;
	
	public CustomAuthenticationProvider(SecurityLoginService securityService,
			ShaPasswordEncoder encoder) {
		super();
		this.securityService = securityService;
		this.encoder = encoder;
		System.out.println("custom생성(컨트롤러)"+securityService);
	}
	
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String username = authentication.getName();
		String user_pass = (String)authentication.getCredentials();
		Object obj = (String)authentication.getPrincipal();
		
		UsernamePasswordAuthenticationToken loginUser = null;
		System.out.println(username+","+user_pass+","+obj);
		
		User user = (User)securityService.loadUserByUsername(username);
		boolean state = 
				encoder.isPasswordValid(user.getPassword(), user_pass, null);
		if(state){
			System.out.println("성공");
			loginUser = 
					new UsernamePasswordAuthenticationToken(user, 
											user_pass, user.getAuthorities());
		}else{
			System.out.println("실패");
		}
		return loginUser;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		
		return true;
	}

}
