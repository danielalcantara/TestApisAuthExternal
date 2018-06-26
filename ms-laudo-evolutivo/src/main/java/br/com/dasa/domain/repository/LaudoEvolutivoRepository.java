package br.com.dasa.domain.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.infra.ILaudoEvolutivoInfra;
import br.com.dasa.infra.response.laudo.ResponseAPILaudo;
import br.com.dasa.infra.response.laudo.entity.Laudo;

@Repository
public class LaudoEvolutivoRepository implements ILaudoEvolutivoRepository {

	@Autowired
	private ILaudoEvolutivoInfra laudoInfra;

	@Override
	public List<Laudo> getLaudosByFap(Long fap)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		ResponseAPILaudo responseAPILaudo = laudoInfra.getResponseFromFap(fap);

		return getLaudosFromResponseAPILaudo(responseAPILaudo);

	}

	@Override
	public List<Laudo> getLaudosByCip(Long cip, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException {

		ResponseAPILaudo responseAPILaudo = laudoInfra.getResponseFromCip(cip, marcaOrigem, qtdLaudos);

		return getLaudosFromResponseAPILaudo(responseAPILaudo);

	}

	private List<Laudo> getLaudosFromResponseAPILaudo(ResponseAPILaudo responseAPILaudo) {
		List<Laudo> laudos = new ArrayList<>();

		if (responseAPILaudo != null && responseAPILaudo.getResults() != null
				&& !responseAPILaudo.getResults().isEmpty()) {
			laudos.addAll(responseAPILaudo.getResults());
		}

		return laudos;
	}

}
