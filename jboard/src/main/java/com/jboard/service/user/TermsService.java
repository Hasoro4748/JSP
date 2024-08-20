package com.jboard.service.user;

import com.jboard.dao.user.TermsDAO;
import com.jboard.dto.user.TermsDTO;

public enum TermsService {
	
	INSTANCE;
	
	TermsDAO dao = TermsDAO.getinstance();
	
	public TermsDTO selectTermses() {
		return dao.selectTermses();
	}
}
