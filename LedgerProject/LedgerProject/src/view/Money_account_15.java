package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;

import model.UserDAO;

public class Money_account_15 {

	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();
	
	UserDAO users = new UserDAO();

	public Money_account_15(UserDAO user) {
		SET_Pannels_Area();
		SET_Label_Area();

		jf.setSize(360, 600);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);

		jf.add(jp);
		jf.setVisible(true);
		jp.setVisible(true);
		
		users=user;
	}

	public void SET_Pannels_Area() {
		JPanel sub[] = new JPanel[3];
		JLabel jl[] = new JLabel[22];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = new JPanel();
			jp.add(sub[i]);
			sub[i].setBackground(Color.WHITE);
			sub[i].setVisible(true);
			sub[i].setLayout(null);
		}

		sub[0].setSize(320, 160);
		sub[0].setLocation(15, 50);
		sub[1].setSize(320, 190);
		sub[1].setLocation(15, 230);
		sub[2].setSize(320, 92);
		sub[2].setLocation(15, 440);

		ImageIcon img = new ImageIcon("images/plus.png");

		String arr[] = { "예산", "총 예산", "총 소비액", "400,000", "0", "150,000 남음 ", "소비분류",  "나의 소비분류Top3", "마트",
				"184,000", "카페/베이커리", "74,000", "주유/자동차", "53,000", "카드정보","신한 계좌", "110*****200", "5,257" };
		for (int i = 0; i < arr.length; i++) {
			jl[i] = new JLabel(arr[i]);
			jl[i].setSize(100, 20);
			
			if(i>=14)
			{sub[2].add(jl[i]);}
			else if(i>=6)
			{sub[1].add(jl[i]);}
			else if(i>=0)
			{sub[0].add(jl[i]);}

		}
		//sub[0]
		jl[0].setLocation(10, 10);
		jl[1].setLocation(10, 50);
		jl[2].setLocation(10, 80);
		jl[3].setLocation(200, 50);
		jl[4].setLocation(200, 80);
		jl[5].setLocation(200, 140);
		//sub[1]
		jl[6].setLocation(10, 10);
		jl[7].setLocation(10, 30);
		jl[8].setLocation(10, 50);
		jl[9].setLocation(200, 50);
		jl[10].setLocation(10, 80);
		jl[11].setLocation(200, 80);
		jl[12].setLocation(10, 110);
		jl[13].setLocation(200, 110);
		//sub[2]
		jl[14].setLocation(10, 10);
		jl[15].setLocation(10, 30);
		jl[16].setLocation(10, 50);
		jl[17].setLocation(200, 10);
		for (int i = 17; i < arr.length; i++) {
			jl[i] = new JLabel(img);
			
			
		}

		
		
	}

	public void SET_Label_Area() {
		JLabel jl[] = new JLabel[2];
		ImageIcon img = new ImageIcon("images/menu.png");
		jl[0] = new JLabel("11월 소비액");
		jl[1] = new JLabel(img);

		jl[0].setLocation(20, -20);
		jl[1].setLocation(270, -20);

		jl[1].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new MenuView_28(users).point(jf.getLocation());
				jf.setVisible(false);
			}
		});

		for (int i = 0; i < jl.length; i++) {
			jl[i].setSize(100, 100);
			jl[i].setForeground(Color.WHITE);
			jp.add(jl[i]);
		}

	}

	public void point(Point p) {
		if (p != null) {
			jf.setLocation(p);
		}
	}
	public void sidepoint(Point p) {
		if (p != null) {
			jf.setLocation(p.x+360,p.y);
		}
	}
}
