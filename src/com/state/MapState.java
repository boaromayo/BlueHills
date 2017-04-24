package state;

import main.Constants;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.*;

import tile.*;

public class MapState extends State {
	// TILEMAP.
	private Tilemap _tilemap;
	
	// PLAYER.
	Player _player;
	
	public MapState() {
		_player = new Player(_tilemap);
	}
	
	@Override
	public boolean keyPressed(int key) {
		// TODO Auto-generated method stub
		if (_input != null)
			return _input.isKeyPressed(key);
		
		return false;
	}

	@Override
	public boolean keyDown(int key) {
		if (_input != null)
			return _input.isKeyDown(key);
		
		return false;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
		// Get input from container.
		_input = gc.getInput();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// TODO Auto-generated method stub
		_player.render(gc, sbg, g);
		
		/*if (Constants.get().isPaused()) {
			_hudfont.drawString(Constants._WIDTH / 2 - 10, 
					Constants._HEIGHT / 2 - 10, 
					"P A U S E");
		}*/
		
		g.drawString("(" + _player.getX() + "," + _player.getY() + ")", 4, 30);
		g.drawString("Direction: " + _player.getDirection(), 4, 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		_player.update(gc, sbg);
		
		// KEYBOARD INPUT.
		if (keyDown(Input.KEY_UP) || 
				keyDown(Input.KEY_W)) {
			_player.setUp();
		} else if (keyDown(Input.KEY_LEFT) || 
				keyDown(Input.KEY_A)) {
			_player.setLeft();
		} else if (keyDown(Input.KEY_RIGHT) ||
				keyDown(Input.KEY_D)) {
			_player.setRight();
		} else if (keyDown(Input.KEY_DOWN) ||
				keyDown(Input.KEY_S))
			_player.setDown();
		
		// MISC CONTROLS.
		if (keyPressed(Input.KEY_P)) {
			if (!Constants.get().isPaused()) 
				Constants.get().setPaused(true);
			else
				Constants.get().setPaused(false);
		}
		if (keyPressed(Input.KEY_ESCAPE)) {
			System.out.println("Exiting game...");
			gc.exit();
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
