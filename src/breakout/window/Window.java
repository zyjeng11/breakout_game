 package breakout.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public Window(int w, int h, String title, Board board) {
		//固定視窗大小
		board.setPreferredSize(new Dimension(w, h));
		board.setMaximumSize(new Dimension(w, h));
		board.setMinimumSize(new Dimension(w, h));
		
		JFrame frame= new JFrame(title);
		frame.add(board);
		frame.pack();//大小設定和board一樣
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//不能改大小
		frame.setLocationRelativeTo(null);//中間
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		new Window(800, 600, "Breakout!", new Board());
	}
}
