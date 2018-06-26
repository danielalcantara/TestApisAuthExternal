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
@JsonPropertyOrder({ "sequencia", "status", "codigoOrigem", "nome", "solicitantes", "responsavelTecnico", "resultados",
        "tags", "comentarios" })
public class Exame {

    @JsonProperty("sequencia")
    private Long sequencia;
    @JsonProperty("status")
    private String status;
    @JsonProperty("codigoOrigem")
    private String codigoOrigem;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("solicitantes")
    private List<SolicitanteSimple> solicitantes = null;
    @JsonProperty("responsavelTecnico")
    private ResponsavelTecnico responsavelTecnico;
    @JsonProperty("resultados")
    private List<Resultado> resultados = null;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("comentarios")
    private List<Object> comentarios = null;
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

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("codigoOrigem")
    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    @JsonProperty("codigoOrigem")
    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("solicitantes")
    public List<SolicitanteSimple> getSolicitantes() {
        return solicitantes;
    }

    @JsonProperty("solicitantes")
    public void setSolicitantes(List<SolicitanteSimple> solicitantes) {
        this.solicitantes = solicitantes;
    }

    @JsonProperty("responsavelTecnico")
    public ResponsavelTecnico getResponsavelTecnico() {
        return responsavelTecnico;
    }

    @JsonProperty("responsavelTecnico")
    public void setResponsavelTecnico(ResponsavelTecnico responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    @JsonProperty("resultados")
    public List<Resultado> getResultados() {
        return resultados;
    }

    @JsonProperty("resultados")
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("comentarios")
    public List<Object> getComentarios() {
        return comentarios;
    }

    @JsonProperty("comentarios")
    public void setComentarios(List<Object> comentarios) {
        this.comentarios = comentarios;
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