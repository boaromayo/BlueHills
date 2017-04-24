package main;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import state.*;

public class MainGame extends StateBasedGame {
	// Constructor.
	public MainGame() {
		super(Constants._TITLE);
		addStates();
		enter();
	}
	
	public void addStates() {
		addState(new MenuState());
		addState(new MapState());
	}
	
	public void initState(int stateId, GameContainer gc, StateBasedGame sbg)
		throws SlickException {
		getState(stateId).init(gc, sbg);
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		initState(Constants._MENUSTATE, gc, this);
		initState(Constants._MAPSTATE, gc, this);
	}
	
	private void enter() {
		enterState(Constants._MENUSTATE);
	}
	
	public void start() {
		try {
			AppGameContainer app = new AppGameContainer(this);
			app.setDisplayMode(Constants._WIDTH,
					Constants._HEIGHT, 
					false);
			app.start();
		} catch (SlickException e) {
			System.err.println("ERROR: Unable to create window. Reason: " 
					+ e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
}
