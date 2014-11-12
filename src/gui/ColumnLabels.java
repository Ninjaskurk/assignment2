package gui;

import static java.awt.Color.LIGHT_GRAY;
import static javax.swing.SwingConstants.CENTER;

class ColumnLabels extends GridPanel {
	ColumnLabels(int cols) {
		super(1, cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), LIGHT_GRAY, CENTER));
		}
	}
}