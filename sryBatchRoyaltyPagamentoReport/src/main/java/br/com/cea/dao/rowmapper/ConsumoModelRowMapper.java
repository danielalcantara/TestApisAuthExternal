package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.ConsumoModel;

public class ConsumoModelRowMapper implements RowMapper<ConsumoModel>{

	@Override
	public ConsumoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		ConsumoModel model = new ConsumoModel();
		model.setCdItem(rs.getString("CD_ITEM"));
		model.setDataEmsNf(rs.getDate("DT_EMS_NF"));
		model.setDataFnzRecItem(rs.getDate("DT_FNZ_REC_ITEM"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		model.setIdFor(rs.getLong("CD_FOR"));
		model.setNiLocEtc(rs.getLong("NI_LOC_ETG"));
		model.setNumNfItem(rs.getString("NU_NF_ITEM"));
		model.setNuOrdCom(rs.getString("NU_ORD_COM"));
		model.setOrigem(rs.getString("ORIGEM"));
		model.setValorBruto(rs.getDouble("VL_BRU_DIRT_AUTL_REC_ITEM"));
		model.setValorLiquido(rs.getDouble("VL_LIQ_DIRT_AUTL_REC_ITEM"));
		return model;
	}

}
