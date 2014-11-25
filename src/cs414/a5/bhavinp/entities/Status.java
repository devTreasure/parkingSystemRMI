package cs414.a5.bhavinp.entities;

import java.io.Serializable;

public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean status;
	private String message;

	public Status(Boolean status, String errorMessage) {
		super();
		this.status = status;
		this.message = errorMessage;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccessMessage() {
		return true == status;
	}

	public boolean isFailureMessage() {
		return false == status;
	}

}
