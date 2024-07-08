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

public class Social_News extends JFrame {
	private JPanel contentPane;
	private MP3Player mp3Player;

	/**
	 * Create the frame.
	 */
	public Social_News(String id) {
		setTitle("사회 뉴스");
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
		
		play_btn.setIcon(new ImageIcon(Social_News.class.getResource("/Image/play.png")));
		play_btn.setBounds(467, 158, 50, 48);
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\사회뉴스.mp3");
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
		
		back_btn.setIcon(new ImageIcon(Social_News.class.getResource("/Image/back.png")));
		back_btn.setBounds(546, 10, 40, 48);
		contentPane.add(back_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시 textpane
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		main_news_textpane.setText("* \uB514\uC9C0\uD138 \uC2DC\uB300\uC758 \uB370\uC774\uD130 \uBCF4\uD638\uC640 \uADDC\uC81C \uAC15\uD654 *\r\n\r\n\uB2E4\uC591\uD55C \uAD6D\uAC00\uB4E4\uC774 \uB514\uC9C0\uD138 \uC2DC\uB300\uC758 \uB3C4\uB798\uB85C \uC778\uD574 \uB370\uC774\uD130 \uBCF4\uD638\uC640 \uAC1C\uC778 \uC815\uBCF4 \uBCF4\uD638\uC5D0 \uB300\uD55C \uBC95\uC801 \uADDC\uC81C\uB97C \uAC15\uD654\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uD2B9\uD788 \uAC1C\uC778\uC815\uBCF4 \uC720\uCD9C \uC0AC\uAC74\uC758 \uC99D\uAC00\uB85C \uC778\uD574 \uB370\uC774\uD130 \uBCF4\uC548\uC744 \uAC15\uD654\uD558\uB294 \uBC95\uC548\uB4E4\uC774 \uB2E4\uC218 \uC81C\uC815\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uB7EC\uD55C \uADDC\uC81C\uB294 \uAE30\uC5C5\uB4E4\uACFC \uAC1C\uC778\uB4E4\uC758 \uB370\uC774\uD130 \uCC98\uB9AC \uBC29\uC2DD\uC744 \uC0C8\uB86D\uAC8C \uC815\uB9BD\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC0AC\uD68C\uC801 \uB2E4\uC591\uC131 \uC99D\uC9C4\uACFC \uD3EC\uC6A9 \uC815\uCC45 \uAC15\uD654 *\r\n\r\n\uC0AC\uD68C\uC801 \uB2E4\uC591\uC131\uC744 \uC99D\uC9C4\uC2DC\uD0A4\uAE30 \uC704\uD55C \uB2E4\uC591\uD55C \uB178\uB825\uC774 \uC774\uB8E8\uC5B4\uC9C0\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC5EC\uC131, \uC18C\uC218 \uBBFC\uC871, \uC131\uC18C\uC218\uC790\uB4E4\uC758 \uAD8C\uB9AC \uBCF4\uD638\uB97C \uC704\uD55C \uC815\uCC45\uB4E4\uC774 \uAC15\uD654\uB418\uACE0 \uC788\uC73C\uBA70, \uC774\uB294 \uC0AC\uD68C\uC758 \uD3EC\uC6A9\uB825\uC744 \uB192\uC774\uB294 \uB370 \uAE30\uC5EC\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uAE00\uB85C\uBC8C \uAE30\uBD80 \uD65C\uB3D9\uACFC \uAD6D\uC81C \uD611\uB825 \uD655\uB300 *\r\n\r\n\uAE00\uB85C\uBC8C \uAE30\uBD80 \uD65C\uB3D9\uC774 \uD655\uB300\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uB2E4\uC591\uD55C \uAD6D\uC81C \uAE30\uAD6C\uC640 \uBE44\uC601\uB9AC \uB2E8\uCCB4\uB4E4\uC774 \uC804 \uC138\uACC4\uC801\uC73C\uB85C \uC790\uC6D0\uC744 \uBAA8\uC544 \uB3C4\uC6C0\uC774 \uD544\uC694\uD55C \uC9C0\uC5ED\uC5D0 \uC9C0\uC6D0\uC744 \uD655\uB300\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uD2B9\uD788 \uAE08\uC735 \uC9C0\uC6D0\uBFD0\uB9CC \uC544\uB2C8\uB77C \uAE30\uC220 \uC9C0\uC6D0 \uBC0F \uC778\uD504\uB77C \uAC1C\uBC1C\uC5D0\uB3C4 \uC911\uC810\uC744 \uB450\uACE0 \uC788\uC2B5\uB2C8\uB2E4\r\n\r\n* \uC778\uACF5\uC9C0\uB2A5\uC758 \uC724\uB9AC\uC801 \uBB38\uC81C\uC640 \uC548\uC804\uC131 \uB17C\uC758 *\r\n\r\n\uC778\uACF5\uC9C0\uB2A5 \uAE30\uC220\uC774 \uBC1C\uC804\uD568\uC5D0 \uB530\uB77C \uC724\uB9AC\uC801 \uBB38\uC81C\uC640 \uC548\uC804 \uBB38\uC81C\uAC00 \uC81C\uAE30\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC778\uACF5\uC9C0\uB2A5\uC758 \uC790\uC728\uC131\uACFC \uD22C\uBA85\uC131\uC744 \uB192\uC774\uAE30 \uC704\uD55C \uB2E4\uC591\uD55C \uB17C\uC758\uAC00 \uC774\uB8E8\uC5B4\uC9C0\uACE0 \uC788\uC73C\uBA70, \uC774\uB294 \uC778\uACF5\uC9C0\uB2A5\uC758 \uBC1C\uC804\uC774 \uC0AC\uD68C\uC640 \uAE30\uC5C5\uC5D0 \uBBF8\uCE58\uB294 \uC601\uD5A5\uC744 \uC2E0\uC911\uD558\uAC8C \uAC80\uD1A0\uD558\uACE0 \uC788\uB294 \uACFC\uC815\uC785\uB2C8\uB2E4.\r\n\r\n* \uC0AC\uD68C \uACBD\uC81C\uC801 \uBD88\uD3C9\uB4F1 \uD574\uC18C\uB97C \uC704\uD55C \uC815\uCC45 \uCD94\uC9C4 *\r\n\r\n\uC0AC\uD68C \uACBD\uC81C\uC801 \uBD88\uD3C9\uB4F1 \uBB38\uC81C \uD574\uACB0\uC744 \uC704\uD55C \uB2E4\uC591\uD55C \uC815\uCC45\uB4E4\uC774 \uCD94\uC9C4\uB418\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC18C\uB4DD \uBD84\uBC30\uC758 \uACF5\uC815\uC131 \uC99D\uC9C4\uC744 \uBAA9\uD45C\uB85C \uD55C \uC815\uCC45\uB4E4\uC774 \uB2E4\uC591\uD55C \uAD6D\uAC00\uB4E4\uC5D0\uC11C \uC2DC\uD589\uB418\uACE0 \uC788\uC73C\uBA70, \uC774\uB294 \uC0AC\uD68C\uC801 \uC548\uC815\uACFC \uACBD\uC81C \uC131\uC7A5\uC758 \uAE30\uBC18\uC744 \uB2E4\uC9C0\uB294 \uB370 \uC911\uC694\uD55C \uC5ED\uD560\uC744 \uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.");
		main_news_textpane.setBounds(22, 216, 530, 515);
		contentPane.add(main_news_textpane);
		
		JButton stop_btn = new JButton(""); // 뉴스 중단 버튼
		stop_btn.setBorderPainted(false); 
		stop_btn.setContentAreaFilled(false); 
		stop_btn.setFocusPainted(false);
		stop_btn.setIcon(new ImageIcon(Social_News.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		stop_btn.setBounds(520, 158, 50, 48);
		contentPane.add(stop_btn);
		
		JLabel titleimg = new JLabel("");
		titleimg.setIcon(new ImageIcon(Social_News.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\" \uB514\uC9C0\uD138 \uADDC\uC81C, \uC0AC\uD68C\uC801 \uB2E4\uC591\uC131, \uAE00\uB85C\uBC8C \uAE30\uBD80, \uC778\uACF5\uC9C0\uB2A5 \uC724\uB9AC, \r\n  \uC0AC\uD68C \uACBD\uC81C\uC801 \uBD88\uD3C9\uB4F1 \uD574\uC18C \"");
		textPane.setBounds(22, 105, 548, 60);
		contentPane.add(textPane);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(22, 165, 170, 30);
		contentPane.add(date_label);
	}
	
    public void stop() { // mp3 파일 중지 Method
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