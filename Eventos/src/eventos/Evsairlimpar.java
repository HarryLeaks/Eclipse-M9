package eventos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Evsairlimpar extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JButton bot1, bot2, bot3;
	private JTextField txt1;
	private JLabel jltxt1, jltxt2;
	
	public void janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Eventos em Botões");
		setResizable(false);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		bot1 = new JButton("OK");
		bot2 = new JButton("SAIR");
		bot3 = new JButton("LIMPAR");
		
		bot1.addActionListener(this);
		bot2.addActionListener(this);
		bot3.addActionListener(this);
		
		txt1 = new JTextField();
		txt1.setBounds(100, 50, 250, 25);
		add(txt1);
		
		jltxt1 = new JLabel("NOME:");
		jltxt1.setBounds(50, 50, 80, 25);
		add(jltxt1);
		
		jltxt2 = new JLabel("");
		jltxt2.setBounds(50, 250, 200, 25);
		add(jltxt2);
		
		add(bot1);
		add(bot2);
		add(bot3);
		
		bot1.setBounds(100, 100, 100, 40);
		bot2.setBounds(200, 100, 100, 40);
		bot3.setBounds(300, 100, 100, 40);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == bot1) {
			jltxt2.setFont(new Font("SansSerif", Font.BOLD, 20));
			jltxt2.setText(txt1.getText().toUpperCase());
		}else if(ev.getSource() == bot2) {
			System.exit(0);
		}else if(ev.getSource() == bot3) {
			txt1.setText("");
		}
	}
	
	public static void main(String[] args) {
		Evsairlimpar win = new Evsairlimpar();
		win.janela();
	}
}
