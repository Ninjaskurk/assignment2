package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.XLException;

class TestReaderPrinter {
	public static void main(String[] args) {
		String fileName = "testReaderPrinter";
		SlotFactory sf = new SlotFactory();
		XLPrintStream ps;
		XLBufferedReader br;

		HashMap<String, Slot> originalMap = new HashMap<String, Slot>();
		originalMap.put("A1", sf.createSlot("a1*b1+1"));
		originalMap.put("A2", sf.createSlot("1+2"));
		originalMap.put("B2", sf.createSlot("#1234"));
		originalMap.put("B1", sf.createSlot("#="));
		originalMap.put("C1", sf.createSlot("1"));
		originalMap.put("C2", sf.createSlot("2"));

		try {
			ps = new XLPrintStream(fileName);
			ps.save(originalMap);
		} catch (FileNotFoundException e) {
			System.out.println("Printer didnt find file");
		}

		HashMap<String, Slot> newMap = new HashMap<String, Slot>();
		try {
			br = new XLBufferedReader(fileName);
			br.load(newMap);
		} catch (FileNotFoundException e) {
			System.out.println("Reader didnt find file");
		}

		for (Entry<String, Slot> entry : newMap.entrySet()) {
			System.out.println(entry.getKey() +" "+entry.getValue().toString());
			
			
		}

	}
}