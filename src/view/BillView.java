package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import data.impl.DataFile;
import model.Bill;
import model.Menu;
import java.awt.Color;

public class BillView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel rootPane;
	private JMenuBar menuBar;
	private JButton btnExit, btnMenu;
	private MenuView bill;
	private DataFile controller;
	private ArrayList<Menu> menus;
	private Out out;
	private ArrayList<Bill> arrCus;
	private JTextPane textPane;

	public BillView(JFrame parent, boolean modal) {
		this.setTitle("영수증");
		bill = (MenuView) parent;
		loadCustomerData("src/data/bill.txt");
		addControl();
		addEvent();
	}

	//file으로 부터 데이터 읽음
	private void loadCustomerData(String file) {
		controller = new DataFile();
		arrCus = new ArrayList<>();
		arrCus = controller.readBill(file);
	}

	private void addEvent() {
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventExit(e);
			}
		});
		btnMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventMenu(e);
			}
		});
	}

	protected void btnEventMenu(ActionEvent e) {
		bill = new MenuView();
		bill.setLocationRelativeTo(null);
		bill.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventExit(ActionEvent e) {
		out = new Out(this);
		out.setLocationRelativeTo(null);
		out.setVisible(true);
	}

	private void addControl() {
		setBounds(100, 100, 327, 226);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnMenu = new JButton("메뉴");
		btnMenu.setBackground(SystemColor.scrollbar);
		menuBar.add(btnMenu);

		btnExit = new JButton("종류");
		btnExit.setBackground(Color.ORANGE);
		menuBar.add(btnExit);

		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new BoxLayout(rootPane, BoxLayout.X_AXIS));
		textPane = new JTextPane();
		StyledDocument doc = textPane.getStyledDocument();
		Style styleDef = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setFontFamily(styleDef, "SansSerif");
		StringBuilder str = new StringBuilder();
		
		for(Bill cus : arrCus) {
			str.append("Phone: "+cus.getphoneNumber()+"\n"+"Bank: "+cus.getBankId()
			+"\n"+"Pay Total: "+cus.getPayTotal()+"\n-----------------------------------------"+"\n");
		}
		try {
			doc.insertString(doc.getLength(), String.valueOf(str), doc.getStyle("regular"));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		
		JScrollPane sc = new JScrollPane(textPane);
		textPane.setEditable(false);
		rootPane.add(sc);
		
	}
}
