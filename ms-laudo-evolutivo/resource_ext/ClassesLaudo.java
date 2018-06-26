-----------------------------------br.com.dasa.Amostra.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sequencia" })
public class Amostra {

    @JsonProperty("sequencia")
    private String sequencia;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

-----------------------------------br.com.dasa.Amostra_.java-----------------------------------

package br.com.dasa;

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
public class Amostra_ {

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
//-----------------------------------br.com.dasa.Exame.java-----------------------------------

package br.com.dasa;

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
    private List<Solicitante_> solicitantes = null;
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
    public List<Solicitante_> getSolicitantes() {
        return solicitantes;
    }

    @JsonProperty("solicitantes")
    public void setSolicitantes(List<Solicitante_> solicitantes) {
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

}-----------------------------------br.com.dasa.Laudo.java-----------------------------------

package br.com.dasa;

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
    private List<Requisico> requisicoes = null;
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
    public List<Requisico> getRequisicoes() {
        return requisicoes;
    }

    @JsonProperty("requisicoes")
    public void setRequisicoes(List<Requisico> requisicoes) {
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

}-----------------------------------br.com.dasa.Material.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codigoIntegracao", "nome" })
public class Material {

    @JsonProperty("codigoIntegracao")
    private String codigoIntegracao;
    @JsonProperty("nome")
    private String nome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("codigoIntegracao")
    public String getCodigoIntegracao() {
        return codigoIntegracao;
    }

    @JsonProperty("codigoIntegracao")
    public void setCodigoIntegracao(String codigoIntegracao) {
        this.codigoIntegracao = codigoIntegracao;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}-----------------------------------br.com.dasa.Metodo.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codigo", "descricao" })
public class Metodo {

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("descricao")
    private String descricao;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}-----------------------------------br.com.dasa.Paciente.java-----------------------------------

package br.com.dasa;

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

}-----------------------------------br.com.dasa.Requisico.java-----------------------------------

package br.com.dasa;

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
public class Requisico {

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
    private List<Amostra_> amostras = null;
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
    public List<Amostra_> getAmostras() {
        return amostras;
    }

    @JsonProperty("amostras")
    public void setAmostras(List<Amostra_> amostras) {
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

}-----------------------------------br.com.dasa.ResponsavelDigitacao.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nome", "complemento" })
public class ResponsavelDigitacao {

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("complemento")
    private String complemento;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonProperty("complemento")
    public String getComplemento() {
        return complemento;
    }

    @JsonProperty("complemento")
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}-----------------------------------br.com.dasa.ResponsavelLiberacao.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nome" })
public class ResponsavelLiberacao {

    @JsonProperty("nome")
    private String nome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}-----------------------------------br.com.dasa.ResponsavelTecnico.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nome" })
public class ResponsavelTecnico {

    @JsonProperty("nome")
    private String nome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("nome")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}-----------------------------------br.com.dasa.Resultado.java-----------------------------------

package br.com.dasa;

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
    private List<Object> subResultados = null;
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
    public List<Object> getSubResultados() {
        return subResultados;
    }

    @JsonProperty("subResultados")
    public void setSubResultados(List<Object> subResultados) {
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

}-----------------------------------br.com.dasa.Solicitante.java-----------------------------------

package br.com.dasa;

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

}-----------------------------------br.com.dasa.Solicitante_.java-----------------------------------

package br.com.dasa;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "sequencia" })
public class Solicitante_ {

    @JsonProperty("sequencia")
    private Long sequencia;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}