package hu.naszi.example.transparencyrectangle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
	
	private Color randomColor() {
		
		Random random = new Random();
		
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		
		Color color = new Color(red, green, blue);
		
		return color;
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setPaint(randomColor());

		for (int i = 1; i <= 10; i++) {

			float alpha = i * 0.1f;
			AlphaComposite alphaComposite = AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, alpha);
			g2d.setComposite(alphaComposite);
			g2d.fillRect(50 * i, 20, 40, 40);
		}

		g2d.dispose();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

}

public class TransparencyRectangle extends JFrame {
	
	public TransparencyRectangle() {
		
		initUI();
	}

	private void initUI() {
		
		add(new Surface());
		
		setTitle("Transparent rectangle");
		setSize(590, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				TransparencyRectangle rectangle = new TransparencyRectangle();
				rectangle.setVisible(true);
			}
		});
	}
}
