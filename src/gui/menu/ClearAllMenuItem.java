package gui.menu;

import java.awt.event.ActionEvent;
import model.SheetModel;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private SheetModel sheetModel;
	public ClearAllMenuItem(SheetModel sheetModel) {
        super("Clear all");
        this.sheetModel = sheetModel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	sheetModel.clearAll();
        
    }
}