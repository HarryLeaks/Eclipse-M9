package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FacilM8 implements ActionListener{
	private static final long serialVersionUID = 1L;
	private static JFrame janela;
	private static JPanel painel;
	
	private JLabel txt1, txt2, txt3, txt4, txt5;
	private JTextField jtftxt2, jtftxt3, jtftxt4;
	private JButton limpar, sair, mult, div, som, sub;
	
	public void calcJanela() {
		janela = new JFrame();
		painel = new JPanel();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(520, 330);
		janela.setTitle("CALCULADORA");
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		
		painel.setOpaque(true);
		painel.setLayout(null);
		painel.setBackground(new Color(255, 102, 102));
		janela.add(painel);
		
		txt1 = new JLabel("CALCULADORA SIMPLES");
		txt2 = new JLabel("1º Valor");
		txt3 = new JLabel("2º Valor");
		txt4 = new JLabel("Total");
		txt5 = new JLabel("OPERAÇÕES");
		
		//campos de texto
		jtftxt2 = new JTextField();
		jtftxt3 = new JTextField();
		jtftxt4 = new JTextField();
		
		//Botão
		limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		mult = new JButton("*");
		mult.addActionListener(this);
		div = new JButton("/");
		div.addActionListener(this);
		som = new JButton("+");
		som.addActionListener(this);
		sub = new JButton("-");
		sub.addActionListener(this);
		
		//colocar os componentes no local exato
		txt1.setBounds(150, 10, 200, 25);
		painel.add(txt1);
		txt2.setBounds(10, 60, 100, 25);
		painel.add(txt2);
		jtftxt2.setBounds(100, 60, 200, 25);
		painel.add(jtftxt2);
		txt3.setBounds(10, 100, 100, 25);
		painel.add(txt3);
		jtftxt3.setBounds(100, 100, 200, 25);
		painel.add(jtftxt3);
		txt4.setBounds(10, 150, 100, 25);
		painel.add(txt4);
		jtftxt4.setBounds(100, 150, 200, 25);
		painel.add(jtftxt4);
		
		limpar.setBounds(150, 250, 75, 25);
		painel.add(limpar);
		sair.setBounds(250, 250, 70, 25);
		painel.add(sair);
		
		txt5.setBounds(350, 50, 100, 25);
		painel.add(txt5);
		som.setBounds(350, 80, 45, 25);
		painel.add(som);
		sub.setBounds(420, 80, 45, 25);
		painel.add(sub);
		div.setBounds(420, 130, 45, 25);
		painel.add(div);
		mult.setBounds(350, 130, 45, 25);
		painel.add(mult);
		
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		float num1, num2, resultado = 0;
		if(ev.getSource() == sair) {
			System.exit(0);
		}
		if(ev.getSource() == limpar) {
			jtftxt2.setText("");
			jtftxt3.setText("");
			jtftxt4.setText("");
		}
		if(ev.getSource() == mult || ev.getSource() == som || ev.getSource() == sub || ev.getSource() == div) {
			num1 = Float.parseFloat(jtftxt2.getText());
			num2 = Float.parseFloat(jtftxt3.getText());
			
			if(ev.getSource() == mult) resultado = num1*num2;
			if(ev.getSource() == som) resultado = num1+num2;
			if(ev.getSource() == div) resultado = num1/num2;
			if(ev.getSource() == sub) resultado = num1-num2;
			
			if(ev.getSource() == div) {
				if(num2 != 0) {
					resultado = num1 / num2;
					jtftxt4.setText(String.valueOf(resultado));
				}else {
					JOptionPane.showMessageDialog(janela, "Operação inválida");
				}
			}else {
				jtftxt4.setText(String.valueOf(resultado));
			}
		}
	}
	
	public static void main(String[] args) {
		FacilM8 win = new FacilM8();
		win.calcJanela();
	}
}
