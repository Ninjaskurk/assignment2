package gui.menu;

import gui.StatusLabel;
import model.SheetModel;
import model.StatusModel;
import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class OpenMenuItem extends JMenuItem implements ActionListener {
    protected StatusModel statusModel;
    protected SheetModel sheetModel;
    protected XL xl;
    

    protected OpenMenuItem(XL xl, StatusModel statusModel, SheetModel sheetModel, String title) {
        super(title);
        this.xl = xl;
        this.statusModel = statusModel;
        this.sheetModel = sheetModel;
        addActionListener(this);
    }

    protected abstract void action(String path) throws FileNotFoundException;

    public void actionPerformed(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser(".");
        FileFilter filter = new FileNameExtensionFilter("XL files", "xl");
        fileChooser.setFileFilter(filter);
        int option = openDialog(fileChooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                action(file.toString());
                xl.rename(file.getName());
            } catch (FileNotFoundException e) {
                statusModel.setStatusMessage(e.getMessage());
            }
        }
    }

    protected abstract int openDialog(JFileChooser fileChooser);
}