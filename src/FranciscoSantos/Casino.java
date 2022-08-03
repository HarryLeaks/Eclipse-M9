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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Casino extends Principal implements FocusListener, ActionListener{
	private JFrame window;
	private JPanel panel;
	private JLabel roulette, rouletteImg;
	private JLabel slot;
	private JLabel[] slotImg = new JLabel[3];
	private String[] images = {"src/images/casino/slots/1.png", "src/images/casino/slots/2.png", "src/images/casino/slots/3.png"};
	private JLabel bet1, bet2, JColor;
	private JTextField betValue1, betValue2;
	private String[] colors = {"Black", "Red", "Green"};
	private JComboBox<String> color = new JComboBox<String>(colors);
	private JButton spin;
	private int num;
	private boolean rotating1;
	private JLabel sort;
	private Boolean pressed, pressed2 = false;
	private Random randIndex = new Random();
	private Thread time1, time2;
	
	public void win() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500, 250);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(5);
		ImageIcon icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		window.setIconImage(logo);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 400);
		panel.setBackground(new Color(7, 133, 95));
		
		time1 = new Thread() {
			public void run() {
				while(true) {
					timeCounter(3, true);
				}
			}
		};
		
		time2 = new Thread() {
			public void run() {
				while(true) {
					timeCounter(3, false);
				}
			}
		};
		
		roulette = new JLabel("Roulette");
		roulette.setFont(new Font("Sans Serif", Font.BOLD, 16));
		roulette.setBounds(80, 5, 70, 30);
		roulette.setForeground(new Color(255, 255, 255));
		rouletteImg = new JLabel(new ImageIcon("src/images/casino/roleta/roullete2.png"));
		rouletteImg.setBounds(60, 45, 100, 100);
		rouletteImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rouletteImg.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(!betValue1.getText().equals(null) && !betValue1.getText().equals("0") && !betValue1.getText().equals("") && rotating1 == false) {
					rouletteImg.setIcon(new ImageIcon("src/images/casino/roleta/roullete.gif"));
					rotating1 = true;
					pressed = true;
					time1.start();
				}
			}
		});
		
		bet1 = new JLabel("Bet value:");
		bet1.setBounds(30, 155, 70, 20);
		bet1.setFont(new Font("Sans Serif", Font.BOLD, 12));
		bet1.setForeground(new Color(255, 255, 255));
		betValue1 = new JTextField();
		betValue1.setBounds(100, 155, 100, 20);
		betValue1.addFocusListener(this);
		
		JColor = new JLabel("Color:");
		JColor.setBounds(30, 185, 70, 20);
		JColor.setFont(new Font("Sans Serif", Font.BOLD, 12));
		JColor.setForeground(new Color(255, 255, 255));
		
		color.setBounds(100,  185,  100,  20);
		
		sort = new JLabel();
		sort.setBounds(165, 70, 100, 30);
		
		slot = new JLabel("Slot Machine");
		slot.setFont(new Font("Sans Serif", Font.BOLD, 16));
		slot.setForeground(new Color(255, 255, 255));
		for(int i = 0; i < 3; i++) {
			slotImg[i] = new JLabel(new ImageIcon(images[i]));
		}
		spin = new JButton("Spin");
		spin.setEnabled(false);
		spin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(Integer.parseInt(betValue2.getText()) < getClient().getDeposit()) {
					pressed2 = true;
					time2.start();
				}
			}
		});
		bet2 = new JLabel("Bet value:");
		bet2.setFont(new Font("Sans Serif", Font.BOLD, 12));
		bet2.setForeground(new Color(255, 255, 255));
		betValue2 = new JTextField();
		betValue2.addFocusListener(this);
		
		slot.setBounds(315, 5, 100, 30);
		slotImg[0].setBounds(280, 45, 50, 100);
		slotImg[1].setBounds(330, 45, 50, 100);
		slotImg[2].setBounds(380, 45, 50, 100);
		
		spin.setBounds(335, 185, 100, 20);
		bet2.setBounds(265, 155, 70, 20);
		betValue2.setBounds(335, 155, 100, 20);
		betValue2.addFocusListener(this);
		
		panel.add(roulette);
		panel.add(rouletteImg);
		panel.add(bet1);
		panel.add(betValue1);
		panel.add(JColor);
		panel.add(color);
		panel.add(sort);
		panel.add(slot);
		for(int i = 0; i < 3; i++) {
			panel.add(slotImg[i]);
		}
		panel.add(betValue2);
		panel.add(bet2);
		panel.add(spin);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void timeCounter(int seconds, boolean roleta) {
		Date secStart = new Date();
		Date secEnd;
		if(roleta == true) {
			do {
				secEnd = new Date();
				//int time = (int)((secEnd.getTime() - secStart.getTime()) / 1000);
			}while(seconds != (int)((secEnd.getTime() - secStart.getTime()) / 1000));
			if(pressed == true) {
				rouletteImg.setIcon(new ImageIcon("src/images/casino/roleta/roullete2.png"));
				num = randIndex.nextInt(49) + 1;
				if(num % 2 == 0) {
					sort.setForeground(new Color(0, 0, 0));
					if(color.getSelectedIndex() == 0) {
						getClient().setDeposit(getClient().getDeposit() + Integer.parseInt(betValue1.getText()));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), (String)formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else {
						getClient().setDeposit(getClient().getDeposit() - Integer.parseInt(betValue1.getText()));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
				}else if(num % 2 != 0 && num != 5) {
					sort.setForeground(new Color(255, 0, 0));
					if(color.getSelectedIndex() == 1) {
						getClient().setDeposit(getClient().getDeposit() + Integer.parseInt(betValue1.getText()));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else {
						getClient().setDeposit(getClient().getDeposit() - Integer.parseInt(betValue1.getText()));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
				}else {
					sort.setForeground(new Color(255, 255, 255));
					if(color.getSelectedIndex() == 2) {
						getClient().setDeposit(getClient().getDeposit() + (Integer.parseInt(betValue1.getText())*4));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else {
						getClient().setDeposit(getClient().getDeposit() - Integer.parseInt(betValue1.getText()));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Roulette", betValue1.getText(), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
				}
				sort.setText("Sorted: " + num);
				System.out.println(getClient().getDeposit());
				pressed = false;
				rotating1 = false;
				window.dispose();
			}
		}else {
			if(pressed2 == true) {
				do {
					secEnd = new Date();
					//int time = (int)((secEnd.getTime() - secStart.getTime()) / 1000); 
					if((int)((secEnd.getTime() - secStart.getTime()) / 1000) < 1) {
						for(int i = 0; i < 3; i++)
							slotImg[i].setIcon(new ImageIcon(images[randIndex.nextInt(3)]));
					}else if((int)((secEnd.getTime() - secStart.getTime()) / 1000) < 2) {
						for(int i = 1; i < 3; i++)
							slotImg[i].setIcon(new ImageIcon(images[randIndex.nextInt(3)]));
					}else if((int)((secEnd.getTime() - secStart.getTime()) / 1000) < 3) {
						slotImg[2].setIcon(new ImageIcon(images[randIndex.nextInt(3)]));
					}
				}while(seconds != (int)((secEnd.getTime() - secStart.getTime()) / 1000));
					if(slotImg[0].getIcon().toString().equals(slotImg[1].getIcon().toString()) && slotImg[0].getIcon().toString().equals(slotImg[2].getIcon().toString())) {
						getClient().setDeposit(getClient().getDeposit() + ((Integer.parseInt(betValue2.getText()))*100));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Slot", betValue2.getText(), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if((slotImg[0].getIcon().toString().equals(slotImg[1].getIcon().toString()) && !slotImg[0].getIcon().toString().equals(slotImg[2].getIcon().toString())) || (!slotImg[0].getIcon().toString().equals(slotImg[1].getIcon().toString()) && slotImg[0].getIcon().toString().equals(slotImg[2].getIcon().toString())) || (!slotImg[0].getIcon().toString().equals(slotImg[1].getIcon().toString()) && slotImg[1].getIcon().toString().equals(slotImg[2].getIcon().toString()))) {
						getClient().setDeposit(getClient().getDeposit() - ((Integer.parseInt(betValue2.getText()) / 2)));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Slot", betValue2.getText(), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}else if(!slotImg[0].getIcon().toString().equals(slotImg[1].getIcon().toString()) && !slotImg[0].getIcon().toString().equals(slotImg[2].getIcon().toString()) && !slotImg[1].getIcon().toString().equals(slotImg[2].getIcon().toString())) {
						getClient().setDeposit(getClient().getDeposit() - (Integer.parseInt(betValue2.getText())));
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Slot", betValue2.getText(), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
					System.out.println(getClient().getDeposit());
			}
			pressed2 = false;
			window.dispose();
		}
	}
	public void focusLost(FocusEvent fe) {
		if(fe.getSource() == betValue1) {
			for(char i : betValue1.getText().toCharArray()) {
				if(!Character.isDigit(i)) {
					JOptionPane.showMessageDialog(window, "Only numbers!!!");
					betValue1.setText("0");
					break;
				}
			}
			if(betValue1.getText().equals("") == true|| betValue1.getText().equals(null) == true || Integer.parseInt(betValue1.getText()) > getClient().getDeposit()) {
				betValue1.setText("0");
			}
		}
		if(fe.getSource() == betValue2) {
			for(char i : betValue2.getText().toCharArray()) {
				if(!Character.isDigit(i)) {
					JOptionPane.showMessageDialog(window, "Only numbers!!!");
					betValue1.setText("0");
					break;
				}
			}
			if(betValue2.getText().equals("") == true || betValue2.getText().equals(null) == true || Integer.parseInt(betValue2.getText()) > getClient().getDeposit()) {
				betValue2.setText("0");
				spin.setEnabled(false);
			}
			if(!betValue2.getText().equals(null) && !betValue2.getText().equals("0") && !betValue2.getText().equals("")) {
				spin.setEnabled(true);
			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}
}