package breakout.window;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import breakout.framework.GameObject;
import breakout.framework.KeyInput;
import breakout.framework.Level;
import breakout.framework.Menu;
import breakout.framework.MouseInput;
import breakout.framework.ObjectId;
import breakout.objects.Ball;
import breakout.objects.Paddle;

public class Board extends JPanel implements Runnable{
	
	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	Handler handler;
	Menu menu;
	
	public Board() {
		start();
	}
	
	private void init() {
		setFocusable(true);
		WIDTH = 800;
		HEIGHT = 600;
		
		handler = new Handler();
		handler.addObject(new Paddle(100, 570, handler, ObjectId.Paddle));
		handler.addObject(new Ball(120, 548, handler, ObjectId.Ball));
		handler.creatLevel();
		
		menu = new Menu();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(handler.getLevel() == Level.menu) {
			menu.render(g);
		}else {
			handler.render(g);
		}
		
		g.dispose();		
	}
	
	public synchronized void start() {
		if(running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();//執行run()
	}

	@Override
	public void run() {
		
		init();
		
		while(running) {
			//game loop
			move();
			
			repaint();//call the component's paint method
			
			try {
				thread.sleep(20);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	private void move() {
		
		if(handler.getLevel() == Level.menu) {
			//do nothing
		}else {
			if(handler.object.size()<=2 && handler.getLevel() == Level.level1) {//磚塊打完了
				handler.setLevel(Level.level2);
				
				for(int i=0; i<handler.object.size(); i++) {
					GameObject tempObject = handler.object.get(i);
					
					if(tempObject.getId() == ObjectId.Ball) {
						Ball ball = (Ball)tempObject;
						ball.resetBall();
					}
				}
				
				handler.creatLevel2();				
			}
			handler.move();
		}
	}
}
