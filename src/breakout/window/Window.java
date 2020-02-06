 package breakout.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public Window(int w, int h, String title, Board board) {
		//�T�w�����j�p
		board.setPreferredSize(new Dimension(w, h));
		board.setMaximumSize(new Dimension(w, h));
		board.setMinimumSize(new Dimension(w, h));
		
		JFrame frame= new JFrame(title);
		frame.add(board);
		frame.pack();//�j�p�]�w�Mboard�@��
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);//�����j�p
		frame.setLocationRelativeTo(null);//����
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		new Window(800, 600, "Breakout!", new Board());
	}
}
