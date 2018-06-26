package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.PagamentoModel;

public class PagamentoModelRowMapper implements RowMapper<PagamentoModel>{

	@Override
	public PagamentoModel mapRow(ResultSet rs, int arg1) throws SQLException {
		PagamentoModel model = new PagamentoModel();
		Integer stProcesso = rs.getInt("ST_PRO_PAR");
		Integer stProcessoStatus = rs.getInt("ST_PRO_PAR_ST");
		
		if (stProcesso == null || stProcesso.equals(0)) {
			model.setStProcesso(false);
		} else {
			model.setStProcesso(true);
		}
		
		if (stProcessoStatus == null || stProcessoStatus.equals(0)) {
			model.setStProcessoStatus(false);
		} else {
			model.setStProcessoStatus(true);
		}
		
		model.setId(rs.getLong("NI_SEQ_PGT"));
		model.setIdReport(rs.getLong("NI_SEQ_LCN_AGR_PER"));
		model.setIdStatus(rs.getLong("CD_ST_PGT"));
		model.setNumeroContrato(rs.getLong("NI_CTO_RTY"));
		model.setNumeroContratoParcela(rs.getLong("NI_CTO_PAR"));
		model.setNumeroSequencialGarantia(rs.getLong("NI_SEQ_GRT"));
		model.setNumeroSequencialParcela(rs.getLong("NI_SEQ_PAR"));
		model.setDataAltStatus(rs.getDate("DT_ALT_ST"));
		model.setDataAprGes(rs.getDate("DT_APR_GES"));
		model.setDataEtmPgt(rs.getDate("DT_ETM_PGT"));
		model.setDataPagamento(rs.getDate("DT_LCN_PGT"));
		model.setDescStatus(rs.getString("DS_ST_PGT"));
		model.setValorConsumo(rs.getDouble("VLR_CNS_GRT"));
		model.setValorPagamento(rs.getDouble("VLR_TTL_PGO"));
		model.setValorParcela(rs.getDouble("VLR_PGT_PCL"));
		model.setValorSaldo(rs.getDouble("VLR_SLD_PCL_PGA"));
		model.setValorSaldoParcelaPendente(rs.getDouble("VLR_SLD_PCL_NAO_PGA"));
		
		return model;
	}

}
