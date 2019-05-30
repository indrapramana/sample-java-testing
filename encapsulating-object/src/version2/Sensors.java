package version2;

import java.util.ArrayList;
import java.util.List;

public class Sensors {
	
	private List<Boolean> L = new ArrayList<>();
	private static final Boolean off = new Boolean(false);
	private static final Boolean on = new Boolean(true);
	
	public Sensors(int size) {
		for (int i = 0; i < size; i++) {
			L.add(off);
		}
	}
	
	public boolean getSensor(int n) {
		Boolean val = L.get(n);
		return val.booleanValue();
	}
	
	public void setSensor(int n, boolean b) {
		Boolean val = b ? on : off;
		L.set(n, val);
	}

}
