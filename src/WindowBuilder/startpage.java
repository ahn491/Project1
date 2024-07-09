package WindowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class startpage extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("");
	Main_Page main = new Main_Page();
	
	/**
	 * Create the frame.
	 */
	public startpage(String id) throws ClassNotFoundException, SQLException {
		
		System.out.println(id);
		
		setTitle("Hangman Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 485);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_mainpage.png")));
		lblNewLabel.setBounds(0, 0, 686, 446);
		contentPane.add(lblNewLabel);
		
		JButton btn_start = new JButton(""); // 게임 시작 버튼
		btn_start.addMouseListener(new MouseAdapter() { // 버튼 클릭 이벤트(게임 창으로 넘어감)
			@Override
			public void mouseClicked(MouseEvent e) {
				gamepage secondwindow;
				
				try {
					secondwindow = new gamepage(id);
					
					dispose();
					
					setVisible(false);
					
					secondwindow.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 안으로 들어오면 발생하는 이벤트(이미지 변경)
				lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_start_mouseenter.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼 밖으로 나가면 발생하는 이벤트(이미지 변경)
				lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_mainpage.png")));
			}
		});
		
		btn_start.setOpaque(false);
		btn_start.setBounds(93, 342, 103, 38);
		contentPane.add(btn_start);
		
		JButton btn_quit = new JButton(""); // 게임 나가기 버튼
		btn_quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.welcome_label.setText(id + "님 환영합니다!");
    			
    			main.str = id;
    			
    			dispose();
    			
    			setVisible(false);
    			
    			main.setVisible(true);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 버튼 안으로 들어오면 발생하는 이벤트(이미지 변경)
				lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_quit_mouseenter.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 버튼 밖으로 나가면 발생하는 이벤트(이미지 변경)
				lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_mainpage.png")));
			}
		});
		
		btn_quit.setOpaque(false);
		btn_quit.setBounds(93, 390, 103, 46);
		contentPane.add(btn_quit);
	}
}