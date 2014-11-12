package gui.menu;

import java.awt.event.ActionEvent;
import model.SheetModel;
import model.CurrentLabelModel;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private SheetModel sheetModel;
	private CurrentLabelModel currentLabelModel;
	public ClearMenuItem(SheetModel sheetModel,CurrentLabelModel currentLabelModel) {
        super("Clear");
        addActionListener(this);
        this.sheetModel = sheetModel;
        this.currentLabelModel = currentLabelModel;
    }

    public void actionPerformed(ActionEvent e) {
        sheetModel.remove(currentLabelModel.getLabel());
    }
}