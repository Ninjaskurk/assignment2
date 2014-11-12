package gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.CurrentLabelModel;

public class CurrentLabelController implements MouseListener {
	private CurrentLabelModel currentLabelModel;
	private SlotLabels slotLabels;

	public CurrentLabelController(CurrentLabelModel currentLabelModel,
			SlotLabels slotLabels) {
		this.currentLabelModel = currentLabelModel;
		this.slotLabels = slotLabels;
		slotLabels.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component comp = slotLabels.getComponentAt(e.getPoint());
		if (comp instanceof SlotLabel) {
			currentLabelModel.setLabel(((SlotLabel) comp).toString());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
