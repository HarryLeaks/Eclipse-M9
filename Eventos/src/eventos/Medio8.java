package eventos;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JYearChooser;

public class Medio8 implements ActionListener{	
	private JFrame window;
	private JPanel panel;
	private ImageIcon icon;
	
	private JLabel lbnome, lbmorada;
	private JTextField jtfnome, jtfmorada;
	
	private ImageIcon perfil, preferencia;
	private JLabel fotoPerfil, fotoPreferencia;
	
	private JButton aplicar, limpar, ajuda, sair;
	
	private JLabel jlano, jlturma, jlnascimento;
	private JComboBox<String> ano, turma;
	private JYearChooser year;
	
	private JLabel sexo;
	private ButtonGroup genero;
	private JRadioButton masculino;
	private JRadioButton feminino;
	
	private JLabel redesociais;
	private ButtonGroup rede;
	private JCheckBox facebook, twitter, instagram, linkedin;
	
	//private faceb

	public void janela() {
		window = new JFrame();
		panel = new JPanel();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("A Minha Informação");
		window.setSize(490, 470);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		panel.setLayout(null);
		panel.setBackground(Color.GREEN);
		window.add(panel);
		
		//modificar tipo de janela + icon no titleBar
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(8); //utiliza valor inteiro de 1 a 8
		icon = new ImageIcon("src/eventos/apply.png");
		Image logo = icon.getImage();
		window.setIconImage(logo);
		
		perfil = new ImageIcon("src/eventos/ric.jpg");
		fotoPerfil = new JLabel(perfil);
		fotoPerfil.setBorder(BorderFactory.createTitledBorder("Aluno"));
		
		preferencia = new ImageIcon("src/eventos/logo.jpg");
		fotoPreferencia = new JLabel(preferencia);
		fotoPreferencia.setBorder(BorderFactory.createTitledBorder("Preferências"));
		
		redesociais = new JLabel("REDES SOCIAIS: ");
		rede = new ButtonGroup();
		facebook = new JCheckBox("FaceBook", false);
		facebook.addActionListener(this);
		twitter = new JCheckBox("twitter", true);
		twitter.addActionListener(this);
		instagram = new JCheckBox("Instagram", false);
		instagram.addActionListener(this);
		linkedin = new JCheckBox("Linkedin", false);
		linkedin.addActionListener(this);
		rede.add(facebook);
		rede.add(twitter);
		rede.add(instagram);
		rede.add(linkedin);
		
		lbnome = new JLabel("NOME: ");
		jtfnome = new JTextField();
		lbmorada = new JLabel("MORADA: ");
		jtfmorada = new JTextField();
		
		aplicar = new JButton(new ImageIcon("src/eventos/apply.png"));
		limpar = new JButton("Limpar");
		ajuda = new JButton("Ajuda");
		sair = new JButton("Sair");
		
		sexo = new JLabel("SEXO: ");
		genero = new ButtonGroup();
		masculino = new JRadioButton("Masculino", true);
		feminino = new JRadioButton("Feminino");
		genero.add(masculino);
		genero.add(feminino);
		
		jlano = new JLabel("ANO: ");
		ano = new JComboBox<String>();
		ano.addItem("10º");
		ano.addItem("11º");
		ano.addItem("12º");
		
		jlturma = new JLabel("TURMA: ");
		turma = new JComboBox<String>();
		turma.addItem("1ª");
		turma.addItem("2ª");
		turma.addItem("3ª");
		
		jlnascimento = new JLabel("ANO NASCIMENTO");
		year = new JYearChooser();
		
		fotoPerfil.setBounds(10, 10, 160, 220);
		fotoPreferencia.setBounds(190, 10, 160, 180);
		
		redesociais.setBounds(195, 185, 100, 20);
		facebook.setBounds(195, 210, 100, 20);
		twitter.setBounds(195, 235, 100, 20);
		instagram.setBounds(195, 260, 100, 20);
		linkedin.setBounds(195, 285, 100, 20);
		
		lbnome.setBounds(10, 310, 70, 20);
		lbmorada.setBounds(10, 335, 70, 20);
		jtfnome.setBounds(85, 310, 240, 20);
		jtfmorada.setBounds(85, 335, 240, 20);
		
		aplicar.setBounds(195, 380, 70, 25);
		ajuda.setBounds(275, 380, 70, 25);
		limpar.setBounds(355, 380, 80, 25);
		sair.setBounds(115, 380, 70,25);
		
		sexo.setBounds(390, 10, 100, 20);
		masculino.setBounds(360, 35, 100, 30);
		feminino.setBounds(360, 60, 100, 30);
		
		jlano.setBounds(390, 100, 100, 20);
		ano.setBounds(360, 120, 100, 25);
		
		jlturma.setBounds(390, 170, 100, 20);
		turma.setBounds(360, 190, 100, 25);
		
		jlnascimento.setBounds(360, 240, 120, 20);
		year.setBounds(360, 260, 100, 20);
		
		panel.add(redesociais);
		panel.add(facebook);
		panel.add(twitter);
		panel.add(instagram);
		panel.add(linkedin);
		panel.add(fotoPerfil);
		panel.add(fotoPreferencia);
		panel.add(lbnome);
		panel.add(lbmorada);
		panel.add(jtfnome);
		panel.add(jtfmorada);
		panel.add(aplicar);
		panel.add(ajuda);
		panel.add(sair);
		panel.add(limpar);
		panel.add(sexo);
		panel.add(masculino);
		panel.add(feminino);
		panel.add(jlano);
		panel.add(ano);
		panel.add(jlturma);
		panel.add(turma);
		panel.add(jlnascimento);
		panel.add(year);
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev){
		//submeter
		if(ev.getSource() == aplicar) {
			//guardar dados
		}
		//Limpar (má solução)
		else if(ev.getSource() == limpar) {
			window.dispose();
			Medio8 window = new Medio8();
			window.janela();
		}else if(ev.getSource() == sair) {
			window.dispose();
		}else if(ev.getSource() == ajuda) {
			JOptionPane.showMessageDialog(window, "Preencha os campos de acordo com as informações\n de ajuda disponibilizada!\n\n\n");
		}else if(ev.getSource() == facebook) {
			panel.remove(redesociais);
			redesociais = new JLabel("", faceb, SwingConstants.LEFT);
			redesociais.setBorder(BorderFactory.createTitledBorder("Preferências"));
			redesociais.setHorizontalAlignment(SwingConstants.CENTER);
			redesociais.setBounds(180, 10, 150, 140);
			panel.add(redesociais);
			panel.validate();
			panel.repaint();
		}else if(ev.getSource() == twitter) {
			panel.remove(redesociais);
			redesociais = new JLabel("", twit, SwingConstants.LEFT);
			redesociais.setBorder(BorderFactory.createTitledBorder("Preferências"));
			redesociais.setHorizontalAlignment(SwingConstants.CENTER);
			redesociais.setBounds(180, 10, 150, 140);
			panel.add(redesociais);
			panel.validate();
			panel.repaint();
		}else if(ev.getSource() == instagram) {
			panel.remove(redesociais);
			redesociais = new JLabel("", insta, SwingConstants.LEFT);
			redesociais.setBorder(BorderFactory.createTitledBorder("Preferências"));
			redesociais.setHorizontalAlignment(SwingConstants.CENTER);
			redesociais.setBounds(180, 10, 150, 140);
			panel.add(redesociais);
			panel.validate();
			panel.repaint();
		}else if(ev.getSource() == linkedin) {
			panel.remove(redesociais);
			redesociais = new JLabel("", link, SwingConstants.LEFT);
			redesociais.setBorder(BorderFactory.createTitledBorder("Preferências"));
			redesociais.setHorizontalAlignment(SwingConstants.CENTER);
			redesociais.setBounds(180, 10, 150, 140);
			panel.add(redesociais);
			panel.validate();
			panel.repaint();
		}
	}
	
	public static void main(String[] args) {
		Medio8 win = new Medio8();
		win.janela();
	}
}
