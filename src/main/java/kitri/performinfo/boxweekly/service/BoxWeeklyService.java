package kitri.performinfo.boxweekly.service;

import java.util.List;

import kitri.performinfo.boxweekly.dto.BoxWeeklyDTO;


public interface BoxWeeklyService {

	List<BoxWeeklyDTO> Show_BoxWeekly(String genre);

}
