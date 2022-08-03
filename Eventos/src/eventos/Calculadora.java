package eventos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora implements ActionListener{
	private JFrame f;
	private JPanel p;
	private JTextField mostrador = new JTextField("0");
	private JButton b;
	private boolean calculo = true;
	private double resultado = 0;
	private String operador = "=";
	
	//Construtor da classe
	public Calculadora() {
		JFrame.setDefaultLookAndFeelDecorated(true); //provide windows decorations
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //nao faz nada pois vai criar um optionPane
		f.setTitle("Calculadora");
		f.setSize(300, 300);
		f.setLocationRelativeTo(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String tit = "Confirmar Saída";
				String[] opc = {"Sim", "Não"};
				
				int resp = JOptionPane.showOptionDialog(f, "Quer mesmo sair?", tit, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
				
				if(resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		f.setLayout(new BorderLayout());
		
		//JTextField onde se vêem os calculos
		mostrador.setEditable(false);
		mostrador.setHorizontalAlignment(JTextField.RIGHT);
		f.add(mostrador, BorderLayout.NORTH);
		
		p = new JPanel();
		p.setLayout(new GridLayout(4, 4));
		
		//criar botões
		String nomesButton = "789/456*123-0C=+";
		for(int i = 0; i < nomesButton.length(); i++) {
			b = new JButton(nomesButton.substring(i, i+1));
			p.add(b);
			b.addActionListener(this);
		}
		f.add(p, BorderLayout.CENTER);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent env) {
		String cmd = env.getActionCommand();
		
		if(cmd.equals("C")) {
			resultado = 0;
			operador = "=";
			calculo = true;
			mostrador.setText("0");
		}
		
		//para escrever os numeros no mostrador
		if('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9') {
			if(calculo)
				mostrador.setText(cmd); //numero unico
			else
				mostrador.setText(mostrador.getText() + cmd); //mais de um numero
			calculo = false;
		}
		//para fazer a operação pretendida
		else {
			if(!calculo) {
				double x = Double.parseDouble(mostrador.getText());
				calcular(x);
				operador = cmd;
				calculo = true;
			}
		}
	}
	
	private void calcular(double n) {
		if(operador.equals("+"))
			resultado += n;
		else if(operador.equals("-"))
			resultado -= n;
		else if(operador.equals("*"))
			resultado *= n;
		else if(operador.equals("/"))
			resultado /= n;
		else if(operador.equals("="))
			resultado = n;
		
		DecimalFormat df = new DecimalFormat("0.00");
		mostrador.setText("" + df.format(resultado));
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}
}
