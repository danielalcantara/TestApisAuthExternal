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
@JsonPropertyOrder({ "sequencia", "codigo", "descricao", "dataColeta", "material" })
public class AmostraFull {

    @JsonProperty("sequencia")
    private String sequencia;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("dataColeta")
    private String dataColeta;
    @JsonProperty("material")
    private Material material;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sequencia")
    public String getSequencia() {
        return sequencia;
    }

    @JsonProperty("sequencia")
    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("dataColeta")
    public String getDataColeta() {
        return dataColeta;
    }

    @JsonProperty("dataColeta")
    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    @JsonProperty("material")
    public Material getMaterial() {
        return material;
    }

    @JsonProperty("material")
    public void setMaterial(Material material) {
        this.material = material;
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