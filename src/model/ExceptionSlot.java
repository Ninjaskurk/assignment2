package model;

import expr.Environment;
import util.XLException;

public class ExceptionSlot implements Slot {
	public ExceptionSlot() {
	}

	public double getValue(Environment e) {
		throw new XLException("");
	}

	public String toString() {
		return "";
	}

	public String toString(Environment e) {
		return "";

	}
}
