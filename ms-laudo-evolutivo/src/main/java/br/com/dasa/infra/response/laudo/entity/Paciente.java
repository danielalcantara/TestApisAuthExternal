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
@JsonPropertyOrder({ "codigoOrigem", "codigoDestino", "nome", "sexo", "dataNascimento" })
public class Paciente {

    @JsonProperty("codigoOrigem")
    private String codigoOrigem;
    @JsonProperty("codigoDestino")
    private String codigoDestino;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("sexo")
    private String sexo;
    @JsonProperty("dataNascimento")
    private String dataNascimento;
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

    @JsonProperty("codigoDestino")
    public String getCodigoDestino() {
        return codigoDestino;
    }

    @JsonProperty("codigoDestino")
    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("sexo")
    public String getSexo() {
        return sexo;
    }

    @JsonProperty("sexo")
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @JsonProperty("dataNascimento")
    public String getDataNascimento() {
        return dataNascimento;
    }

    @JsonProperty("dataNascimento")
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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