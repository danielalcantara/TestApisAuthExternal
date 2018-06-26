package br.com.dasa.domain.repository;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.infra.response.laudo.entity.Laudo;

public interface ILaudoEvolutivoRepository {

	public List<Laudo> getLaudosByFap(Long fap)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

	public List<Laudo> getLaudosByCip(Long cip, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

}
