package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EventoRadio implements ActionListener{
	private static final long servialVersionUID = 1L;
	private JFrame janela;
	private JPanel painel;
	
	private ButtonGroup group;
	private JRadioButton bt1, bt2, bt3;
	private JLabel txt;
	
	public void janela() {
		janela = new JFrame();
		painel = new JPanel();
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setTitle("RadioButtons");
		janela.setLocationRelativeTo(null);
		janela.setSize(600, 400);
		painel.setOpaque(true);
		painel.setLayout(null);
		janela.add(painel);
		
		group = new ButtonGroup();
		bt1 = new JRadioButton("Letra A");
		bt2 = new JRadioButton("Letra B");
		bt3 = new JRadioButton("Letra C");
		
		group.add(bt1);
		group.add(bt2);
		group.add(bt3);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		txt = new JLabel("Sem seleção");
	
		bt1.setBounds(200, 40, 80, 20);
		bt2.setBounds(200, 80, 80, 20);
		bt3.setBounds(200, 120, 80, 20);
		txt.setBounds(200, 250, 150, 100);
		
		painel.add(bt1);
		painel.add(bt2);
		painel.add(bt3);
		painel.add(txt);
		
		janela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		JRadioButton bot = (JRadioButton) ev.getSource();
		txt.setText(bot.getText() + " Selecionada");
	}
	
	public static void main(String[] args) {
		EventoRadio win = new EventoRadio();
		win.janela();
	}
}
