package main;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import state.*;

public class Game extends StateBasedGame {
	// GAME PROPERTIES.
	private static final String _TITLE = "BlueHills";
	private boolean _paused;
	
	private int _width = Constants.get().screenWidth();
	private int _height = Constants.get().screenHeight();
	
	public Game() {
		super(_TITLE);
		addStatesList();
	}

	public void addStatesList() {
		addState(new MenuState());
		addState(new MapState());
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		initState(Constants.get().menuState(), gc, this);
		initState(Constants.get().mapState(), gc, this);
		enterMenu();
	}
	
	public void initState(int stateId, GameContainer gc, StateBasedGame sbg) 
			throws SlickException {
		getState(stateId).init(gc, sbg);
	}
	
	public void enterMenu() {
		enterState(Constants.get().menuState()); // Enter menu.
	}
	
	public void setPaused(boolean p) {
		_paused = p;
	}
	
	public boolean isPaused() {
		return _paused;
	}
	
	public void start() {
		try {
			AppGameContainer app = new AppGameContainer(this);
			app.setDisplayMode(_width, _height, false);
			app.start();
		} catch (SlickException e) {
			System.err.println("ERROR: Unable to create window. Reason: " 
					+ e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
}
