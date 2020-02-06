package breakout.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import breakout.window.Board;
import breakout.window.Handler;

public class MouseInput implements MouseListener{

	Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		
		//play button
		if(x >= Board.WIDTH/3 + 75 && x <= Board.WIDTH/3 + 175) {
			if(y >= 150 && y <= 200) {
				handler.setLevel(Level.level1);				
			}
		}
		//quit button
		if(x >= Board.WIDTH/3 + 75 && x <= Board.WIDTH/3 + 175) {
			if(y >= 250 && y <= 300) {
				System.exit(1);;				
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
