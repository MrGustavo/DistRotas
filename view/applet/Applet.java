package applet;

import java.awt.Button;
import java.awt.Color;
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
	private final int RAIO = 10, X = 500, Y = 400;// RAIO � o raio do ponto, X e Y � o tamanho do panel.
	private ArrayList<Ponto> listaDePontos= new ArrayList<Ponto>();
	private Panel panelPrincipal = null;
	private Panel panelCadastraPonto = null;

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

	private void cadastraPonto(){

		Ponto ponto = new Ponto();
		panelPrincipal.setVisible(false);

		Button botaoVoltar = new Button("Voltar ao Inicio");
		botaoVoltar.setBounds(X - 120, Y - 100, 100, 50);

		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				return;
			}
		});
		panelCadastraPonto.add(botaoVoltar);

		nomePonto(panelCadastraPonto, "Digite o nome aqui", ponto);
		//TODO desenhaPontos(panelCadastraPonto, listaDePontos);

		panelCadastraPonto.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// M�todo n�o utilizado.
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// M�todo n�o utilizado.
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// M�todo n�o utilizado.
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				ponto.setX(arg0.getX());
				ponto.setY(arg0.getY());
				desenhaPonto(panelCadastraPonto, ponto);
				listaDePontos.add(ponto);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// M�todo n�o utilizado.
			}
		});
	}

	private void desenhaPonto(Panel panel, Ponto ponto){
		Graphics draw = panel.getGraphics();
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

	private void nomePonto(Panel panel, String textoLabel, Ponto ponto){

		TextField textField = new TextField();
		textField.setText(textoLabel);
		textField.setLocation(X/4, 30);
		textField.setEditable(true);
		textField.setSize(150, 20);

		ponto.setNome(textoLabel);

		Button botaoDefinirNome = new Button("Definir Nome");
		botaoDefinirNome.setBounds(X/4 + 160, 30, 100, 20);

		textField.setVisible(true);
		botaoDefinirNome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				ponto.setNome(nome);
			}
		});
		panel.add(botaoDefinirNome);
		panel.add(textField);
	}

	private void desenhaPontos(Panel panel, ArrayList<Ponto> listaPontos){
		Iterator<Ponto> iteradorListaPontos = listaPontos.iterator();
		Ponto ponto = null;
		while(iteradorListaPontos.hasNext()){
			ponto = iteradorListaPontos.next();
			desenhaPonto(panel, ponto);
		}
	}
}