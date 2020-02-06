package breakout.window;

import java.awt.Graphics;
import java.util.LinkedList;

import breakout.framework.GameObject;
import breakout.framework.Level;
import breakout.framework.ObjectId;
import breakout.framework.State;
import breakout.objects.Brick;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<>();
	private GameObject tempObject;
	private State state;
	private Level level;
	
	public Handler() {
		state = State.dead;
		level = Level.menu;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	public State getState() {
		return state;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	public Level getLevel() {
		return level;
	}
	
	public void move() {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			tempObject.move();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<object.size(); i++) {
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void creatLevel() {
		int xpos = 50;
		for(int x=0; x<7; x++) {
			addObject(new Brick(xpos, 100, this, ObjectId.Brick));
			xpos += 100;
		}
		xpos = 50;
		
		for(int x=0; x<7; x++) {
			addObject(new Brick(xpos, 120, this, ObjectId.Brick));
			xpos += 100;
		}
		xpos = 50;
		
		for(int x=0; x<7; x++) {
			addObject(new Brick(xpos, 140, this, ObjectId.Brick));
			xpos += 100;
		}
		xpos = 50;
	}
	
	public void creatLevel2() {
		
		int xpos = 50;
		int ypos = 100;		
		for(int i=0; i<7; i++) {
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			xpos += 100;
		}
		
		xpos = 50;
		ypos = 120;		
		for(int i=0; i<7; i++) {
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			ypos += 20;
		}
		
		xpos = 650;
		ypos = 120;
		
		for(int i=0; i<7; i++) {
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			ypos += 20;
		}
		
		xpos = 50;
		ypos = 300;
		
		for(int i=0; i<7; i++) {
			addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
			xpos += 100;
		}
		
		xpos = 200;
		ypos = 140;
		for(int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				addObject(new Brick(xpos, ypos, this, ObjectId.Brick));
				ypos += 20;
			}
			ypos = 140;
			xpos +=150;
		}
	}
}



