package applet;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AppletDistRotas extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelControle = null;
	private JPanel panelArea = null;

	/**
	 * Create the applet.
	 */
	public AppletDistRotas() {
		
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
		panelControle.add(botaoCadastrarPonto);
	}
	
	private void prepararBotaoCadastrarAresta(){
		JButton botaoCadastrarAresta = new JButton("Cadastrar Aresta");
		botaoCadastrarAresta.setBounds(44, 66, 127, 33);
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

}
