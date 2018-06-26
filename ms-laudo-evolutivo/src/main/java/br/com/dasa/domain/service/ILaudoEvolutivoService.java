package br.com.dasa.domain.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.dasa.domain.dto.ExameDTO;
import br.com.dasa.domain.repository.ILaudoEvolutivoRepository;

public interface ILaudoEvolutivoService {

	public List<ExameDTO> getExamesResultByFap(Long fap, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

	public List<ExameDTO> getExamesResultByCip(Long cip, String marcaOrigem, Integer qtdLaudos)
			throws JsonParseException, JsonMappingException, IOException, JSONException;

	public ILaudoEvolutivoRepository getLaudoRepository();

}
