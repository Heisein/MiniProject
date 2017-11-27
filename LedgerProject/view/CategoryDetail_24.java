package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
//�Һ��̷»�
public class CategoryDetail_24  {
	JFrame jf = new JFrame("�뵷��");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	
	public CategoryDetail_24() {
		jf.setSize(360,600);
		jf.setTitle("�뵷��");
		SET_IMG_Area();
		SET_Text_And_Label_Area();
		SET_Label_Area();
		
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void SET_Text_And_Label_Area() {

		sub.setSize(360, 600);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);
		
		JLabel[] jl1 =new JLabel[6];
		jl1[0]=new JLabel("�ݾ�");
		jl1[1]=new JLabel("����");
		jl1[2]=new JLabel("�Ͻ�");
		jl1[3]=new JLabel("�������");
		jl1[4]=new JLabel("ī�װ�");
		jl1[5]=new JLabel("�޸�");
		for(int i=0; i<jl1.length; i++) {
			jl1[i].setFont(new Font("�������",Font.PLAIN,15));
			jl1[i].setLocation(20,20+(i*50));
		}
		JLabel Line[] =new JLabel[5];
	    for(int i=0; i<Line.length; i++) {
	    	Line[i] =new JLabel();
	    	Line[i].setBorder(new LineBorder(Color.GRAY,5));
		    Line[i].setSize(300,2);
		    Line[i].setLocation(20,50+(i*50));
		    sub.add(Line[i]);
	    }
		JLabel[] jl2 =new JLabel[4];
		jl2[0]=new JLabel("75,000");
		jl2[1]=new JLabel("�丮���� ����");
		jl2[2]=new JLabel("2017.11.23 ");
		jl2[3]=new JLabel("üũī��");
		
		String[] category = {"�ܽ�","ī��/����Ŀ��","��/����","��Ʈ","��Ȱ/�ְ�","����","����/�ڵ���","���","����","�¶��μ���","��Ƽ","��ȭ/��ȭ"};
		JComboBox cate_List =new JComboBox(category);
		cate_List.setSelectedIndex(0);
		cate_List.setSize(100,25);
		cate_List.setLocation(220,210);
		
		sub.add(cate_List);
		
		for(int i=0; i<jl2.length; i++) {
			jl2[i].setFont(new Font("�������",Font.PLAIN,15));
			jl2[i].setLocation(250,10+(i*50));
		}
		
		for (int i = 0; i <jl1.length; i++) {
			jl1[i].setSize(100,15);
			jl1[i].setVisible(true);
			sub.add(jl1[i]);
		}
		
		for (int i = 0; i < jl2.length; i++) {
			jl2[i].setSize(100,15);
			jl2[i].setVisible(true);
			sub.add(jl2[i]);
		}

		for (int i = 0; i < jl2.length; i++) {
			jl2[i].setSize(300, 30);
			jl2[i].setVisible(true);
		}
		
		JTextField memo=new JTextField();
		memo.setSize(330,190);
		memo.setLocation(10,300);
		sub.add(memo);
		jp.add(sub);
		
		
	}
	public void SET_IMG_Area() {
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jp.add(jl);
	}

	public void SET_Label_Area() {//��Ÿ �� ����
		JLabel jl[] = new JLabel[2];
		
		jl[0] = new JLabel("�Һ��̷»�");
		jl[1] = new JLabel("����");

		jl[0].setSize(100, 20);
		jl[0].setLocation(110, 20);
		jl[0].setFont(new Font("���� ���", Font.PLAIN, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(300, 20);
		jl[1].setFont(new Font("���� ���", Font.PLAIN, 14));
		for (int i = 0; i < jl.length; i++) {
			jl[i].setForeground(Color.WHITE);
			jl[i].setVisible(true);
			jp.add(jl[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CategoryDetail_24();
	}

}
