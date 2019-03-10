//ssss
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//涓诲嚱鏁般�佷富瑕佺被
public class JCTX {
	public static void main(String[] args) {
		new Frm_Main();
	}
}
// 瀹炵幇绫�
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
	String strTip[] = { "鏌ヨ鎮ㄨ鎵剧殑瀛︾敓璁板綍...", "娣诲姞瀛︾敓璁板綍...", "鍒犻櫎宸叉湁鐨勫鐢熻褰�", "淇敼瀛︾敓璁板綍...",
			"浣挎偍淇敼鐨勫鐢熻褰曠敓鏁�...", "浣�     鎮ㄦ坊鍔犵殑瀛︾敓璁板綍鐢熸晥...", "纭鍒犻櫎褰撳墠璁板綍...", "閫�鍑烘湰绯荤粺:)" };
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
	public JLabel idL = new JLabel("瀛﹀彿锛�");
	public JLabel nameL = new JLabel("濮撳悕锛�");
	public JLabel sexL = new JLabel("鎬у埆锛�");
	public JLabel jlbirth = new JLabel("鍑虹敓骞存湀锛�");
	public JLabel jladdr = new JLabel("绫嶈疮锛�");
	public JTextField idT = new JTextField();
	public JTextField nameT = new JTextField();
	public JTextField sexT = new JTextField();
	public JTextField jtbirth = new JTextField();
	public JTextField jtaddr = new JTextField();
	public Frm_Main() {
		frame = new JFrame("瀛︾敓淇℃伅绠＄悊绯荤粺");
		c = frame.getContentPane();
		c.setLayout(null);
		menuBar = new JMenuBar();
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		frame.setJMenuBar(menuBar);
		frame.setResizable(false);
		mainMenu1 = new JMenu("绠＄悊");
		String str1[] = { "娣诲姞鐢ㄦ埛", "鍒犻櫎鐢ㄦ埛", "鏌ヨ鐢ㄦ埛", " ", "閫�鍑�" };
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
		mainMenu2 = new JMenu("缁存姢瀛︾敓淇℃伅");
		String str2[] = { "鏌ヨ璁板綍", "娣诲姞璁板綍", "鍒犻櫎璁板綍", "淇敼璁板綍", "鎻愪氦淇敼", "鎻愪氦娣诲姞",
				"纭鍒犻櫎" };
		for (int i = 0; i < 7; i++) {
			subMenu2[i] = new JMenuItem(str2[i]);
			subMenu2[i].addActionListener(this);
			mainMenu2.add(subMenu2[i]);
		}
		menuBar.add(mainMenu2);
		mainMenu3 = new JMenu("甯姪");
		String str3[] = { "甯姪...", "鍏充簬..." };
		for (int i = 0; i < 2; i++) {
			subMenu3[i] = new JMenuItem(str3[i]);
			subMenu3[i].addActionListener(this);
			mainMenu3.add(subMenu3[i]);
		}
		menuBar.add(mainMenu3);
		String strToolBar[] = { "鏌ヨ", "娣诲姞", "鍒犻櫎", "淇敼", "鎻愪氦淇敼", "鎻愪氦娣诲姞", "纭鍒犻櫎" };
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
		information.setFont(new Font("瀹嬩綋", Font.BOLD, 35));
		information.setSize(380, 110);
		information.setLocation(10, 210);
		c.add(information);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		conDB();
	}
	// 浠ヤ笂鏄缃暟鎹簱闈㈢増銆佹鏋�
	// 浠ヤ笅鏄繛鎺ユ暟鎹簱
	public Connection conDB() {
		Connection  con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjava", "root", "gyfwaysys");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "鏁版嵁搴撹繛鎺ュけ璐�");
		}
		return con;
	}
	// 浠ヤ笅鏄叧闂暟鎹簱
	public void closeDB() {
		try {
			pst.close();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "鏁版嵁搴撳叧闂け璐ワ紒");
		}
	}
	// 浠ヤ笅鏄拡瀵规暟鎹簱鐨勫悇绉嶆搷浣�
	public void actionPerformed(ActionEvent e) {
		conn=conDB();
		if (e.getSource() == subMenu3[1] || e.getSource() == toolBarButton[7])
			JOptionPane.showMessageDialog(null, "");
		if (e.getSource() == subMenu1[0] || e.getSource() == subMenu1[1]
				|| e.getSource() == subMenu1[2])
			JOptionPane.showMessageDialog(null, "");
		// 鏌ユ壘鍔熻兘鐨勫疄鐜�
		if (e.getSource() == subMenu2[0] || e.getSource() == toolBarButton[0]) {
			String idid = JOptionPane.showInputDialog("璇疯緭鍏ヨ鏌ユ壘鐨勫鐢熷鍙�");
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
						JOptionPane.showMessageDialog(null, "瀵逛笉璧凤紝娌℃湁鎮ㄨ鏌ユ壘鐨勫鐢燂紒");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birth);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "鎶辨瓑锛岀▼搴忓嚭鐜板紓甯革紒");
				}
			}
		}
		if (e.getSource() == subMenu1[4]) {
			closeDB();
			System.exit(0);
		}
		if (e.getSource() == subMenu2[1] || e.getSource() == toolBarButton[1]) {
			JOptionPane.showMessageDialog(null, "璇疯緭鍏ヨ娣诲姞鐨勫鐢熶俊鎭�");
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
				JOptionPane.showMessageDialog(null, "璇疯緭鍏ヤ俊鎭啀鐐瑰嚮鎻愪氦娣诲姞锛�");
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
					JOptionPane.showMessageDialog(null, "鏁版嵁搴撲腑宸茬粡瀛樺湪鎮ㄨ娣诲姞鐨勫鐢熺殑瀛﹀彿锛�");
					return;
				}
				JOptionPane.showMessageDialog(null, "鎭枩鎮紝娣诲姞鎴愬姛浜嗭紒");
			}
		}
		if (e.getSource() == subMenu2[4] || e.getSource() == toolBarButton[4]) {
			if ((idT.getText().trim()).equals("")
					|| (nameT.getText().trim()).equals("")
					|| (sexT.getText().trim()).equals("")
					|| (jtaddr.getText().trim()).equals("")
					|| (jtbirth.getText().trim()).equals("")) {
				JOptionPane.showMessageDialog(null, "璇疯緭鍏ヤ俊鎭啀鐐瑰嚮淇敼锛�");
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
					JOptionPane.showMessageDialog(null, "鏁版嵁搴撲腑宸茬粡瀛樺湪鎮ㄨ淇敼鐨勫鐢熻褰曪紒");
					return;
				}			
				JOptionPane.showMessageDialog(null, "鎭枩鎮紝淇敼鎴愬姛浜嗭紒");
			}
		}
		if (e.getSource() == subMenu2[3] || e.getSource() == toolBarButton[3]) {
			String idid = JOptionPane.showInputDialog("璇疯緭鍏ヨ淇敼鐨勫鐢熷鍙�");
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
						JOptionPane.showMessageDialog(null, "瀵逛笉璧凤紝娌℃湁鎮ㄨ淇敼鐨勫鐢熶俊鎭紒");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birthday);
						idT.setEnabled(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "鎶辨瓑锛岀▼搴忓嚭鐜板紓甯革紒");
				}
			}
		}
		if (e.getSource() == subMenu2[2] || e.getSource() == toolBarButton[2]) {
			String idDel = JOptionPane.showInputDialog("璇疯緭鍏ヨ鍒犻櫎鐨勫鐢熷鍙�");
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
						JOptionPane.showMessageDialog(null, "瀵逛笉璧凤紝娌℃湁鎮ㄨ鍒犻櫎鐨勫鐢熶俊鎭紒");
					else {
						idT.setText(id);
						nameT.setText(name);
						sexT.setText(sex);
						jtaddr.setText(address);
						jtbirth.setText(birthday);
						idT.setEnabled(false);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "鎶辨瓑锛岀▼搴忓嚭鐜板紓甯革紒");
				}
			}
		}
		if (e.getSource() == toolBarButton[6] || e.getSource() == subMenu2[6]) {
			if ((idT.getText().trim()).equals("")
					|| (nameT.getText().trim()).equals("")
					|| (sexT.getText().trim()).equals("")
					|| (jtaddr.getText().trim()).equals("")
					|| (jtbirth.getText().trim()).equals("")) {
				JOptionPane.showMessageDialog(null, "璇风偣鍑诲垹闄よ褰曟寜閽紒");
				return;
			} else {
				id = idT.getText();
				String strSQL = "delete from student where id=?";
				try {
					pst=conn.prepareStatement(strSQL);
					pst.setString(1, id);
					pst.executeUpdate();
				} catch (Exception exx) {
					JOptionPane.showMessageDialog(null, "鍑洪敊浜嗭紒");
					return;
				}
				JOptionPane.showMessageDialog(null, "鍒犻櫎鎴愬姛锛�");
			}
		}
	}
}
