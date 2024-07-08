package WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField id_textField;
	private JPasswordField pw_passwordField;
	private JTextField name_textField;
	private JTextField age_textField;
	private JTextField tel_textField;
	private JTextField addr_textField;
	
	Login login = new Login();

	/**
	 * Create the frame.
	 */
	public Register() throws ClassNotFoundException, SQLException { // 회원가입 화면
		MemberDAO dao = new MemberDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setTitle("회원가입");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252, 247, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		addr_textField = new JTextField(); // 주소 입력 TextField
		addr_textField.setBorder(BorderFactory.createEmptyBorder());
		addr_textField.setFont(new Font("굴림", Font.BOLD, 20));
		addr_textField.setColumns(10);
		addr_textField.setBounds(142, 530, 236, 33);
		contentPane.add(addr_textField);
		
		tel_textField = new JTextField(); // 전화번호 입력 TextField
		tel_textField.setBorder(BorderFactory.createEmptyBorder());
		tel_textField.setFont(new Font("굴림", Font.BOLD, 20));
		tel_textField.setColumns(10);
		tel_textField.setBounds(142, 479, 236, 33);
		contentPane.add(tel_textField);
		
		JComboBox gender_comboBox = new JComboBox(); // 성별 선택 ComboBox
		gender_comboBox.setBorder(null);
		gender_comboBox.setFont(new Font("굴림", Font.BOLD, 20));
		gender_comboBox.setBounds(142, 428, 236, 33);
		gender_comboBox.setBackground(new Color(255, 255, 255));
		gender_comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "W"}));
		contentPane.add(gender_comboBox);
		
		age_textField = new JTextField(); // 나이 입력 TextField
		age_textField.setBorder(BorderFactory.createEmptyBorder());
		age_textField.setFont(new Font("굴림", Font.BOLD, 20));
		age_textField.setColumns(10);
		age_textField.setBounds(142, 377, 236, 33);
		contentPane.add(age_textField);
		
		name_textField = new JTextField(); // 이름 입력 TextField
		name_textField.setBorder(BorderFactory.createEmptyBorder());
		name_textField.setFont(new Font("굴림", Font.BOLD, 20));
		name_textField.setColumns(10);
		name_textField.setBounds(142, 326, 236, 41);
		contentPane.add(name_textField);
		
		pw_passwordField = new JPasswordField(); // 비밀번호 입력 Field(비밀번호를 보이지 않도록 하기 위해 PasswordField를 사용)
		pw_passwordField.setBorder(BorderFactory.createEmptyBorder());
		pw_passwordField.setFont(new Font("굴림", Font.BOLD, 20));
		pw_passwordField.setBounds(142, 244, 209, 41);
		contentPane.add(pw_passwordField);
		
		JButton btn_close = new JButton(""); // 취소 버튼
		
		btn_close.setBorderPainted(false); 
		btn_close.setContentAreaFilled(false); 
		btn_close.setFocusPainted(false);
		
		btn_close.setBounds(311, 624, 126, 41);
		contentPane.add(btn_close);
		
		JButton btn_register = new JButton(""); // 회원가입 버튼
		
		btn_register.setBorderPainted(false); 
		btn_register.setContentAreaFilled(false); 
		btn_register.setFocusPainted(false);
		
		btn_register.setBounds(155, 624, 126, 41);
		contentPane.add(btn_register);
		
		id_textField = new JTextField();
		id_textField.setBorder(BorderFactory.createEmptyBorder());
		id_textField.setFont(new Font("굴림", Font.BOLD, 20));
		id_textField.setBounds(142, 193, 236, 41);
		contentPane.add(id_textField);
		id_textField.setColumns(10);
		btn_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 회원가입 버튼 클릭 이벤트
				String id = id_textField.getText();
				String pw = new String(pw_passwordField.getPassword());
				String name = name_textField.getText();
				String age = age_textField.getText();
				String gender = gender_comboBox.getSelectedItem().toString();
				String tel = tel_textField.getText();
				String address = addr_textField.getText();
				
				// 각 필드 빈 값 체크
				if(id.isEmpty())
					JOptionPane.showMessageDialog(null, "ID는 필수 입력 항목입니다!");
				
				else if(pw.isEmpty())
					JOptionPane.showMessageDialog(null, "비밀번호는 필수 입력 항목입니다!");
				
				else if(name.isEmpty())
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요!");
				
				else if(age.isEmpty())
					JOptionPane.showMessageDialog(null, "나이를 입력해주세요!");
				
				else if(gender.isEmpty())
					JOptionPane.showMessageDialog(null, "성별을 선택해주세요!");
				
				else if(tel.isEmpty())
					JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요!");
				
				else if(address.isEmpty())
					JOptionPane.showMessageDialog(null, "주소를 입력해주세요!");
				
				else {
					if(dao.register(id, pw, name, age, gender, tel, address)) { // INSERT 구문 실행 한 결과 반환
						JOptionPane.showMessageDialog(null, "회원 가입을 축하드립니다!");
						
						dispose();
						
						setVisible(false);
						
						login.setVisible(true); // 로그인 창으로 이동
					} else {
						JOptionPane.showMessageDialog(null, "회원 가입에 실패하셨습니다!");
					}
				}
			}
		});
		btn_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 취소 버튼 클릭 이벤트
				dispose();
				
				setVisible(false);
				
				login.setVisible(true); // 로그인 창으로 이동
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Register1.png"));
		lblNewLabel_1.setBounds(0, 0, 598, 741);
		contentPane.add(lblNewLabel_1);
	}
}