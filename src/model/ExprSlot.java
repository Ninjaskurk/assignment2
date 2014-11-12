package model;

import expr.*;

public class ExprSlot implements Slot {
	private Expr expr;

	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double getValue(Environment e) throws IllegalArgumentException {
		return expr.value(e);
	}

	public String toString() {
		return expr.toString();
	}

	public String toString(Environment e) {
		return String.valueOf(expr.value(e));
	}

}
