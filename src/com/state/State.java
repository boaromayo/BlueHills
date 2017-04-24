package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import main.MainGame;

public abstract class State extends BasicGameState {
	// INPUT.
	protected Input _input;
	
	// MESSAGE FONT.
	
	// HUD FONT (will also be MENU FONT).
	protected SpriteSheetFont _hudfont;

	public abstract boolean keyPressed(int key);
	
	public abstract boolean keyDown(int key);
	
	public State() {
		//_hudfont = new SpriteSheetFont(Constants.get().);
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
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
