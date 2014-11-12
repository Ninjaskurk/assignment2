package gui.menu;

import gui.StatusLabel;
import model.SheetModel;
import model.Slot;
import model.StatusModel;
import model.XLBufferedReader;
import gui.XL;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusModel statusModel,SheetModel sheetModel) {
		super(xl, statusModel, sheetModel, "Load");
	}

	protected void action(String path) throws FileNotFoundException {
		XLBufferedReader bufferedReader = new XLBufferedReader(path);
		Map<String, Slot> newMap = new HashMap<String,Slot>();
		bufferedReader.load(newMap);
		sheetModel.load(newMap);
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}