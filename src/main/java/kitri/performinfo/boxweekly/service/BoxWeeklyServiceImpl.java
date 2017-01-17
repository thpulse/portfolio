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
	public void Add_BoxWeekly(String genre) {
		dao.Add_BoxWeekly(genre);
	}

	@Override
	public List<BoxWeeklyDTO> Total_BoxWeekly(BoxWeeklyDTO dto) {
		return dao.Total_BoxWeekly(dto);
	}

}
