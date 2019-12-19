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

public class Wine extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel rootPane, selectPanel;
	private JButton btnSelect, btnBack, btnBrothers, btnMakedonik, btnCuvee89, btnLamarca, btnRon, btnUnruly;
	private JLabel lblSelect, labelCount, lblBrothers, lblCuvee89, lblLamarca, lblMakedonik, lblRon,lblUnruly;
	private MenuView bill;
	int count1=0, count2=0, count3=0, count4=0, count5=0, count6=0; //click chon thi tu dong tang len 1

	public Wine(JFrame jFrame, boolean modal) {
		this.setLocationRelativeTo(null);
		this.setTitle("Wine"); //ten
		bill = (MenuView)jFrame;
		addControl();
		addEvent();
	}

	private void addEvent() {
		btnBrothers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count1;
				String countMenu = String.valueOf(count1);
				labelCount.setText(countMenu);
				lblSelect.setText(lblBrothers.getText());
				count2=0;count3=0;count4=0;count5=0;count6=0;
			}
		});

		btnCuvee89.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count2;
				String countMenu = String.valueOf(count2);
				labelCount.setText(countMenu);
				lblSelect.setText(lblCuvee89.getText());
				count1=0;count3=0;count4=0;count5=0;count6=0;
	
			}
		});

		btnLamarca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count3;
				String countMenu = String.valueOf(count3);
				labelCount.setText(countMenu);
				lblSelect.setText(lblLamarca.getText());
				count2=0;count1=0;count4=0;count5=0;count6=0;
			}
		});

		btnRon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count4;
				String countMenu = String.valueOf(count4);
				labelCount.setText(countMenu);
				lblSelect.setText(lblRon.getText());
				count2=0;count3=0;count1=0;count5=0;count6=0;
			}
		});

		btnMakedonik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count5;
				String countMenu = String.valueOf(count5);
				labelCount.setText(countMenu);
				lblSelect.setText(lblMakedonik.getText());
				count2=0;count3=0;count4=0;count1=0;count6=0;
			}
		});

		btnUnruly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count6;
				String countMenu = String.valueOf(count6);
				labelCount.setText(countMenu);
				lblSelect.setText(lblUnruly.getText());
				count2=0;count3=0;count4=0;count5=0;count1=0;
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
		}else if(Integer.parseInt(labelCount.getText()) <= 0) {
			JOptionPane.showMessageDialog(rootPane, "수량을 선택하시요");
		}
			else {
			bill.addMenu(lblSelect.getText(),Integer.parseInt(labelCount.getText()));
			lblSelect.setText("Selected menu");
			labelCount.setText("0");
		}

	}

	protected void btnSkip(ActionEvent e) {
		this.dispose();
		bill.setVisible(true);
	}

	public void addControl() {

		setBounds(100, 100, 500, 594);
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
		
		btnBrothers = new JButton(new ImageIcon("images/wine/Brothers.png"));

		btnMakedonik = new JButton(new ImageIcon("images/wine/Cuvee 89.png"));
		//ten va anh menu
		btnCuvee89 = new JButton(new ImageIcon("images/wine/Lamarca.png"));

		btnLamarca = new JButton(new ImageIcon("images/wine/Makedonik.jpg"));

		btnRon = new JButton(new ImageIcon("images/wine/Ron.png"));

		btnUnruly = new JButton(new ImageIcon("images/wine/Unruly.png"));

		 lblBrothers = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 20) {
				lblBrothers.setText(m.getName());
			}
		}

		 lblCuvee89 = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 21) {
				lblCuvee89.setText(m.getName());
			}
		}

		 lblLamarca = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 22) {
				lblLamarca.setText(m.getName());
			}
		}
		 lblMakedonik = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 23) {
				lblMakedonik.setText(m.getName());
			}
		}
		 lblRon = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 24) {
				lblRon.setText(m.getName());
			}
		}
		 lblUnruly = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 25) {
				lblUnruly.setText(m.getName());
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
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSelect, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_rootPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelCount))
								.addGroup(gl_rootPane.createSequentialGroup()
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_rootPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_rootPane.setVerticalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblSelect))
					.addGap(18)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(labelCount))
					.addGap(18)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(93))
		);
		
		GroupLayout gl_selectPanel = new GroupLayout(selectPanel);
		gl_selectPanel.setHorizontalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnMakedonik, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBrothers, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addGap(46)
									.addComponent(lblBrothers, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRon, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCuvee89, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_selectPanel.createSequentialGroup()
									.addComponent(lblCuvee89)
									.addGap(30))))
						.addGroup(Alignment.TRAILING, gl_selectPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblMakedonik, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addComponent(lblRon, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_selectPanel.createSequentialGroup()
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnUnruly, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnLamarca, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addComponent(lblUnruly, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(33)))
							.addContainerGap(24, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_selectPanel.createSequentialGroup()
							.addComponent(lblLamarca)
							.addGap(51))))
		);
		gl_selectPanel.setVerticalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBrothers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCuvee89, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLamarca, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLamarca, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCuvee89, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBrothers, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUnruly, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRon, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMakedonik, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUnruly, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRon, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMakedonik, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		selectPanel.setLayout(gl_selectPanel);
		rootPane.setLayout(gl_rootPane);
	}
}
