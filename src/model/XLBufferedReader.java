package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
	public XLBufferedReader(String name) throws FileNotFoundException {
		super(new FileReader(name));
	}

	public void load(Map<String, Slot> map) {
		SlotFactory slotFactory = new SlotFactory();
		try {
			while (ready()) {
				String string = readLine();
				int index = string.indexOf('=');
				String key = string.substring(0, index);
				String value = string.substring(index + 1, string.length());
				Slot slot = slotFactory.createSlot(value);
				map.put(key, slot);
			}
		} catch (Exception e) {
			throw new XLException(e.getMessage());
		}
	}
}
