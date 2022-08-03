package projeto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Janelatriangulo implements ActionListener{
	private JFrame janela;
	private JPanel painel;
	private JLabel txt, txt1, txt2, wutil, wutil1;
	private JButton sair, calc;
	private JTextField jtf1, jtf2;
	private ImageIcon image;
	
	public void triJan() {
		janela = new JFrame();
		janela.setSize(300, 250);
		janela.setLocationRelativeTo(null);
		
		//Modificar o tipo de janela
		janela.setUndecorated(true);
		janela.getRootPane().setWindowDecorationStyle(5);
		
		painel = new JPanel();
		painel.setOpaque(true);
		painel.setBackground(new Color(221, 255, 204));
		painel.setLayout(null);
		txt = new JLabel(new ImageIcon("src/img/triang.jpg"), SwingConstants.LEFT);
		txt.setBounds(10, 10, 300, 75);
		
		jtf1 = new JTextField();
		jtf1.setBounds(200, 50, 50, 25);
		jtf1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				wutil.setVisible(false);
				if((ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE) || (jtf1.getText().length() >= 5))
					e.consume();
			}
		});
		
		jtf1.addActionListener(this);
		
		jtf2 = new JTextField();
		jtf2.setBounds(200, 80, 50, 25); //falta addKeyListener
		jtf2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				wutil1.setVisible(false);
				if((ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE) || (jtf2.getText().length() >= 5))
					e.consume();
			}
		});
		jtf2.addActionListener(this);
		
		txt1 = new JLabel("Altura:");
		txt1.setBounds(160, 50, 50, 25);
		txt2 = new JLabel("Base");
		txt2.setBounds(160, 80, 50, 25);
		
		//Nova forma de utilizar Labels (mensagens de utilizador)
		wutil =  new JLabel();
		wutil.setVisible(false);
		wutil.setHorizontalAlignment(SwingConstants.CENTER);
		wutil.setIcon(new ImageIcon("src/img/aviso.jpg"));
		
		wutil1 = new JLabel();
		wutil1 .setVisible(false);
		wutil1.setHorizontalAlignment(SwingConstants.CENTER);
		wutil1.setIcon(new ImageIcon("src/img/aviso.jpg"));
		
		image = new ImageIcon("src/img/Aviso.png");
		
		janela.add(painel);
		painel.add(txt);
		painel.add(jtf1);
		painel.add(txt1);
		painel.add(jtf2);
		painel.add(txt2);
		painel.add(wutil);
		painel.add(wutil1);
		
		calc = new JButton("Area?");
		calc.setBounds(100, 160, 80, 25);
		calc.addActionListener(this);
		
		//alterar o botão sair
		sair = new JButton("SAIR");
		sair.setBounds(200, 160, 80, 25);
		
		sair.setFocusable(false);
		sair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sair.setFont(new Font("Arial Black", Font.BOLD, 8));
		sair.setForeground(new Color(0, 0, 0));
		sair.setBackground(new Color(128, 0, 0));
		sair.addActionListener(this);
		painel.add(calc);
		painel.add(sair);
		
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		//sair
		if(ev.getSource() == sair) {
			janela.dispose();
		}
		//Calcular a area 
		if(ev.getSource() == calc) {
			if(jtf1.getText().trim().equals("")) {
				wutil.setVisible(true);
				wutil.setBounds(250, 50, 50, 25);
				wutil.setToolTipText("Não preencheu a altura");
			}
			else
				wutil.setVisible(false);
			if(jtf2.getText().trim().equals("")) {
				wutil1.setVisible(true);
				wutil1.setBounds(250, 80, 50, 25);
				wutil1.setToolTipText("Não preencheu a Base");
			}
			else {
				wutil1.setVisible(false);
			}
			if(!jtf1.getText().trim().equals("") && !jtf2.getText().trim().equals("")) {
				Triangulo t = new Triangulo();
				
				UIManager.put("OptionPane.Background", Color.ORANGE);
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.ORANGE);
				try {
					t.setAlt(Double.parseDouble(jtf1.getText()));
					t.setLarg(Double.parseDouble(jtf2.getText()));
					JOptionPane.showMessageDialog(null,  t.calcArea(), "A Area do triangulo é: ", JOptionPane.INFORMATION_MESSAGE);
				}catch(NumberFormatException e) {
					//e.printStackTrace();
					System.out.println("NumberFormatException ERROR");
					JOptionPane.showMessageDialog(null, "Introduziu letras em vez de números!!!", "Erro", JOptionPane.ERROR_MESSAGE, image);
					jtf1.setText("");
					jtf2.setText("");
				}
			}
		}
	}
}