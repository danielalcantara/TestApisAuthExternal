package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.cea.model.PagamentoModel;
import br.com.cea.model.ParcelaModel;

public class ParcelaModelRowMapper implements RowMapper<ParcelaModel> {

	@Override
	public ParcelaModel mapRow(ResultSet rs, int arg1) throws SQLException {
		ParcelaModel model = new ParcelaModel();
		boolean stProcesso = rs.getLong("ST_PRO_PAR") == 0 ? false : true;
		boolean stProcessoStatus = rs.getLong("ST_PRO_PAR_ST") == 0 ? false : true;

		model.setId(rs.getLong("NI_SEQ_PAR"));
		model.setIdPeriodo(rs.getLong("NI_SEQ_GRT"));
		model.setIdContrato(rs.getLong("NI_CTO_RTY"));
		model.setDataVencimento(rs.getDate("DT_PGT_GRT"));
		model.setValor(rs.getDouble("VL_PAR_GRT"));

		PagamentoModel pagamentoModel = new PagamentoModel();
		pagamentoModel.setId(rs.getLong("NI_SEQ_PGT"));
		pagamentoModel.setNumeroContrato(rs.getLong("NI_CTO_RTY"));
		pagamentoModel.setValorParcela(rs.getDouble("VLR_PGT_PCL"));
		pagamentoModel.setValorConsumo(rs.getDouble("VLR_CNS_GRT"));
		pagamentoModel.setValorPagamento(rs.getDouble("VLR_TTL_PGO"));
		pagamentoModel.setValorSaldo(rs.getDouble("VLR_SLD_PCL_PGA"));
		pagamentoModel.setValorSaldoParcelaPendente(rs.getDouble("VLR_SLD_PCL_NAO_PGA"));
		pagamentoModel.setNumeroContratoParcela(rs.getLong("NI_CTO_PAR"));
		pagamentoModel.setNumeroSequencialGarantia(rs.getLong("NI_SEQ_GRT"));
		pagamentoModel.setNumeroSequencialParcela(rs.getLong("NI_SEQ_PAR"));
		pagamentoModel.setIdStatus(rs.getLong("CD_ST_PGT"));
		pagamentoModel.setDescStatus(rs.getString("DS_ST_PGT"));
		pagamentoModel.setDataAltStatus(rs.getDate("DT_ALT_ST"));
		pagamentoModel.setDataAprGes(rs.getDate("DT_APR_GES"));
		pagamentoModel.setDataEtmPgt(rs.getDate("DT_ETM_PGT"));
		pagamentoModel.setDataPagamento(rs.getDate("DT_LCN_PGT"));
		pagamentoModel.setStProcesso(stProcesso);
		pagamentoModel.setStProcessoStatus(stProcessoStatus);

		model.setPagamento(pagamentoModel);

		return model;
	}

}
