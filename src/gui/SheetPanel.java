package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.WEST;
import static java.awt.Color.LIGHT_GRAY;
import static javax.swing.SwingConstants.RIGHT;

import java.awt.Dimension;

import model.CurrentLabelModel;
import model.SheetModel;

public class SheetPanel extends BorderPanel {
	public static final int COLUMNWIDTH = 80;
	public static final int ROWHEIGTH = 0;
	private SlotLabels slotLabels;

	public SheetPanel(int rows, int cols,SlotLabels slotLabels) {
		BorderPanel borderPanelLeft = new BorderPanel();
		BorderPanel borderPanelRight = new BorderPanel();
		borderPanelRight.add(NORTH, new ColumnLabels(cols));
		borderPanelRight.add(CENTER, slotLabels);
		borderPanelRight.setPreferredSize(new Dimension(cols * COLUMNWIDTH,
				rows * ROWHEIGTH));
		GridPanel gridPanelEmpty = new GridPanel(1, 1);
		gridPanelEmpty.add(new ColoredLabel(" ", LIGHT_GRAY, RIGHT));
		borderPanelLeft.add(NORTH, gridPanelEmpty);
		borderPanelLeft.add(CENTER, new RowLabels(rows));
		add(WEST, borderPanelLeft);
		add(CENTER, borderPanelRight);
	}

	public SlotLabels getSlotLabels() {
		return slotLabels;
	}
}