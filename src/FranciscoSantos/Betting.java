package FranciscoSantos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Betting extends RegisterWin implements ActionListener, FocusListener{
	private JFrame window;
	private JPanel panel;
	private JLabel team1Img, team2Img;
	private JButton bet;
	private JTextField quantBet;
	private int isSelected = 0;
	private boolean pressedBet = false;
	
	public void setAll(ImageIcon img, ImageIcon img2) {		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(250, 200);
		window.setLocationRelativeTo(null);
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(5);
		ImageIcon icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		window.setIconImage(logo);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 102, 102));
		team1Img = new JLabel(img);
		team1Img.setBounds(10, 10, 80, 80);
		team1Img.setCursor(new Cursor(Cursor.HAND_CURSOR));
		team1Img.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(isSelected == 0) {
					isSelected = 1;
				}else if(isSelected == 2) {
					isSelected = 1;
					team2Img.setBorder(null);
				}
				team1Img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));			}
		});
		team2Img = new JLabel(img2);
		team2Img.setBounds(150, 10, 80, 80);
		team2Img.setCursor(new Cursor(Cursor.HAND_CURSOR));
		team2Img.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(isSelected == 0) {
					isSelected = 2;
				}else if(isSelected == 1) {
					isSelected = 2;
					team1Img.setBorder(null);
				}
				team2Img.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			}
		});
		quantBet = new JTextField();
		quantBet.setText("0");
		quantBet.setBounds(70, 100, 100, 30);
		bet = new JButton("BET");
		bet.setBounds(90, 135, 60, 30);
		bet.setForeground(new Color(237, 238, 49));
		bet.setBorder(new LineBorder(new Color(237, 238, 49)));
		bet.setBackground(new Color(237, 238, 49));
		bet.setFont(new Font("Sans Serif", Font.BOLD, 16));
		bet.setContentAreaFilled(false);
		bet.addActionListener(this);
		
		panel.add(team1Img);
		panel.add(team2Img);
		panel.add(quantBet);
		panel.add(bet);
		window.add(panel);
		window.setVisible(true);
		quantBet.addFocusListener(this);
	}
	
	public void timeOut() {
		if(window.isDisplayable())
			JOptionPane.showMessageDialog(window, "Game Time out!!!");
		window.dispose();
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == bet) {
			if(getClient().getDeposit() < Integer.parseInt(quantBet.getText())) {
				JOptionPane.showMessageDialog(window, "You have less money!!!");
				quantBet.setText("0");
			}else {
				pressedBet = true;
				window.dispose();
			}
		}
	}
	
	public boolean isPressedBet() {
		return pressedBet;
	}

	public void setPressedBet(boolean pressedBet) {
		this.pressedBet = pressedBet;
	}

	public void focusLost(FocusEvent fe) {
		if(fe.getSource() == quantBet) {
			for(char i : quantBet.getText().toCharArray()) {
				if(!Character.isDigit(i)) {
					JOptionPane.showMessageDialog(window, "Only numbers!!!");
					quantBet.setText("0");
					break;
				}
			}
		}
	}
	
	public int getBetValue() {
		return Integer.parseInt(quantBet.getText());
	}
	
	public int getSelectedTeam() {
		return isSelected;
	}
	
	public void SetSelectedTeam() {
		isSelected = 0;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}




