package kitri.user.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<loginVO>{
	
	public loginVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		loginVO login = 
				new loginVO(rs.getString(1),rs.getString(2));
		return login;
				
	}

}
