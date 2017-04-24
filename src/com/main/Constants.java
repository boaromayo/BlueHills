package main;

import org.newdawn.slick.*;

public class Constants {
	// SINGLETON.
	private static Constants _singleton = null;
	
	// CONSTANTS.
	// GAME PROPERTIES.
	public static final String _TITLE = "BlueHills";
	
	public static final int _WIDTH = 640;
	public static final int _HEIGHT = 480;
	
	public static final int _PWIDTH = 32;
	public static final int _PHEIGHT = 48;
	
	public static final int _MENUSTATE = 0;
	public static final int _MAPSTATE = 1;
	private boolean _paused = false;
	
	public static final int _TILESIZE = 32;
	
	//private SpriteSheetFont _HUDFONT;
	//private SpriteSheetFont _MSGFONT;
	
	//private SpriteSheet _hudFontSheet;
	//private SpriteSheet _msgFontPath;
	
	private Constants() {}
	
	// Instantiation of singleton.
	public static Constants get() {
		if (_singleton == null) {
			synchronized (Constants.class) {
				if (_singleton == null)
					_singleton = new Constants();
			}
		}
		return _singleton;
	}
	
	public void setPaused(boolean p) {
		_paused = p;
	}
	
	public boolean isPaused() {
		return _paused;
	}
	
	/*public SpriteSheetFont hudFont() {
		try {
			 _hudFontSheet = new SpriteSheet(
					 new Image("/assets/font/hud-font.bmp"), 
					 32, 
					 32);
			_HUDFONT = new SpriteSheetFont(_hudFontSheet, '0');
			
			return _HUDFONT;
		} catch (SlickException e) {
			System.err.println("ERROR: Unable to load HUD font. " +
					"REASON: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}*/
	
	/*public SpriteSheet msgFont() {
		try {
			_msgFontSheet = new SpriteSheet(
				new Image("/assets/font/msg-font.png"),
				24,
				24);
			_MSGFONT = new SpriteSheetFont(_msgFontSheet, 'A');
			
			return _MSGFONT;
		} catch (SlickException e) {
			System.err.println("ERROR: Unable to load message font. REASON: " 
					+ e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}*/
}
