package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CategoryList_23 {
	JFrame jf =new JFrame("¿ëµ·Á¶");
	JPanel jp =new JPanel();
	JPanel sub =new JPanel();
	JPanel sub1 =new JPanel();
	
	public CategoryList_23() {
		jf.setSize(360,600);
		jf.setTitle("¿ëµ·Á¶");
		SET_IMG_Area();
		SET_Label_Area();
		SET_Text_And_Label_Area1();
		SET_Text_And_Label_Area();
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void SET_Text_And_Label_Area1() {
		
		sub1.setSize(360, 70);
		sub1.setLocation(0, 60);
		sub1.setLayout(null);
		JLabel label =new JLabel("ºäÆ¼ ¼Òºñ¾×");
		label.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,12));
		label.setForeground(Color.WHITE);
		label.setSize(100,20);
		label.setLocation(20,10);
		JLabel label2 =new JLabel("115,200");
		label2.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,22));
		label2.setForeground(Color.WHITE);
		label2.setSize(100,20);
		label2.setLocation(15,40);
		sub1.setBackground(new Color(117, 102, 205));
		sub1.add(label);
		sub1.add(label2);
		
		jp.add(sub1);
	}
	public void SET_Text_And_Label_Area() {
		sub.setSize(360, 600);
		sub.setLocation(0, 130);
		sub.setLayout(null);
		sub.setBackground(Color.white);
		
		JLabel jl1[]=new JLabel[4];
		jl1[0]=new JLabel("Åä¸®Çì¾î¼öÁö");
		jl1[1]=new JLabel("2016.12.27 ¿ÀÈÄ 09:34");
		jl1[2]=new JLabel("¾¾Á¦ÀÌ¿À¸®ºê³×");
		jl1[3]=new JLabel("2016.12.23 ¿ÀÈÄ 01:36");
		
		jl1[0].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		jl1[1].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
		jl1[2].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
		jl1[3].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,10));
		
		jl1[0].setSize(100,20);
		jl1[0].setLocation(10,5);
		
		jl1[1].setSize(150,20);
		jl1[1].setLocation(10,25);
		
		jl1[2].setSize(100,20);
		jl1[2].setLocation(10,55);

		jl1[3].setSize(150,20);
		jl1[3].setLocation(10,75);

		JLabel Line[] =new JLabel[2];
		for(int i=0; i<Line.length; i++) {
			Line[i] =new JLabel();
	    	Line[i].setBorder(new LineBorder(Color.GRAY,5));
		    Line[i].setSize(330,2);
		    sub.add(Line[i]);
	    }
	    Line[0].setLocation(10,50);
	    Line[1].setLocation(10,100);

	    ImageIcon checkCardimg=new ImageIcon("images/checkcard.png");
	    JLabel checkcard[] = new JLabel[2];
	    for(int i=0; i<checkcard.length; i++) {
	    	checkcard[i]= new JLabel(checkCardimg);
	    	checkcard[i].setSize(100,25);
	    	sub.add(checkcard[i]);
	    }
	    checkcard[0].setLocation(120,15);
	    checkcard[1].setLocation(120,70);

	    JLabel cost[] =new JLabel[2];
	    cost[0]=new JLabel("75,000");
	    cost[1]=new JLabel("40,200");
	    
	    for(int i=0; i<cost.length; i++) {
	    	cost[i].setSize(100,25);
	    	cost[i].setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,15));
	    	sub.add(cost[i]);
	    }
	    cost[0].setLocation(270,15);
	    cost[1].setLocation(270,70);
	    
	    ImageIcon moreimg=new ImageIcon("images/front.png");
	    JLabel[] more = new JLabel[2];
	    for(int i=0; i<more.length; i++) {
	    	more[i]=new JLabel(moreimg);
	    	more[i].setSize(50,30);
	    	sub.add(more[i]);
	    	
	    }
	    more[0].setLocation(305,12);
	    more[1].setLocation(305,65);
	    
	    ImageIcon plusimg =new ImageIcon("images/23_plus.png");
	    JLabel plus=new JLabel(plusimg);
	    plus.setSize(100,100);
	    plus.setLocation(250,350);
	    sub.add(plus);
		
	    for(int i=0; i<jl1.length; i++) {
			sub.add(jl1[i]);
		}
		jp.add(sub);
	}
	
	
	
	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jp.add(jl);
	}
	public void SET_Label_Area() {//±âÅ¸ ¶óº§ ¿µ¿ª
		JLabel jl[] = new JLabel[2];
		ImageIcon menu = new ImageIcon("images/menu.png");
		
		jl[0] = new JLabel("¼ÒºñºÐ·ù»ó¼¼");
		jl[1] = new JLabel(menu);
		
		
		jl[0].setSize(100, 20);
		jl[0].setLocation(130, 20);
		jl[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));

		jl[1].setSize(40, 40);
		jl[1].setLocation(295, 10);
		jl[1].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CategoryList_23();
	}

}
