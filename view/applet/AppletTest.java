package applet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;

import model.Ponto;

public class AppletTest extends JApplet {

	private static final long serialVersionUID = 1L;
	private static List<Ponto> pontos = new ArrayList<Ponto>();
	private static int i = 0;
	static Graphics2D a = null;
	static GraphicsApplet panel = new GraphicsApplet();

	/*public void init(){
		this.setSize(600, 540);
		panel.setSize(600, 540);
		panel.setVisible(true);
		this.add(panel);

		JButton b = new JButton("OOOO");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//paint();
				ta();
			}
		});
		b.setSize(20, 20);
		panel.setLocation(10, 10);
		panel.add(b);

		Graphics ass = panel.getGraphics();

		ass.drawString("Qualquer coisa diga algo", 10, 40);
	 */

	/*Ponto ponto = new Ponto();
		ponto.setNome("Alguem 1");
		ponto.setX(50);
		ponto.setY(50);
		pontos.add(ponto);

		Ponto ponto2 = new Ponto();
		ponto2.setNome("Alguem 2");
		ponto2.setX(70);
		ponto2.setY(50);
		pontos.add(ponto2);

		Ponto ponto3 = new Ponto();
		ponto3.setNome("Alguem 3");
		ponto3.setX(90);
		ponto3.setY(50);
		pontos.add(ponto3);

		Ponto ponto4 = new Ponto();
		ponto4.setNome("Alguem 4");
		ponto4.setX(110);
		ponto4.setY(50);
		pontos.add(ponto4);

		Ponto ponto5 = new Ponto();
		ponto5.setNome("Alguem 5");
		ponto5.setX(130);
		ponto5.setY(50);
		pontos.add(ponto5);
	}*/

	public void init(){
		AppletTest pa = new AppletTest();
		pa.montarTela();
	}
	
	public void montarTela(){
		System.out.println("Começou");
		
		this.setSize(500, 500);
		panel.setSize(500, 500);
		panel.setVisible(true);
		panel.setBackground(Color.red);
		this.add(new AppletTest());
		
		/*Graphics ga = this.getGraphics();
		panel.paintComponent(ga);*/
		
	}	
}
