package kitri.performinfo.boxweekly.service;

import java.util.List;

import kitri.performinfo.boxweekly.dao.BoxWeeklyDAO;
import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boxservice")
public class BoxWeeklyServiceImpl implements BoxWeeklyService {
	@Autowired
	BoxWeeklyDAO dao;
	
	@Override
	public List<BoxWeeklyDTO> Show_BoxWeekly(String genre) {
		return dao.Show_BoxWeekly(genre);
	}

}
