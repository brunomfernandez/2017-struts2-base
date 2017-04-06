package utn.frd.bean;

public class MessageStore {
	private String message;

	public MessageStore() {

		setMessage("Hello User, this is a message from MessageStore object.");
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}
}
