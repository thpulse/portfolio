package kitri.performinfo.boxweekly.dao;

import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;


public interface BoxWeeklyDAO {

	List<BoxWeeklyDTO> Show_BoxWeekly(String genre);

}
