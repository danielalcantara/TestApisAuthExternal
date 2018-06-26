package br.com.cea.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import br.com.cea.model.ContratoModel;
import br.com.cea.model.GarantiaModel;
import br.com.cea.model.LancamentoPeriodoModel;
import br.com.cea.model.PagamentoModel;
import br.com.cea.model.PeriodoModel;

public abstract class ResultSetExtractorUtil {

	public static ResultSetExtractor<List<LancamentoPeriodoModel>> getLancamentosPeriodo()
			throws SQLException, DataAccessException {

		return new ResultSetExtractor<List<LancamentoPeriodoModel>>() {

			@Override
			public List<LancamentoPeriodoModel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<LancamentoPeriodoModel> result = new ArrayList<>();

				while (rs.next()) {

					LancamentoPeriodoModel lancamentoPeriodoModel = new LancamentoPeriodoModel();

					lancamentoPeriodoModel.setId(rs.getLong("NI_SEQ_LCT_AGR"));
					lancamentoPeriodoModel.setIdContrato(rs.getLong("NI_CTO_RTY"));
					lancamentoPeriodoModel.setValorBrutoConsolidado(rs.getDouble("VL_DA_BRT_CNS"));
					lancamentoPeriodoModel.setValorLiquidoConsolidado(rs.getDouble("VL_DA_LIQ_CNS"));
					lancamentoPeriodoModel.setDataAlteracaoRegistro(rs.getDate("DT_ALT_REG_GRT"));
					lancamentoPeriodoModel.setCodigoPeriodicidade(rs.getInt("CD_PER_REP_RTY"));
					lancamentoPeriodoModel.setDataInclusaoRegistro(rs.getDate("TS_INC_REG"));
					lancamentoPeriodoModel.setDataInicioReport(rs.getDate("DT_INI_RPT"));
					lancamentoPeriodoModel.setDataFimReport(rs.getDate("DT_FIM_RPT"));
					lancamentoPeriodoModel.setStatusReport(rs.getString("ST_RPT"));
					lancamentoPeriodoModel.setIdPeriodo(rs.getLong("NI_SEQ_GRT"));
					lancamentoPeriodoModel.setValorSaldo(rs.getDouble("VLR_SLD_PCL_PGA"));
					lancamentoPeriodoModel.setValorSaldoParcelaPendente(rs.getDouble("VLR_SLD_PCL_NAO_PGA"));

					result.add(lancamentoPeriodoModel);

				}

				return result;
			}

		};

	}

	public static ResultSetExtractor<PagamentoModel> getPagamentoModel() throws SQLException, DataAccessException {

		return new ResultSetExtractor<PagamentoModel>() {
			@Override
			public PagamentoModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {

					PagamentoModel model = new PagamentoModel();
					Integer stProcesso = rs.getInt("ST_PRO_PAR");
					Integer stProcessoStatus = rs.getInt("ST_PRO_PAR_ST");

					if (stProcesso == null || stProcesso == 0)
						model.setStProcesso(false);
					else
						model.setStProcesso(true);

					if (stProcessoStatus == null || stProcessoStatus == 0)
						model.setStProcessoStatus(false);
					else
						model.setStProcessoStatus(true);

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

					if (model.getIdReport() != null && model.getIdReport() != 0) {
						model.setValorParcela(null);
						model.setNumeroSequencialParcela(null);
						model.setNumeroContratoParcela(null);
						model.setNumeroSequencialGarantia(null);
					}

					return model;

				}

				return null;
			}
		};

	}

	public static ResultSetExtractor<ContratoModel> getContratoComGarantia() throws SQLException, DataAccessException {

		return new ResultSetExtractor<ContratoModel>() {
			@Override
			public ContratoModel extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {

					ContratoModel contrato = new ContratoModel();
					contrato.setId(rs.getLong("NI_CTO_RTY"));
					contrato.setDataInicio(rs.getDate("DT_INI_VIG_CTO"));
					contrato.setDataFim(rs.getDate("DT_TOL_REC_ITEM"));
					contrato.setPeriodicidade(rs.getInt("CD_PER_REP_RTY"));

					GarantiaModel garantia = new GarantiaModel();
					garantia.setId(rs.getLong("NI_CTO_RTY"));
					garantia.setTipo(rs.getString("CD_TPO_GRT"));
					garantia.setValor(rs.getDouble("VL_SLD_GRT_CTO"));
					garantia.setDescTipo(rs.getString("DSC_TPO_GRT"));
					garantia.setNomeClasseNegocio(rs.getString("NM_CLS_NGC"));
					garantia.setIdContrato(rs.getLong("NI_CTO_RTY"));

					contrato.setGarantia(garantia);

					return contrato;

				}

				return null;
			}
		};

	}

	public static ResultSetExtractor<PeriodoModel> getPeriodo() throws SQLException, DataAccessException {

		return new ResultSetExtractor<PeriodoModel>() {
			@Override
			public PeriodoModel extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					PeriodoModel model = new PeriodoModel();
					model.setId(rs.getLong("NI_SEQ_GRT"));
					model.setIdContrato(rs.getLong("NI_CTO_RTY"));
					model.setDataInicio(rs.getDate("DT_INI_PRZ_PAG_PAR_GRT"));
					model.setDataFim(rs.getDate("DT_FIM_PRZ_PAG_PAR_GRT"));
					model.setValor(rs.getDouble("VL_PAR_GRT_CTO_RTY"));

					return model;

				}

				return null;
			}
		};

	}

}
