package model;

import util.XLException;
import util.XLExceptionArithmetic;
import util.XLExceptionEmptySlot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import expr.Environment;

public class SheetModel extends Observable implements Environment {
	private Map<String, Slot> slots;

	public SheetModel() {
		slots = new HashMap<String, Slot>();
	}

	public double value(String slotLabel){
		Slot tmpSlot = slots.get(slotLabel);
		if (tmpSlot == null) {
			throw new XLExceptionEmptySlot("Empty slot: " + slotLabel);
		}try{
			return tmpSlot.getValue(this);
		} catch (IllegalArgumentException e){
			throw new XLExceptionArithmetic("Divide by 0 in: " + slotLabel);
		}
		

	}

	public void add(String slotLabel, Slot slot) throws IllegalArgumentException{
		Slot originalSlot = slots.get(slotLabel);
		slots.put(slotLabel, new ExceptionSlot());
		try {
			slot.getValue(this);
		} catch (XLExceptionEmptySlot e) {
			slots.put(slotLabel, originalSlot);
			throw new XLException(e.getMessage());
		} catch (XLException e) {
			slots.put(slotLabel, originalSlot);
			throw new XLException("Slot refers to itself: " + slotLabel);
		} catch (IllegalArgumentException e){
			throw new XLExceptionArithmetic("Divide by 0 in: " + slotLabel);
		}
		slots.put(slotLabel, slot);
		setChanged();
		notifyObservers();
	}

	public void remove(String slotLabel) {
		Slot originalSlot = slots.get(slotLabel);
		slots.put(slotLabel, new ExceptionSlot());
		try {
			for (Entry<String, Slot> entry : slots.entrySet()) {
				if (entry.getKey() != slotLabel) {
					entry.getValue().getValue(this);
				}
			}
		} catch (XLException e) {
			slots.put(slotLabel, originalSlot);
			throw new XLException("Other slots depend on: " + slotLabel);
		}
		slots.remove(slotLabel);
		setChanged();
		notifyObservers();
	}

	public Slot getSlot(String slotLabel) {
		return slots.get(slotLabel);
	}

	public void clearAll() {
		slots = new HashMap<String, Slot>();
		setChanged();
		notifyObservers();
	}

	public void load(Map<String, Slot> newMap) {
		slots = newMap;
		setChanged();
		notifyObservers();
	}

	public Map<String, Slot> save() {
		return slots;
	}

}
