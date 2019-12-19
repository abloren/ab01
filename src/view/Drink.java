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

public class Drink extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel rootPane, selectPanel;
	private JButton btnSelect, btnBack, buttonAfri, buttonPer, buttonBunda, buttonCoca, buttonNgo, buttonSprite;
	private JLabel lblSelect, labelCount, lblAfri, lblBundaberg, lblCocacola, lblPerrier, lblngo,lblSprite ;
	private MenuView bill;
	int count1=0, count2=0, count3=0, count4=0, count5=0, count6=0; //click chon thi tu dong tang len 1

	public Drink(JFrame jFrame, boolean modal) {
		this.setLocationRelativeTo(null);
		this.setTitle("Drink"); 
		bill = (MenuView)jFrame;
		addControl(); //GUI 설계 함수
		addEvent(); //이벤트 처리 함수
	}

	private void addEvent() {
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
		
		buttonAfri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count1;
				String countMenu = String.valueOf(count1);
				labelCount.setText(countMenu);
				lblSelect.setText(lblAfri.getText());
				count2=0;count3=0;count4=0;count5=0;count6=0;
			}
		});

		buttonBunda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count2;
				String countMenu = String.valueOf(count2);
				labelCount.setText(countMenu);
				lblSelect.setText(lblBundaberg.getText());
				count1=0;count3=0;count4=0;count5=0;count6=0;
			}
		});

		buttonCoca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count3;
				String countMenu = String.valueOf(count3);
				labelCount.setText(countMenu);
				lblSelect.setText(lblCocacola.getText());
				count2=0;count1=0;count4=0;count5=0;count6=0;
			}
		});

		buttonNgo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count4;
				String countMenu = String.valueOf(count4);
				labelCount.setText(countMenu);
				lblSelect.setText(lblngo.getText());
				count2=0;count3=0;count1=0;count5=0;count6=0;
			}
		});

		buttonPer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count5;
				String countMenu = String.valueOf(count5);
				labelCount.setText(countMenu);
				lblSelect.setText(lblPerrier.getText());
				count2=0;count3=0;count4=0;count1=0;count6=0;
			}
		});

		buttonSprite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				++count6;
				String countMenu = String.valueOf(count6);
				labelCount.setText(countMenu);
				lblSelect.setText(lblSprite.getText());
				count2=0;count3=0;count4=0;count5=0;count1=0;
			}
		});

		

	}

	protected void btnSelect(ActionEvent e) { //Dink에서 문걸을 주문하게 된다면 MenuView의 table에 들어갈것이다.
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

		setBounds(100, 100, 500, 530);
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
		buttonAfri = new JButton(new ImageIcon("images/nuoc_ngot/afri_m.jpg"));

		buttonPer = new JButton(new ImageIcon("images/nuoc_ngot/perrier_m.jpg"));
		//ten va anh menu
		buttonBunda = new JButton(new ImageIcon("images/nuoc_ngot/bunda_m.jpg"));

		buttonCoca = new JButton(new ImageIcon("images/nuoc_ngot/cocacola_m.jpg"));

		buttonNgo = new JButton(new ImageIcon("images/nuoc_ngot/ngo_m.jpg"));

		buttonSprite = new JButton(new ImageIcon("images/nuoc_ngot/sprite_m.jpg"));

		 lblAfri = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 1) {
				lblAfri.setText(m.getName());
			}
		}

		 lblBundaberg = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 2) {
				lblBundaberg.setText(m.getName());
			}
		}

		 lblCocacola = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 3) {
				lblCocacola.setText(m.getName());
			}
		}
		 lblPerrier = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 5) {
				lblPerrier.setText(m.getName());
			}
		}
		 lblngo = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 4) {
				lblngo.setText(m.getName());
			}
		}
		 lblSprite = new JLabel();
		for(Menu m : bill.menus) {
			if(m.getId() == 6) {
				lblSprite.setText(m.getName());
			}
		}
		GroupLayout gl_selectPanel = new GroupLayout(selectPanel);
		gl_selectPanel.setHorizontalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(buttonAfri, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonPer, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addGap(37)
									.addComponent(lblAfri, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(buttonBunda, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonNgo, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_selectPanel.createSequentialGroup()
									.addComponent(lblBundaberg)
									.addGap(26))))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addGap(49)
							.addComponent(lblPerrier, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblngo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(buttonSprite, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonCoca, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addComponent(lblCocacola)
							.addGap(28))
						.addGroup(gl_selectPanel.createSequentialGroup()
							.addComponent(lblSprite, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(33)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_selectPanel.setVerticalGroup(
			gl_selectPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonAfri, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonBunda, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCoca, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAfri, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBundaberg, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCocacola, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonSprite, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonNgo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPer, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_selectPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPerrier, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblngo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSprite, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		selectPanel.setLayout(gl_selectPanel);
		rootPane.setLayout(gl_rootPane);
	}
}
