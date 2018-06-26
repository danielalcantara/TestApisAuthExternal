package br.com.cea.enumerator;

public enum TipoProcessarPagamentoReportEnum {
	TIPO1("GMPUI", "ProcessarPagamentoReportGMPUI"),
	TIPO2("GMP1", "ProcessarPagamentoReportGMP1"),
	TIPO3("GMP2", "ProcessarPagamentoReportGMP2"),
	TIPO4("GMP4", "ProcessarPagamentoReportGMP4");
	
	private String tipo;
	private String className;
    
	TipoProcessarPagamentoReportEnum(String tipo, String className) {
    	this.tipo = tipo;
    	this.className = className;
    }
    
    public String tipo() {
    	return tipo;
    }
    
    public String className() {
    	return className;
    }
}
