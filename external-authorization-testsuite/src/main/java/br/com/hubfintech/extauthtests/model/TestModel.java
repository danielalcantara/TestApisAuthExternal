package br.com.hubfintech.extauthtests.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.hubfintech.extauthtests.enums.EStatusTest;
import br.com.valepresente.kharon.external.enums.EAction;

public class TestModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer index;
	private EStatusTest status;
	private EAction action;
	private String accountId;
	private String type;
	private String truncCardNumber;
	private String commerceName;
	private BigDecimal amount;
	private String codeExpected;
	private String codeReturned;
	private String responseCode;
	private String requestJson;
	private String responseJson;
	private String requestJsonMessage;
	private String responseJsonMessage;
	private String requestId;

	public EStatusTest getStatus() {
		return status;
	}

	public void setStatus(EStatusTest status) {
		this.status = status;
	}

	public EAction getAction() {
		return action;
	}

	public void setAction(EAction action) {
		this.action = action;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTruncCardNumber() {
		return truncCardNumber;
	}

	public void setTruncCardNumber(String truncCardNumber) {
		this.truncCardNumber = truncCardNumber;
	}

	public String getCommerceName() {
		return commerceName;
	}

	public void setCommerceName(String commerceName) {
		this.commerceName = commerceName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCodeExpected() {
		return codeExpected;
	}

	public void setCodeExpected(String codeExpected) {
		this.codeExpected = codeExpected;
	}

	public String getCodeReturned() {
		return codeReturned;
	}

	public void setCodeReturned(String codeReturned) {
		this.codeReturned = codeReturned;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getRequestJson() {
		return requestJson;
	}

	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getResponseJsonMessage() {
		return responseJsonMessage;
	}

	public void setResponseJsonMessage(String responseJsonMessage) {
		this.responseJsonMessage = responseJsonMessage;
	}

	public String getRequestJsonMessage() {
		return requestJsonMessage;
	}

	public void setRequestJsonMessage(String requestJsonMessage) {
		this.requestJsonMessage = requestJsonMessage;
	}

	public String getActionUpperCase() {
		return action.toString().toUpperCase();
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
