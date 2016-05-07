package applet;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JApplet;

import model.Linha;
import model.Ponto;

public class Applet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int RAIO = 10, X = 500, Y = 400;// RAIO é o raio do ponto, X e Y é o tamanho do panel.
	private static ArrayList<Ponto> listaDePontos= new ArrayList<Ponto>();
	private static Panel panelPrincipal = null;
	private static Panel panelCadastraPonto = null;
	private static TextField textFieldNome = null;

	public void init(){

		preparaPanelPrincipal();
		preparaPanelCadastraPonto();
		preparaBotaoCadastrarPonto();
		preparaBotaoEscolherRota();
	}
	private void preparaPanelPrincipal(){
		this.setSize(X, Y);// Seta o tamanho do applet.
		panelPrincipal = new Panel(null);// Cria o panel principal.
		panelPrincipal.setSize(X, Y);// Seta o tamanho do panel.
		panelPrincipal.setVisible(true);// Seta a visibilidade para true.
		add(panelPrincipal);// Adiciona o panel no applet.
	}

	private void preparaPanelCadastraPonto(){
		panelCadastraPonto = new Panel(null);
		panelCadastraPonto.setSize(X, Y);
		panelCadastraPonto.setVisible(true);
		preparaTextFildNome();
		add(panelCadastraPonto);
	}
	private void preparaBotaoCadastrarPonto(){
		Button botaoCadastrarPonto = new Button("Cadastrar Ponto");
		int x = 120;
		int y = 50;
		botaoCadastrarPonto.setSize(x, y);
		botaoCadastrarPonto.setLocation((X/2) - x/2, 30);
		botaoCadastrarPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				desenhaPontos(panelCadastraPonto, listaDePontos);
				cadastraPonto();
			}
		});
		panelPrincipal.add(botaoCadastrarPonto);
	}

	private void preparaBotaoEscolherRota(){
		Button botaoEscolherRota = new Button("Escolher Rota");
		int x = 120;
		int y = 50;
		botaoEscolherRota.setSize(x, y);
		botaoEscolherRota.setLocation(X/2 - x/2, 100);
		panelPrincipal.add(botaoEscolherRota);
	}
	
	private static void preparaTextFildNome(){
		textFieldNome = new TextField("Digite o nome aqui!");
		textFieldNome.setLocation(X/4, 30);
		textFieldNome.setEditable(true);
		textFieldNome.setSize(150, 20);
		textFieldNome.setVisible(true);
		panelCadastraPonto.add(textFieldNome);
	}

	private void cadastraPonto(){

		Ponto ponto = new Ponto();
		panelCadastraPonto.setVisible(true);
		panelPrincipal.setVisible(false);
		
		Button botaoVoltar = new Button("Voltar ao Inicio");
		botaoVoltar.setBounds(X - 120, Y - 100, 100, 50);
		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelCadastraPonto.setVisible(false);
				return;
			}
		});
		panelCadastraPonto.add(botaoVoltar);
		
		panelCadastraPonto.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Método não utilizado.
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// Método não utilizado.
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// Método não utilizado.
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				desenhaPontos(panelCadastraPonto, listaDePontos);
				ponto.setNome(textFieldNome.getText());
				ponto.setX(arg0.getX());
				ponto.setY(arg0.getY());
				listaDePontos.add(ponto);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Método não utilizado.
			}
		});
	}

	private static void desenhaPonto(Panel panel, Ponto ponto){
		if(ponto == null){
			return;
		}
		Graphics draw = panelCadastraPonto.getGraphics();
		draw.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
		draw.drawString(ponto.getNome(), ponto.getX() - RAIO * 2, ponto.getY() - RAIO * 2);
	}

	private void desenhaLinha(Panel panel, Linha linha){
		Graphics draw = panel.getGraphics();
		int var = 1;
		draw.drawLine(linha.getX1(), linha.getY1(), linha.getX2(), linha.getY2());
		draw.drawLine(linha.getX1() + var, linha.getY1() + var, linha.getX2() + var, linha.getY2() + var);
		var++;
		draw.drawLine(linha.getX1() + var, linha.getY1() + var, linha.getX2() + var, linha.getY2() + var);
	}

	private static void desenhaPontos(Panel panel, ArrayList<Ponto> listaPontos){
		Graphics g = panel.getGraphics();
		Ponto ponto;
		for(int i = 0; i < listaPontos.size(); i++){
			ponto = listaPontos.get(i);
			g.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
			g.drawString(ponto.getNome(), ponto.getX() - RAIO * 2, ponto.getY() - RAIO * 2);
		}
	}
	
	public void de(){
		Graphics a = panelCadastraPonto.getGraphics();
		for(int i = 0; i < 10; i++){
			a.drawOval(i*10, 20, 30, 30);
		}
	}
}
