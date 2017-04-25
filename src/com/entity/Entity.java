package entity;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

import tile.*;

public abstract class Entity {
	// MAP.
	private Tilemap _tilemap;
	
	// POSITION.
	protected float _x;
	protected float _y;
	
	// SIZE.
	protected int _width;
	protected int _height;
	
	// VECTOR POSITION.
	protected float _dx;
	protected float _dy;
	
	// SPEED.
	protected float _v;
	
	// ANIMATION IMGS.
	protected Animation _animation;
	protected SpriteSheet _upSheet;
	protected SpriteSheet _leftSheet;
	protected SpriteSheet _rightSheet;
	protected SpriteSheet _downSheet;
	
	// DIRECTION.
	protected enum Direction {
		_UP, _LEFT, _RIGHT, _DOWN
	};
	
	protected Direction _dir;
	
	// MOVEMENT.
	protected boolean _moving;
	
	// COLLISION.
	protected boolean _collision;
	
	protected int _upTile;
	protected int _leftTile;
	protected int _rightTile;
	protected int _downTile;
	
	// HEALTH.
	protected int _hp;
	protected int _maxhp;
	
	// DEAD.
	protected boolean _dead = false;
	
	public Entity(/*Tilemap m*/) {
		//_tilemap = m;
	}
	
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
			throws SlickException;
	
	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta) 
			throws SlickException;
	
	protected void setAnimation(Animation frames, int duration) {
		_animation = frames;
		_animation.setCurrentFrame(0); // Set to first frame.
		_animation.setDuration(0, duration);
	}
	
	public void setPosition(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void setSize(int w, int h) {
		_width = w;
		_height = h;
	}
	
	public void setSpeed(int spd) {
		_v = spd;
	}
	
	public void setSpeed(float spd) {
		_v = spd;
	}
	
	public void setdx(int x) {
		_dx = x;
	}
	
	public void setdx(float x) {
		_dx = x;
	}
	
	public void setdy(int y) {
		_dy = y;
	}
	
	public void setdy(float y) {
		_dy = y;
	}
	
	public void setMoving(boolean m) {
		_moving = m;
	}
	
	public void move() {
		_x += _dx;
		_y += _dy;
	}
	
	public void setDirection(Direction d) {
		_dir = d;
	}
	
	public void setUp() {
		setDirection(Direction._UP);
	}
	
	public void setLeft() {
		setDirection(Direction._LEFT);
	}
	
	public void setRight() {
		setDirection(Direction._RIGHT);
	}
	
	public void setDown() {
		setDirection(Direction._DOWN);
	}
	
	public void setHealth(int h) {
		if (h > _maxhp) {
			_maxhp = h;
		}
		
		_hp = h;
	}
	
	public void heal() {
		heal(1);
	}
	
	public void heal(int h) {
		if (_hp + h >= _maxhp) {
			_hp = _maxhp;
		} else {
			_hp += h;
		}
	}
	
	public void hit() {
		hit(1);
	}
	
	public void hit(int h) {
		if (_hp - h < 0) {
			_hp = 0;
		} else {
			_hp -= h;
		}
		
		if (_hp < 0) {
			kill();
		}
	}
	
	public void kill() {
		if (isDead()) 
			return;
		
		_dead = true;
	}
	
	public int getX() {
		return (int)_x;
	}
	
	public float getActualX() {
		return _x;
	}
	
	public int getY() {
		return (int)_y;
	}
	
	public float getActualY() {
		return _y;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public int getSpeed() {
		return (int)_v;
	}
	
	public float getActualSpeed() {
		return _v;
	}
	
	public Direction getDirection() {
		return _dir;
	}
	
	public boolean isUp() {
		return (_dir == Direction._UP);
	}
	
	public boolean isLeft() {
		return (_dir == Direction._LEFT);
	}
	
	public boolean isRight() {
		return (_dir == Direction._RIGHT);
	}
	
	public boolean isDown() {
		return (_dir == Direction._DOWN);
	}
	
	public boolean isMoving() {
		return _moving;
	}
	
	// Make a rectangle from the upper-left corner.
	public Rectangle getBoundingBox() {
		return new Rectangle(_x - (_width / 2),
				_y - (_height / 2), 
				_width, _height);
	}
	
	public boolean intersects(Entity e) {
		Rectangle r1 = getBoundingBox();
		Rectangle r2 = e.getBoundingBox();
		return r1.intersects(r2);
	}
	
	public boolean intersects(Rectangle r) {
		return getBoundingBox().intersects(r);
	}
	
	public boolean contains(Entity e) {
		Rectangle r1 = getBoundingBox();
		Rectangle r2 = e.getBoundingBox();
		return r1.contains(r2);
	}
	
	public boolean contains(Rectangle r) {
		return getBoundingBox().contains(r);
	}
	
	public int getHealth() {
		return _hp;
	}
	
	public boolean isDead() {
		return _dead;
	}
}
