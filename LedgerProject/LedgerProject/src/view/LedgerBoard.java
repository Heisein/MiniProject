package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Ledger;
import model.LedgerDAO;
import model.User;

public class LedgerBoard {
	User user;
	JFrame jf = new JFrame("�뵷��"); // ���� ������
	JPanel jp = new JPanel(); // ���� �г�
	JPanel ledgerPanel; // ���� �г�, ��� ���� ������ �г�
	JLabel titleLabel = new JLabel();
	showPopup pop; // �˾�â
	LedgerBoard ledgerlo;
	int totalExpense = 0; // �� ����
	int totalImpotation = 0; // �� ����
	DecimalFormat shapFormat = new DecimalFormat("#,###"); // ��ǥ�� ���� 

	LedgerDAO ledgerDAO; // ���� dao
	ArrayList<Ledger> ledgers; // �Ǽ�

	public LedgerBoard(User user) {
		this.user = user;
		ledgerDAO = new LedgerDAO(user); // ������ �г� �ʱ�ȭ ���� ledgerDAO�� �ҷ��µ�
		ledgers = ledgerDAO.getLedgers(); // ó���� �׷��� �뵵�� ledger ������
		ledgerlo = this; // JDialog���� �긦 ���� ���ؼ� �� �ּҸ� �������� �� ���۷��� ������

		System.out.println("���� �α����� ���� : " + user.getUserID());

		// �� �߰�
		titleLabel = new JLabel("�Һ� ����");

		titleLabel.setSize(100, 20);
		titleLabel.setLocation(140, 20);
		titleLabel.setFont(new Font("���� ���", Font.PLAIN, 16));
		titleLabel.setForeground(Color.WHITE);

		jp.add(titleLabel);

		// �̹��� �߰�
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Terms_3();
				jf.dispose();
			}
		});

		ImageIcon img2 = new ImageIcon("images/plus.png");
		JLabel plusLabel = new JLabel(img2);
		plusLabel.setSize(50, 50);
		plusLabel.setLocation(295, 6);
		plusLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pop = new showPopup(jf, "��� �̷� �߰�", ledgerlo);
				pop.setVisible(true);
			}
		});

		jp.add(plusLabel);
		jp.add(jl);

		// ���� �г� �߰�
		ledgerPanel = new JPanel();
		ledgerPanel.setLocation(0, 60);
		ledgerPanel.setLayout(null);
		ledgerPanel.setBackground(Color.white);

		// �����гο� ��ũ�� ����
		ScrollPane sp = new ScrollPane();
		sp.setLocation(0, 60);
		sp.setSize(340, 600);
		sp.add(ledgerPanel);

		// �ʱ� �о�� ledger �ѷ���
		this.setLedgerList();

		// ���� �г� �ʱ�ȭ
		jp.setLayout(null);
		jp.setBackground(new Color(117, 102, 205));
		jp.add(sp);

		// ���� ������ �ʱ�ȭ
		jf.add(jp);
		jf.setSize(360, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void rePaint() { // �� �Ҹ������� ȭ�� �ٽñ׸���
		Collections.sort(ledgers); // ������ �𸣰ڴµ� ������ ����ξȵǼ� ��Ʈ(��������)������
		Collections.reverse(ledgers); // ������������ ���Ľ�Ŵ
		ledgerDAO.saveLedger(); // ��������

		ledgerPanel.removeAll();
		this.setLedgerList();
		System.out.println("������Ʈ ����!");
	}

	// ledger �÷��ǿ� �ִ°� ȭ�鿡 �ѷ��ش�
	public void setLedgerList() {
		
		JLabel[] locateLabel = new JLabel[ledgers.size()];
		JLabel[] dateLabel = new JLabel[ledgers.size()];
		JLabel[] payLabel = new JLabel[ledgers.size()];
		JLabel[] moneyLabel = new JLabel[ledgers.size()];

		// ledger �ҷ��ö����� ������ �ٽñ׷���!
		ledgerPanel.setSize(360, 200 + (ledgers.size() * 55));
		ledgerPanel.setPreferredSize(new Dimension(340, 200 + (ledgers.size() * 55)));

		System.out.println("�缳���� ledgerPanel : " + ledgerPanel.getSize());

		// �Ź� ������,������ ���̸� �ȵǹǷ� setLedgerList �ҷ��ö����� �ʱ�ȭ
		totalExpense = 0;
		totalImpotation = 0;
		
		for (int i = 0; i < ledgers.size(); i++) {
			Ledger l = ledgers.get(i); // temp������ ����� Ledger l

			// ��� ���� �ѷ���
			locateLabel[i] = new JLabel(l.getLocate());
			locateLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			locateLabel[i].setBounds(15, 5 + (i * 55), 200, 25);

			// ���� �ѷ���
			String date = l.getDate();
			String str = new String(
					"20" + date.substring(0, 2) + "." + date.substring(2, 4) + "." + date.substring(4, 6) + " "
							+ date.substring(6, 8) + ":" + date.substring(8, 10) + " " + l.getCategory());

			dateLabel[i] = new JLabel(str);
			dateLabel[i].setFont(new Font("���� ���", Font.PLAIN, 12));
			dateLabel[i].setForeground(Color.GRAY);
			dateLabel[i].setBounds(15, 25 + (i * 55), 200, 25);
			
			// ���α׾���
			JLabel line = new JLabel();
			line.setBorder(new LineBorder(Color.GRAY, 5));
			line.setSize(275, 2);
			line.setLocation(15, 55 + (i * 55));
			line.setVisible(true);

			// �Һ�ݾ� �ѷ���
			payLabel[i] = new JLabel();
			int payInt = Integer.parseInt(l.getPay()); // ��ǥ������� �о�� �Һ�ݾ� int������ �Ľ�
			
			String payStr;
			if (l.isExpense()) {
				payLabel[i].setForeground(Color.RED); // �����̸� ����
				payStr = "- " + shapFormat.format(payInt);
				totalExpense += payInt; // �����⿡ ������
			} else {
				payLabel[i].setForeground(Color.BLUE); // �����̸� �Ķ�
				payStr = "+ " + shapFormat.format(payInt);
				totalImpotation += payInt; // �Ѽ��Կ� ������
			}
			payLabel[i].setText(payStr);
			payLabel[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			int payX = 281 - (payStr.length() * 7);
			if (l.isExpense())
				payX += 4;
			payLabel[i].setBounds(payX, 5 + (i * 55), payStr.length() * 10, 25);

			ledgerPanel.add(line);
			ledgerPanel.add(locateLabel[i]);
			ledgerPanel.add(dateLabel[i]);
			ledgerPanel.add(payLabel[i]);
		} // eof
		
		System.out.println("������ : " + totalExpense);
		System.out.println("�Ѽ��� : " + totalImpotation);
	}
}

// ================== ���� �߰��ϴ� �˾�â Ŭ���� ==========================
class showPopup extends JDialog implements ActionListener {
	JPanel mp, innerPanel;
	JLabel titleLabel;
	JButton confirmButton;
	LedgerBoard board;
	LedgerBoard le;

	public showPopup(Frame parent, String str, LedgerBoard le) {
		super(parent, str, true); // JDialog �������ε�
		this.le = le; //

		this.setSize(360, 600);
		addWindowListener(new MyWinListener());

		// ���� �г� �ʱ�ȭ
		mp = new JPanel();
		mp.setBackground(new Color(117, 102, 205));
		mp.setLayout(null);

		// ���� �гο� Ÿ��Ʋ �� ���̱�
		titleLabel = new JLabel("�Һ� ���� �߰�");

		titleLabel.setSize(150, 20);
		titleLabel.setLocation(120, 20);
		titleLabel.setFont(new Font("���� ���", Font.PLAIN, 16));
		titleLabel.setForeground(Color.WHITE);

		mp.add(titleLabel);

		// ���� �Է� �г� �ʱ�ȭ
		innerPanel = new JPanel();
		innerPanel.setBackground(Color.WHITE);
		innerPanel.setLayout(null);
		innerPanel.setBounds(0, 60, 360, 450);

		// ���� �Է� �гο� ���� ���̱�
		JLabel[] titles = new JLabel[6];
		titles[0] = new JLabel("�ݾ�");
		titles[1] = new JLabel("����");
		titles[2] = new JLabel("�Ͻ�");
		titles[3] = new JLabel("���⿩��");
		titles[4] = new JLabel("ī�װ�");
		titles[5] = new JLabel("�޸�");

		JTextField[] texts = new JTextField[4];

		for (int i = 0; i < 6; i++) {
			// �󺧵� ũ��� ��Ʈ ����, �гο� �߰�
			titles[i].setFont(new Font("���� ���", Font.PLAIN, 16));
			titles[i].setBounds(15, 5 + (i * 50), 100, 50);
			innerPanel.add(titles[i]);

			// ���� ������
			if (i < 5) {
				JLabel line = new JLabel();
				line.setBorder(new LineBorder(Color.GRAY, 5));
				line.setSize(275, 2);
				line.setLocation(15, 55 + (i * 50));
				line.setVisible(true);
				innerPanel.add(line);
			}

			// �ؽ�Ʈ�ʵ� �ʱ�ȭ, ����, �гο� �߰�
			if (i < 3) {
				texts[i] = new JTextField();
				texts[i].setBounds(90, 18 + (i * 50), 200, 30);

				innerPanel.add(texts[i]);
			}

		} // eof

		JTextArea memoArea = new JTextArea();
		memoArea.setBounds(15, 300, 300, 120);
		memoArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		innerPanel.add(memoArea);

		// �Ͻ� �ؽ�Ʈ�ʵ� ���� �ڵ� �Ͻ� ��ư
		JButton autoDateBtn = new JButton("����");
		autoDateBtn.setBounds(295, 118, 45, 30);

		// �ڵ� �Ͻ� ��ư ������ ����ð� �Էµ�
		autoDateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
				texts[2].setText(sdf.format(date));
			}
		});

		innerPanel.add(autoDateBtn);

		// �ؽ�Ʈ�ʵ� �ؽ�Ʈ �ʱ�ȭ
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
		texts[0].setText("�ݾ��� �Է����ּ���.");
		texts[1].setText("�̿� ������ �Է����ּ���.");
		texts[2].setText(sdf.format(date));

		// �ؽ�Ʈ�ʵ� ������ ���ھ������� ���콺������ �߰�
		texts[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[0].setText("");
			}
		});

		texts[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[1].setText("");
			}
		});

		texts[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				texts[2].setText("");
			}
		});

		// ����, ���� �����ڽ�
		JRadioButton jrb1 = new JRadioButton("����");
		JRadioButton jrb2 = new JRadioButton("����");

		jrb1.setSelected(true); // �����ڽ� ���� �ϳ��� ���õǾ� �־�� �ϹǷ� �⺻������ ���� true��

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		jrb1.setBackground(Color.white);
		jrb2.setBackground(Color.white);
		jrb1.setFont(new Font("���� ���", Font.PLAIN, 15));
		jrb2.setFont(new Font("���� ���", Font.PLAIN, 15));

		jrb1.setBounds(85, 165, 70, 30);
		jrb2.setBounds(160, 165, 70, 30);

		innerPanel.add(jrb1);
		innerPanel.add(jrb2);

		// ī�װ�
		String[] categoryStr = { "ī�װ��� �������ּ���", "ī�װ�1", "ī�װ�2", "ī�װ�3" };
		JComboBox categoryCb = new JComboBox(categoryStr);
		categoryCb.setBounds(90, 218, 200, 30);

		innerPanel.add(categoryCb);

		// =============== ���� �����г� ==============

		// �����г� �ڷΰ��� ��ư
		ImageIcon img = new ImageIcon("images/back.png");
		JLabel jl = new JLabel(img);
		jl.setSize(50, 50);
		jl.setLocation(5, 5);
		jl.setVisible(true);
		jl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		// �����г� �Ϸ��ư
		JLabel commitLabel = new JLabel("�Ϸ�");
		commitLabel.setSize(100, 20);
		commitLabel.setLocation(150, 525);
		commitLabel.setFont(new Font("���� ���", Font.PLAIN, 14));
		commitLabel.setForeground(Color.white);

		// �Ϸ��ư ������
		commitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// texts 0�ݾ� 1�Ͻ� 2���⿩�� 3ī�װ� 4�޸�
				boolean isExpense = true;

				// �����ڽ� �⺻���� �����̹Ƿ�.
				if (jrb1.isSelected())
					isExpense = true;
				else
					isExpense = false;

				// �ֿܼ� �߰��� Ledger ����
				String str = (texts[0].getText() + "," + texts[1].getText() + "," + texts[2].getText() + "," + isExpense
						+ "," + categoryCb.getSelectedItem());
				System.out.println(str);

				// ledgerDAO�� insert
				le.ledgerDAO.insertLedger(texts[0].getText(), texts[1].getText(), texts[2].getText(), isExpense,
						categoryCb.getSelectedItem().toString(), memoArea.getText());

				le.rePaint(); // �ٽ� �׷��ֱ�~
				dispose(); // �̰� ����
			}
		});

		mp.add(jl);
		mp.add(commitLabel);

		add(innerPanel);
		add(mp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); // ��ȭ���� ����
	}

	class MyWinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			dispose();
		}
	}

}
