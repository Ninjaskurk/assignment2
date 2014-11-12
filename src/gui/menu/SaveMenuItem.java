package gui.menu;

import gui.StatusLabel;
import model.SheetModel;
import model.XLPrintStream;
import gui.XL;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import model.StatusModel;

class SaveMenuItem extends OpenMenuItem {
	public SaveMenuItem(XL xl, StatusModel statusModel, SheetModel sheetModel) {
		super(xl, statusModel, sheetModel, "Save");
	}

	protected void action(String path) throws FileNotFoundException {
		XLPrintStream printStream;
		printStream = new XLPrintStream(path);
		printStream.save(sheetModel.save());
		printStream.close();

	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}