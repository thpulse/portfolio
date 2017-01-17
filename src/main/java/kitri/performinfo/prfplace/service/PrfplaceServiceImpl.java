package kitri.performinfo.prfplace.service;

import java.util.List;

import kitri.performinfo.prfplace.dao.PrfplaceDAO;
import kitri.performinfo.prfplace.dto.PrfplaceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("prfplcservice")
public class PrfplaceServiceImpl implements PrfplaceService {
	@Autowired
	PrfplaceDAO dao;
	
	@Override
	public void Add_Prfplace() {
		dao.Add_Prfplace();
	}
	
	@Override
	public List<PrfplaceDTO> Total_PrfPlace() {
		return dao.Total_PrfPlace();
	}

	@Override
	public PrfplaceDTO PrfPlace_Info(PrfplaceDTO plc) {
		return dao.PrfPlace_Info(plc);
	}


}
