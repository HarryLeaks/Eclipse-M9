package eventos;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Evmaxtexto1{
	private JFrame j;
	private JPanel p;
	private JLabel ltxt;
	private JTextField texto;
	
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
		texto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if((ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE) || texto.getText().length() >= 10)
					e.consume();
			}
		});
		
		texto.setBounds(190, 50, 100, 25);
		p.add(ltxt);
		p.add(texto);
		
		j.setVisible(true);
	}
	
	public static void main(String[] args) {
		Evmaxtexto1 ex = new Evmaxtexto1();
		ex.textoMaximo();
	}
}
