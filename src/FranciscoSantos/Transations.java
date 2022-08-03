package FranciscoSantos;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Transations implements ChangeListener{
	private JFrame window;
	private JPanel panel, panel2;
	private JCheckBox cat1;
	private String[] column = {
			"Category",
			"Bet",
			"Date",
			"Profit"
	};
	 private JTable tbl = new JTable();
	 private static DefaultTableModel model = new DefaultTableModel(0, 0);
	 private boolean added = false;
	 private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	 private JScrollPane scrollPane = new JScrollPane();
	 
	public void win() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(500, 350);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setUndecorated(true);
		window.getRootPane().setWindowDecorationStyle(5);
		ImageIcon icon = new ImageIcon("src/images/logo.jpg");
		Image logo = icon.getImage();
		window.setIconImage(logo);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(
		         BorderFactory.createEtchedBorder(), "ODI Transations", TitledBorder.CENTER, TitledBorder.TOP));
		panel.setBounds(0, 0, 500, 400);
		panel.setBackground(new Color(7, 133, 95));
		panel2 = new JPanel();
		panel2.setLayout(null);

		tbl.setModel(model);
		if(added == false) {
			for(int i = 0; i < 4; i++)
				model.addColumn(column[i]);
			added = true;
		}
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tbl.setDefaultRenderer(String.class, centerRenderer);
		cat1 = new JCheckBox("Order by bet", false);
		cat1.addChangeListener(this);
		panel.add(cat1);
		
		scrollPane.setViewportView(tbl);
		scrollPane.setBounds(10, 50, 470, 250);
		panel2.add(scrollPane);
		window.add(scrollPane);
		window.add(panel);
		window.add(panel2);
		window.setVisible(true);
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}
	
	public void stateChanged(ChangeEvent ev){
		String auxcat, auxbet, auxdate, auxprofit;
		if(ev.getSource() == cat1) {
			if(cat1.isSelected()) {
				for(int i = 0; i < model.getRowCount(); i++) {
					for(int x = i; x < model.getRowCount(); x++) {
						if(Integer.parseUnsignedInt((String) model.getValueAt(i, 1)) > Integer.parseInt((String) model.getValueAt(x,  1))) {
							auxcat = (String) model.getValueAt(i, 0);
							auxbet = (String)model.getValueAt(i, 1);
							auxdate = (String)model.getValueAt(i, 2);
							auxprofit = (String)model.getValueAt(i, 3);
							model.setValueAt((String)model.getValueAt(x, 0), i, 0);
							model.setValueAt((String)model.getValueAt(x, 1), i, 1);
							model.setValueAt((String)model.getValueAt(x, 2), i, 2);
							model.setValueAt((String)model.getValueAt(x, 3), i, 3);
							model.setValueAt(auxcat, x, 0);
							model.setValueAt(auxbet, x, 1);
							model.setValueAt(auxdate, x, 2);
							model.setValueAt(auxprofit, x, 3);
						}
					}
				}
				tbl.repaint();
			}
		}
	}
	
	public JFrame getJFrame() {
		return window;
	}
}
