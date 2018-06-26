package br.com.dasa.infra;

import java.io.IOException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.infra.response.laudo.ResponseAPILaudo;

public interface ILaudoEvolutivoInfra {

	public ResponseAPILaudo getResponseFromFap(Long fap)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

	public ResponseAPILaudo getResponseFromCip(Long cid, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

}
