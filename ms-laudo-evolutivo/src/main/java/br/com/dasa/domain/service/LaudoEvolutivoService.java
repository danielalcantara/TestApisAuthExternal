package br.com.dasa.domain.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.domain.bo.ICalculoResultadoExame;
import br.com.dasa.domain.dto.ExameDTO;
import br.com.dasa.domain.dto.ResultadoExameDTO;
import br.com.dasa.domain.repository.ILaudoEvolutivoRepository;
import br.com.dasa.infra.response.laudo.entity.AmostraFull;
import br.com.dasa.infra.response.laudo.entity.Laudo;
import br.com.dasa.infra.response.laudo.entity.Resultado;

@Service
public class LaudoEvolutivoService implements ILaudoEvolutivoService {

	@Autowired
	private ILaudoEvolutivoRepository laudoRepository;

	@Autowired
	private ICalculoResultadoExame calculoResultadoExame;

	@Override
	public List<ExameDTO> getExamesResultByFap(Long fap, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		List<ExameDTO> exameDTOs = new ArrayList<>();
		List<Laudo> laudosByFAP = getLaudoRepository().getLaudosByFap(fap);
		List<Laudo> laudosByCid = new ArrayList<>();

		if (!laudosByFAP.isEmpty()) {
			laudosByCid = getLaudoRepository().getLaudosByCip(
					Long.valueOf(laudosByFAP.get(0).getPaciente().getCodigoOrigem()),
					laudosByFAP.get(0).getMarcaOrigem(), qtdLaudos);
		}

		exameDTOs.addAll(generateListExamesDTO(laudosByCid));

		return exameDTOs;

	}

	@Override
	public List<ExameDTO> getExamesResultByCip(Long cip, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		List<ExameDTO> exameDTOs = new ArrayList<>();
		List<Laudo> laudosbyCid = getLaudoRepository().getLaudosByCip(cip, marcaOrigem, qtdLaudos);

		exameDTOs = generateListExamesDTO(laudosbyCid);

		return exameDTOs;
	}

	private List<ExameDTO> generateListExamesDTO(List<Laudo> laudos) {

		List<ExameDTO> exameDTOs = new ArrayList<>();

		if (laudos != null && !laudos.isEmpty()) {
			laudos.stream().forEach(laudo -> {

				if (laudo.getRequisicoes() != null && !laudo.getRequisicoes().isEmpty()) {
					composeExamesDTOFromLaudos(exameDTOs, laudo);
				}

			});
		}

		return exameDTOs;

	}

	private void composeExamesDTOFromLaudos(List<ExameDTO> exameDTOs, Laudo laudo) {
		laudo.getRequisicoes().stream().forEach(requisicao -> {

			List<AmostraFull> amostras = requisicao.getAmostras();

			if (requisicao.getExames() != null && !requisicao.getExames().isEmpty()) {

				requisicao.getExames().stream().forEach(exame -> {

					ExameDTO exameDTO = new ExameDTO();

					exameDTO.setDataRequisicao(requisicao.getDataRequisicao());
					exameDTO.setNome(exame.getNome());
					exameDTO.setCodigoOrigem(exame.getCodigoOrigem());
					exameDTO.setStatus(exame.getStatus());

					composeExamsResults(exameDTO, exame.getResultados(), amostras);

					exameDTOs.add(exameDTO);

				});

			}

		});
	}

	private void composeExamsResults(ExameDTO exameDTO, List<Resultado> resultados, List<AmostraFull> amostras) {

		resultados.stream().forEach(resultado -> {

			ResultadoExameDTO resultadoExameDTO = new ResultadoExameDTO();

			composeResultSubResult(resultado, resultadoExameDTO, amostras);
			exameDTO.getResultadosExame().add(resultadoExameDTO);

		});

	}

	private void composeResultSubResult(Resultado resultado, ResultadoExameDTO resultadoExameDTO,
			List<AmostraFull> amostras) {

		setValuesResult(resultadoExameDTO, resultado, amostras);

		if (resultado.getSubResultados() != null && !resultado.getSubResultados().isEmpty()) {

			resultado.getSubResultados().stream().forEach(subResult -> {
				ResultadoExameDTO subResultadoExameDTO = new ResultadoExameDTO();
				resultadoExameDTO.getSubResultadosExame().add(subResultadoExameDTO);
				composeResultSubResult(subResult, subResultadoExameDTO, amostras);
			});

		}

	}

	private void setValuesResult(ResultadoExameDTO resultadoExameDTO, Resultado resultado, List<AmostraFull> amostras) {

		resultadoExameDTO.setCodigo(resultado.getCodigo());
		resultadoExameDTO.setDescricao(resultado.getDescricao());
		resultadoExameDTO.setValor(resultado.getValor());
		resultadoExameDTO.setValorReferencia(resultado.getValorReferencia());
		resultadoExameDTO.setStatusResultado(
				calculoResultadoExame.getStatusResultado(resultado.getValor(), resultado.getValorReferencia()));

		AmostraFull amostra = null;

		if (resultado.getAmostra() != null) {
			amostra = amostras.stream().filter(amostraFilter -> Objects.equals(amostraFilter.getSequencia(),
					resultado.getAmostra().getSequencia())).findFirst().orElse(null);
		}

		if (amostra != null) {
			resultadoExameDTO.setDataColeta(amostra.getDataColeta());
		}

	}

	public ILaudoEvolutivoRepository getLaudoRepository() {
		return laudoRepository;
	}

}
