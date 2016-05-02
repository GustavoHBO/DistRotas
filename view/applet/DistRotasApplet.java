package applet;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JApplet;

public class DistRotasApplet extends JApplet {

	public DistRotasApplet() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g){
		
	}
	
	public void init(){
		
		this.setSize(500, 500);
		
        Panel painelform1 = new Panel(new GridLayout(5, 2));
        TextField cor = new TextField(30);
        TextField matricula = new TextField(30);
        TextField marca = new TextField(30);
        TextField modelo = new TextField(30);
        Button confirmar = new Button("Confirmar");
        Button limpar = new Button("Limpar");
        painelform1.add(new Label("Matricula:"));
        painelform1.add(matricula);
        painelform1.add(new Label("Marca:"));
        painelform1.add(marca);
        painelform1.add(new Label("Modelo:"));
        painelform1.add(modelo);
        painelform1.add(new Label("Cor"));
        painelform1.add(cor);
        painelform1.add(confirmar);
        painelform1.add(limpar);
        add(painelform1);
	}
}
