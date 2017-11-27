package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;

public class StatView_29 {

	JFrame jf = new JFrame("용돈조");
	JPanel jp = new JPanel();

	public StatView_29() {
		SET_Graph_Area();
		SET_Pannels_Area();
		SET_Label_Area();

		jf.setSize(360, 600);

		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);

		jf.add(jp);
		jf.setVisible(true);
		jp.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void SET_Graph_Area() {

		ImageIcon img = new ImageIcon("Graph_bar.png");
		
		JLabel jl[] = new JLabel[6];
		for (int i = 0; i < jl.length; i++) {
			jl[i]=new JLabel(img);
			jl[i].setSize(35, 200);
			jl[i].setLocation(40+(i*45), 50);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}

	}

	public void SET_Pannels_Area() {
		JPanel sub[] = new JPanel[2];

		for (int i = 0; i < sub.length; i++) {
			sub[i] = new JPanel();
			jp.add(sub[i]);
			sub[i].setBackground(Color.WHITE);
			sub[i].setVisible(true);
			sub[i].setLayout(null);
		}

		sub[0].setSize(320, 120);
		sub[0].setLocation(15, 280);

		sub[1].setSize(320, 120);
		sub[1].setLocation(15, 430);
		
		JLabel jl[] =new JLabel[10];
		for(int i = 0; i<jl.length;i++)
		{
			
		}


	}

	public void SET_Label_Area() {
		JLabel jl[] = new JLabel[2];
		ImageIcon img = new ImageIcon("menu.png");
		jl[0] = new JLabel("11월 소비액");
		jl[1] = new JLabel(img);

		jl[0].setLocation(20, -20);
		jl[1].setLocation(270, -20);

		for (int i = 0; i < jl.length; i++) {
			jl[i].setSize(100, 100);
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}

	}

	public void point(Point p) {
		if (p != null) {
			jf.setLocation(p);
		}
	}

}
