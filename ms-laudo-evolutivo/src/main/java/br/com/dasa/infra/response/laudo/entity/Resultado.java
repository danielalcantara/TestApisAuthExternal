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
@JsonPropertyOrder({ "sequencia", "tipo", "codigo", "codigoAlternativo", "descricao", "metodo", "valor",
        "valorNaoFormatado", "unidadeMedida", "valorReferencia", "subResultados", "dataLiberacao", "dataDigitacao",
        "responsavelLiberacao", "responsavelDigitacao", "tags", "amostra", "comentarios" })
public class Resultado {

    @JsonProperty("sequencia")
    private Long sequencia;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("codigoAlternativo")
    private String codigoAlternativo;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("metodo")
    private Metodo metodo;
    @JsonProperty("valor")
    private String valor;
    @JsonProperty("valorNaoFormatado")
    private String valorNaoFormatado;
    @JsonProperty("unidadeMedida")
    private String unidadeMedida;
    @JsonProperty("valorReferencia")
    private String valorReferencia;
    @JsonProperty("subResultados")
    private List<Resultado> subResultados = null;
    @JsonProperty("dataLiberacao")
    private String dataLiberacao;
    @JsonProperty("dataDigitacao")
    private String dataDigitacao;
    @JsonProperty("responsavelLiberacao")
    private ResponsavelLiberacao responsavelLiberacao;
    @JsonProperty("responsavelDigitacao")
    private ResponsavelDigitacao responsavelDigitacao;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("amostra")
    private Amostra amostra;
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

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JsonProperty("codigoAlternativo")
    public String getCodigoAlternativo() {
        return codigoAlternativo;
    }

    @JsonProperty("codigoAlternativo")
    public void setCodigoAlternativo(String codigoAlternativo) {
        this.codigoAlternativo = codigoAlternativo;
    }

    @JsonProperty("descricao")
    public String getDescricao() {
        return descricao;
    }

    @JsonProperty("descricao")
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("metodo")
    public Metodo getMetodo() {
        return metodo;
    }

    @JsonProperty("metodo")
    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    @JsonProperty("valor")
    public String getValor() {
        return valor;
    }

    @JsonProperty("valor")
    public void setValor(String valor) {
        this.valor = valor;
    }

    @JsonProperty("valorNaoFormatado")
    public String getValorNaoFormatado() {
        return valorNaoFormatado;
    }

    @JsonProperty("valorNaoFormatado")
    public void setValorNaoFormatado(String valorNaoFormatado) {
        this.valorNaoFormatado = valorNaoFormatado;
    }

    @JsonProperty("unidadeMedida")
    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    @JsonProperty("unidadeMedida")
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @JsonProperty("valorReferencia")
    public String getValorReferencia() {
        return valorReferencia;
    }

    @JsonProperty("valorReferencia")
    public void setValorReferencia(String valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    @JsonProperty("subResultados")
    public List<Resultado> getSubResultados() {
        return subResultados;
    }

    @JsonProperty("subResultados")
    public void setSubResultados(List<Resultado> subResultados) {
        this.subResultados = subResultados;
    }

    @JsonProperty("dataLiberacao")
    public String getDataLiberacao() {
        return dataLiberacao;
    }

    @JsonProperty("dataLiberacao")
    public void setDataLiberacao(String dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    @JsonProperty("dataDigitacao")
    public String getDataDigitacao() {
        return dataDigitacao;
    }

    @JsonProperty("dataDigitacao")
    public void setDataDigitacao(String dataDigitacao) {
        this.dataDigitacao = dataDigitacao;
    }

    @JsonProperty("responsavelLiberacao")
    public ResponsavelLiberacao getResponsavelLiberacao() {
        return responsavelLiberacao;
    }

    @JsonProperty("responsavelLiberacao")
    public void setResponsavelLiberacao(ResponsavelLiberacao responsavelLiberacao) {
        this.responsavelLiberacao = responsavelLiberacao;
    }

    @JsonProperty("responsavelDigitacao")
    public ResponsavelDigitacao getResponsavelDigitacao() {
        return responsavelDigitacao;
    }

    @JsonProperty("responsavelDigitacao")
    public void setResponsavelDigitacao(ResponsavelDigitacao responsavelDigitacao) {
        this.responsavelDigitacao = responsavelDigitacao;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("amostra")
    public Amostra getAmostra() {
        return amostra;
    }

    @JsonProperty("amostra")
    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
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