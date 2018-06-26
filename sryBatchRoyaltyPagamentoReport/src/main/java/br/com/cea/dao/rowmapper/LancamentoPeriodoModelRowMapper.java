package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.LancamentoPeriodoModel;

public class LancamentoPeriodoModelRowMapper implements RowMapper<LancamentoPeriodoModel> {

	@Override
	public LancamentoPeriodoModel mapRow(ResultSet rs, int arg1) throws SQLException {

		LancamentoPeriodoModel model = new LancamentoPeriodoModel();
		
		model.setId(rs.getLong("NI_SEQ_LCT_AGR"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		model.setValorBrutoConsolidado(rs.getDouble("VL_DA_BRT_CNS"));
		model.setValorLiquidoConsolidado(rs.getDouble("VL_DA_LIQ_CNS"));
		model.setDataAlteracaoRegistro(rs.getDate("DT_ALT_REG_GRT"));
		model.setCodigoPeriodicidade(rs.getInt("CD_PER_REP_RTY"));
		model.setDataInclusaoRegistro(rs.getDate("TS_INC_REG"));
		model.setDataInicioReport(rs.getDate("DT_INI_RPT"));
		model.setDataFimReport(rs.getDate("DT_FIM_RPT"));
		model.setStatusReport(rs.getString("ST_RPT"));
		model.setIdPeriodo(rs.getLong("NI_SEQ_GRT"));
		model.setValorSaldo(rs.getDouble("VLR_SLD_PCL_PGA"));
		model.setValorSaldoParcelaPendente(rs.getDouble("VLR_SLD_PCL_NAO_PGA"));

		return model;

	}

}
