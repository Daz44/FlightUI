package test.mallen.flighui;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.NumberIndicatorHorizontal;

public class Test extends JPanel{
	NumberIndicatorHorizontal numInd = new NumberIndicatorHorizontal(10, 10, 40, 400, 0, 360, 1);

	public static void main(String[] args){
		Test m = new Test();
		m.initFrame();
	}
	
	public void initFrame(){
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(this);
		jf.setVisible(true);
	}
	
	
	
	public void paint(Graphics g){
	super.paint(g);
	setDoubleBuffered(true);
	
		numInd.update(10, 360);
		numInd.draw(g, this);

		try {
			Thread.sleep(10);
		} catch(Exception e){
			e.printStackTrace();
		}
	
	repaint();
	}
}
