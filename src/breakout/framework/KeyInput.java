package breakout.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import breakout.window.Handler;

public class KeyInput extends KeyAdapter{
	Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(-10);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(10);
				}
			}
			
			if(tempObject.getId() == ObjectId.Ball) {
				if(key == KeyEvent.VK_SPACE) {
					if(handler.getState() == State.dead) {
						handler.setState(State.alive);
						
						tempObject.setVelY(-8);
						tempObject.setVelX(8);						
					}
				}
			}
		}
		if(key == KeyEvent.VK_P) {
			if(handler.getState() == State.alive) {
				handler.setState(State.pause);
			}else if(handler.getState() == State.pause) {
				handler.setState(State.alive);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Paddle) {
				if(key == KeyEvent.VK_LEFT) {
					tempObject.setVelX(0);
				}
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
				}
			}
		}
	}
}
