package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.CurrentLabelModel;
import model.SheetModel;

public class SlotLabels extends GridPanel implements Observer {
	private List<SlotLabel> slotLabelList;
	private CurrentLabelModel currentLabelModel;
	private int rows;
	private int cols;

	public SlotLabels(int rows, int cols, CurrentLabelModel currentLabelModel,
			SheetModel sheetModel) {
		super(rows, cols);
		this.rows = rows;
		this.cols = cols;
		this.currentLabelModel = currentLabelModel;
		currentLabelModel.addObserver(this);
		slotLabelList = new ArrayList<SlotLabel>(rows * cols);
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel slotLabel = new SlotLabel(Integer.toString(row),
						Character.toString(ch), sheetModel);
				add(slotLabel);
				slotLabelList.add(slotLabel);
			}
		}
		currentLabelModel.setLabel(slotLabelList.get(0).toString());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (SlotLabel slotLabel : slotLabelList) {
			if (slotLabel.toString().equals(currentLabelModel.getLabel())) {
				slotLabel.setBackground(Color.YELLOW);
			} else {
				slotLabel.setBackground(Color.WHITE);
			}
		}
	}
}
