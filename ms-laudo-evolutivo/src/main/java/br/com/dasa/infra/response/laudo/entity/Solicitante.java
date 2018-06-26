package br.com.dasa.infra.response.laudo.entity;

import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sequencia", "nome", "ufConselho", "numeroConselho" })
public class Solicitante {

    @JsonProperty("sequencia")
    private Long sequencia;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("ufConselho")
    private String ufConselho;
    @JsonProperty("numeroConselho")
    private String numeroConselho;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sequencia")
    public Long getSequencia() {
        return sequencia;
    }

    @JsonProperty("sequencia")
    public void setSequencia(Long sequencia) {
        this.sequencia = sequencia;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("ufConselho")
    public String getUfConselho() {
        return ufConselho;
    }

    @JsonProperty("ufConselho")
    public void setUfConselho(String ufConselho) {
        this.ufConselho = ufConselho;
    }

    @JsonProperty("numeroConselho")
    public String getNumeroConselho() {
        return numeroConselho;
    }

    @JsonProperty("numeroConselho")
    public void setNumeroConselho(String numeroConselho) {
        this.numeroConselho = numeroConselho;
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