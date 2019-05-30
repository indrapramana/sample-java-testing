package version1;

import java.util.ArrayList;
import java.util.List;

public class Sensors {
	
	private List<Boolean> L = new ArrayList<>();
	
	public Sensors(int size) {
		for (int i = 0; i < size; i++) {
			L.add(new Boolean(false));
		}
	}
	
	public boolean getSensor(int n) {
		Boolean val = L.get(n);
		return val.booleanValue();
	}
	
	public void setSensor(int n, boolean b) {
		L.set(n, new Boolean(b));
	}

	
	
}
