package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.LancamentoPedidoModel;

public class LancamentoPedidoModelRowMapper implements RowMapper<LancamentoPedidoModel>{

	@Override
	public LancamentoPedidoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		LancamentoPedidoModel model = new LancamentoPedidoModel();
		model.setId(rs.getLong("NI_LCT_CNS_PDO"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		model.setDataRecebementoDevolucaoItem(rs.getDate("DT_FNZ_REC_ITEM"));
		model.setValorBruto(rs.getDouble("VL_BRT_DIRT_AUTL_REC_ITEM"));
		model.setValorLiquido(rs.getDouble("VL_LIQ_DIRT_AUTL_REC_ITEM"));
		model.setCodigoDepartamento(rs.getLong("CD_DPT"));
		model.setCodigoDivisao(rs.getLong("CD_DIV"));
		return model;
	}

}
