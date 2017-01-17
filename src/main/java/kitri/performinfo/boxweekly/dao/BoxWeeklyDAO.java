package kitri.performinfo.boxweekly.dao;

import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;


public interface BoxWeeklyDAO {

	void Add_BoxWeekly(String genre);

	List<BoxWeeklyDTO> Total_BoxWeekly(BoxWeeklyDTO dto);

}
