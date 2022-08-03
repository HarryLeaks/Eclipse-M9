package FranciscoSantos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends RegisterWin implements ActionListener{
	private JFrame win;
	private JPanel panel1, panel2;
	private JLabel login, jlEmail, jlPassword;
	private JTextField jtfEmail;
	private JPasswordField jpfPassword;
	private JButton btnCancel, btnLogin;
	private ImageIcon icon;
	private ClientInfo client = getClient();
	
	public void win() {
		win = new JFrame();
		win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		win.setSize(250, 250);
		win.setLocationRelativeTo(null);
		win.setUndecorated(true);
		win.getRootPane().setWindowDecorationStyle(5);
		icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		win.setIconImage(logo);
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 250, 30);
		panel1.setBackground(new Color(7, 133, 95));
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 30, 250, 275);
		panel2.setBackground(new Color(242, 242, 242));
		
		login = new JLabel("Login In Your Account");
		login.setBounds(40, -10, 180, 50);
		login.setFont(new Font("Sans Serif", Font.BOLD, 16));
		login.setForeground(new Color(255, 255, 255));
		
		jlEmail = new JLabel("Email: ");
		jlEmail.setBounds(20, 50, 60, 30);
		jlEmail.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		jlEmail.setForeground(new Color(0, 0, 0));
		jtfEmail = new JTextField();
		jtfEmail.setBounds(105, 58, 120, 20);
		
		jlPassword = new JLabel("Password: ");
		jlPassword.setBounds(20, 100, 90, 30);
		jlPassword.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		jlPassword.setForeground(new Color(0, 0, 0));
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(105, 108, 120, 20);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(20, 150, 100, 30);
		btnCancel.setForeground(new Color(110, 110, 110));
		btnCancel.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(this);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(140, 150, 80, 30);
		btnLogin.setForeground(new Color(110, 110, 110));
		btnLogin.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(this);
		
		panel1.add(login);
		panel2.add(jlEmail);
		panel2.add(jtfEmail);
		panel2.add(jlPassword);
		panel2.add(jpfPassword);
		panel2.add(btnCancel);
		panel2.add(btnLogin);
		
		win.add(panel1);
		win.add(panel2);
		win.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel)	{
			win.dispose();
			Principal p = getWindow();
			p.win(true);
		}
		if(e.getSource() == btnLogin && jtfEmail.getText().equals(client.getEmail()) && new String(jpfPassword.getPassword()).equals(client.getPassword())) {
			Principal p = getWindow();
			p.win(1);
			win.dispose();
		}
		if(e.getSource() == btnLogin && ((jtfEmail.getText().equals(client.getEmail())) == false || (new String(jpfPassword.getPassword()).equals(client.getPassword())) == false)) {
			JOptionPane.showMessageDialog(win, "Email or Password wrong!");
		}
	}
	
}
