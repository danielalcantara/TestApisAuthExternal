package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.PeriodoModel;

public class PeriodoModelRowMapper implements RowMapper<PeriodoModel>{

	@Override
	public PeriodoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		PeriodoModel model = new PeriodoModel();
		model.setId(rs.getLong("NI_SEQ_GRT"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		model.setDataInicio(rs.getDate("DT_INI_PRZ_PAG_PAR_GRT"));
		model.setDataFim(rs.getDate("DT_FIM_PRZ_PAG_PAR_GRT"));
		model.setValor(rs.getDouble("VL_PAR_GRT_CTO_RTY"));
		return model;
	}

}
