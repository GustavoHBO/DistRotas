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
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Linha;
import model.Ponto;

public class AppletDistRotas extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int RAIO = 10;
	private JPanel panelControle = null;
	private static JPanel panelArea = null;

	private static List<Ponto> listaDePontos;
	private static List<Linha> listaDeLinhas;

	private JTextField textFieldNome = null;

	/**
	 * Create the applet.
	 */
	public AppletDistRotas() {

		listaDePontos = new ArrayList<Ponto>();
		listaDeLinhas = new ArrayList<Linha>();
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

		if(panelArea != null)
			this.remove(panelArea);

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

		botaoRemoverPonto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaRemoverPonto();
			}
		});

		panelControle.add(botaoRemoverPonto);
	}

	private void prepararBotaoRemoverAresta(){
		JButton botaoRemoverAresta = new JButton("Remover Aresta");
		botaoRemoverAresta.setBounds(44, 154, 127, 33);
		
		botaoRemoverAresta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaRemoverAresta();
				
			}
		});
		
		panelControle.add(botaoRemoverAresta);
	}

	private void prepararBotaoEscolherRota(){
		JButton botaoEscolherRota = new JButton("Escolher Rota");
		botaoEscolherRota.setBounds(44, 198, 127, 33);
		
		botaoEscolherRota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prepararPanelAreaEscolherRota();
			}
		});
		
		panelControle.add(botaoEscolherRota);
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
				String nome = textFieldNome.getText();
				if(nome.trim().equals("")){
					JOptionPane.showMessageDialog(null, "Insira um nome primeiro");
					return;
				}
				ponto.setNome(textFieldNome.getText());

				Iterator<Ponto> it = listaDePontos.iterator();
				Ponto aux = null;
				while(it.hasNext()){
					aux = it.next();
					if(aux.getNome().equals(ponto.getNome())){
						JOptionPane.showMessageDialog(null, "Já existe ponto cadastrado com este nome!");
						return;
					}
				}
				listaDePontos.add(ponto);
				desenharPonto(ponto);
				JOptionPane.showMessageDialog(null, "Ponto inserido com sucesso");
				prepararPanelArea();
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

		Linha linha = new Linha();

		JComboBox<String> comboInicio = new JComboBox<String>();
		JComboBox<String> comboFim = new JComboBox<String>();

		for(Ponto ponto : listaDePontos){
			comboInicio.addItem(ponto.getNome());
		}
		comboInicio.setSize(140, 20);
		comboInicio.setLocation(130, 20);
		panelArea.add(comboInicio);

		for(Ponto ponto : listaDePontos){
			comboFim.addItem(ponto.getNome());
		}
		comboFim.setSize(140, 20);
		comboFim.setLocation(130, 60);

		JButton botaoCriarAresta = new JButton("Criar Aresta");
		botaoCriarAresta.setSize(140, 20);
		botaoCriarAresta.setLocation(130, 100);

		botaoCriarAresta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Ponto ponto1, ponto2;
				if(listaDePontos.size() <= 1){
					JOptionPane.showMessageDialog(null, "Não existe pontos suficientes!");
					return;
				}
				ponto1 = listaDePontos.get(comboInicio.getSelectedIndex());
				ponto2 = listaDePontos.get(comboFim.getSelectedIndex());
				if(ponto1.equals(ponto2)){
					JOptionPane.showMessageDialog(null, "Você não pode criar uma aresta com inicio e fim iguais");
					return;
				} 
				else {
					linha.setPonto1(ponto1);
					linha.setPonto2(ponto2);

					Iterator<Linha> it = listaDeLinhas.iterator();
					Linha aux;
					while(it.hasNext()){
						aux = it.next();
						if((aux.getPonto1().equals(ponto1) && aux.getPonto2().equals(ponto2)) || (aux.getPonto1().equals(ponto2) && aux.getPonto2().equals(ponto1))){
							JOptionPane.showMessageDialog(null, "Já existe aresta cadastrada entre os pontos");
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Aresta Cadastrada!");
					listaDeLinhas.add(linha);
				}
			}
		});
		panelArea.add(botaoCriarAresta);
		panelArea.add(comboFim);
	}

	private void prepararPanelAreaRemoverPonto(){
		prepararPanelArea();

		JComboBox<String> comboRemover = new JComboBox<String>();
		comboRemover.setSize(140, 20);
		comboRemover.setLocation(100, 20);

		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDePontos.size(); i++){
			comboRemover.addItem(listaDePontos.get(i).getNome());
		}

		panelArea.add(comboRemover);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setSize(100, 20);
		botaoRemover.setLocation(260, 20);

		botaoRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaDePontos.size() == 0)
					JOptionPane.showMessageDialog(null, "Não existem pontos a serem removidos!");
				else{
					listaDePontos.remove(comboRemover.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Ponto Removido!");
					prepararPanelArea();
				}

			}
		});
		panelArea.add(botaoRemover);
	}

	private void prepararPanelAreaRemoverAresta(){
		prepararPanelArea();

		JComboBox<String> comboRemover = new JComboBox<String>();
		comboRemover.setSize(140, 20);
		comboRemover.setLocation(100, 20);

		/*Adicionando os pontos existentes*/
		for(int i = 0; i < listaDeLinhas.size(); i++){
			comboRemover.addItem(listaDeLinhas.get(i).getPonto1().getNome() + " - " + listaDeLinhas.get(i).getPonto2().getNome());
		}

		panelArea.add(comboRemover);

		JButton botaoRemover = new JButton("Remover");
		botaoRemover.setSize(100, 20);
		botaoRemover.setLocation(260, 20);

		botaoRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaDeLinhas.size() == 0)
					JOptionPane.showMessageDialog(null, "Não existem arestas a serem removidas!");
				else{
					listaDePontos.remove(comboRemover.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Aresta Removida!");
					prepararPanelArea();
				}

			}
		});
		panelArea.add(botaoRemover);
	}
	
	private void prepararPanelAreaEscolherRota(){
		prepararPanelArea();
		
		JLabel labelGaragem = new JLabel("Garagem");
		labelGaragem.setSize(100, 20);
		labelGaragem.setLocation(60, 20);
		panelArea.add(labelGaragem);
		
		JComboBox<String> comboGaragem = new JComboBox<String>();
		comboGaragem.setSize(140, 20);
		comboGaragem.setLocation(130, 20);
		panelArea.add(comboGaragem);
		
		JLabel labelColeta = new JLabel("Coleta");
		labelColeta.setSize(100, 20);
		labelColeta.setLocation(60, 60);
		panelArea.add(labelColeta);
		
		JComboBox<String> comboColeta = new JComboBox<String>();
		comboColeta.setSize(140, 20);
		comboColeta.setLocation(130, 60);
		panelArea.add(comboColeta);
		
		JLabel labelBanco = new JLabel("Banco");
		labelBanco.setSize(100, 20);
		labelBanco.setLocation(60, 100);
		panelArea.add(labelBanco);
		
		JComboBox<String> comboBanco = new JComboBox<String>();
		comboBanco.setSize(140, 20);
		comboBanco.setLocation(130, 100);
		panelArea.add(comboBanco);
		
		JButton botaoGerarRota = new JButton("Gerar Rota");
		botaoGerarRota.setSize(140, 20);
		botaoGerarRota.setLocation(130, 140);
		
		botaoGerarRota.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(listaDePontos.size() <= 1){
					JOptionPane.showMessageDialog(null, "Não existe pontos suficientes!");
					return;
				}
				
				Ponto pontoGaragem = listaDePontos.get(comboGaragem.getSelectedIndex());
				Ponto pontoColeta = listaDePontos.get(comboColeta.getSelectedIndex());
				Ponto pontoBanco = listaDePontos.get(comboBanco.getSelectedIndex());
				
				if(pontoGaragem.equals(pontoColeta)){
					JOptionPane.showMessageDialog(null, "O ponto de coleta não pode ser o mesmo que a garagem!");
					return;
				}
				
			}
		});
		
		panelArea.add(botaoGerarRota);
	}
}
