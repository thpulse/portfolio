package kitri.performinfo.boxweekly.service;

import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;


public interface BoxWeeklyService {

	void Add_BoxWeekly(String genre);

	List<BoxWeeklyDTO> Total_BoxWeekly(BoxWeeklyDTO dto);

}
