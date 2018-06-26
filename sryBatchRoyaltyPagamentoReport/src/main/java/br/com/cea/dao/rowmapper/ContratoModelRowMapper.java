package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.ContratoModel;

public class ContratoModelRowMapper implements RowMapper<ContratoModel>{

	@Override
	public ContratoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		ContratoModel model = new ContratoModel();
		model.setId(rs.getLong("NI_CTO_RTY"));
		model.setDataInicio(rs.getDate("DT_INI_VIG_CTO"));
		model.setDataFim(rs.getDate("DT_TOL_REC_ITEM"));
		model.setPeriodicidade(rs.getInt("CD_PER_REP_RTY"));
		return model;
	}

}
