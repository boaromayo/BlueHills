package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import main.*;

public class MenuState extends State {
	
	// menu mode
	private int _choice;
	
	// choices
	private final int _START = 0;
	private final int _QUIT = 1;
	
	private String[] _choices = {
		"START GAME", "END GAME"
	};
	
	public MenuState() {
		_choice = 0;
	}
	
	@Override
	public boolean keyPressed(int key) {
		if (_input != null) {
			return _input.isKeyPressed(key);
		}
		
		return false;
	}
	
	@Override
	public boolean keyDown(int key) {
		if (_input != null) {
			return _input.isKeyDown(key);
		}
		
		return false;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		if (_input == null)
			_input = gc.getInput();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		g.drawString(_choices[_START], (Constants._WIDTH / 2) - 30, 240);
		g.drawString(_choices[_QUIT], (Constants._WIDTH / 2) - 30, 270);
		g.drawString("Cursor position: " + (_choice + 1), 4, 30);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if (keyPressed(Input.KEY_W) ||
				keyPressed(Input.KEY_UP)) {
			if (_choice > 0)
				_choice--;
			else
				_choice = _choices.length - 1;
		} else if (keyPressed(Input.KEY_S) ||
				keyPressed(Input.KEY_DOWN)) {
			if (_choice < _choices.length - 1) 
				_choice++;
			else
				_choice = 0;
		} else if (keyPressed(Input.KEY_ENTER)) {
			branch(gc, sbg);
		}
	}
	
	public int getID() {
		return 0;
	}
	
	private void branch(GameContainer gc, StateBasedGame sbg) {
		if (_choice == _START) {
			sbg.enterState(Constants._MAPSTATE);
		} else if (_choice == _QUIT) {
			System.out.println("Exiting game...");
			gc.exit();
		}
	}

}
