package kitri.performinfo.prfplace.service;

import kitri.performinfo.prfplace.dao.PrfplaceDAO;

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

}
