package entity;

import main.Constants;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

import tile.*;

public class Player extends Entity {
	// JEWELS.
	private int _jewels;
	
	// TIME.
	private long _time;
	
	// Constructor.
	public Player(Tilemap m) {
		//super(m);
		setSize(Constants._PWIDTH, Constants._PHEIGHT);
		
		setSpeed(3);
		setPosition(300,200);
		setDirection(Direction._DOWN);
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) 
			throws SlickException {
		_jewels = 0; // No money, no items.
		_time = 0;
		
		/*_upSheet = new SpriteSheet("assets/img/playerup.png", 
		 	getWidth(), getHeight());
		_leftSheet = new SpriteSheet("assets/img/playerleft.png", 
			getWidth(), getHeight());
		_rightSheet = new SpriteSheet("assets/img/playerright.png", 
			getWidth(), getHeight());
		_downSheet = new SpriteSheet("assets/img/playerdown.png", 
			getWidth(), getHeight());*/
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
			throws SlickException {
		// Draw placeholder of a circle and bounding box.
		g.draw(getBoundingBox());
		g.fill(new Ellipse(getX(), getY(), getWidth() / 2, getHeight() / 2));
	}
	
	public void update(GameContainer gc, StateBasedGame sbg) 
			throws SlickException {
		// Check movement.
			if (isUp()) {
 				setdy(-getSpeed());
 			} else if (isDown()) {
				setdy(getSpeed());
			} else {
				setdy(0);
			}
			
 			if (isLeft()) {
				setdx(-getSpeed());
			} else if (isRight()) {
				setdx(getSpeed());
			} else {
				setdx(0);
			}
		
		move();
	}
	
}
