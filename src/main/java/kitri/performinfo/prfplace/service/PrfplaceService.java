package kitri.performinfo.prfplace.service;

import java.util.List;

import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface PrfplaceService {

	void Add_Prfplace();

	List<PrfplaceDTO> Total_PrfPlace();
	
	PrfplaceDTO PrfPlace_Info(PrfplaceDTO plc);


}
