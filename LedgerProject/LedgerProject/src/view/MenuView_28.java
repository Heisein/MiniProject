package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;

import model.UserDAO;

public class MenuView_28 {
	JFrame jf = new JFrame("¿ëµ·Á¶");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	JLabel jl[] = new JLabel[2];
	UserDAO users = new UserDAO();

	public MenuView_28(UserDAO user) {
		users=user;
		Set_setting();
		SET_IMG_Area();
		SET_Label_Area();
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Set_setting() {
		JPanel S_sub[] = new JPanel[6];
		for (int i = 0; i < S_sub.length; i++) {
			S_sub[i] = new JPanel();
			S_sub[i].setLayout(null);
			S_sub[i].setVisible(true);
			S_sub[i].setBackground(Color.WHITE);
		}
		S_sub[0].setLocation(0, 60);
		S_sub[0].setSize(360, 70);

		S_sub[1].setLocation(0, 130);
		S_sub[1].setSize(360, 50);
		S_sub[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new FirstLogin_1();
				jf.setVisible(false);
			}
		});

		S_sub[2].setLocation(0, 180);
		S_sub[2].setSize(360, 20);
		S_sub[2].setBackground(Color.GRAY);

		S_sub[3].setLocation(0, 200);
		S_sub[3].setSize(360, 50);
		S_sub[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new FirstLogin_1();
				jf.setVisible(false);
			}
		});
		S_sub[4].setLocation(0, 250);
		S_sub[4].setSize(360, 50);
		S_sub[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new StatView_29(users).point(jf.getLocation());
				jf.setVisible(false);
			}
		});

		S_sub[5].setLocation(0, 300);
		S_sub[5].setSize(360, 50);
		S_sub[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new FirstLogin_1();
				jf.setVisible(false);
			}
		});

		JLabel jl[] = new JLabel[9];
		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel();
			jl[i].setVisible(true);
		}
		ImageIcon img = new ImageIcon("front.png");

		jl[0].setText("Username ");
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[0].setSize(200, 25);
		jl[0].setLocation(20, 10);

		jl[1].setText("Email ");
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jl[1].setSize(200, 25);
		jl[1].setLocation(20, 30);

		jl[2].setText("¿ëµ·Á¶ ºñ¹Ð¹øÈ£ º¯°æ ");
		jl[2].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[2].setSize(200, 25);
		jl[2].setLocation(20, 15);

		jl[3] = new JLabel(img);
		jl[3].setSize(20, 20);
		jl[3].setLocation(320, 20);

		jl[4].setText("µî·Ï°èÁÂ °ü¸®");
		jl[4].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[4].setSize(200, 25);
		jl[4].setLocation(20, 15);

		jl[5] = new JLabel(img);
		jl[5].setSize(20, 20);
		jl[5].setLocation(320, 20);

		jl[6].setText("Åë°è");
		jl[6].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[6].setSize(200, 25);
		jl[6].setLocation(20, 15);

		jl[7] = new JLabel(img);
		jl[7].setSize(20, 20);
		jl[7].setLocation(320, 20);

		jl[8].setText("·Î±×¾Æ¿ô");
		jl[8].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[8].setSize(200, 25);
		jl[8].setLocation(20, 15);
		

		S_sub[0].add(jl[0]);
		S_sub[0].add(jl[1]);

		S_sub[1].add(jl[2]);
		S_sub[1].add(jl[3]);

		S_sub[3].add(jl[4]);
		S_sub[3].add(jl[5]);

		S_sub[4].add(jl[6]);
		S_sub[4].add(jl[7]);

		S_sub[5].add(jl[8]);
		for (int i = 0; i < S_sub.length; i++) {
			jp.add(S_sub[i]);
		}

	}

	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new MainScreen_14(users);
				jf.setVisible(false);
			}
		});
		
		jp.add(jl);
	}
	
	public void SET_Label_Area() {

		jl[0] = new JLabel("¼³Á¤");
		jl[0].setSize(100, 20);
		jl[0].setLocation(150, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		jl[0].setForeground(Color.WHITE);
		jl[0].setVisible(true);
		jp.add(jl[0]);
	}
	public void point(Point p) {
	      if (p != null) {
	         jf.setLocation(p);
	   }
	 }
}
