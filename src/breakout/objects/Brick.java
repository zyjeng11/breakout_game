package breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import breakout.framework.GameObject;
import breakout.framework.Level;
import breakout.framework.ObjectId;
import breakout.window.Handler;

public class Brick extends GameObject{

	private int width = 90, height = 15;
	Handler handler;
	public Brick(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void move() {
		//collision with the ball
		collision();
	}
	
	private void collision() {
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Ball) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);//
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		if(handler.getLevel() == Level.level1) {
			g.setColor(Color.red);
		}else {
			g.setColor(Color.yellow);
		}
		g.fillRect((int)x, (int)y, width, height);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}

	@Override
	public Rectangle getBoundsTop() {
		return new Rectangle((int)x, (int)y, width, height/2);
	}

	@Override
	public Rectangle getBoundsButtom() {
		return new Rectangle((int)x, (int)y+height/2, width, height/2);
	}

	@Override
	public Rectangle getBoundsLeft() {
		return null;
	}

	@Override
	public Rectangle getBoundsRight() {
		return null;
	}

}
