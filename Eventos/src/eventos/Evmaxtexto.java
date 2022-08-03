package eventos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Evmaxtexto implements KeyListener{
	private JFrame j;
	private JPanel p;
	private JLabel ltxt;
	private JTextField texto;
	private int MAX = 10;
	private int cont = 0;
	
	void textoMaximo() {
		j = new JFrame();
		p = new JPanel();
		
		j.setResizable(false);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(500, 200);
		j.setLocationRelativeTo(null);
		j.add(p);
		
		p.setOpaque(true);
		p.setBackground(new Color(50, 78, 10));
		p.setLayout(null);
		
		ltxt = new JLabel("Máximo de 10 Caracteres: ");
		ltxt.setBounds(20, 50, 150, 25);
		ltxt.setForeground(Color.white);
		texto = new JTextField();
		texto.addKeyListener(this);
		
		texto.setBounds(190, 50, 100, 25);
		p.add(ltxt);
		p.add(texto);
		
		j.setVisible(true);
	}
	
	public void keyReleased(KeyEvent ev) {
		if(ev.getSource() == texto) {
			if(ev.getKeyCode() == 8) { //8 - Backspace Nao conta como caracter
				if(cont > 0) cont--;
				return;
			}
			if(ev.getKeyCode() == KeyEvent.VK_DELETE) { //Nao conta como caracter
				return;
			}
			cont++;
			if(cont > MAX) {
				JOptionPane.showMessageDialog(j,  "Antingiu o limite de caracteres!");
				texto.setText(texto.getText().substring(0, texto.getText().length() - 1));
				cont--;
			}
		}
	}
	
	public void keyTyped(KeyEvent ke) {
	}
	
	public void keyPressed(KeyEvent ke) {
	}
	
	public static void main(String[] args) {
		Evmaxtexto ex = new Evmaxtexto();
		ex.textoMaximo();
	}
}
