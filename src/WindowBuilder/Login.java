package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;

	Main_Page main;
	private JPasswordField pwField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() throws ClassNotFoundException, SQLException { // 로그인 화면
		MemberDAO dao = new MemberDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setTitle("로그인");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(252, 247, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		IDtextField = new JTextField(); // ID 입력 Field
		IDtextField.setBounds(165, 444, 222, 34);
		IDtextField.setColumns(10);
		IDtextField.setBorder(BorderFactory.createEmptyBorder()); // 테두리 x
		contentPane.add(IDtextField);
		
		JButton LoginButton = new JButton(""); // 로그인 버튼
		
		LoginButton.setBorderPainted(false); 
		LoginButton.setContentAreaFilled(false); 
		LoginButton.setFocusPainted(false); 
		
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 버튼 클릭 이벤트
				String id = IDtextField.getText();
				String pw = new String(pwField.getPassword());
				
				if(id.isEmpty()) { // ID TextField 빈 값 Check
					JOptionPane.showMessageDialog(null, "ID를 입력해주세요!"); // 빈 값일 경우 Message 표시 창 생성
					
					setVisible(true);
				} else if(pw.isEmpty()) { // PW PasswordField 빈 값 check
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요!"); // 빈 값일 경우 Message 표시 창 생성
					
					setVisible(true);
				} else {
					try {
						if(id.equals(dao.login(id, pw))) { // DB에서 가져온 ID 값과 입력한 ID 값이 일치하는지 확인
							JOptionPane.showMessageDialog(null, "로그인 성공!");
							
							dispose();
								
							setVisible(false);
							
							main = new Main_Page();
							main.setVisible(true); // 메인 페이지 표시
							main.welcome_label.setText(id + "님 환영합니다!");	
							main.str = id;
						} else {
							JOptionPane.showMessageDialog(null, "로그인 실패!");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "로그인 오류!");
					}
				}
			}
		});
		
		LoginButton.setBackground(SystemColor.activeCaption);
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setFont(new Font("Arial", Font.BOLD, 20));
		LoginButton.setBounds(197, 568, 156, 43);
		contentPane.add(LoginButton);
		
		JButton MemButton = new JButton(""); // 회원가입 버튼
		MemButton.setBorderPainted(false); 
		MemButton.setContentAreaFilled(false); 
		MemButton.setFocusPainted(false); 
		
		MemButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 버튼 클릭 이벤트
				dispose();
				
				setVisible(false);
				try {
					new Register().setVisible(true); // 회원가입 창 표시
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		MemButton.setBackground(SystemColor.activeCaption);
		MemButton.setFont(new Font("Arial", Font.BOLD, 20));
		MemButton.setForeground(Color.WHITE);
		MemButton.setBounds(323, 626, 156, 43);
		contentPane.add(MemButton);
		
		pwField = new JPasswordField(); // Password 입력 Field
		pwField.setBorder(BorderFactory.createEmptyBorder());
		pwField.setBounds(165, 505, 222, 34);
		contentPane.add(pwField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Image/login1.png")));
		lblNewLabel.setBounds(0, 0, 598, 741);
		contentPane.add(lblNewLabel);
	}
}