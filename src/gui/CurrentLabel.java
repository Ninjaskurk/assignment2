	package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.CurrentLabelModel;

public class CurrentLabel extends ColoredLabel implements Observer {
	private CurrentLabelModel currentLabelModel;
    public CurrentLabel(CurrentLabelModel currentLabelModel) {
        super("A1", Color.WHITE);
        this.currentLabelModel = currentLabelModel;
        currentLabelModel.addObserver(this);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(currentLabelModel.getLabel());
		
	}
}