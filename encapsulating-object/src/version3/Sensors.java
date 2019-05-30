package version3;

import java.util.ArrayList;
import java.util.List;

public class Sensors {

	public static final Boolean TRUE = new Boolean(true);
	public static final Boolean FALSE = new Boolean(false);;
	private boolean value;
	
	public void Boolean(boolean b) {
		value = b;
	}
	
	public boolean booleanValue() {
		return value;
	}
	
	public static Boolean valueOf(boolean b) {
		return (b ? TRUE : FALSE);
	}
}
