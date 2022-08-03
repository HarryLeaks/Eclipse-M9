package FranciscoSantos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;


public class Principal extends RegisterWin implements ActionListener{
	private JFrame window;
	private JPanel panel1;
	private JPanel[] panel2 = new JPanel[3];
	private JPanel panelGame; 
	private ImageIcon icon;
	private JLabel logo1;
	private JButton btnLogin, btnRegister, b, btnLive;
	private JPopupMenu popup1, popup2, popup3;
	private JMenuItem menuitems, menuitem, menuitems1; 
	private String items[] = {"Basketball", "Football", "Poker", "Roleta", "Slot"};
	private String imgPath[] = {"src/images/sports/Basketball.png", "src/images/sports/Football.png", "src/images/poker/poker_icon.png", "src/images/casino/roleta/roleta.png", "src/images/casino/slots/slot.jpg"};
	
	private JButton btnSign;
	private JLabel lb1, lb2, lb3;
	private JButton leftBtn1, leftBtn2, rightBtn1, rightBtn2;
	
	private JPanel inGame;
	private JButton btnAcc, btnCasino, btnTransation;
	
	private JLabel lb4, lb5;	
	private int pos = 1;
	
	private JButton btnSoccer, btnBasket, btnFooter;
	private JLabel soccerTeam1, soccerTeam2, basketTeam1, basketTeam2;
	private JLabel soccerTeam1Img, soccerTeam2Img, basketTeam1Img, basketTeam2Img;
	private SoccerInfo soccerTeams = new SoccerInfo();
	private BasketballInfo basketTeams = new BasketballInfo();
	private MinImageFootball minsoccerTeams = new MinImageFootball();
	private MinImageBasketball minbasketTeams = new MinImageBasketball();
	
	private JLabel match, results;
	private JButton bet;
	private int time;
	private int isInGame = 1;
	private boolean betting1 = false;
	private boolean betting2 = false; 
	
	private JLabel match2, results2;
	private JButton bet2;
	private int isInGame2 = 1;
	
	private boolean isLog;
	
	private JLabel profileImg, name, email, country, money = new JLabel(), birthday;
	private JFileChooser file = new JFileChooser();
	
	private Betting soccerBet = new Betting();
	private Betting basketBet = new Betting();
	private static Transations historic = new Transations(); 
	
	public void win() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.setSize(500, 600);
		window.setLocationRelativeTo(null);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				String title = "Confirm exit";
				String[] opc = {"Exit", "Cancel"};
				
				int response = JOptionPane.showOptionDialog(window, "Do you want to leave?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
	
				if(response == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(5);
		icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		window.setIconImage(logo);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 500, 60);
		panel1.setBackground(new Color(7, 133, 95));
		
		inGame = new JPanel();
		inGame.setBounds(0, 0, 500, 60);
		inGame.setLayout(null);
		inGame.setBackground(new Color(7, 133, 95));
		
		for(int i = 0; i < 3; i++) {
			panel2[i] = new JPanel();
			panel2[i].setLayout(null);
			panel2[i].setBounds(0, 0, 500, 180);
			panel2[i].setVisible(true);
			panel2[i].setOpaque(false);
			if(i == 0) {
				rightBtn1 = new JButton(new ImageIcon("src/images/rightBtn.png"));
				rightBtn1.setBounds(460, 110, 20, 20);
				rightBtn1.setContentAreaFilled(false);
				rightBtn1.addActionListener(this);
				
				panel2[i].setBackground(new Color(255, 0, 0));
				lb1 = new JLabel(new ImageIcon("src/images/promoSoccer.png"));
				lb1.setBounds(0, 60, 500, 120);
				lb1.setOpaque(true);
				
				lb2 = new JLabel("New Customers");
				lb2.setBounds(10, 70, 150, 30);
				lb2.setFont(new Font("Sans Serif", Font.BOLD, 10));
				lb2.setForeground(new Color(237, 238, 49));
				
				lb3 = new JLabel("Open Account Offer");
				lb3.setBounds(10, 87, 150, 30);
				lb3.setFont(new Font("Sans Serif", Font.BOLD, 14));
				lb3.setForeground(new Color(255, 255, 255));
				
				btnSign = new JButton("Register");
				btnSign.setForeground(new Color(237, 238, 49));
				btnSign.setBorder(new LineBorder(new Color(237, 238, 49)));
				btnSign.setBackground(new Color(237, 238, 49));
				btnSign.setFont(new Font("Sans Serif", Font.BOLD, 16));
				btnSign.setContentAreaFilled(false);
				btnSign.setBounds(10, 130, 90, 30);
				
				btnSign.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						btnSign.setContentAreaFilled(true);
					}
					
					public void mouseReleased(MouseEvent e) {
						btnSign.setContentAreaFilled(false);
					}
				});
				btnSign.addActionListener(this);
								
				panel2[i].add(rightBtn1);
				panel2[i].add(btnSign);
				panel2[i].add(lb3);
				panel2[i].add(lb2);
				panel2[i].add(lb1);
			}else if(i == 1){
				rightBtn2 = new JButton(new ImageIcon("src/images/rightBtn.png"));
				rightBtn2.setBounds(460, 110, 20, 20);
				rightBtn2.setContentAreaFilled(false);
				rightBtn2.addActionListener(this);
				
				leftBtn1 = new JButton(new ImageIcon("src/images/leftBtn.png"));
				leftBtn1.setBounds(20, 110, 20, 20);
				leftBtn1.setContentAreaFilled(false);
				leftBtn1.addActionListener(this);
				
				panel2[i].setBackground(new Color(255, 0, 0));
				
				lb4 = new JLabel(new ImageIcon("src/images/promocasino.jpg"));
				lb4.setBounds(0, 60, 500, 120);
				lb4.setOpaque(true);
				
				panel2[i].add(rightBtn2);
				panel2[i].add(leftBtn1);
				panel2[i].add(lb4);
				panel2[i].setVisible(false);
			}else if(i == 2){			
				leftBtn2 = new JButton(new ImageIcon("src/images/leftBtn.png"));
				leftBtn2.setBounds(20, 110, 20, 20);
				leftBtn2.setContentAreaFilled(false);
				leftBtn2.addActionListener(this);
				
				lb5 = new JLabel(new ImageIcon("src/images/promoPoker.jpg"));
				lb5.setBounds(0, 60, 500, 120);
				lb5.setOpaque(true);
				
				panel2[i].add(leftBtn2);
				panel2[i].add(lb5);
				panel2[i].setBackground(new Color(255, 255, 255));
				panel2[i].setVisible(false);
			}
		}
		
		logo1 = new JLabel(icon);
		logo1.setBounds(220, -5, 70, 70);
		panel1.add(logo1);
		
		btnRegister = new JButton("Join");
		btnRegister.setFont(new Font("Sans Serif", Font.BOLD, 16));
		btnRegister.setBounds(305, 15, 70, 30);
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBorderPainted(false);
		btnRegister.setContentAreaFilled(false);
		btnRegister.addActionListener(this);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Sans Serif", Font.BOLD, 16));
		btnLogin.setForeground(new Color(237, 238, 49));
		btnLogin.setBounds(370, 15, 80, 30);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.addActionListener(this);
		
		b = new JButton("A-Z");
		b.setFont(new Font("Sans Serif", Font.BOLD, 16));
		b.setForeground(new Color(255, 255, 255));
		b.setBounds(15,5, 60, 50);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
	
		popup1 = new JPopupMenu();
		for(int i = 0; i < items.length; i++) {
			menuitems = new JMenuItem(items[i], new ImageIcon(imgPath[i]));
			popup1.add(menuitems);
		}
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				popup1.show(b, -20, b.getBounds().height);
			}
		});
		
		btnLive = new JButton("Games Results");
		btnLive.setFont(new Font("Sans Serif", Font.BOLD, 16));
		btnLive.setForeground(new Color(255, 255, 255));
		btnLive.setBounds(65, 15, 160, 30);
		btnLive.setBorderPainted(false);
		btnLive.setContentAreaFilled(false);
		
		popup2 = new JPopupMenu();		
		btnLive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				popup2.show(btnLive, -20, btnLive.getBounds().height);
			}
		});
		
		panel1.add(btnLive);
		panel1.add(b);
		panel1.add(btnRegister);
		panel1.add(btnLogin);
		
		panelGame = new JPanel();
		panelGame.setLayout(null);
		panelGame.setVisible(true);
		panelGame.setOpaque(true);
		panelGame.setBounds(0,60, 500, 540);
		panelGame.setBackground(new Color(102, 102, 102));
		
		teams();
		
		match = new JLabel();
		match.setBounds(340, 240, 140, 30);
		match.setFont(new Font("Sans Serif", Font.BOLD, 12));
		match.setForeground(new Color(255, 255, 255));
		results = new JLabel();
		results.setBounds(340, 260, 140, 30);
		results.setFont(new Font("Sans Serif", Font.BOLD, 12));
		results.setForeground(new Color(255, 255, 255));

		bet = new JButton("Start Bet");
		bet.setForeground(new Color(237, 238, 49));
		bet.setBorder(new LineBorder(new Color(237, 238, 49)));
		bet.setBackground(new Color(237, 238, 49));
		bet.setFont(new Font("Sans Serif", Font.BOLD, 16));
		bet.setContentAreaFilled(false);
		bet.setBounds(340, 310, 90, 30);
		
		bet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bet.setContentAreaFilled(true);
			}
			
			public void mouseReleased(MouseEvent e) {
				bet.setContentAreaFilled(false);
			}
		});
		
		bet.addActionListener(this);
		
		btnFooter = new JButton();
		btnFooter.setBackground(new Color(7, 133, 95));
		btnFooter.setEnabled(false);
		btnFooter.setBounds(-5, 550, 505, 30);
		btnFooter.setForeground(new Color(7, 133, 95));
		btnBasket = new JButton("Basket Games");
		btnBasket.setFont(new Font("Sans Serif", Font.BOLD, 16));
		btnBasket.setForeground(new Color(255, 255, 255));
		btnBasket.setBounds(-5, 390, 505, 45);
		btnBasket.setBackground(new Color(7, 133, 95));
		btnBasket.setEnabled(false);
		btnSoccer = new JButton("Soccer Game");
		btnSoccer.setFont(new Font("Sans Serif", Font.BOLD, 16));
		btnSoccer.setBackground(new Color(7, 133, 95));
		btnSoccer.setEnabled(false);
		btnSoccer.setBounds(0, 180, 500, 45);
		
		panelGame.add(btnSoccer);
		panelGame.add(btnBasket);
		panelGame.add(btnFooter);
		panelGame.add(match);
		panelGame.add(results);
		panelGame.add(bet);
		
		teams2();
		match2 = new JLabel();
		match2.setBounds(340, 445, 140, 30);
		match2.setFont(new Font("Sans Serif", Font.BOLD, 12));
		match2.setForeground(new Color(255, 255, 255));
		results2 = new JLabel();
		results2.setBounds(340, 465, 140, 30);
		results2.setFont(new Font("Sans Serif", Font.BOLD, 12));
		results2.setForeground(new Color(255, 255, 255));

		bet2 = new JButton("Start Bet");
		bet2.setForeground(new Color(237, 238, 49));
		bet2.setBorder(new LineBorder(new Color(237, 238, 49)));
		bet2.setBackground(new Color(237, 238, 49));
		bet2.setFont(new Font("Sans Serif", Font.BOLD, 16));
		bet2.setContentAreaFilled(false);
		bet2.setBounds(340, 505, 90, 30);
		
		bet2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bet2.setContentAreaFilled(true);
			}
			
			public void mouseReleased(MouseEvent e) {
				bet2.setContentAreaFilled(false);
			}
		});		
		
		bet2.addActionListener(this);
		
		panelGame.add(match2);
		panelGame.add(results2);
		panelGame.add(bet2);
		
		window.add(panel1);
		for(int i = 0; i < 3; i++)
			window.add(panel2[i]);
		window.add(panelGame);
		window.setVisible(true);
		
		Thread time1 = new Thread() {
			public void run() {
				while(true) {
					timeCounter(5, true);
				}
			}
		};
		Thread time2 = new Thread() {
			public void run() {
				while(true) {
					timeCounter(7, false);
				}
			}
		};
		time1.start();
		time2.start();
		
		//win(1);
	}
	
	public void timeCounter(int seconds, boolean soccer)
	{
		Date secStart = new Date();
		Date secEnd;
		int countdown = seconds;
		if(soccer) {
			do {
				secEnd = new Date();
				time = (int)((secEnd.getTime() - secStart.getTime()) / 1000);
				if(isInGame == 1) {
					match.setText("Match Result in: " + (Integer.toString(countdown - time)));
				}else {
					match.setText("Next Match Starts in: " + (Integer.toString(countdown - time)));
					if(betting1 == true) {
						soccerBet.timeOut();
						betting1 = false;
					}
				}
				if(isLog == true) {
					moneyUpdate();				
				}
			}while(seconds != (int)((secEnd.getTime() - secStart.getTime()) / 1000));
			if(isInGame == 1) {
				isInGame = 0;
				soccerTeams.WhoWon();
				results.setText("Match Result: " + soccerTeams.getGolos1() + " x " + soccerTeams.getGolos2());
				if(isLog == true && soccerBet.isPressedBet() == true) {
					if(soccerBet.getSelectedTeam() == 1 && soccerTeams.getGolos1() > soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() + soccerBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(soccerBet.getSelectedTeam() == 1 && soccerTeams.getGolos1() <= soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() - soccerBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}else if(soccerBet.getSelectedTeam() == 0 && soccerTeams.getGolos1() == soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() + (soccerBet.getBetValue()*2));
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(soccerBet.getSelectedTeam() == 0 && soccerTeams.getGolos1() != soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() - soccerBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}else if(soccerBet.getSelectedTeam() == 2 && soccerTeams.getGolos1() < soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() + soccerBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(soccerBet.getSelectedTeam() == 2 && soccerTeams.getGolos1() >= soccerTeams.getGolos2()) {
						getClient().setDeposit(getClient().getDeposit() - soccerBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Soccer", String.valueOf(soccerBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
					System.out.println(soccerBet.getSelectedTeam());
					soccerBet.SetSelectedTeam();
					soccerBet.setPressedBet(false);
				}
				if(popup2.getComponentCount() == 15) {
					popup2.remove(0);
					popup2.remove(1);
					popup2.remove(2);
				}
				menuitem = new JMenuItem(soccerTeam1.getText() + " " + soccerTeams.getGolos1(), minsoccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())));
				popup2.add(menuitem);
				menuitem = new JMenuItem(soccerTeam2.getText() + " " + soccerTeams.getGolos2(), minsoccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())));
				popup2.add(menuitem);
				popup2.addSeparator();
			}else {
				isInGame = 1;
				results.setText("");
				soccerTeams.getTeam();
				soccerTeam1.setText(soccerTeams.getSoccerTeams(soccerTeams.getTeam1()));
				soccerTeam1Img.setIcon(soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())));		
				if(soccerTeam1.getText().equals("Juventus")) {
					soccerTeam1Img.setBounds(50, 270, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())).getIconHeight());
				}else {
					soccerTeam1Img.setBounds(50, 280, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())).getIconHeight());
				}
				
				soccerTeam2.setText(soccerTeams.getSoccerTeams(soccerTeams.getTeam2()));
				soccerTeam2Img.setIcon(soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())));
				if(soccerTeam2.getText().equals("Juventus")) {
					soccerTeam2Img.setBounds(200, 270, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())).getIconHeight());
				}else {
					soccerTeam2Img.setBounds(200, 280, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())).getIconHeight());
				}
				panelGame.add(soccerTeam1);
				panelGame.add(soccerTeam1Img);
				panelGame.add(soccerTeam2);
				panelGame.add(soccerTeam2Img);
			}
		}else {
			do {
				secEnd = new Date();
				time = (int)((secEnd.getTime() - secStart.getTime()) / 1000);
				if(isInGame2 == 1) {
					match2.setText("Match Result in: " + (Integer.toString(countdown - time)));
				}else {
					if(betting2 == true) {
						basketBet.timeOut();
						betting2 = false;
					}
					match2.setText("Next Match Starts in: " + (Integer.toString(countdown - time)));
				}
			}while(seconds != (int)((secEnd.getTime() - secStart.getTime()) / 1000));
			if(isInGame2 == 1) {
				isInGame2 = 0;
				basketTeams.WhoWon();
				results2.setText("Match Result: " + basketTeams.getPoints1() + " x " + basketTeams.getPoints2());
				if(isLog == true && basketBet.isPressedBet() == true) {
					if(basketBet.getSelectedTeam() == 1 && basketTeams.getPoints1() > basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() + basketBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(basketBet.getSelectedTeam() == 1 && basketTeams.getPoints1() <= basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() - basketBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}else if(basketBet.getSelectedTeam() == 0 && basketTeams.getPoints1() == basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() + (basketBet.getBetValue()*2));
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(basketBet.getSelectedTeam() == 0 && basketTeams.getPoints1() != basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() - basketBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}else if(basketBet.getSelectedTeam() == 2 && basketTeams.getPoints1() < basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() + basketBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "won");
						JOptionPane.showMessageDialog(window, "Won!!!");
					}else if(basketBet.getSelectedTeam() == 2 && basketTeams.getPoints1() >= basketTeams.getPoints2()) {
						getClient().setDeposit(getClient().getDeposit() - basketBet.getBetValue());
						money.setText("Bank: " + getClient().getDeposit() + "$");
						SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
						Date date = new Date(System.currentTimeMillis());
						addRow("Basket", String.valueOf(basketBet.getBetValue()), formatter.format(date), "loss");
						JOptionPane.showMessageDialog(window, "Lost!!!");
					}
					System.out.println(basketBet.getSelectedTeam());
					basketBet.SetSelectedTeam();
					basketBet.setPressedBet(false);
				}
				if(popup2.getComponentCount() == 15) {
					popup2.remove(0);
					popup2.remove(1);
					popup2.remove(2);
				}
				menuitem = new JMenuItem(basketTeam1.getText() + " " + basketTeams.getPoints1(), minbasketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())));
				popup2.add(menuitem);
				menuitem = new JMenuItem(basketTeam2.getText() + " " + basketTeams.getPoints2(), minbasketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())));
				popup2.add(menuitem);
				popup2.addSeparator();
			}else {
				isInGame2 = 1;
				results2.setText("");
				basketTeams.getTeam();
				basketTeam1.setText(basketTeams.getBasketTeams(basketTeams.getTeam1()));
				basketTeam1Img.setIcon(basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())));		
				if(basketTeam1.getText().equals("Miami Heat")) {
					basketTeam1Img.setBounds(50, 465, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())).getIconHeight());
				}else {
					basketTeam1Img.setBounds(50, 475, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())).getIconHeight());
				}
				
				basketTeam2.setText(basketTeams.getBasketTeams(basketTeams.getTeam2()));
				basketTeam2Img.setIcon(basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())));
				if(basketTeam2.getText().equals("Miami Heat")) {
					basketTeam2Img.setBounds(200, 465, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())).getIconHeight());
				}else {
					basketTeam2Img.setBounds(200, 475, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())).getIconHeight());
				}
				panelGame.add(basketTeam1);
				panelGame.add(basketTeam1Img);
				panelGame.add(basketTeam2);
				panelGame.add(basketTeam2Img);
			}
		}
	}
	
	public void teams() {
		soccerTeams.getTeam();
		soccerTeam1 = new JLabel(soccerTeams.getSoccerTeams(soccerTeams.getTeam1()));
		soccerTeam1.setBounds(50, 245, 100, 30);
		soccerTeam1.setForeground(new Color(255, 255, 255));
		soccerTeam1.setFont(new Font("Sans Serif", Font.BOLD, 16));
		soccerTeam1Img = new JLabel(soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())));		if(soccerTeam1.getText().equals("Juventus")) {
			soccerTeam1Img.setBounds(50, 260, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())).getIconHeight());
		}else {
			soccerTeam1Img.setBounds(50, 280, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam1())).getIconHeight());
		}
		
		soccerTeam2 = new JLabel(soccerTeams.getSoccerTeams(soccerTeams.getTeam2()));
		soccerTeam2.setBounds(200, 245, 100, 30);
		soccerTeam2.setForeground(new Color(255, 255, 255));
		soccerTeam2.setFont(new Font("Sans Serif", Font.BOLD, 16));
		soccerTeam2Img = new JLabel(soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())));
		soccerTeam2Img.setBounds(200, 275, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())).getIconHeight());
		if(soccerTeam2.getText().equals("Juventus")) {
			soccerTeam2Img.setBounds(200, 270, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())).getIconHeight());
		}else {
			soccerTeam2Img.setBounds(200, 280, 60, soccerTeams.getImage(soccerTeams.getSoccerTeams(soccerTeams.getTeam2())).getIconHeight());
		}
		
		panelGame.add(soccerTeam1);
		panelGame.add(soccerTeam1Img);
		panelGame.add(soccerTeam2);
		panelGame.add(soccerTeam2Img);
	}
	
	public void teams2() {
		basketTeams.getTeam();
		basketTeam1 = new JLabel(basketTeams.getBasketTeams(basketTeams.getTeam1()));
		basketTeam1.setBounds(50, 440, 100, 30);
		basketTeam1.setForeground(new Color(255, 255, 255));
		basketTeam1.setFont(new Font("Sans Serif", Font.BOLD, 16));
		basketTeam1Img = new JLabel(basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())));
		if(basketTeam1.getText().equals("Miami Heat")) {
			basketTeam1Img.setBounds(50, 465, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())).getIconHeight());
		}else {
			basketTeam1Img.setBounds(50, 475, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam1())).getIconHeight());
		}
		
		basketTeam2 = new JLabel(basketTeams.getBasketTeams(basketTeams.getTeam2()));
		basketTeam2.setBounds(200, 440, 100, 30);
		basketTeam2.setForeground(new Color(255, 255, 255));
		basketTeam2.setFont(new Font("Sans Serif", Font.BOLD, 16));
		basketTeam2Img = new JLabel(basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())));
		basketTeam2Img.setBounds(200, 470, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())).getIconHeight());
		if(basketTeam2.getText().equals("Miami Heat")) {
			basketTeam2Img.setBounds(200, 465, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())).getIconHeight());
		}else {
			basketTeam2Img.setBounds(200, 475, 60, basketTeams.getImage(basketTeams.getBasketTeams(basketTeams.getTeam2())).getIconHeight());
		}
		
		panelGame.add(basketTeam1);
		panelGame.add(basketTeam1Img);
		panelGame.add(basketTeam2);
		panelGame.add(basketTeam2Img);
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == rightBtn1 && pos == 1) {
			pos = 2;
			panel2[0].setVisible(false);
			panel2[1].setVisible(true);
		}
		if(ev.getSource() == rightBtn2 && pos == 2) {
			pos = 3;
			panel2[1].setVisible(false);
			panel2[2].setVisible(true);
		}
		if(ev.getSource() == leftBtn1 && pos  == 2) {
			pos = 1;
			panel2[1].setVisible(false);
			panel2[0].setVisible(true);
		}
		if(ev.getSource() == leftBtn2 && pos == 3) {
			pos = 2;
			panel2[2].setVisible(false);
			panel2[1].setVisible(true);
		}
		if(ev.getSource() == btnRegister || ev.getSource() == btnSign) {
			RegisterWin register = new RegisterWin();
			register.window();
			window.setVisible(false);
		}
		if(ev.getSource() == btnLogin) {
			Login login = new Login();
			login.win();
			window.setVisible(false);
		}
		if((ev.getSource() == bet || ev.getSource() == bet2) && isLog == false) {
			JOptionPane.showMessageDialog(window,  "You are not logged!");
		}
		if(ev.getSource() == bet && isInGame == 1 && getClient().getDeposit() > 0) {
			betting1 = true;
			soccerBet.setAll((ImageIcon) soccerTeam1Img.getIcon(), (ImageIcon) soccerTeam2Img.getIcon());
		}
		if(ev.getSource() == bet2 && isInGame2 == 1 && getClient().getDeposit() > 0) {
			betting2 = true;
			basketBet.setAll((ImageIcon) basketTeam1Img.getIcon(), (ImageIcon) basketTeam2Img.getIcon());
		}
		if(ev.getSource() == btnCasino) {
			Casino casino = new Casino();
			casino.win();
		}
	}
	
	public void win(Boolean bool) {
		window.setVisible(bool);
	}
	
	public void win(int loggin) {
		historic.win();
		historic.getJFrame().dispose();
		if(loggin == 1) {
			isLog = true;
			panel1.removeAll();
			btnCasino = new JButton("Casino");
			btnCasino.setFont(new Font("Sans Serif", Font.BOLD, 16));
			btnCasino.setBounds(85, 15, 160, 30);
			btnCasino.setForeground(new Color(255, 255, 255));
			btnCasino.setBorderPainted(false);
			btnCasino.setContentAreaFilled(false);
			btnCasino.addActionListener(this);
			
			btnAcc = new JButton(new ImageIcon("src/images/account.png"));
			btnAcc.setFont(new Font("Sans Serif", Font.BOLD, 16));
			btnAcc.setBounds(400, 0, 80, 60);
			btnAcc.setForeground(new Color(255, 255, 255));
			btnAcc.setBorderPainted(false);
			btnAcc.setContentAreaFilled(false);
			btnAcc.addActionListener(this);
			
			popup3 = new JPopupMenu();
			menuitems1 = new JMenuItem("Logout", new ImageIcon("src/images/logout.png"));
			popup3.add(menuitems1);
			
			btnAcc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					popup3.show(btnAcc, -20, btnAcc.getBounds().height);
				}
			});
			
			menuitems1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent ev) {
					if(ev.getSource() == menuitems1) {
						panel1.removeAll();
						btnLive.setBounds(65, 15, 160, 30);
						panel1.add(btnLive);
						panel1.add(b);
						panel1.add(logo1);
						panel1.add(btnRegister);
						panel1.add(btnLogin);
						for(int i = 0; i < 3; i++) {
							panel2[i].removeAll();
							if(i == 0) {
								panel2[i].setBackground(new Color(255, 0, 0));
								panel2[i].add(rightBtn1);
								panel2[i].add(btnSign);
								panel2[i].add(lb3);
								panel2[i].add(lb2);
								panel2[i].add(lb1);
							}else if(i == 1) {
								panel2[i].setBackground(new Color(255, 0, 0));
								panel2[i].add(rightBtn2);
								panel2[i].add(leftBtn1);
								panel2[i].add(lb4);
								panel2[i].setVisible(false);
							}else if(i == 2) {
								panel2[i].add(leftBtn2);
								panel2[i].add(lb5);
								panel2[i].setBackground(new Color(255, 255, 255));
								panel2[i].setVisible(false);
							}
						}
						window.repaint();
					}
				}
			});
			
			btnTransation = new JButton("Transations");
			btnTransation.setFont(new Font("Sans Serif", Font.BOLD, 16));
			btnTransation.setBounds(280, 15, 125, 30);
			btnTransation.setForeground(new Color(255, 255, 255));
			btnTransation.setBorderPainted(false);
			btnTransation.setContentAreaFilled(false);
			btnTransation.addActionListener(this);
			
			btnTransation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					historic.win();
				}
			});
			
			btnLive.setBounds(-20, 5, 160, 50);
			
			for(int i = 0; i < 3; i++) {
				panel2[i].removeAll();
				if(i == 0) {
					panel2[i].setVisible(true);
					profileImg = new JLabel(new ImageIcon("src/images/profile.png"));
					name = new JLabel("Name: " + getClient().getName());
					email = new JLabel("Email: " + getClient().getEmail());
					birthday = new JLabel("Birthday: " + getClient().getBirthday());
					country = new JLabel("Country: " + getClient().getCountry());
					money.setText("Bank: " + getClient().getDeposit() + "$");
					
					profileImg.setBounds(5, 65, 100, 100);
					profileImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
					profileImg.addMouseListener(new MouseAdapter(){
						@Override
						public void mousePressed(MouseEvent e) {
							file = new JFileChooser();
							int image = file.showSaveDialog(null);
							
							if(image == JFileChooser.APPROVE_OPTION) {
								profileImg.setIcon(new ImageIcon(file.getSelectedFile().getAbsolutePath()));	
							}
						}
					});
					
					name.setBounds(115, 65, 180, 30);
					name.setFont(new Font("Sans Serif", Font.BOLD, 14));
					email.setBounds(115, 95, 180, 30);
					email.setFont(new Font("Sans Serif", Font.BOLD, 14));
					birthday.setBounds(115, 125, 180, 30);
					birthday.setFont(new Font("Sans Serif", Font.BOLD, 14));		
					country.setBounds(320, 65, 180, 30);
					country.setFont(new Font("Sans Serif", Font.BOLD, 14));	
					money.setBounds(320, 95, 180, 30);
					money.setFont(new Font("Sans Serif", Font.BOLD, 14));		
					panel2[i].add(profileImg);
					panel2[i].add(name);
					panel2[i].add(email);
					panel2[i].add(birthday);
					panel2[i].add(country);
					panel2[i].add(money);
				}else {
					panel2[i].setVisible(false);
				}
			}
			
			panel1.add(logo1);
			panel1.add(btnLive);
			panel1.add(btnCasino);
			panel1.add(btnAcc);
			panel1.add(btnTransation);
						
			window.setVisible(true);
		}
	}
	
	public void addRow(String cat, String bet, String date, String profit) {
		Transations.getModel().addRow(new Object[] {cat, bet, date, profit});
	}
	
	public void moneyUpdate() {
		money.setText("Bank: " + getClient().getDeposit() + "$");
		window.repaint();
	}
}