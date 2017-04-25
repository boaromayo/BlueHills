package tile;

import org.newdawn.slick.*;

import main.*;

public class Tile {
	
	private int _id;
	private String _name;
	private boolean _blocked;
	private Image _img;
	
	public Tile() throws SlickException {
		_img = new Image("/assets/img/blank.png");
		_id = -1;
		_name = "Blank";
		_blocked = false;
	}
	
	public Tile(Image i, int id, String name) {
		_img = i;
		_id = id;
		_name = name;
		_blocked = false;
	}
	
	public Tile(Image i, int id, String name, boolean blocked) {
		_img = i;
		_id = id;
		_name = name;
		_blocked = blocked;
	}
	
	public Image getImage() throws SlickException {
		return _img;
	}
	
	public int getID() {
		return _id;
	}
	
	public String getName() {
		return _name;
	}
	
	public boolean isBlocked() {
		return _blocked;
	}
}
