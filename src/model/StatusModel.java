package model;

import java.util.Observable;

public class StatusModel extends Observable {
	private String statusMessage;

	public void setStatusMessage(String newStatusMessage) {
		statusMessage = newStatusMessage;
		setChanged();
		notifyObservers();

	}

	public String getStatusMessage() {
		return statusMessage;
	}

}
