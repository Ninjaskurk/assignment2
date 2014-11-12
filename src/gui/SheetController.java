package gui;

import util.XLException;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.StatusModel;
import model.CurrentLabelModel;
import model.SlotFactory;
import model.SheetModel;

public class SheetController implements ActionListener {
	private SheetModel sheetModel;
	private Editor editor;
	private CurrentLabelModel currentLabelModel;
	private SlotFactory slotFactory = new SlotFactory();
	private StatusModel statusModel;

	public SheetController(SheetModel sheetModel, Editor editor,
			CurrentLabelModel currentLabelModel,StatusModel statusModel) {
		this.sheetModel = sheetModel;
		this.editor = editor;
		this.currentLabelModel = currentLabelModel;
		this.statusModel = statusModel;
		editor.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String slotLabel = currentLabelModel.getLabel();
		String text = editor.getText();
		try {
			if (text.isEmpty()) {
				sheetModel.remove(slotLabel);
			} else {
				sheetModel.add(slotLabel, slotFactory.createSlot(text));
			}
			statusModel.setStatusMessage("Updated:" +currentLabelModel.getLabel());
		} catch (XLException e) {
			statusModel.setStatusMessage(e.getMessage());
		}
		
	}	
}
