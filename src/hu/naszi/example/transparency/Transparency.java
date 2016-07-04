package hu.naszi.example.transparency;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Surface extends JPanel {
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.setPaint(Color.blue);
		
		for (int i = 1; i <= 1; i++) {
			float alpha;
		}
	}
}

public class Transparency {

}
