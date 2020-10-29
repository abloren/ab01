package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data.impl.DataFile;
import model.Menu;

public class Customer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPhone;
	private JTextField txtBankId;
	private JButton btnCancel, btnOk;
	private Basket basket;
	private MenuView bill;
	HashMap<Menu, Integer> hashCus;
	JLabel labelTotal;
	private DataFile controller;

	public Customer(JDialog jDialog, boolean modal) {
		super(jDialog, modal);
		basket = (Basket) jDialog;
		basket.setVisible(false);
		hashCus = new HashMap<Menu, Integer>();
		hashCus.putAll(basket.mapBasket);
		this.setTitle("Customer Information");
		addControl();
		labelTotal.setText(basket.labelTotal.getText());
		addEvent();
	}

	private void addEvent() {
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventOk(e);
			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEventCancel(e);
			}
		});
	}

	protected void btnEventCancel(ActionEvent e) {
		this.dispose();
		bill = new MenuView();
		bill.setLocationRelativeTo(null);
		bill.setVisible(true);
	}

	protected void btnEventOk(ActionEvent e) {
		JOptionPane.showMessageDialog(rootPane, "계산되었다.");
		controller = new DataFile();
		model.Bill cus = new model.Bill(txtPhone.getText(), txtBankId.getText(),Integer.parseInt(basket.labelTotal.getText()));
		model.Customer c = new model.Customer(txtPhone.getText(), Integer.parseInt(basket.labelTotal.getText()));
		controller.writeBillFile(cus, "src/data/bill.txt"); //영수증들의 정보를 file로 저장
		controller.writeFile(basket.mapBasket, "src/data/admin.txt"); //걱 물건의 개수와 이름을 file로 저장
		controller.writeCus(c, "src/data/customer.txt", hashCus); //손님의 주문한 각 문걸을 file로 저장
		bill = new MenuView();
		bill.setLocationRelativeTo(null);
		bill.setVisible(true);
		this.dispose();
	}


	private void addControl() {
		setBounds(100, 100, 406, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{70, 109, 157, 0};
		gbl_contentPanel.rowHeights = new int[]{26, 33, 26, 33, 20, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
				
						JLabel lblNewLabel = new JLabel("전화번호:");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel.gridx = 0;
						gbc_lblNewLabel.gridy = 0;
						contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
				txtPhone = new JTextField();
				txtPhone.setColumns(10);
				GridBagConstraints gbc_txtPhone = new GridBagConstraints();
				gbc_txtPhone.anchor = GridBagConstraints.NORTH;
				gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
				gbc_txtPhone.gridwidth = 2;
				gbc_txtPhone.gridx = 1;
				gbc_txtPhone.gridy = 0;
				contentPanel.add(txtPhone, gbc_txtPhone);
				
						JLabel label = new JLabel("계좌번호:");
						GridBagConstraints gbc_label = new GridBagConstraints();
						gbc_label.anchor = GridBagConstraints.SOUTHWEST;
						gbc_label.insets = new Insets(0, 0, 5, 5);
						gbc_label.gridx = 0;
						gbc_label.gridy = 2;
						contentPanel.add(label, gbc_label);
		
				txtBankId = new JTextField();
				txtBankId.setColumns(10);
				GridBagConstraints gbc_txtBankId = new GridBagConstraints();
				gbc_txtBankId.anchor = GridBagConstraints.NORTH;
				gbc_txtBankId.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtBankId.insets = new Insets(0, 0, 5, 0);
				gbc_txtBankId.gridwidth = 2;
				gbc_txtBankId.gridx = 1;
				gbc_txtBankId.gridy = 2;
				contentPanel.add(txtBankId, gbc_txtBankId);
				
						JLabel label_1 = new JLabel("총 계산: ");
						GridBagConstraints gbc_label_1 = new GridBagConstraints();
						gbc_label_1.anchor = GridBagConstraints.NORTHEAST;
						gbc_label_1.insets = new Insets(0, 0, 0, 5);
						gbc_label_1.gridx = 1;
						gbc_label_1.gridy = 4;
						contentPanel.add(label_1, gbc_label_1);
		
				labelTotal = new JLabel(" ");
				GridBagConstraints gbc_labelTotal = new GridBagConstraints();
				gbc_labelTotal.anchor = GridBagConstraints.NORTH;
				gbc_labelTotal.fill = GridBagConstraints.HORIZONTAL;
				gbc_labelTotal.gridx = 2;
				gbc_labelTotal.gridy = 4;
				contentPanel.add(labelTotal, gbc_labelTotal);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{256, 65, 53, 0};
			gbl_buttonPane.rowHeights = new int[]{29, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				btnCancel = new JButton("취소");
				btnCancel.setActionCommand("Cancel");
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
				gbc_btnCancel.gridx = 1;
				gbc_btnCancel.gridy = 0;
				buttonPane.add(btnCancel, gbc_btnCancel);
			}
			{
				btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				GridBagConstraints gbc_btnOk = new GridBagConstraints();
				gbc_btnOk.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnOk.gridx = 2;
				gbc_btnOk.gridy = 0;
				buttonPane.add(btnOk, gbc_btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
		}
	}
}
