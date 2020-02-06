package breakout.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import breakout.framework.GameObject;
import breakout.framework.ObjectId;
import breakout.framework.State;
import breakout.window.Handler;

public class Ball extends GameObject{

	private int width = 20, height = 20;
	private GameObject paddleTemp;
	Handler handler;
	
	public Ball(float x, float y, Handler handler, ObjectId id) {		
		super(x, y, id);
		this.handler = handler;
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				paddleTemp = tempObject;
			}
		}
		
		velX = velY = 1;
	}

	@Override
	public void move() {
		
		if(handler.getState() == State.dead) {
			velX = paddleTemp.getVelX();
			
			x += velX;
		}
		else if(handler.getState() == State.pause) {
			//handler state is pause
			//do nothing
		}else {
		
			if(handler.object.size() <= 2) {
				
			}
			
			x += velX;
			y += velY;
			
			//collision against wall
			if(x <= 0) {
				velX = 8;
			}
			if(x >= 790) {
				velX = -8;
			}
			if(y <= 0) {
				velY = 8;
			}
		}
		
		//collision against brick or paddle
		collision();
		
		//falling below the paddle
		resetBall();
	}
	
	private void collision() {
		
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Paddle) {
				if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsLeft())) {
					velY = -8;
					velX = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsRight())) {
					velY = -8;
					velX = 8;
				}
			}
			
			if(tempObject.getId() == ObjectId.Brick) {
				if(getBounds().intersects(tempObject.getBoundsTop())) {
					velY = -8;
				}
				if(getBounds().intersects(tempObject.getBoundsButtom())) {
					velY = 8;
				}
			}
		}
	}
	
	public void resetBall() {
		if(y > 600 || handler.object.size() <= 2) {
			handler.setState(State.dead);
			velX = 0;
			velY = 0;
			
			x = paddleTemp.getX() +20;
			y = paddleTemp.getY() -20;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((int)x, (int)y, width, height);
		
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.blue);
//		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}

	@Override
	public Rectangle getBoundsTop() {
		return null;
	}

	@Override
	public Rectangle getBoundsButtom() {
		return null;
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
