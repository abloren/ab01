package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.impl.DataFile;

public class Out extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private MenuView bill;
	private Admin admin;
	private DataFile controller;
	private BillView infor;
	private JLabel lblNewLabel_1;

	/**
	 * @wbp.parser.constructor
	 */
	public Out(JFrame parent, boolean modal) {
		this.setTitle("Exit system");
		bill = (MenuView) parent;
		bill.setVisible(false);
		addControl();
		addEvent();
	}

	public Out(JDialog parent, boolean modal) {
		this.setTitle("Exit system");
		admin = (Admin) parent;
		admin.setVisible(false);
		addControl();
		addEvent();
	}
	
	public Out(JDialog parent) {
		this.setTitle("Exit system");
		infor = (BillView) parent;
		infor.setVisible(false);
		addControl();
		addEvent();
	}

	void addEvent() {
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnOkEvent(e);
			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelEvent(e);
			}
		});

	}

	protected void btnCancelEvent(ActionEvent e) {
		bill = new MenuView();
		bill.setLocationRelativeTo(null);
		bill.setVisible(true);
		this.dispose();
	}

	protected void btnOkEvent(ActionEvent e) {
		controller = new DataFile();
		controller.deleteData("/src/data/admin.txt"); //마감하후 에 오늘 매출 정보,영수증 다른 데에서 저장 예 usb 복사, cloud
		controller.deleteData("/src/data/bill.txt");	//이 스시템안에 있던 데이터는 손님의 주문한 각 문걸 정보를 빼고 다 치움
											//(손님의 주문한 각 문걸만 저장)
		
		System.exit(0);
	}

	void addControl() {
		setBounds(100, 100, 330, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{79, 79, 53, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 20, 29, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
				{
					lblNewLabel_1 = new JLabel(" ");
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_1.gridx = 1;
					gbc_lblNewLabel_1.gridy = 0;
					contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
				}
		
				JLabel lblNewLabel = new JLabel("종류하시겠습니까?");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridwidth = 2;
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		{
			cancelButton = new JButton("Cancel");
			cancelButton.setActionCommand("Cancel");
		}
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 2;
		contentPanel.add(cancelButton, gbc_cancelButton);
		{
			okButton = new JButton("OK");
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_okButton.gridx = 2;
		gbc_okButton.gridy = 2;
		contentPanel.add(okButton, gbc_okButton);
	}
}
