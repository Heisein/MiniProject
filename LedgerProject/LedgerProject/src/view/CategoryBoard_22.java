package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.UserDAO;

//�Һ��̷��Է�

public class CategoryBoard_22 {
	JFrame jf = new JFrame("�뵷��");
	JPanel jp = new JPanel();
	JPanel sub = new JPanel();
	UserDAO users=new UserDAO();

	public CategoryBoard_22(UserDAO user) {
		jf.setSize(360, 600);
		jp.setBackground(new Color(117, 102, 205));
		jp.setLayout(null);
		SET_IMG_Area();
		SET_Label_Area();
		Input_Consumption();
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 users= user;
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
				new LedgerBoardInput_21(users).point(jf.getLocation());
				jf.setVisible(false);
			}
		});
		jp.add(jl);
	}

	public void Input_Consumption() {
		sub.setSize(360, 450);
		sub.setLocation(0, 60);
		sub.setLayout(null);
		sub.setBackground(Color.white);
		jp.add(sub);

		JLabel[] jl1 = new JLabel[6];
		jl1[0] = new JLabel("�ݾ�");
		jl1[1] = new JLabel("����");
		jl1[2] = new JLabel("�Ͻ�");
		jl1[3] = new JLabel("�������");
		jl1[4] = new JLabel("ī�װ�");
		jl1[5] = new JLabel("�޸�");
		for (int i = 0; i < jl1.length; i++) {
			jl1[i].setFont(new Font("�������", Font.PLAIN, 15));
			jl1[i].setLocation(20, 20 + (i * 50));
		}
		JLabel Line[] = new JLabel[5];
		for (int i = 0; i < Line.length; i++) {
			Line[i] = new JLabel();
			Line[i].setBorder(new LineBorder(Color.GRAY, 5));
			Line[i].setSize(300, 2);
			Line[i].setLocation(20, 50 + (i * 50));
			sub.add(Line[i]);
		}
		for (int i = 0; i < jl1.length; i++) {
			jl1[i].setSize(100, 15);
			jl1[i].setVisible(true);
			sub.add(jl1[i]);
		}

		JTextArea input[] = new JTextArea[3];
		input[0] = new JTextArea(" �ݾ��� �Է����ּ���");
		input[1] = new JTextArea(" ���� ������ �Է����ּ���");
		input[2] = new JTextArea(" ���� �Ͻø� �Է����ּ���");
		for (int i = 0; i < input.length; i++) {
			input[i].setSize(200, 25);
			input[i].setBorder(new LineBorder(Color.black));
			sub.add(input[i]);
		}
		input[0].setLocation(100, 15);
		input[1].setLocation(100, 65);
		input[2].setLocation(100, 115);

		String[] money = { "����", "ī��" };
		String[] category = { "�ܽ�", "ī��/����Ŀ��", "��/����", "��Ʈ", "��Ȱ/�ְ�", "����", "����/�ڵ���", "���", "����", "�¶��μ���", "��Ƽ",
				"��ȭ/��ȭ" };
		JComboBox[] combo = new JComboBox[2];
		combo[0] = new JComboBox(money);
		combo[1] = new JComboBox(category);
		for (int i = 0; i < combo.length; i++) {
			combo[i].setSelectedIndex(0);
			combo[i].setSize(200, 25);
			sub.add(combo[i]);
		}
		combo[0].setLocation(100, 160);
		combo[1].setLocation(100, 210);

		// ������� ���� [�̺�Ʈ��]
		input[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				input[0].setText("");
			}
		});
		input[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				input[1].setText("");
			}
		});
		input[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				input[2].setText("");
			}
		});

		JTextField memo = new JTextField();
		memo.setSize(330, 130);
		memo.setLocation(10, 300);
		sub.add(memo);

	}

	public void SET_Label_Area() {// ��Ÿ �� ����
		JLabel jl[] = new JLabel[2];

		jl[0] = new JLabel("�Һ��̷��Է�");
		jl[1] = new JLabel("�Ϸ�");

		jl[1].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new LedgerBoardInput_21(users).point(jf.getLocation());
				jf.setVisible(false);
			}
		});

		jl[0].setSize(100, 20);
		jl[0].setLocation(130, 20);
		jl[0].setFont(new Font("���� ���", Font.BOLD, 16));

		jl[1].setSize(100, 20);
		jl[1].setLocation(150, 525);
		jl[1].setFont(new Font("���� ���", Font.BOLD, 14));
		for (int i = 0; i < jl.length; i++) {
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
