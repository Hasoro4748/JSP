package com.jboard.dao.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboard.dto.user.TermsDTO;

import util.DBHelper;
import util.SQL;

public class TermsDAO extends DBHelper{
	private static TermsDAO instance = new TermsDAO();
	public static TermsDAO getinstance() {
		return instance;
	}
	private TermsDAO() {};
	
	private Logger logger = LoggerFactory.getLogger("TermsDAO");
	
	public TermsDTO selectTermses() {
		TermsDTO dto = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);
			
			if(rs.next()) {
				dto = new TermsDTO();
				dto.setTerms(rs.getString(1));
				dto.setPrivacy(rs.getString(2));
			}
			closeAll();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return dto;
	}
}
