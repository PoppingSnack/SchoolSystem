//123
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//����������Ҫ��
public class JCTX {
	public static void main(String[] args) {
		new Frm_Main();
	}
}
// ʵ����
class Frm_Main implements ActionListener 
{
	public JFrame frame;
	public Container c;
	public JMenuBar menuBar;
	public JMenu mainMenu1;
	public JMenu mainMenu2;
	public JMenu mainMenu3;
	public JMenuItem subMenu1[] = new JMenuItem[5];
	public JMenuItem subMenu2[] = new JMenuItem[7];
	public JMenuItem subMenu3[] = new JMenuItem[2];
	JButton toolBarButton[] = new JButton[8];
	public JToolBar toolBar;
	String strTip[] = { "��ѯ��Ҫ�ҵ�ѧ����¼...", "���ѧ����¼...", "ɾ�����е�ѧ����¼", "�޸�ѧ����¼...",
			"ʹ���޸ĵ�ѧ����¼��Ч...", "ʹ     ����ӵ�ѧ����¼��Ч...", "ȷ��ɾ����ǰ��¼...", "�˳���ϵͳ:)" };
	String id = new String();
	String name = new String();
	String sex = new String();
	String birthday = new String();
	String address = new String();
	String birth = new String();
	Connection conn;
	ResultSet rs;
	Statement st;
	PreparedStatement pst;
	public JLabel idL = new JLabel("ѧ�ţ�");
	public JLabel nameL = new JLabel("������");
	public JLabel sexL = new JLabel("�Ա�");
	public JLabel jlbirth = new JLabel("�������£�");
	public JLabel jladdr = new JLabel("���᣺");
	public JTextField idT = new JTextField();
	public JTextField nameT = new JTextField();
	public JTextField sexT = new JTextField();
	public JTextField jtbirth = new JTextField();
	public JTextField jtaddr = new JTextField();
	public Frm_Main() {
		frame = new JFrame("ѧ����Ϣ����ϵͳ");
		c = frame.getContentPane();
		c.setLayout(null);
		menuBar = new JMenuBar();
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.setJMenuBar(menuBar);
		frame.setResizable(false);
		mainMenu1 = new JMenu("����");
		String str1[] = { "����û�", "ɾ���û�", "��ѯ�û�", " ", "�˳�" };
		for (int i = 0; i < 5; i++) {
			if (i == 3)
				mainMenu1.addSeparator();
			else {
				subMenu1[i] = new JMenuItem(str1[i]);
				subMenu1[i].addActionListener(this);
				mainMenu1.add(subMenu1[i]);
			}
		}
		menuBar.add(mainMenu1);
		mainMenu2 = new JMenu("ά��ѧ����Ϣ");
		String str2[] = { "��ѯ��¼", "��Ӽ�¼", "ɾ����¼", "�޸ļ�¼", "�ύ�޸�", "�ύ���",
				"ȷ��ɾ��" };
		for (int i = 0; i < 7; i++) {
			subMenu2[i] = new JMenuItem(str2[i]);
			subMenu2[i].addActionListener(this);
			mainMenu2.add(subMenu2[i]);
		}
		menuBar.add(mainMenu2);
		mainMenu3 = new JMenu("����");
		String str3[] = { "����...", "����..." };
		for (int i = 0; i < 2; i++) {
			subMenu3[i] = new JMenuItem(str3[i]);
			subMenu3[i].addActionListener(this);
			mainMenu3.add(subMenu3[i]);
		}
		menuBar.add(mainMenu3);
		String strToolBar[] = { "��ѯ", "���", "ɾ��", "�޸�", "�ύ�޸�", "�ύ���", "ȷ��ɾ��" };
		for (int i = 0; i < 7; i++) {
			toolBarButton[i] = new JButton(strToolBar[i]);
			toolBarButton[i].setToolTipText(strTip[i]);
			toolBarButton[i].addActionListener(this);
			toolBar.add(toolBarButton[i]);
		}
		toolBar.setLocation(0, 0);
		toolBar.setSize(400, 30);
		c.add(toolBar);
		idL.setLocation(35, 40);
		idL.setSize(40, 20);
		c.add(idL);
		idT.setLocation(90, 40);
		idT.setSize(200, 20);
		c.add(idT);
		nameL.setLocation(35, 70);
		nameL.setSize(40, 20);
		c.add(nameL);
		nameT.setLocation(90, 70);
		nameT.setSize(200, 20);
		c.add(nameT);
		sexL.setLocation(35, 100);
		sexL.setSize(40, 20);
		c.add(sexL);
		sexT.setLocation(90, 100);
		sexT.setSize(200, 20);
		c.add(sexT);
		jlbirth.setLocation(35, 160);
		jlbirth.setSize(40, 20);
		c.add(jlbirth);
		jtbirth.setLocation(90, 160);
		jtbirth.setSize(200, 20);
		c.add(jtbirth);
		jladdr.setLocation(35, 190);
		jladdr.setSize(40, 20);
		c.add(jladdr);
		jtaddr.setLocation(90, 190);
		jtaddr.setSize(200, 20);
		c.add(jtaddr);
		JLabel information = new JLabel("");
		information.setFont(new Font("����", Font.BOLD, 35));
		information.setSize(380, 110);
		information.setLocation(10, 210);
		c.add(information);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		conDB();
	}
	// �������������ݿ���桢���
	// �������������ݿ�
	public Connection conDB() {
		Connection  con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjava", "root", "gyfwaysys");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��");
		}
		return con;
	}
	// �����ǹر����ݿ�
	public void closeDB() {
		try {
			pst.close();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ�ر�ʧ�ܣ�");
		}
	}
	// ������������ݿ�ĸ��ֲ���
	public void actionPerformed(ActionEvent e) {
		conn=conDB();
		if (e.getSource() == subMenu3[1] || e.getSource() == toolBarButton[7])
			JOptionPane.showMessageDialog(null, "");
		if (e.getSource() == subMenu1[0] || e.getSource() == subMenu1[1]
				|| e.getSource() == subMenu1[2])
			JOptionPane.showMessageDialog(null, "");
		// ���ҹ��ܵ�ʵ��
		if (e.getSource() == subMenu2[0] || e.getSource() == toolBarButton[0]) {
			String idid = JOptionPane.showInputDialog("������Ҫ���ҵ�ѧ��ѧ��");
			if (idid.trim() != "") {
				String strSQL = "select * from student where id =?" ;	
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, idid);
					rs=pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						id = rs.getString("id");
						name = rs.getString("name");
						address = rs.getString("address");
						sex = rs.getString("sex");
						birth=rs.getString("birthday");
						count++;
					}
					if (count == 0)
						JOptionPane.showMessageDialog(null, "�Բ���û����Ҫ���ҵ�ѧ����");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birth);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "��Ǹ����������쳣��");
				}
			}
		}
		if (e.getSource() == subMenu1[4]) {
			closeDB();
			System.exit(0);
		}
		if (e.getSource() == subMenu2[1] || e.getSource() == toolBarButton[1]) {
			JOptionPane.showMessageDialog(null, "������Ҫ��ӵ�ѧ����Ϣ");
			idT.setEnabled(true);
			idT.setText("");
			nameT.setText("");
			sexT.setText("");
			jtaddr.setText("");
			jtbirth.setText("");
		}
		if (e.getSource() == toolBarButton[5] || e.getSource() == subMenu2[5]) {
			if ((idT.getText().trim()).equals("")
					|| (nameT.getText().trim()).equals("")
					|| (sexT.getText().trim()).equals("")
					|| (jtaddr.getText().trim()).equals("")
					|| (jtbirth.getText().trim()).equals(""))
				JOptionPane.showMessageDialog(null, "��������Ϣ�ٵ���ύ��ӣ�");
			else {
				id = idT.getText();
				name = nameT.getText();
				sex = sexT.getText();
				birthday = jtaddr.getText();
				address = jtbirth.getText();
				String strSQL = "insert into student values(?,?,?,?,?)";
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, id);
					pst.setString(2, name);
					pst.setString(3, sex);
					pst.setString(4, address);
					pst.setString(5, birthday);
					pst.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "���ݿ����Ѿ�������Ҫ��ӵ�ѧ����ѧ�ţ�");
					return;
				}
				JOptionPane.showMessageDialog(null, "��ϲ������ӳɹ��ˣ�");
			}
		}
		if (e.getSource() == subMenu2[4] || e.getSource() == toolBarButton[4]) {
			if ((idT.getText().trim()).equals("")
					|| (nameT.getText().trim()).equals("")
					|| (sexT.getText().trim()).equals("")
					|| (jtaddr.getText().trim()).equals("")
					|| (jtbirth.getText().trim()).equals("")) {
				JOptionPane.showMessageDialog(null, "��������Ϣ�ٵ���޸ģ�");
				return;
			} else {
				id = idT.getText();
				name = nameT.getText();
				sex = sexT.getText();
				birthday = jtaddr.getText();
				address = jtbirth.getText();
				String strSQL = "update student set name=?,sex=?,address=?,birthday=? where id=?";
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, name);
					pst.setString(2, sex);
					pst.setString(3, address);
					pst.setString(4, birthday);
					pst.setString(5, id);
					pst.executeUpdate();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "���ݿ����Ѿ�������Ҫ�޸ĵ�ѧ����¼��");
					return;
				}			
				JOptionPane.showMessageDialog(null, "��ϲ�����޸ĳɹ��ˣ�");
			}
		}
		if (e.getSource() == subMenu2[3] || e.getSource() == toolBarButton[3]) {
			String idid = JOptionPane.showInputDialog("������Ҫ�޸ĵ�ѧ��ѧ��");
			if (idid.trim() != "") {
				String strSQL = "select * from student where id =?" ;
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, idid);
					rs = pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						id = rs.getString("id");
						name = rs.getString("name");
						address = rs.getString("address");
						sex = rs.getString("sex");
						birthday = rs.getString("birthday");
						count++;
					}
					if (count == 0)
						JOptionPane.showMessageDialog(null, "�Բ���û����Ҫ�޸ĵ�ѧ����Ϣ��");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birthday);
						idT.setEnabled(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "��Ǹ����������쳣��");
				}
			}
		}
		if (e.getSource() == subMenu2[2] || e.getSource() == toolBarButton[2]) {
			String idDel = JOptionPane.showInputDialog("������Ҫɾ����ѧ��ѧ��");
			if (idDel.trim() != "") {
				String strSQL = "select * from student where id =?";
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, idDel);
					rs = pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						id = rs.getString("id");
						name = rs.getString("name");
						address = rs.getString("address");
						sex = rs.getString("sex");
						birthday = rs.getString("birthday");
						++count;
					}
					if (count == 0)
						JOptionPane.showMessageDialog(null, "�Բ���û����Ҫɾ����ѧ����Ϣ��");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birthday);
						idT.setEnabled(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "��Ǹ����������쳣��");
				}
			}
		}
		if (e.getSource() == toolBarButton[6] || e.getSource() == subMenu2[6]) {
			if ((idT.getText().trim()).equals("")
					|| (nameT.getText().trim()).equals("")
					|| (sexT.getText().trim()).equals("")
					|| (jtaddr.getText().trim()).equals("")
					|| (jtbirth.getText().trim()).equals("")) {
				JOptionPane.showMessageDialog(null, "����ɾ����¼��ť��");
				return;
			} else {
				id = idT.getText();
				String strSQL = "delete from student where id=?";
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, id);
					pst.executeUpdate();
				} catch (Exception exx) {
					JOptionPane.showMessageDialog(null, "�����ˣ�");
					return;
				}
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
			}
		}
	}
}