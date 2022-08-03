package FranciscoSantos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class RegisterWin extends ClientInfo implements KeyListener, ActionListener {
	private JFrame win;
	private JPanel panel1, panel2;
	private JLabel openAccount, imgIcon, warnIcon;
	private ImageIcon icon;
	
	private JLabel jlName, jlEmail, jlPassword, jlDate, jlDeposit, jlCountry;
	private JTextField jtfName, jtfEmail;
	private String[] Countries = {"Afghanistan",
			"Albania",
			"Algeria",
			"Andorra",
			"Angola",
			"Antigua and Barbuda",
			"Argentina",
			"Armenia",
			"Australia",
			"Austria",
			"Azerbaijan",
			"The Bahamas",
			"Bahrain",
			"Bangladesh",
			"Barbados",
			"Belarus",
			"Belgium",
			"Belize",
			"Benin",
			"Bhutan",
			"Bolivia",
			"Bosnia and Herzegovina",
			"Botswana",
			"Brazil",
			"Brunei",
			"Bulgaria",
			"Burkina Faso",
			"Burundi",
			"Cabo Verde",
			"Cambodia",
			"Cameroon",
			"Canada",
			"Central African",
			"Chad",
			"Chile",
			"China",
			"Colombia",
			"Comoros",
			"Congo",
			"Costa Rica",
			"Côte d’Ivoire",
			"Croatia",
			"Cuba",
			"Cyprus",
			"Czech Republic",
			"Denmark",
			"Djibouti",
			"Dominica",
			"Dominican Republic",
			"East Timor",
			"Ecuador",
			"Egypt",
			"El Salvador",
			"Equatorial Guinea",
			"Eritrea",
			"Estonia",
			"Eswatini",
			"Ethiopia",
			"Fiji",
			"Finland",
			"France",
			"Gabon",
			"The Gambia",
			"Georgia",
			"Germany",
			"Ghana",
			"Greece",
			"Grenada",
			"Guatemala",
			"Guinea",
			"Guinea-Bissau",
			"Guyana",
			"Haiti",
			"Honduras",
			"Hungary",
			"Iceland",
			"India",
			"Indonesia",
			"Iran",
			"Iraq",
			"Ireland",
			"Israel",
			"Italy",
			"Jamaica",
			"Japan",
			"Jordan",
			"Kazakhstan",
			"Kenya",
			"Kiribati",
			"Korea",
			"Korea",
			"Kosovo",
			"Kuwait",
			"Kyrgyzstan",
			"Laos",
			"Latvia",
			"Lebanon",
			"Lesotho",
			"Liberia",
			"Libya",
			"Liechtenstein",
			"Lithuania",
			"Luxembourg",
			"Madagascar",
			"Malawi",
			"Malaysia",
			"Maldives",
			"Mali",
			"Malta",
			"Marshall Islands",
			"Mauritania",
			"Mauritius",
			"Mexico",
			"Micronesia", 
			"Moldova",
			"Monaco",
			"Mongolia",
			"Montenegro",
			"Morocco",
			"Mozambique",
			"Myanmar (Burma)",
			"Namibia",
			"Nauru",
			"Nepal",
			"Netherlands",
			"New Zealand",
			"Nicaragua",
			"Niger",
			"Nigeria",
			"North Macedonia",
			"Norway",
			"Oman",
			"Pakistan",
			"Palau",
			"Panama",
			"Papua New Guinea",
			"Paraguay",
			"Peru",
			"Philippines",
			"Poland",
			"Portugal",
			"Qatar",
			"Romania",
			"Russia",
			"Rwanda",
			"Saint Kitts and Nevis",
			"Saint Lucia",
			"Saint Vincent and the Grenadines",
			"Samoa",
			"San Marino",
			"Sao Tome and Principe",
			"Saudi Arabia",
			"Senegal",
			"Serbia",
			"Seychelles",
			"Sierra Leone",
			"Singapore",
			"Slovakia",
			"Slovenia",
			"Solomon Islands",
			"Somalia",
			"South Africa",
			"Spain",
			"Sri Lanka",
			"Sudan",
			"Sudan, South",
			"Suriname",
			"Sweden",
			"Switzerland",
			"Syria",
			"Taiwan",
			"Tajikistan",
			"Tanzania",
			"Thailand",
			"Togo",
			"Tonga",
			"Trinidad and Tobago",
			"Tunisia",
			"Turkey",
			"Turkmenistan",
			"Tuvalu",
			"Uganda",
			"Ukraine",
			"United Arab Emirates",
			"United Kingdom",
			"United States",
			"Uruguay",
			"Uzbekistan",
			"Vanuatu",
			"Vatican City",
			"Venezuela",
			"Vietnam",
			"Yemen",
			"Zambia",
			"Zimbabwe",
			};
	
	private String[] Deposit = {
			"100",
			"200", 
			"500", 
			"700", 
			"1000", 
			"1200", 
			"1500",
			"2000"	
	};
	
	private JComboBox<String> JCountry = new JComboBox<String>(Countries);
	private JComboBox<String> JDeposit = new JComboBox<String>(Deposit);
	private JPasswordField jpfPassword;
	private int cont;
	private boolean contains;
	
	private JDayChooser day;
	private JMonthChooser month;
	private JYearChooser year;
	
	private JButton JBack, JRegister;
	private static ClientInfo client = new ClientInfo();

	public void window() {
		win = new JFrame();
		win.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		win.setSize(500, 600);
		win.setLocationRelativeTo(null);
		win.setUndecorated(true);
		win.getRootPane().setWindowDecorationStyle(5);
		icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		win.setIconImage(logo);
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 0, 500, 60);
		panel1.setBackground(new Color(7, 133, 95));
		
		imgIcon = new JLabel(new ImageIcon("src/images/beticon.png"));
		imgIcon.setBounds(10, 5, 100, 50);
		panel1.add(imgIcon);
		openAccount = new JLabel("Open Account");
		openAccount.setBounds(200, 20, 120, 30);
		openAccount.setForeground(new Color(255, 255, 255));
		openAccount.setFont(new Font("Sans Serif", Font.BOLD, 16));
		panel1.add(openAccount);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 60, 500, 540);
		panel2.setBackground(new Color(242, 242, 242));
		
		jlName = new JLabel("Name: ");
		jlName.setBounds(70, 72, 80, 30);
		jlName.setForeground(new Color(0, 0, 0));
		jlName.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		jtfName = new JTextField();
		jtfName.setBounds(160, 80, 200, 20);
		
		jlEmail = new JLabel("Email: ");
		jlEmail.setBounds(70, 112, 80, 30);
		jlEmail.setForeground(new Color(0, 0, 0));
		jlEmail.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		jtfEmail = new JTextField();
		jtfEmail.setBounds(160, 120, 200, 20);
		jtfEmail.addKeyListener(this);
		
		jlPassword = new JLabel("Password: ");
		jlPassword.setBounds(70, 152, 90, 30);
		jlPassword.setForeground(new Color(0, 0, 0));
		jlPassword.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(160, 160, 200, 20);
		jpfPassword.addKeyListener(this);
		
		jlDate = new JLabel("Date:");
		jlDate.setBounds(70, 202, 90, 30);
		jlDate.setForeground(new Color(0, 0, 0));
		jlDate.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		
		day = new JDayChooser();
		month = new JMonthChooser();
		year = new JYearChooser();
		day.setBounds(120, 210, 200, 170);
		month.setBounds(340, 210, 115, 30);
		year.setBounds(340, 255, 115, 30);
		
		jlCountry = new JLabel("Country: ");
		jlCountry.setBounds(70, 375, 90, 30);
		jlCountry.setForeground(new Color(0, 0, 0));
		jlCountry.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		JCountry.setBounds(150, 375, 200, 30);
		
		jlDeposit = new JLabel("Deposit: ");
		jlDeposit.setBounds(70, 425, 90, 30);
		jlDeposit.setForeground(new Color(0, 0, 0));
		jlDeposit.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		JDeposit.setBounds(150, 425, 200, 30);
		
		JBack = new JButton("Cancel");
		JBack.setBounds(140, 500, 90, 30);
		JBack.setForeground(new Color(110, 110, 110));
		JBack.setFont(new Font("Sans Serif", Font.BOLD, 16));
		JBack.setBorderPainted(false);
		JBack.setContentAreaFilled(false);
		JBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JBack.addActionListener(this);
		
		JRegister = new JButton("Register");
		JRegister.setBounds(240, 500, 100, 30);
		JRegister.setForeground(new Color(110, 110, 110));
		JRegister.setFont(new Font("Sans Serif", Font.BOLD, 16));
		JRegister.setBorderPainted(false);
		JRegister.setContentAreaFilled(false);
		JRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JRegister.addActionListener(this);
		
		warnIcon = new JLabel(new ImageIcon("src/images/WarnIcon.jpg"));
		warnIcon.setBounds(370, 120, 30, 30);
		warnIcon.setVisible(false);
		
		panel2.add(jlName);
		panel2.add(jtfName);
		panel2.add(jlEmail);
		panel2.add(jtfEmail);
		panel2.add(jlPassword);
		panel2.add(jpfPassword);
		panel2.add(jlDate);
		panel2.add(jlCountry);
		panel2.add(JCountry);
		panel2.add(jlDeposit);
		panel2.add(JDeposit);
		panel2.add(JBack);
		panel2.add(JRegister);
		panel2.add(warnIcon);
		panel2.add(day);
		panel2.add(month);
		panel2.add(year);
		
		win.add(panel1);
		win.add(panel2);
		win.setVisible(true);
	}
	
	public void keyReleased(KeyEvent ev) {
		if(ev.getSource() == jpfPassword) {
			if(ev.getKeyCode() == 8) { //8 - Backspace Nao conta como caracter
				if(cont > 0) cont--;
				return;
			}
			if(ev.getKeyCode() == KeyEvent.VK_DELETE) { //Nao conta como caracter
				return;
			}
			cont++;
			if(cont > 10) {
				JOptionPane.showMessageDialog(win,  "Characters limit!");
				jpfPassword.setText(new String(jpfPassword.getPassword()).substring(0, new String(jpfPassword.getPassword()).length() - 1));
				cont--;
			}
		}
		if(ev.getSource() == jtfEmail) {
			if(ev.getKeyCode() == 50 && contains == false) {
				contains = true;
				warnIcon.setVisible(false);
			}else if(contains == false){
				//System.out.println("Warning");
				warnIcon.setVisible(true);
			}
			if(ev.getKeyCode() == 8) {
				if(!jtfEmail.getText().contains("@")) {
					contains = false;
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent ke) {
	}

	@Override
	public void keyPressed(KeyEvent ke) {
	}
	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == JBack) {
			win.dispose();
			Principal p = getWindow();
			p.win(true);
		}
		if(ev.getSource() == JRegister && jtfName.getText().isEmpty() == false && jtfEmail.getText().isEmpty() == false && new String(jpfPassword.getPassword()).isEmpty() == false && warnIcon.isVisible() == false) {
			if(check18() == true) {
				win.dispose();
				client.setName(jtfName.getText());
				client.setEmail(jtfEmail.getText());
				client.setPassword(new String(jpfPassword.getPassword()));
				client.setCountry(JCountry.getItemAt(JCountry.getSelectedIndex()));
				client.setDeposit(Integer.parseInt(JDeposit.getItemAt(JDeposit.getSelectedIndex())));
				client.setDay(day.getDay());
				client.setMonth(month.getMonth());
				client.setYear(year.getYear());
				Principal p = getWindow();
				System.out.println(client.getEmail() + " " + client.getPassword());
				p.win(true);
			}else {
				JOptionPane.showMessageDialog(win,  "You are under 18!");
			}
		}
	}
	
	public ClientInfo getClient() {
		return client;
	}
	
	public boolean check18() {
		Calendar date = new GregorianCalendar();
		if(date.get(Calendar.YEAR) - year.getYear() > 18) {
			return true;
		}else if(date.get(Calendar.YEAR) - year.getYear() == 18) {
			if(month.getMonth() < date.get(Calendar.MONTH)) {
				return true;
			}else if(month.getMonth() == date.get(Calendar.MONTH)) {
				if(day.getDay() <= date.get(Calendar.DAY_OF_MONTH)) {
					return true;
				}
			}
		}
		return false;
	}
}
