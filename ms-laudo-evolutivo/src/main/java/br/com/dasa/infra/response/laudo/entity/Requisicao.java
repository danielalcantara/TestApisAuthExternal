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
@JsonPropertyOrder({ "codigoOrigem", "senha", "codigoDestino", "dataRequisicao", "exames", "amostras", "laudoBase64",
        "responsavelTecnico", "comentarios" })
public class Requisicao {

    @JsonProperty("codigoOrigem")
    private String codigoOrigem;
    @JsonProperty("senha")
    private String senha;
    @JsonProperty("codigoDestino")
    private String codigoDestino;
    @JsonProperty("dataRequisicao")
    private String dataRequisicao;
    @JsonProperty("exames")
    private List<Exame> exames = null;
    @JsonProperty("amostras")
    private List<AmostraFull> amostras = null;
    @JsonProperty("laudoBase64")
    private String laudoBase64;
    @JsonProperty("responsavelTecnico")
    private String responsavelTecnico;
    @JsonProperty("comentarios")
    private List<Object> comentarios = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("codigoOrigem")
    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    @JsonProperty("codigoOrigem")
    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    @JsonProperty("senha")
    public String getSenha() {
        return senha;
    }

    @JsonProperty("senha")
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @JsonProperty("codigoDestino")
    public String getCodigoDestino() {
        return codigoDestino;
    }

    @JsonProperty("codigoDestino")
    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    @JsonProperty("dataRequisicao")
    public String getDataRequisicao() {
        return dataRequisicao;
    }

    @JsonProperty("dataRequisicao")
    public void setDataRequisicao(String dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    @JsonProperty("exames")
    public List<Exame> getExames() {
        return exames;
    }

    @JsonProperty("exames")
    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    @JsonProperty("amostras")
    public List<AmostraFull> getAmostras() {
        return amostras;
    }

    @JsonProperty("amostras")
    public void setAmostras(List<AmostraFull> amostras) {
        this.amostras = amostras;
    }

    @JsonProperty("laudoBase64")
    public String getLaudoBase64() {
        return laudoBase64;
    }

    @JsonProperty("laudoBase64")
    public void setLaudoBase64(String laudoBase64) {
        this.laudoBase64 = laudoBase64;
    }

    @JsonProperty("responsavelTecnico")
    public String getResponsavelTecnico() {
        return responsavelTecnico;
    }

    @JsonProperty("responsavelTecnico")
    public void setResponsavelTecnico(String responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
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