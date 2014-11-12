package model;

import java.util.Observable;

public class CurrentLabelModel extends Observable {
	private String currentLabel = "";

	public void setLabel(String newLabel) {
		if (currentLabel == null || currentLabel != newLabel) {
			currentLabel = newLabel;
			setChanged();
			notifyObservers(currentLabel);
		}
	}

	public String getLabel(){
		return currentLabel;
	}
	
}

