package br.com.dasa.infra.response.laudo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.dasa.infra.response.laudo.entity.Laudo;
import br.com.dasa.infra.response.laudo.entity.Metadata;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseAPILaudo {
	
	private Metadata metadata;
	private List<Laudo> results;

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public List<Laudo> getResults() {
		return results;
	}

	public void setResults(List<Laudo> results) {
		this.results = results;
	}

}
