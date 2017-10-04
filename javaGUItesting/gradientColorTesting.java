package javaGUItesting;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class gradientColorTesting extends JFrame {
	
	public  gradientColorTesting() {
		super("Let's see how gradient color works");
		this.setSize(850, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(new PaintablePanel());
		
	}

	public static void main(String[] args){
		gradientColorTesting theFrame = new gradientColorTesting();
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		theFrame.setLocation(dim.width/2-theFrame.getSize().width/2, dim.height/2-theFrame.getSize().height/2);
		
		theFrame.setVisible(true);
	}
}
