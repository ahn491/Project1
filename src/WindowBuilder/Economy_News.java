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

public class Economy_News extends JFrame {
	private JPanel contentPane;
	private MP3Player mp3Player;
	
	/**
	 * Create the frame.
	 */
	public Economy_News(String id) { // 경제 뉴스 창
		setTitle("경제 뉴스");
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
		
		play_btn.setIcon(new ImageIcon(Economy_News.class.getResource("/Image/play.png")));
		play_btn.setBounds(462, 158, 50, 48);
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\경제뉴스.mp3");
			}
		});
		
		contentPane.add(play_btn);
		contentPane.setLayout(null);
		
		JButton back_btn = new JButton(""); // 뒤로가기 버튼
		
		back_btn.setBorderPainted(false); 
		back_btn.setContentAreaFilled(false); 
		back_btn.setFocusPainted(false);
		
		back_btn.setIcon(new ImageIcon(Economy_News.class.getResource("/Image/back.png")));
		back_btn.setBounds(546, 10, 40, 48);
		
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
		
		contentPane.add(back_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시 textpane
		main_news_textpane.setEditable(false);
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		main_news_textpane.setText("* \uCF54\uB85C\uB09819 \uC774\uD6C4 \uAE00\uB85C\uBC8C \uACBD\uC81C \uD68C\uBCF5\uC138 *\r\n\r\n\uCD5C\uADFC \uAE00\uB85C\uBC8C \uACBD\uC81C\uB294 \uCF54\uB85C\uB09819 \uD32C\uB370\uBBF9 \uC774\uD6C4 \uD68C\uBCF5\uC138\uB97C \uBCF4\uC774\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uB2E4\uC218\uC758 \uC8FC\uC694 \uACBD\uC81C \uAD6D\uAC00\uB4E4\uC774 \uACBD\uC81C \uD65C\uB3D9\uC744 \uC7AC\uAC1C\uD558\uACE0 \uACBD\uC81C \uC9C0\uD45C\uAC00 \uD68C\uBCF5\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uADF8\uB7EC\uB098 \uC5EC\uC804\uD788 \uC77C\uBD80 \uAD6D\uAC00\uB4E4\uC740 \uC81C\uD55C\uC801\uC778 \uACBD\uC81C \uD65C\uB3D9\uC744 \uC720\uC9C0\uD558\uACE0 \uC788\uC5B4 \uD68C\uBCF5 \uC18D\uB3C4\uC5D0 \uCC28\uC774\uAC00 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC6D0\uC790\uC7AC \uAC00\uACA9 \uC0C1\uC2B9\uC774 \uC0B0\uC5C5\uC5D0 \uBBF8\uCE58\uB294 \uC601\uD5A5 *\r\n\r\n\uAE08\uC18D \uBC0F \uC5D0\uB108\uC9C0 \uC6D0\uC790\uC7AC\uC758 \uAC00\uACA9\uC774 \uC0C1\uC2B9\uD558\uBA74\uC11C \uC5EC\uB7EC \uC0B0\uC5C5 \uBD80\uBB38\uC5D0\uC11C \uC6D0\uAC00 \uC0C1\uC2B9\uC758 \uC555\uBC15\uC744 \uBC1B\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uD2B9\uD788 \uAC74\uC124, \uC790\uB3D9\uCC28 \uC81C\uC870 \uB4F1 \uB300\uADDC\uBAA8 \uC18C\uBE44\uC7AC \uC0B0\uC5C5\uC5D0\uC11C \uC6D0\uC790\uC7AC \uBE44\uC6A9 \uC99D\uAC00\uB85C \uC778\uD55C \uAC00\uACA9 \uC778\uC0C1\uC774 \uC608\uC0C1\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uB514\uC9C0\uD138 \uACBD\uC81C\uC758 \uAC00\uC18D\uD654\uC640 \uC131\uC7A5 *\r\n\r\n\uB514\uC9C0\uD138 \uACBD\uC81C \uC0B0\uC5C5\uC740 \uC804 \uC138\uACC4\uC801\uC73C\uB85C \uC131\uC7A5\uD558\uACE0 \uC788\uC73C\uBA70, \uD074\uB77C\uC6B0\uB4DC \uCEF4\uD4E8\uD305, \uC778\uACF5\uC9C0\uB2A5, \uC0AC\uBB3C\uC778\uD130\uB137 \uB4F1\uC758 \uAE30\uC220 \uBC1C\uC804\uC774 \uB514\uC9C0\uD138 \uBCC0\uD601\uC744 \uAC00\uC18D\uD654\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uC5D0 \uB530\uB77C \uB514\uC9C0\uD138 \uAE30\uC5C5\uB4E4\uC758 \uC218\uC775\uC131\uC774 \uD5A5\uC0C1\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n*. \uC911\uAD6D\uC758 \uACBD\uC81C \uC131\uC7A5\uACFC \uBBF8\uAD6D\uC758 \uC0C8\uB85C\uC6B4 \uD1B5\uC0C1 \uC815\uCC45 *\r\n\r\n\uC911\uAD6D \uACBD\uC81C\uB294 \uC218\uCD9C \uD68C\uBCF5\uACFC \uB0B4\uC218 \uC18C\uBE44 \uC99D\uAC00\uB85C \uC131\uC7A5\uC138\uB97C \uC720\uC9C0\uD558\uACE0 \uC788\uC73C\uBA70, \uBBF8\uAD6D\uC740 \uC0C8\uB85C\uC6B4 \uD1B5\uC0C1 \uC815\uCC45\uC744 \uD1B5\uD574 \uC911\uAD6D\uACFC\uC758 \uBB34\uC5ED \uADE0\uD615\uC744 \uC870\uC815\uD558\uB824\uB294 \uB178\uB825\uC744 \uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uB85C \uC778\uD574 \uAD6D\uC81C \uBB34\uC5ED \uB3D9\uD5A5\uC774 \uBCC0\uB3D9\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC9C0\uC18D \uAC00\uB2A5\uD55C \uC131\uC7A5\uC744 \uC704\uD55C ESG \uD22C\uC790 \uD655\uB300 *\r\n\r\n\uAE30\uC5C5\uB4E4\uC740 \uD658\uACBD, \uC0AC\uD68C, \uC9C0\uBC30\uAD6C\uC870 (ESG) \uCC45\uC784\uC744 \uAC15\uD654\uD558\uB824\uB294 \uB178\uB825\uC744 \uAC00\uC18D\uD654\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. ESG \uD22C\uC790\uB294 \uC9C0\uC18D \uAC00\uB2A5\uD55C \uACBD\uC81C \uC131\uC7A5\uC744 \uC9C0\uC6D0\uD558\uBA70, \uAE30\uC5C5\uC758 \uC0AC\uD68C\uC801 \uCC45\uC784\uC744 \uAC15\uC870\uD558\uB294 \uD22C\uC790 \uD2B8\uB80C\uB4DC\uB85C \uC790\uB9AC \uC7A1\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n");
		main_news_textpane.setBounds(35, 216, 530, 515);
		contentPane.add(main_news_textpane);
		
		JButton stop_btn = new JButton(""); // 뉴스 중지 버튼
		
		stop_btn.setBorderPainted(false); 
		stop_btn.setContentAreaFilled(false); 
		stop_btn.setFocusPainted(false);
		stop_btn.setIcon(new ImageIcon(Economy_News.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		stop_btn.setBounds(515, 158, 50, 48);
		contentPane.add(stop_btn);
		
		JLabel titleimg = new JLabel("");
		titleimg.setIcon(new ImageIcon(Economy_News.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\" \uAE00\uB85C\uBC8C \uACBD\uC81C \uD68C\uBCF5, \uC6D0\uC790\uC7AC \uAC00\uACA9 \uC0C1\uC2B9, \uB514\uC9C0\uD138 \uACBD\uC81C \uC131\uC7A5, \r\n  \uBBF8\uC911 \uD1B5\uC0C1 \uC815\uCC45, ESG \uD22C\uC790 \uD655\uB300 \"");
		textPane.setBounds(35, 97, 530, 60);
		contentPane.add(textPane);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(35, 158, 170, 30);
		contentPane.add(date_label);
	}
	
    public void stop() { // 파일 중지 메소드
    	if(mp3Player != null) {
    		mp3Player.stop();
    	}
    }
    
	// mp3 파일 재생 메소드
    public void playNews(String filename)  {
    	File newsfile = new File(filename);
    		
    	if(mp3Player != null) {
    		mp3Player.stop();
    	}
    		
    	mp3Player = new MP3Player(newsfile);
    	mp3Player.play();
    }
}