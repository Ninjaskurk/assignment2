package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.util.Observable;
import java.util.Observer;

import model.CurrentLabelModel;

public class StatusPanel extends BorderPanel {
	protected StatusPanel(CurrentLabel currentLabel, StatusLabel statusLabel) {
		add(WEST, currentLabel);
		add(CENTER, statusLabel);
	}
}