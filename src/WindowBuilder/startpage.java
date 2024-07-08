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

	/**
	 * Create the frame.
	 */
	public startpage(String id) {
		
		System.out.println(id);
		
		setTitle("Hangman Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 485);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			JButton btn_start = new JButton("게임 시작");
			btn_start.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String id1 = id;
					
					gamepage secondwindow;
					
					try {
						secondwindow = new gamepage(id1);
						
						dispose();
						
						setVisible(false);
						
						secondwindow.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			btn_start.setIcon(new ImageIcon(startpage.class.getResource("/Image/start.png")));
			btn_start.setBounds(69, 190, 102, 30);
			contentPane.add(btn_start);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(startpage.class.getResource("/Image/hangman_mainpage.png")));
		lblNewLabel.setBounds(0, 0, 686, 446);
		contentPane.add(lblNewLabel);
	}
}