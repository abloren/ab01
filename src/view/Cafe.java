package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.Menu;

public class Cafe extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel rootPane, selectPanel;
	private JButton btnSelect, btnBack, btnHome, btnLatte, btnMatcha, btnMocha, btnCappu, btnLobby;
	private JLabel lblCam, lblHome, lblLatte, lblLobby, lblMatcha, lblMocha, lblSelect, labelCount;
	private MenuView bill;
	int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0;

	public Cafe(JFrame jFrame, boolean modal) {
		this.setLocationRelativeTo(null);
		this.setTitle("Cafe"); // name
		bill = (MenuView) jFrame;
		addControl();//design function
		addEvent(); //event function
	}

	//event function
	private void addEvent() {

		 btnCappu.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				++count1;
				String countMenu = String.valueOf(count1);
				labelCount.setText(countMenu);
				lblSelect.setText(lblCam.getText());
				count2 = 0; count3 = 0; count4 = 0;
				count5 = 0; count6 = 0;
			 }
		 });

		 btnHome.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ++count2;
				 String countMenu = String.valueOf(count2);
				 labelCount.setText(countMenu);
				 lblSelect.setText(lblHome.getText());
				 count1 = 0; count3 = 0; count4 = 0;
				 count5 = 0; count6 = 0;
			 }
		 });

		 btnLatte.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ++count3;
				 String countMenu = String.valueOf(count3);
				 labelCount.setText(countMenu);
				 lblSelect.setText(lblLatte.getText());
				 count2 = 0; count1 = 0; count4 = 0;
				 count5 = 0; count6 = 0;
			 }
		 });

		 btnLobby.addActionListener(new ActionListener() {


			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ++count4;
				 String countMenu = String.valueOf(count4);
				 labelCount.setText(countMenu);
				 lblSelect.setText(lblLobby.getText());
				 count2 = 0; count3 = 0; count1 = 0;
				 count5 = 0; count6 = 0;
			 }
		 });

		 btnMatcha.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ++count5;
				 String countMenu = String.valueOf(count5);
				 labelCount.setText(countMenu);
				 lblSelect.setText(lblMatcha.getText());
				 count2 = 0; count3 = 0; count4 = 0;
				 count1 = 0; count6 = 0;
			 }
		 });

		 btnMocha.addActionListener(new ActionListener() {

			 @Override
			 public void actionPerformed(ActionEvent e) {
				 ++count6;
				 String countMenu = String.valueOf(count6);
				 labelCount.setText(countMenu);
				 lblSelect.setText(lblMocha.getText());
				 count2 = 0; count3 = 0; count4 = 0;
				 count5 = 0; count1 = 0;
			 }
		 });


		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSkip(e);
			}

		});
		btnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSelect(e);
			}
		});

	}


	protected void btnSelect(ActionEvent e) {
		if (lblSelect.getText() == "Selected menu") {
			JOptionPane.showMessageDialog(rootPane, "제품을 선택하지 않았음");
		} else if (Integer.parseInt(labelCount.getText()) <= 0) {
			JOptionPane.showMessageDialog(rootPane, "수량을 선택하시요");
		} else {
			bill.addMenu(lblSelect.getText(), Integer.parseInt(labelCount.getText()));
			lblSelect.setText("Selected menu");
			labelCount.setText("0");
		}

	}

	protected void btnSkip(ActionEvent e) {
		this.dispose();
		bill.setVisible(true);
	}

	//design function
	public void addControl() {

		setBounds(100, 100, 526, 573);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);

		selectPanel = new JPanel();

		JLabel lblNewLabel = new JLabel("선택:");

		JLabel label_1 = new JLabel("\uAC1C\uC218: ");

		btnSelect = new JButton("주문");
		btnSelect.setBackground(SystemColor.inactiveCaption);

		btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.inactiveCaption);

		lblSelect = new JLabel("Selected menu");

		labelCount = new JLabel("0");

		// ten va anh menu
		btnCappu = new JButton(new ImageIcon("images/cafe/cappuccino_m.jpg"));

		btnLobby = new JButton(new ImageIcon("images/cafe/lobby_m.jpg"));
		btnHome = new JButton(new ImageIcon("images/cafe/homemade_m.jpg"));

		btnLatte = new JButton(new ImageIcon("images/cafe/latte_m.png"));

		btnMatcha = new JButton(new ImageIcon("images/cafe/matcha_m.png"));

		btnMocha = new JButton(new ImageIcon("images/cafe/mocha_m.png"));

		lblCam = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 7) {
				lblCam.setText(m.getName());
			}
		}

		lblHome = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 8) {
				lblHome.setText(m.getName());
			}
		}

		lblLatte = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 9) {
				lblLatte.setText(m.getName());
			}
		}
		lblLobby = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 10) {
				lblLobby.setText(m.getName());
			}
		}
		lblMatcha = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 11) {
				lblMatcha.setText(m.getName());
			}
		}
		lblMocha = new JLabel();
		for (Menu m : bill.menus) {
			if (m.getId() == 12) {
				lblMocha.setText(m.getName());
			}
		}

		GroupLayout gl_rootPane = new GroupLayout(rootPane);
		gl_rootPane.setHorizontalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rootPane.createSequentialGroup()
							.addGap(162)
							.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_rootPane.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSelect, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_rootPane.createSequentialGroup()
									.addGroup(gl_rootPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_rootPane.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(labelCount)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_rootPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_rootPane.setVerticalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelect)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(labelCount))
					.addGap(18)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(265))
		);

		GroupLayout gl_selectPanel = new GroupLayout(selectPanel);
		gl_selectPanel.setHorizontalGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_selectPanel
				.createSequentialGroup()
				.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING, false).addGroup(gl_selectPanel
						.createSequentialGroup().addContainerGap()
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCappu, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLobby, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup().addGap(21).addComponent(lblCam,
										GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMatcha, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup().addComponent(lblHome).addGap(26))))
						.addGroup(gl_selectPanel.createSequentialGroup().addGap(49)
								.addComponent(lblLobby, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMatcha, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addGap(19)))
				.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
				.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMocha, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLatte, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_selectPanel.createSequentialGroup()
										.addComponent(lblMocha, GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addGap(33))
						.addGroup(gl_selectPanel.createSequentialGroup().addComponent(lblLatte).addGap(28)))
				.addContainerGap(27, Short.MAX_VALUE)));
		gl_selectPanel.setVerticalGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup().addGap(18)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLatte, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCappu, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLatte, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCam, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMocha, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMatcha, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLobby, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLobby, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMatcha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMocha, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		selectPanel.setLayout(gl_selectPanel);
		rootPane.setLayout(gl_rootPane);
	}
}
