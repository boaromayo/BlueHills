package main;

public class Constants {
	private static Constants _singleton = null;
	
	// CONSTANTS.
	private static final int _WIDTH = 640;
	private static final int _HEIGHT = 480;
	
	private static final int _MENUSTATE = 0;
	private static final int _MAPSTATE = 1;
	
	private Constants() {}
	
	public static Constants get() {
		if (_singleton == null) {
			synchronized (Constants.class) {
				if (_singleton == null)
					_singleton = new Constants();
			}
		}
		return _singleton;
	}
	
	public int menuState() {
		return _MENUSTATE;
	}
	
	public int mapState() {
		return _MAPSTATE;
	}
	
	public int screenWidth() {
		return _WIDTH;
	}
	
	public int screenHeight() {
		return _HEIGHT;
	}
}
