package eventos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Evslider implements ChangeListener{
	private JFrame janela;
	private JPanel painel;
	private JLabel txt;
	private JTextField texto;
	private JSlider deslizar;
	
	public void janelaSlider() {
		janela = new JFrame();
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(500, 200);
		janela.setLocationRelativeTo(null);
		painel = new JPanel(new FlowLayout()); //vai preenchendo
		painel.setOpaque(true);
		painel.setBackground(Color.RED);
		painel.setLayout(null);
		janela.add(painel);
		
		txt = new JLabel("Valor: ");
		txt.setBounds(100, 120, 50, 25);
		txt.setFont(new Font("Areal", Font.BOLD, 15));
		txt.setForeground(Color.white);
		texto = new JTextField();
		texto.setBounds(150, 120, 20, 25);
		texto.setEditable(false);
		painel.add(txt);
		painel.add(texto);
		
		deslizar = new JSlider(JSlider.HORIZONTAL, 0, 40, 10);
		deslizar.setMinorTickSpacing(2);
		deslizar.setMajorTickSpacing(10);
		deslizar.setPaintTicks(true);
		deslizar.setPaintLabels(true);
		deslizar.setBounds(50, 50, 350, 50);
		deslizar.addChangeListener(this);
		painel.add(deslizar);
		
		janela.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent ev) {
		texto.setText("" + deslizar.getValue());
	}
	
	public static void main(String[] args) {
		Evslider sld = new Evslider();
		sld.janelaSlider();
	}
}
