package model;

import expr.*;

public class CommentSlot implements Slot {
	private String commentString;

	public CommentSlot(String commentString) {
		this.commentString = commentString;
	}

	public double getValue(Environment e) {
		return 0d;
	}

	public String toString() {
		return commentString;
	}

	public String toString(Environment e) {
		return commentString.substring(1);
	}
}
