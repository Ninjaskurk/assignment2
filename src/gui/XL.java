package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLMenuBar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import javax.swing.JFrame;

import model.SheetModel;
import model.CurrentLabelModel;
import model.StatusModel;

public class XL extends JFrame implements Printable {
	private static final int ROWS = 10, COLUMNS = 8;
	private XLCounter counter;
	private XLList xlList;

	public XL(XL oldXL) {
		this(oldXL.xlList, oldXL.counter);
	}

	public XL(XLList xlList, XLCounter counter) {
		super("Untitled-" + counter);
		this.xlList = xlList;
		this.counter = counter;
		xlList.add(this);
		counter.increment();
		CurrentLabelModel currentLabelModel = new CurrentLabelModel();
		SheetModel sheetModel = new SheetModel();
		StatusModel statusModel = new StatusModel();
		SlotLabels slotLabels = new SlotLabels(ROWS, COLUMNS,
				currentLabelModel, sheetModel);
		SheetPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, slotLabels);
		CurrentLabelController currentLabelController = new CurrentLabelController(
				currentLabelModel, slotLabels);
		CurrentLabel currentLabel = new CurrentLabel(currentLabelModel);
		StatusLabel statusLabel = new StatusLabel(statusModel);
		StatusPanel statusPanel = new StatusPanel(currentLabel, statusLabel);
		Editor editor = new Editor(currentLabelModel, sheetModel);
		SheetController sheetController = new SheetController(sheetModel,
				editor, currentLabelModel, statusModel);
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);

		setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheetModel,
				currentLabelModel, statusModel));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		xlList.setChanged();
	}

	public static void main(String[] args) {
		new XL(new XLList(), new XLCounter());
	}
}