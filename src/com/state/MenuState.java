package state;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

import main.*;

public class MenuState extends State {
	// CURSOR for menu
	private Cursor _cursor;
	
	// choices
	private final int _START = 0;
	private final int _QUIT = 1;
	
	private String[] _choices = {
		"START GAME", "END GAME"
	};
	
	public MenuState() {		
		_cursor = new Cursor();
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
		if (_cursor.getPosition() == _START) {
			_cursor.move((Constants._WIDTH / 2) - 50, 
					(Constants._HEIGHT / 2) + 20);
		} else if (_cursor.getPosition() == _QUIT) {
			_cursor.move((Constants._WIDTH / 2) - 50, 
				(Constants._HEIGHT / 2) + 60);
		}
		
		_cursor.render(g);
		
		g.drawString(_choices[_START], (Constants._WIDTH / 2) - 30, 
				(Constants._HEIGHT / 2) + 10);
		g.drawString(_choices[_QUIT], (Constants._WIDTH / 2) - 30, 
				(Constants._HEIGHT / 2) + 50);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		if (keyPressed(Input.KEY_W) ||
				keyPressed(Input.KEY_UP)) {
			if (_cursor.getPosition() > 0)
				_cursor.decrement();
			else
				_cursor.setPosition(_choices.length - 1);
		} else if (keyPressed(Input.KEY_S) ||
				keyPressed(Input.KEY_DOWN)) {
			if (_cursor.getPosition() < _choices.length - 1) 
				_cursor.increment();
			else
				_cursor.setPosition(0);
		} else if (keyPressed(Input.KEY_ENTER)) {
			branch(gc, sbg);
		}
	}
	
	public int getID() {
		return 0;
	}
	
	private void branch(GameContainer gc, StateBasedGame sbg) {
		if (_cursor.getPosition() == _START) {
			sbg.enterState(Constants._MAPSTATE);
		} else if (_cursor.getPosition() == _QUIT) {
			System.out.println("Exiting game...");
			gc.exit();
		}
	}
	
	private class Cursor {
		private float _x;
		private float _y;
		private int _pos;
		private Polygon _shape;
		
		public Cursor() {
			_shape = new Polygon();
			
			_x = 0;
			_y = 0;
			
			_shape.addPoint(_x, _y-10);
			_shape.addPoint(_x+10, _y);
			_shape.addPoint(_x, _y+10);
			
			_pos = 0;
			
			_shape.setLocation(_x, _y);
		}
		
		public void render(Graphics g) {
			g.fill(_shape);
		}
		
		public void move(int x, int y) {
			_x = x;
			_y = y;
			
			_shape.setLocation(_x, _y);
		}
		
		public void setPosition(int pos) {
			_pos = pos;
		}
		
		public void increment() {
			_pos++;
		}
		
		public void decrement() {
			_pos--;
		}
		
		public int getPosition() {
			return _pos;
		}
	}
}
