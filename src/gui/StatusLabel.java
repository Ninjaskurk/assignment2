package gui;

import java.awt.Color;
import model.StatusModel;
import java.util.Observable;
import java.util.Observer;

public class StatusLabel extends ColoredLabel implements Observer {
    private StatusModel statusModel;
	public StatusLabel(StatusModel statusModel) {
        super(statusModel.getStatusMessage(), Color.WHITE);
        this.statusModel = statusModel;
        statusModel.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText(statusModel.getStatusMessage());
    }
}