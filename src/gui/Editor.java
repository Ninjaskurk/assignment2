package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.CurrentLabelModel;
import model.Slot;
import model.SheetModel;

public class Editor extends JTextField implements Observer {
	private CurrentLabelModel currentLabelModel;
	private SheetModel sheetModel;

	public Editor(CurrentLabelModel currentCurrentSlotModel, SheetModel sheetModel) {
		this.currentLabelModel = currentCurrentSlotModel;
		this.sheetModel = sheetModel;
		currentCurrentSlotModel.addObserver(this);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		try {
			Slot slot = sheetModel.getSlot(currentLabelModel.getLabel());
			setText(slot.toString());
		} catch (Exception e) {
			setText("");
		}
		
		
	}

}