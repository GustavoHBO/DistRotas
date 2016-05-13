package applet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GraphicsApplet extends JPanel {

	private static final long serialVersionUID = -4008779547235228667L;

	public GraphicsApplet() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("Oiie", 20, 30);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250,200);
	}
}
