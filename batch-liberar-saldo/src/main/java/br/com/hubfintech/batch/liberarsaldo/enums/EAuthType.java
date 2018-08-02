package br.com.hubfintech.batch.liberarsaldo.enums;

public enum EAuthType {
	
	FINAL_AUTH(1,7),
	UNDEFINED_AUTH(0,7),
	PRE_AUTH(4,30);
	
	private Integer typeCode;
	private int daysForCancellation;
	
	private EAuthType(Integer typeCode, int days) {
		this.typeCode = typeCode;
		this.daysForCancellation = days;
	}
	
	public Integer getTypeCode() {
		return typeCode;
	}

	public int getDays() {
		return daysForCancellation;
	}

}
