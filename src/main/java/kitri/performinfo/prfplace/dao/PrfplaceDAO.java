package kitri.performinfo.prfplace.dao;

import java.util.List;

import kitri.performinfo.prfplace.dto.PrfplaceDTO;

public interface PrfplaceDAO {

	void Add_Prfplace();

	List<PrfplaceDTO> Total_PrfPlace();
	
	PrfplaceDTO PrfPlace_Info(PrfplaceDTO plc);


}
