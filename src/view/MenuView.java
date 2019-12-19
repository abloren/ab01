package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.DataFile;
import model.Menu;
import java.awt.Color;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel rootPane;
	private DefaultTableModel tableModel;
	ArrayList<Menu> menus;
	private controller.DataFile controller;
	private JButton btnDrink, btnWine, btnCafe, btnFood, btnBuy, btnExit, btnInfor;
	private JTable table;
	JRadioButton rdbtnNewRadioButton;
	private JLabel lblTotal;
	private JLabel lblMoney;
	private Menu m;
	public HashMap<Menu, Integer> mapTable;
	private Basket basket;
	private JMenuBar menuBar;
	private JButton btnAdmin;
	private Out out;
	private Admin admin;
	private JButton btnMenu;
	private BillView infor;
	
	public MenuView() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Wine Store"); // file name
		loadMenuData("data.txt"); //메뉴 전부 다 읽어서 받음
		mapTable = new HashMap<Menu, Integer>(); //메뉴와 해당한 개수 저장
		addControl(); //GUI 설계 함수
		addEvent(); //이벤트 처리 함수
	}

	void showData() {
		tableModel.setRowCount(0); //만약에 출력전 테이터 없으면 테이블 내용을 다 치움
		for (Menu m : mapTable.keySet()) {
			tableModel.addRow(new Object[] { m.getName(), mapTable.get(m), (m.getPrice() * mapTable.get(m)) }); //테이블 데이터 표현
		}

		int total = 0;
		for (Menu m : mapTable.keySet()) {
			total += (m.getPrice() * mapTable.get(m));
		}
		lblMoney.setText(String.valueOf(total)); //총 계선해야 될 금액
	}

	
	public Menu findMenuByName(String name) { //비교해서 개체 return
		for (Menu m : menus) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}

	public void addMenu(String name, int countR) {  // add data to MenuView from Dink, Cafe, Wine, Food
		m = findMenuByName(name);
		if (!mapTable.containsKey(m)) {
			mapTable.put(m, countR);
		} else {
			int getValueSame = 0;
			getValueSame = mapTable.get(m);
			int newValue = getValueSame + countR;
			mapTable.replace(m, newValue);
		}
		showData();
	}
	
	private void loadMenuData(String file) { //load all data of menus
		controller = new DataFile();
		menus = controller.readDataFromFile(file);
	}
	
	private void addEvent() {
		btnDrink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventWater(e);
			}
		});

		btnCafe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventCafe(e);
			}
		});
		btnWine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventWine(e);
			}
		});
		btnFood.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventFood(e);
			}
		});
		btnBuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventBuy(e);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventExit(e);
			}
		});
		btnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventAdmin(e);
			}
		});
		
		btnInfor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventInfo(e);
			}
		});
	}

	protected void btnEventInfo(ActionEvent e) {
		infor = new BillView(this, true);
		infor.setLocationRelativeTo(null);
		infor.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventAdmin(ActionEvent e) {
		admin = new Admin(this, true);
		admin.setLocationRelativeTo(null);
		admin.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventExit(ActionEvent e) {
		out = new Out(this, true);
		out.setLocationRelativeTo(null);
		out.setVisible(true);
	}
	

	protected void btnEventCancel(ActionEvent e) {
		mapTable.clear();
		showData();
	}

	protected void btnEventBuy(ActionEvent e) {
		basket = new Basket(this, true);
		basket.showData();
		showData();
		mapTable.clear();
		showData();
		basket.setLocationRelativeTo(null);
		basket.setVisible(true);
	}

	protected void btnEventFood(ActionEvent e) {
		Food w = new Food(this, true);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventWine(ActionEvent e) {
		Wine w = new Wine(this, true);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventCafe(ActionEvent e) {
		Cafe w = new Cafe(this, true);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventWater(ActionEvent e) {
		Drink w = new Drink(this, true);
		w.setLocationRelativeTo(null);
		w.setVisible(true);
		this.setVisible(false);
	}

	private void addControl() {
		setBounds(100, 100, 606, 559);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		btnAdmin = new JButton("관리자");
		btnAdmin.setBackground(SystemColor.inactiveCaption);
		menuBar.add(btnAdmin);
		 
		 btnMenu = new JButton("메뉴");
		 btnMenu.setBackground(SystemColor.inactiveCaption);
		 menuBar.add(btnMenu);
		
		 btnInfor = new JButton("영수증");
		 btnInfor.setBackground(SystemColor.inactiveCaption);
		menuBar.add(btnInfor);
		
		 btnExit = new JButton("종류");
		 btnExit.setForeground(Color.BLACK);
		 btnExit.setBackground(Color.ORANGE);
		 menuBar.add(btnExit);
		
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);

		JPanel panel = new JPanel();
		GroupLayout gl_rootPane = new GroupLayout(rootPane);
		gl_rootPane.setHorizontalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_rootPane.setVerticalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);

		// gan anh vo button
		btnCafe = new JButton("Cafe");
		btnCafe.setBackground(SystemColor.inactiveCaption);

		btnDrink = new JButton("Drink");
		btnDrink.setBackground(SystemColor.inactiveCaption);

		btnFood = new JButton("Food");

		btnFood.setBackground(SystemColor.inactiveCaption);

		btnWine = new JButton("Wine");
		btnWine.setBackground(SystemColor.inactiveCaption);
		table = new JTable();
		String columnName[] = { "이름", "개수", "총금액" };
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columnName));
		tableModel = (DefaultTableModel) table.getModel();
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(table);

		rdbtnNewRadioButton = new JRadioButton("Coupon");
		lblTotal = new JLabel("Total:");

		lblMoney = new JLabel("0");

		btnBuy = new JButton("주문");
		btnBuy.setBackground(SystemColor.inactiveCaption);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnWine, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFood, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDrink, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCafe, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(sp, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(96)
							.addComponent(lblTotal)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(sp, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCafe, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDrink, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnFood, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnWine, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuy)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		rootPane.setLayout(gl_rootPane);
	}
}
