package eventos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClickCount implements ActionListener{
	private static final long servialVersionUID = 1L;
	private JFrame janela = new JFrame();
	private JPanel painel = new JPanel();
	
	private JButton button;
	private int count;
	private JLabel txt;
	
	public void janela() {
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setTitle("Click counter");
		janela.setSize(400, 200);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		
		painel.setLayout(null);
		painel.setOpaque(true);
		painel.setBackground(new Color(0, 255, 0));
		
		janela.add(painel);
		
		button = new JButton(new ImageIcon("src/eventos/image.jpg"));
		button.addActionListener(this);
		button.setBounds(30, 20, 80, 50);
		painel.add(button);
		
		txt = new JLabel(""+count);
		txt.setFont(new Font("SansSerif", Font.BOLD, 30));
		txt.setBounds(190, 50, 40, 30);
		
		painel.add(txt);
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == button) {
			count++;
			
			//altera a fonte
			txt.setFont(new Font("SansSerif", Font.BOLD, 30));
			txt.setText(""+count);
		}
	}
	
	public static void main(String[] args) {
		ClickCount win = new ClickCount();
		win.janela();
	}
}
