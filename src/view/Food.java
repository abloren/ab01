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

public class Food extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel rootPane, selectPanel;
	private JButton btnSelect, btnBack, btnBagel, btnChesse, btnBowl, btnBurrito, btnGeneva, btnPizza;
	private JLabel lblSelect, labelCount, lblBagel, lblBowl, lblBurrito, lblChesse, lblGeneva,lblPizza;
	private MenuView bill;
	int count1=0, count2=0, count3=0, count4=0, count5=0, count6=0; //click chon thi tu dong tang len 1

	public Food(JFrame jFrame, boolean modal) {
		this.setLocationRelativeTo(null);
		this.setTitle("Food"); //ten
		bill = (MenuView)jFrame;
		addControl();
		addEvent();
	}

	private void addEvent() {
		btnBagel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count1;
				String countMenu = String.valueOf(count1);
				labelCount.setText(countMenu);
				lblSelect.setText(lblBagel.getText());
				count2=0;count3=0;count4=0;count5=0;count6=0;
			}
		});

		btnBowl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count2;
				String countMenu = String.valueOf(count2);
				labelCount.setText(countMenu);
				lblSelect.setText(lblBowl.getText());
				count1=0;count3=0;count4=0;count5=0;count6=0;
			}
		});

		btnBurrito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count3;
				String countMenu = String.valueOf(count3);
				labelCount.setText(countMenu);
				lblSelect.setText(lblBurrito.getText());
				count2=0;count1=0;count4=0;count5=0;count6=0;
			}
		});

		btnGeneva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count4;
				String countMenu = String.valueOf(count4);
				labelCount.setText(countMenu);
				lblSelect.setText(lblGeneva.getText());
				count2=0;count3=0;count1=0;count5=0;count6=0;
			}
		});

		btnChesse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count5;
				String countMenu = String.valueOf(count5);
				labelCount.setText(countMenu);
				lblSelect.setText(lblChesse.getText());
				count2=0;count3=0;count4=0;count1=0;count6=0;
			}
		});

		btnPizza.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count6;
				String countMenu = String.valueOf(count6);
				labelCount.setText(countMenu);
				lblSelect.setText(lblPizza.getText());
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

		setBounds(100, 100, 500, 544);
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
		
		btnBagel = new JButton(new ImageIcon("images/food/Bagel_m.png"));

		btnBowl = new JButton(new ImageIcon("images/food/Bean and Rice Bowl_m.png"));
		//ten va anh menu
		btnBurrito = new JButton(new ImageIcon("images/food/Burrito_m.png"));

		btnChesse = new JButton(new ImageIcon("images/food/chesse_m.jpg"));

		btnGeneva = new JButton(new ImageIcon("images/food/Geneva Panini_m.png"));

		btnPizza = new JButton(new ImageIcon("images/food/pizza_m.jpg"));

		 lblBagel = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 13) {
				lblBagel.setText(m.getName());
			}
		}

		 lblBowl = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 14) {
				lblBowl.setText(m.getName());
			}
		}

		 lblBurrito = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 15) {
				lblBurrito.setText(m.getName());
			}
		}
		 lblChesse = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 16) {
				lblChesse.setText(m.getName());
			}
		}
		 lblGeneva = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 17) {
				lblGeneva.setText(m.getName());
			}
		}
		 lblPizza = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 18) {
				lblPizza.setText(m.getName());
			}
		}
		
		
		GroupLayout gl_rootPane = new GroupLayout(rootPane);
		gl_rootPane.setHorizontalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rootPane.createSequentialGroup()
							.addGap(154)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rootPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rootPane.createSequentialGroup()
							.addGap(162)
							.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_rootPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSelect, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_rootPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelCount)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_rootPane.setVerticalGroup(
			gl_rootPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rootPane.createSequentialGroup()
					.addComponent(selectPanel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSelect)
						.addGroup(gl_rootPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(8)
							.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(labelCount))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_rootPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		GroupLayout gl_selectPanel = new GroupLayout(selectPanel);
		gl_selectPanel.setHorizontalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBagel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChesse, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addGap(37)
									.addComponent(lblBagel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnBowl, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGeneva, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addComponent(lblBowl)
									.addGap(26))))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addGap(49)
							.addComponent(lblChesse, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblGeneva, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnPizza, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnBurrito, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addComponent(lblPizza, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(33))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addComponent(lblBurrito)
							.addGap(28)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_selectPanel.setVerticalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBagel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBowl, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBurrito, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBagel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBowl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBurrito, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPizza, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGeneva, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChesse, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChesse, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGeneva, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPizza, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		selectPanel.setLayout(gl_selectPanel);
		rootPane.setLayout(gl_rootPane);
	}
}
