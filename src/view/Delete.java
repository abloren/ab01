package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Menu;

public class Delete extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private static Basket basket;
	HashMap<Menu, Integer> mapDelete, mapSearch;
	private DefaultTableModel tableModel;
	private JButton btnDelete;
	private JButton btnSearch;
	private JTextField textSearch;
	private Menu keyDelete;
	private JButton btnBack;

	public Delete(JDialog jFrame, boolean modal) {
		super(jFrame, modal);
		basket = (Basket) jFrame;
		basket.setVisible(false);
		this.setTitle("Delete");
		addControl();
		mapDelete = new HashMap<Menu, Integer>();
		mapDelete.putAll(basket.mapBasket);
		mapSearch = new HashMap<Menu, Integer>();
		addEvent();
	}

	public void showData() {
		tableModel.setRowCount(0);
		for (Menu m : mapSearch.keySet()) {
			tableModel.addRow(new Object[] { m.getName(), mapSearch.get(m), (m.getPrice() * mapSearch.get(m)) });
		}
	}

	public void addEvent() {
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventDelete(e);
			}
		});
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventSearch();
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventBack();			}
		});

	}

	protected void btnEventBack() {
		this.dispose();
		basket.setLocationRelativeTo(null);
		basket.setVisible(true);
	}

	protected void btnEventSearch() { //삭제하고 싶은 것을 먼서 검색해야된다
		mapSearch.clear(); //처음에 빈HashMap 만든다
		if (textSearch.getText().trim().equalsIgnoreCase("")) { //아무것도 쓰지않으면 알림
			JOptionPane.showMessageDialog(rootPane, "빈칸!!! 다시 입력하시오.");
		} else {
			for (Menu m : mapDelete.keySet()) { //조금 같은 이름이라도 다 뽑음
				if (m.getName().toLowerCase().contains(textSearch.getText())
						|| m.getName().toUpperCase().contains(textSearch.getText())) {
					mapSearch.put(m, mapDelete.get(m)); //hashMap에서 저장된다.
					keyDelete = m;
				}
			}
			showData(); //테이블으로 데이터를 표현
		}
	}

	protected void btnEventDelete(ActionEvent e) { //삭제 함수. 각 알람이 나온다
		if (mapSearch.size() > 1) {
			JOptionPane.showMessageDialog(rootPane, "하나밖에 삭제가 불가능."); 
			textSearch.setText("");
			mapSearch.clear();
			showData();
		} else if (mapSearch.size() <= 0) {
			JOptionPane.showMessageDialog(rootPane, "가제될 것이 없다.");
			mapSearch.clear();
			textSearch.setText("");
			showData();
		} else {
			mapDelete.remove(keyDelete);
			JOptionPane.showMessageDialog(rootPane, "삭제가 되었다.");
			textSearch.setText("");
			mapSearch.remove(keyDelete);
			showData();
			basket.mapBasket = mapDelete;
			basket.showData();
			this.dispose();
			basket.setLocationRelativeTo(null);
			basket.setVisible(true);
		}
	}

	public void addControl() {
		setBounds(100, 100, 448, 370);
		String columnName[] = { "Name", "Quantity", "Price" };
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{205, 101, 118, 0};
		gridBagLayout.rowHeights = new int[]{29, 247, 31, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
				textSearch = new JTextField();
				textSearch.setColumns(10);
				GridBagConstraints gbc_textSearch = new GridBagConstraints();
				gbc_textSearch.fill = GridBagConstraints.HORIZONTAL;
				gbc_textSearch.insets = new Insets(0, 0, 5, 5);
				gbc_textSearch.gridwidth = 2;
				gbc_textSearch.gridx = 0;
				gbc_textSearch.gridy = 0;
				getContentPane().add(textSearch, gbc_textSearch);
				
						btnSearch = new JButton("Search");
						GridBagConstraints gbc_btnSearch = new GridBagConstraints();
						gbc_btnSearch.anchor = GridBagConstraints.NORTH;
						gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
						gbc_btnSearch.gridx = 2;
						gbc_btnSearch.gridy = 0;
						getContentPane().add(btnSearch, gbc_btnSearch);
				table = new JTable();
				table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, columnName));
				tableModel = (DefaultTableModel) table.getModel();
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(table);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.gridwidth = 3;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 1;
				getContentPane().add(scrollPane, gbc_scrollPane);
				
				btnBack = new JButton("Back");
				GridBagConstraints gbc_btnBack = new GridBagConstraints();
				gbc_btnBack.anchor = GridBagConstraints.EAST;
				gbc_btnBack.fill = GridBagConstraints.VERTICAL;
				gbc_btnBack.insets = new Insets(0, 0, 0, 5);
				gbc_btnBack.gridx = 0;
				gbc_btnBack.gridy = 2;
				getContentPane().add(btnBack, gbc_btnBack);
		
				btnDelete = new JButton("Delete");
				GridBagConstraints gbc_btnDelete = new GridBagConstraints();
				gbc_btnDelete.anchor = GridBagConstraints.WEST;
				gbc_btnDelete.fill = GridBagConstraints.VERTICAL;
				gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
				gbc_btnDelete.gridx = 1;
				gbc_btnDelete.gridy = 2;
				getContentPane().add(btnDelete, gbc_btnDelete);
	}
}
