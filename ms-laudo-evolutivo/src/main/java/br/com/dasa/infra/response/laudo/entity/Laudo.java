package br.com.dasa.infra.response.laudo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sistemaOrigem", "marcaOrigem", "paciente", "solicitantes", "requisicoes", "tags" })
public class Laudo {

    @JsonProperty("sistemaOrigem")
    private String sistemaOrigem;
    @JsonProperty("marcaOrigem")
    private String marcaOrigem;
    @JsonProperty("paciente")
    private Paciente paciente;
    @JsonProperty("solicitantes")
    private List<Solicitante> solicitantes = null;
    @JsonProperty("requisicoes")
    private List<Requisicao> requisicoes = null;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sistemaOrigem")
    public String getSistemaOrigem() {
        return sistemaOrigem;
    }

    @JsonProperty("sistemaOrigem")
    public void setSistemaOrigem(String sistemaOrigem) {
        this.sistemaOrigem = sistemaOrigem;
    }

    @JsonProperty("marcaOrigem")
    public String getMarcaOrigem() {
        return marcaOrigem;
    }

    @JsonProperty("marcaOrigem")
    public void setMarcaOrigem(String marcaOrigem) {
        this.marcaOrigem = marcaOrigem;
    }

    @JsonProperty("paciente")
    public Paciente getPaciente() {
        return paciente;
    }

    @JsonProperty("paciente")
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @JsonProperty("solicitantes")
    public List<Solicitante> getSolicitantes() {
        return solicitantes;
    }

    @JsonProperty("solicitantes")
    public void setSolicitantes(List<Solicitante> solicitantes) {
        this.solicitantes = solicitantes;
    }

    @JsonProperty("requisicoes")
    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    @JsonProperty("requisicoes")
    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}