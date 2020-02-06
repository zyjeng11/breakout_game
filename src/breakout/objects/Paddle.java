package breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import breakout.framework.GameObject;
import breakout.framework.ObjectId;
import breakout.framework.State;
import breakout.window.Handler;

public class Paddle extends GameObject{

	private int width = 62, height = 10;
	Handler handler;
	
	public Paddle(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void move() {
		
		if(handler.getState() == State.pause) {
			//do nothing
		}else {
			
			//handler state alive or dead
			
			x += velX;
		
			//¶W¥X¥ª¥kÃä¬É
			if(x < 0) {
				velX = 0;
				x = 0;
			}else if(x > 740) {
				velX = 0;
				x = 740;
			}
		}			
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, height);
		
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.blue);
//		g2d.draw(getBoundsTop());
//		g2d.draw(getBoundsLeft());
//		g2d.draw(getBoundsRight());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}

	@Override
	public Rectangle getBoundsTop() {
		return new Rectangle((int)x + width/4, (int)y, width/2, height/2);
	}

	@Override
	public Rectangle getBoundsButtom() {
		return null;
	} 

	@Override
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y, width/4, height);
	}

	@Override
	public Rectangle getBoundsRight() {
		return new Rectangle((int)x + width*3/4, (int)y, width/4, height);
	}

}
