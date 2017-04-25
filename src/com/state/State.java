package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import main.*;

public abstract class State extends BasicGameState {
	// INPUT.
	protected Input _input;
		
	// MESSAGE FONT (will also be INVENTORY MENU FONT).
	protected SpriteSheetFont _msgfont;

	public abstract boolean keyPressed(int key);
	
	public abstract boolean keyDown(int key);
	
	public State() {
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// Initialize assets.
		_msgfont = Constants.get().msgFont();
		
		// Initialize input.
		_input = gc.getInput();
	}

	@Override
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException;

	@Override
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException;
	
	@Override
	public abstract int getID();
}
