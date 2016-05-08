package applet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Ponto;

public class AppletDistRotas extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int RAIO = 10;
	private JPanel panelControle = null;
	private JPanel panelArea = null;
	private JTextField textFieldNome = null;

	private ArrayList<Ponto> listaDePontos;

	/**
	 * Create the applet.
	 */
	public AppletDistRotas() {

		listaDePontos = new ArrayList<Ponto>();
		montarTela();
	}

	public void init(){
		this.setSize(600, 450);
	}

	public void montarTela(){
		prepararPanelControle();
		prepararPanelArea();
	}

	private void prepararPanelControle() {
		getContentPane().setBackground(Color.GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{214, 310, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		panelControle = new JPanel();
		panelControle.setLayout(null);
		GridBagConstraints gbc_panelControle = new GridBagConstraints();
		gbc_panelControle.insets = new Insets(0, 0, 0, 5);
		gbc_panelControle.fill = GridBagConstraints.BOTH;
		gbc_panelControle.gridx = 0;
		gbc_panelControle.gridy = 0;
		getContentPane().add(panelControle, gbc_panelControle);

		/*Prepara os botões do panel controle*/
		prepararBotaoCadastrarPonto();
		prepararBotaoCadastrarAresta();
		prepararBotaoRemoverPonto();
		prepararBotaoRemoverAresta();
		prepararBotaoEscolherRota();
	}

	private void prepararPanelArea(){
		panelArea = null;
		panelArea = new JPanel();
		GridBagConstraints gbc_panelArea = new GridBagConstraints();
		gbc_panelArea.fill = GridBagConstraints.BOTH;
		gbc_panelArea.gridx = 1;
		gbc_panelArea.gridy = 0;
		getContentPane().add(panelArea, gbc_panelArea);
		GroupLayout gl_panelArea = new GroupLayout(panelArea);
		gl_panelArea.setHorizontalGroup(
				gl_panelArea.createParallelGroup(Alignment.LEADING)
				.addGap(0, 428, Short.MAX_VALUE)
				);
		gl_panelArea.setVerticalGroup(
				gl_panelArea.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
				);
		panelArea.setLayout(gl_panelArea);
	}

	private void prepararBotaoCadastrarPonto(){
		JButton botaoCadastrarPonto = new JButton("Cadastrar Ponto");
		botaoCadastrarPonto.setBounds(44, 22, 127, 33);

		botaoCadastrarPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaCadastrarPonto();

			}
		});

		panelControle.add(botaoCadastrarPonto);
	}

	private void prepararBotaoCadastrarAresta(){
		JButton botaoCadastrarAresta = new JButton("Cadastrar Aresta");
		botaoCadastrarAresta.setBounds(44, 66, 127, 33);

		botaoCadastrarAresta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaCadastrarAresta();

			}
		});

		panelControle.add(botaoCadastrarAresta);
	}

	private void prepararBotaoRemoverPonto(){
		JButton botaoRemoverPonto = new JButton("Remover Ponto");
		botaoRemoverPonto.setBounds(44, 110, 127, 33);
		panelControle.add(botaoRemoverPonto);
	}

	private void prepararBotaoRemoverAresta(){
		JButton botaoRemoverAresta = new JButton("Remover Aresta");
		botaoRemoverAresta.setBounds(44, 154, 127, 33);
		panelControle.add(botaoRemoverAresta);
	}

	private void prepararBotaoEscolherRota(){
		JButton btnEscolherRota = new JButton("Escolher Rota");
		btnEscolherRota.setBounds(44, 198, 127, 33);
		panelControle.add(btnEscolherRota);
	}

	private void prepararPanelAreaCadastrarPonto(){
		prepararPanelArea();

		desenharPontos();
		Ponto ponto = new Ponto();

		textFieldNome = new JTextField("Insira o nome aqui!");
		textFieldNome.setSize(120, 20);
		textFieldNome.setLocation(130, 20);

		textFieldNome.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// Evento não utilizado.

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				textFieldNome.setText("");
			}
		});

		panelArea.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// Evento não utilizado.

			}

			@Override
			public void mousePressed(MouseEvent e) {
				ponto.setX(e.getX());
				ponto.setY(e.getY());
				ponto.setNome(textFieldNome.getText());
				listaDePontos.add(ponto);
				desenharPonto(ponto);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Evento não utilizado.

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// Evento não utilizado.

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// Evento não utilizado.

			}
		});
		panelArea.add(textFieldNome);
	}

	private void desenharPonto(Ponto ponto){
		Graphics grap = panelArea.getGraphics();
		grap.drawOval(ponto.getX() - RAIO, ponto.getY() - RAIO, RAIO * 2, RAIO * 2);
		grap.drawString(ponto.getNome(), ponto.getX() - RAIO - 5, ponto.getY() - RAIO - 5);
	}

	private void desenharPontos(){
		for(int i = 0; i < listaDePontos.size(); i++){
			desenharPonto(listaDePontos.get(i));
		}
	}

	private void prepararPanelAreaCadastrarAresta(){
		
		prepararPanelArea();
		JComboBox<Ponto> comboInicio = new JComboBox<Ponto>();
		comboInicio.addItem(listaDePontos.get(0));
		comboInicio.setSize(50, 20);
		comboInicio.setLocation(120, 20);
		panelArea.add(comboInicio);
	}

}
