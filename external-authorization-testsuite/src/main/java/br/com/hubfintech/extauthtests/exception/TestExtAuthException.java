package br.com.hubfintech.extauthtests.exception;

public class TestExtAuthException extends Exception {

	private static final long serialVersionUID = 1L;

	public TestExtAuthException() {
		super();
	}
	
	public TestExtAuthException(String message) {
		super(message);
	}

	public TestExtAuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public TestExtAuthException(Throwable cause) {
		super(cause);
	}

}
