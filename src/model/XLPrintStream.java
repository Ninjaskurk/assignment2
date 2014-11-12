package model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class XLPrintStream extends PrintStream {
    public XLPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }
    
    public void save(Map<String, Slot> map) {
        for (Entry<String, Slot> entry : map.entrySet()) {
            print(entry.getKey());
            print('=');
            println(entry.getValue().toString());
        }
        flush();
        close();
    }
}
