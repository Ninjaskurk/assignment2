package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Slot;
import model.SheetModel;

public class SlotLabel extends ColoredLabel implements Observer {
	private String slotLabel;
	private SheetModel sheetModel;

	public SlotLabel(String rowName, String colName, SheetModel sheetModel) {
		super("", Color.WHITE, RIGHT);
		this.sheetModel = sheetModel;
		slotLabel = colName + rowName;
		sheetModel.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Slot tmpSlot = sheetModel.getSlot(slotLabel);
		if (tmpSlot == null) {
			setText("");
		} else {
			setText(tmpSlot.toString(sheetModel));
		}
	}

	public String toString() {
		return slotLabel;
	}
}