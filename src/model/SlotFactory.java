package model;
import java.io.IOException;

import util.XLException;
import expr.ExprParser;
import expr.Environment;


public class SlotFactory {
	private ExprParser exprParser;
	public SlotFactory(){
		exprParser = new ExprParser();
	
	}
	public Slot createSlot(String s) throws XLException{
		if (s.isEmpty()){
			return null;
		}
		if (s.charAt(0) == '#'){
			return new CommentSlot(s);
		}
		try {
			ExprSlot exprSlot = new ExprSlot(exprParser.build(s));
			return exprSlot;
		} catch (IOException e) {
			return null;
		}
		
		
	}
}
