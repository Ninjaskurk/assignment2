package gui.menu;

import gui.StatusLabel;
import model.CurrentLabelModel;
import model.SheetModel;
import model.StatusModel;
import gui.XL;
import gui.XLList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XLMenuBar extends JMenuBar {
	public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel,
			SheetModel sheetModel, CurrentLabelModel currentLabelModel,
			StatusModel statusModel) {
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		file.add(new PrintMenuItem(xl, statusModel));
		file.add(new SaveMenuItem(xl, statusModel, sheetModel));
		file.add(new LoadMenuItem(xl, statusModel, sheetModel));
		file.add(new NewMenuItem(xl));
		file.add(new CloseMenuItem(xl, xlList));
		edit.add(new ClearMenuItem(sheetModel, currentLabelModel));
		edit.add(new ClearAllMenuItem(sheetModel));
		add(file);
		add(edit);
		add(new WindowMenu(xlList));
	}
}