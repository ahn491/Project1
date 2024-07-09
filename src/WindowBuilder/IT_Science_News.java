package WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class IT_Science_News extends JFrame {

	private JPanel contentPane;
	private MP3Player mp3Player;

	/**
	 * Create the frame.
	 */
	public IT_Science_News(String id) {
		setTitle("IT/과학 뉴스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton play_btn = new JButton(""); // 재생 버튼
		play_btn.setBorderPainted(false); 
		play_btn.setContentAreaFilled(false); 
		play_btn.setFocusPainted(false);
		
		play_btn.setIcon(new ImageIcon(IT_Science_News.class.getResource("/Image/play.png")));
		play_btn.setBounds(461, 179, 50, 48);
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\it과학뉴스.mp3");
			}
		});
		
		contentPane.add(play_btn);
		contentPane.setLayout(null);
		
		JButton back_btn = new JButton(""); // 뒤로가기 버튼
		back_btn.setBorderPainted(false); 
		back_btn.setContentAreaFilled(false); 
		back_btn.setFocusPainted(false);
		
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				News_Main main;
				
				try {
					main = new News_Main(id);
					
					dispose();
					
					setVisible(false);
					
					main.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		back_btn.setIcon(new ImageIcon(IT_Science_News.class.getResource("/Image/back.png")));
		back_btn.setBounds(546, 10, 40, 48);
		contentPane.add(back_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시 textpane
		main_news_textpane.setEditable(false);
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		main_news_textpane.setText("* \uC591\uC790 \uCEF4\uD4E8\uD305 \uAE30\uC220\uC758 \uBC1C\uC804 \uAC00\uC18D\uD654 *\r\n\r\n\uC591\uC790 \uCEF4\uD4E8\uD305 \uAE30\uC220\uC740 \uC810\uC810 \uB354 \uBC1C\uC804\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uAD6C\uAE00, IBM \uB4F1 \uB300\uAE30\uC5C5\uB4E4\uC774 \uC591\uC790 \uCEF4\uD4E8\uD130\uC758 \uC131\uB2A5\uC744 \uD5A5\uC0C1\uC2DC\uD0A4\uBA70 \uC591\uC790 \uC54C\uACE0\uB9AC\uC998\uC744 \uD65C\uC6A9\uD55C \uB2E4\uC591\uD55C \uC751\uC6A9 \uC0AC\uB840\uB97C \uD0D0\uAD6C\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* 5G \uB124\uD2B8\uC6CC\uD06C \uD655\uC0B0\uC73C\uB85C \uC778\uD55C \uD601\uC2E0\uC801 \uC751\uC6A9 \uC0AC\uB840 *\r\n\r\n5\uC138\uB300(5G) \uC774\uB3D9\uD1B5\uC2E0 \uAE30\uC220\uC758 \uC0C1\uC6A9\uD654\uAC00 \uC9C4\uD589\uB418\uBA70 \uC790\uC728 \uC8FC\uD589\uCC28, \uC6D0\uACA9 \uC758\uB8CC \uC11C\uBE44\uC2A4, \uC0B0\uC5C5 \uC790\uB3D9\uD654 \uB4F1 \uB2E4\uC591\uD55C \uBD84\uC57C\uC5D0\uC11C \uC0C8\uB85C\uC6B4 \uAE30\uC220\uC801 \uAC00\uB2A5\uC131\uC774 \uD655\uC7A5\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uB300\uADDC\uBAA8 \uB370\uC774\uD130 \uC720\uCD9C \uC0AC\uAC74\uACFC \uBCF4\uC548\uC758 \uC911\uC694\uC131 *\r\n\r\n\uCD5C\uADFC \uB300\uAE30\uC5C5\uACFC \uC815\uBD80 \uAE30\uAD00\uC5D0\uC11C \uB300\uADDC\uBAA8 \uB370\uC774\uD130 \uC720\uCD9C \uC0AC\uAC74\uC774 \uBC1C\uC0DD\uD558\uBA70 \uB370\uC774\uD130 \uBCF4\uC548\uC758 \uC911\uC694\uC131\uC774 \uD55C\uCE35 \uBD80\uAC01\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uB85C \uC778\uD574 \uB370\uC774\uD130 \uBCF4\uD638 \uBC0F \uAD00\uB9AC \uAE30\uC220\uC5D0 \uB300\uD55C \uD544\uC694\uC131\uC774 \uC99D\uAC00\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC0AC\uC774\uBC84 \uBCF4\uC548\uC758 \uC0C8\uB85C\uC6B4 \uB3C4\uC804\uACFC \uB300\uC751 \uC804\uB7B5*\r\n\r\n\uB79C\uC12C\uC6E8\uC5B4 \uACF5\uACA9\uC774 \uC758\uB8CC \uAE30\uAD00, \uAE08\uC735 \uAE30\uAD00 \uB4F1\uC5D0 \uD0C0\uAC9F\uC744 \uB9DE\uCD94\uBA70 \uC0C8\uB85C\uC6B4 \uD615\uD0DC\uB85C \uBC1C\uC804\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uC5D0 \uB530\uB77C \uC0AC\uC774\uBC84 \uBCF4\uC548 \uC804\uBB38\uAC00\uB4E4\uC740 \uC2E0\uC18D\uD55C \uB300\uC751\uACFC \uC608\uBC29 \uC870\uCE58\uAC00 \uD544\uC218\uC801\uC784\uC744 \uC778\uC2DD\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC2E0\uC81C\uD488 \uCD9C\uC2DC\uC640 IT \uAE30\uC220 \uD601\uC2E0\uC758 \uBB3C\uACB0 *\r\n\r\n\uB2E4\uC218\uC758 IT \uAE30\uC5C5\uB4E4\uC774 \uC778\uACF5\uC9C0\uB2A5(AI), \uD074\uB77C\uC6B0\uB4DC \uCEF4\uD4E8\uD305, \uC0AC\uBB3C\uC778\uD130\uB137(IoT) \uB4F1 \uB2E4\uC591\uD55C \uAE30\uC220 \uBD84\uC57C\uC5D0\uC11C \uC0C8\uB85C\uC6B4 \uC81C\uD488\uACFC \uC11C\uBE44\uC2A4\uB97C \uCD9C\uC2DC\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uB97C \uD1B5\uD574 \uC2DC\uC7A5 \uC810\uC720\uC728\uC744 \uD655\uB300\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.");
		main_news_textpane.setBounds(34, 237, 530, 443);
		contentPane.add(main_news_textpane);
		
		JButton stop_btn = new JButton(""); // 뉴스 중지 버튼
		stop_btn.setBorderPainted(false);
		stop_btn.setContentAreaFilled(false);
		stop_btn.setFocusPainted(false);
		stop_btn.setIcon(new ImageIcon(IT_Science_News.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		stop_btn.setBounds(514, 179, 50, 48);
		contentPane.add(stop_btn);
		
		JLabel titleimg = new JLabel("");
		titleimg.setIcon(new ImageIcon(IT_Science_News.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\" \uCD5C\uC2E0 \uAE30\uC220 \uB3D9\uD5A5: \uC591\uC790 \uCEF4\uD4E8\uD305, 5G \uB124\uD2B8\uC6CC\uD06C, \r\n  \uB370\uC774\uD130 \uBCF4\uC548, \uC0AC\uC774\uBC84 \uBCF4\uC548, IT \uD601\uC2E0 \"");
		textPane.setBounds(34, 109, 530, 60);
		contentPane.add(textPane);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(34, 174, 170, 30);
		contentPane.add(date_label);
	}
	
	// mp3 파일 재생 메소드
    public void playNews(String filename) {
    	File newsfile = new File(filename);
    		
    	if(mp3Player != null) {
    		mp3Player.stop();
    	}
    		
   		mp3Player = new MP3Player(newsfile);
   		mp3Player.play();
    }
	
    // mp3 파일 중단 Method
    public void stop() {
    	if(mp3Player != null) {
    		mp3Player.stop();
    	}
    }
}