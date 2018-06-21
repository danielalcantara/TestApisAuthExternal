package br.com.hubfintech.extauthtests.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class TestModelReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String testId;
	private Integer idx;
	private String status;
	private String action;
	private String accountId;
	private String typeTest;
	private String truncCardNumber;
	private String commerceName;
	private BigDecimal amount;
	private String codeExpected;
	private String codeReturned;
	private String responseCode;
	@Lob
	private String requestJsonMessage;
	@Lob
	private String responseJsonMessage;
	private String requestId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getTypeTest() {
		return typeTest;
	}

	public void setTypeTest(String typeTest) {
		this.typeTest = typeTest;
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

	public String getRequestJsonMessage() {
		return requestJsonMessage;
	}

	public void setRequestJsonMessage(String requestJsonMessage) {
		this.requestJsonMessage = requestJsonMessage;
	}

	public String getResponseJsonMessage() {
		return responseJsonMessage;
	}

	public void setResponseJsonMessage(String responseJsonMessage) {
		this.responseJsonMessage = responseJsonMessage;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

}
