package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.GarantiaModel;

public class GarantiaModelRowMapper implements RowMapper<GarantiaModel>{

	@Override
	public GarantiaModel mapRow(ResultSet rs, int arg1) throws SQLException {
		GarantiaModel model = new GarantiaModel();
		model.setId(rs.getLong("NI_CTO_RTY"));
		model.setTipo(rs.getString("CD_TPO_GRT"));
		model.setValor(rs.getDouble("VL_SLD_GRT_CTO"));
		model.setDescTipo(rs.getString("DSC_TPO_GRT"));
		model.setNomeClasseNegocio(rs.getString("NM_CLS_NGC"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		return model;
	}

}
