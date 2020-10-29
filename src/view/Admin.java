package view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.impl.DataFile;
import model.Customer;
import model.Menu;

public class Admin extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel rootPane;
	private DefaultTableModel tableModel, tableModel_1, tableModel_2;
	private JTable table;
	private JMenuBar menuBar;
	private JButton btnAdmin, btnExit, btnMenu, btnSee;
	private MenuView bill;
	@SuppressWarnings("unused")
	private BillView infor;
	private DataFile controller;
	private ArrayList<Menu> menus;
	private HashMap<String, Integer> mapTemp;
	private HashMap<Menu, Integer> mapTotal;
	private HashMap<Customer, Integer> cusMap;
	HashMap<String, Customer> cusMenuMap;
	private Menu m;
	private Out out;
	private JTable table1;
	private JLabel lblNewLabel;
	private JTextField txtSearch;
	private JScrollPane scrollPane_1;
	private JTable table_2;
	private String phoneSearch;

	/**
	 * @wbp.parser.constructor
	 */
	public Admin(JFrame parent, boolean modal) {
		this.setTitle("Admin");
		bill = (MenuView) parent;
		mapTotal = new HashMap<Menu, Integer>();
		mapTemp = new HashMap<String, Integer>();
		loadAllData("src/data/data.txt");
		loadData("src/data/admin.txt");
		loadCustomer("src/data/customer.txt");
		addControl();
		showCusInfor();
		addDataToMapTotal(mapTemp);
		addEvent();
	}

//	public Admin(JDialog parent, boolean modal) {
//		this.setTitle("Admin");
//		infor = (BillView) parent;
//		addControl();
//		addEvent();
//	}

	//admin.txt 모든 데이터 읽음
	private void loadAllData(String file) {
		controller = new DataFile();
		menus = controller.readDataFromFile(file);
	}

	public Menu findMenuByName(String name) {
		for (Menu m : menus) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}

	//read info from file, then add into maptemp --
	private void loadData(String file) {
		controller = new DataFile();
		mapTemp = controller.readDataToAdmin(file);
	}

	public void addDataToMapTotal(HashMap<String, Integer> mapTemp) { // add data to bill
		for (String name : mapTemp.keySet()) {
			m = findMenuByName(name);
			mapTotal.put(m, mapTemp.get(name));
		}
		showData();
	}

	void showData() {
		tableModel.setRowCount(0);
		for (Menu m : mapTotal.keySet()) {
			tableModel.addRow(new Object[] { m.getName(), mapTotal.get(m), (m.getPrice() * mapTotal.get(m)) });
		}
	}

	// đọc thông tin customer file rồi xử lí
	private void loadCustomer(String file) {
		controller = new DataFile();
		cusMap = controller.readCustomerInfo(file);
	}

	void showCusInfor() {
		tableModel_1.setRowCount(0);
		for (Customer m : cusMap.keySet()) {
			tableModel_1.addRow(new Object[] { m.getPhoneNumber(), cusMap.get(m) });
		}
	}

	// đọc thông tin customer menu file rồi xử lí
	private void loadCustomerMenu(String file,String phoneSearch) {
		
	}

	void showCusMenu() {
		tableModel_2.setRowCount(0);
		for (Customer cus : cusMenuMap.values()) {
			for (Menu m : cus.hashCus.keySet()) {
				tableModel_2
						.addRow(new Object[] { m.getName(), cus.hashCus.get(m), cus.hashCus.get(m) * m.getPrice() });
			}
		}
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
		btnAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventSee(e);
			}
		});

	}

	protected void btnEventSee(ActionEvent e) {
		phoneSearch = txtSearch.getText();
		//loadCustomerMenu("customer.txt", phoneSearch);
		controller = new DataFile();
		cusMenuMap = controller.readCustomerMenu("src/data/customer.txt", phoneSearch);
		System.out.println(cusMenuMap.size());
		if (cusMenuMap != null) {
			for (String phone : cusMenuMap.keySet()) {
				if (phone.equalsIgnoreCase(phone)) {
					showCusMenu();
				}
			}
		}
	}

	protected void btnEventMenu(ActionEvent e) {
		bill = new MenuView();
		bill.setLocationRelativeTo(null);
		bill.setVisible(true);
		this.setVisible(false);
	}

	protected void btnEventExit(ActionEvent e) {
		out = new Out(this, true);
		out.setLocationRelativeTo(null);
		out.setVisible(true);
	}

	private void addControl() {
		setBounds(100, 100, 629, 488);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnAdmin = new JButton("관리자");
		btnAdmin.setBackground(SystemColor.scrollbar);
		menuBar.add(btnAdmin);

		btnMenu = new JButton("메뉴");
		btnMenu.setBackground(SystemColor.scrollbar);
		menuBar.add(btnMenu);

		btnExit = new JButton("종류");
		btnExit.setBackground(Color.ORANGE);
		menuBar.add(btnExit);

		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);

		String columnName1[] = { "전화번호", "총 지불" };
		String columnName[] = { "이름", "개수", "총금액" };
		String columnName2[] = { "이름", "개수", "총금액" };

		JPanel panel_1 = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		table1 = new JTable();
		table1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columnName1));
		tableModel_1 = (DefaultTableModel) table1.getModel();

		JPanel panel = new JPanel();

		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columnName));
		tableModel = (DefaultTableModel) table.getModel();
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(table);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(sp,
				GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		scrollPane.setViewportView(table1);
		scrollPane.setViewportView(table1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		btnSee = new JButton("보기");
		btnSee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		JPanel panel_2 = new JPanel();

		scrollPane_1 = new JScrollPane();
		table_2 = new JTable();
		table_2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columnName2));
		tableModel_2 = (DefaultTableModel) table_2.getModel();
		scrollPane_1.setViewportView(table_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(scrollPane_1,
				GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE).addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JLabel label = new JLabel("~ 매출량~");

		lblNewLabel = new JLabel("~ 손님의 정보  ~");
		GroupLayout gl_rootPane = new GroupLayout(rootPane);
		gl_rootPane.setHorizontalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rootPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addGroup(gl_rootPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_rootPane.createSequentialGroup()
									.addComponent(txtSearch, 0, 0, Short.MAX_VALUE)
									.addGap(3)
									.addComponent(btnSee))
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_rootPane.createSequentialGroup()
							.addGap(70)
							.addComponent(label)
							.addGap(142)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		gl_rootPane.setVerticalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_rootPane.createSequentialGroup()
							.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSee))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)))
		);
		rootPane.setLayout(gl_rootPane);
	}
}
