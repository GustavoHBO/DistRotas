package applet;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ponto;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

public class AppletRotas extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int RAIO = 10;
	private static ArrayList<Ponto> listaDePontos = new ArrayList<Ponto>();
	private static JPanel panelArea = null;
	private static JTextField textField = null;

	/**
	 * Create the applet.
	 */
	public AppletRotas() {
		getContentPane().setLayout(null);

		JPanel panelControle = new JPanel();
		panelControle.setBounds(0, 0, 600, 540);
		getContentPane().add(panelControle);
		panelControle.setLayout(null);

		//prepararPanelArea();

		JButton botaoCadastrarAresta = new JButton("Cadastrar Aresta");
		botaoCadastrarAresta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepararPanelCadastraAresta();
			}

			private void prepararPanelCadastraAresta() {
				prepararPanelArea();
			}
		});
		botaoCadastrarAresta.setBounds(10, 73, 148, 40);
		panelControle.add(botaoCadastrarAresta);

		JButton botaoCadastrarPonto = new JButton("Cadastrar Ponto");
		botaoCadastrarPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepararPanelCadastroPonto();
				cadastrarPonto();
			}
		});
		botaoCadastrarPonto.setBounds(10, 11, 148, 40);
		panelControle.add(botaoCadastrarPonto);

		JButton botaoRemoverPonto = new JButton("Remover Ponto");
		botaoRemoverPonto.setBounds(10, 135, 148, 40);
		panelControle.add(botaoRemoverPonto);

		JButton btnRemoverAresta = new JButton("Remover Aresta");
		btnRemoverAresta.setBounds(10, 197, 148, 40);
		panelControle.add(btnRemoverAresta);

		JButton btnExibirCaminho = new JButton("Exibir Caminho");
		btnExibirCaminho.setBounds(10, 259, 148, 40);
		panelControle.add(btnExibirCaminho);

	}

	public void init(){
		this.setSize(600, 540);
	}

	private void prepararPanelArea(){
		panelArea = new JPanel();
	}

	private void prepararPanelCadastroPonto(){

		if(panelArea == null)
			panelArea = new JPanel();
		textField = new JTextField("Digite o nome aqui!");

		panelArea.setBounds(157, 0, 443, 540);
		getContentPane().add(panelArea);
		GroupLayout gl_panelArea = new GroupLayout(panelArea);
		gl_panelArea.setHorizontalGroup(
				gl_panelArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelArea.createSequentialGroup()
						.addGap(93)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addGap(101))
				);
		gl_panelArea.setVerticalGroup(
				gl_panelArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelArea.createSequentialGroup()
						.addGap(11)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(509, Short.MAX_VALUE))
				);
		panelArea.setLayout(gl_panelArea);
	}

	private void cadastrarPonto(){

		Ponto ponto = new Ponto();
		panelArea.addMouseListener(new MouseListener(){

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
				/*desenhaPontos(panelArea, listaDePontos);*/
				ponto.setNome(textField.getText());
				ponto.setX(arg0.getX());
				ponto.setY(arg0.getY());
				desenharPonto(panelArea.getGraphics(), ponto);
				listaDePontos.add(ponto);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Método não utilizado.
			}
		});
	}

	private void desenharPonto(Graphics graph, Ponto ponto){
		graph.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
		graph.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
	}

	private void desenharPontos(Graphics graph){
		for(int i = 0; i < listaDePontos.size(); i++){
			graph.drawString(listaDePontos.get(i).getNome(), listaDePontos.get(i).getX() - RAIO - 5, listaDePontos.get(i).getY() - RAIO - 5);
			graph.drawOval(listaDePontos.get(i).getX() - RAIO, listaDePontos.get(i).getY() - RAIO, RAIO * 2, RAIO * 2);
		}
	}
}
