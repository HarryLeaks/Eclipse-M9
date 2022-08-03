package projeto;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JanelaForma extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JFrame janela;
   private JPanel painel1,painel2;
   private JLabel img,txt1,txt2;
   private JButton triangulo,retangulo,sair;
   private ImageIcon icon;
   
   public void formJan()
   {
	   janela=new JFrame();
	   janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	   janela.setSize(600, 500);
	   janela.setLocationRelativeTo(null);
	   
	   janela.setUndecorated(true);
	   janela.getRootPane().setWindowDecorationStyle(5); 
	   icon=new ImageIcon("src/img/logo.jpg");
	   Image logo=icon.getImage();
	   janela.setIconImage(logo);
	   

	   painel1=new JPanel();
	   painel1.setLayout(null);
	   painel1.setBounds(0, 0, 600, 75);
	   painel1.setOpaque(true);
	   painel1.setBackground(new Color(255,255,255));
	   img=new JLabel(new ImageIcon("src/img/fundo.jpg"), SwingConstants.LEFT);
	   img.setBounds(0,0,600,75);
	   painel1.add(img);
	   janela.add(painel1);
	   
	   	   
	   painel2=new JPanel();
	   painel2.setLayout(null);
	   painel2.setBounds(0, 300, 600, 450);
	   painel2.setOpaque(true);
	   painel2.setBackground(new Color(221,255,204));
	   
	   triangulo = new JButton(new ImageIcon("src/img/triang.jpg"));
	   triangulo.addActionListener(this);
	   txt1=new JLabel("ÁREA DO TRIÂNGULO");
	   txt1.setForeground(Color.blue);
	   triangulo.setBounds(120, 150, 100, 80);
	   txt1.setBounds(230, 160, 170, 100);
	   
	   retangulo = new JButton(new ImageIcon("src/img/retang.jpg"));
	   retangulo.addActionListener(this);
	   txt2=new JLabel("ÁREA DO RETÂNGULO");
	   txt2.setForeground(Color.blue);
	   retangulo.setBounds(120, 250, 100, 147);
	   txt2.setBounds(230, 300, 150, 120);
	   sair=new JButton("SAIR");
	   sair.addActionListener(this);
	   sair.setBounds(430, 360, 80, 40);
	   
	   
	   janela.add(painel2);
	   painel2.add(txt1);
	   painel2.add(triangulo);
	   painel2.add(txt2);
	   painel2.add(retangulo);
	   painel2.add(sair);
	   
	   janela.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ev) {
	   if(ev.getSource() == sair) {
		  System.exit(0); 
	   }
	   if(ev.getSource() == triangulo) {
		   Janelatriangulo janelaTring = new Janelatriangulo();
		   janelaTring.triJan();
	   }
	   if(ev.getSource() == retangulo) {
		   Janelaretangulo janelaRect = new Janelaretangulo();
		   janelaRect.rectJan();
	   }
   }
}
