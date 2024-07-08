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

public class World_News extends JFrame {
	private JPanel contentPane;
	private MP3Player mp3Player;

	/**
	 * Create the frame.
	 */
	public World_News(String id) {
		setTitle("세계 뉴스");
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
		
		play_btn.setIcon(new ImageIcon(World_News.class.getResource("/Image/play.png")));
		play_btn.setBounds(468, 152, 50, 48);
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\세계뉴스.mp3");
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
		
		back_btn.setIcon(new ImageIcon(World_News.class.getResource("/Image/back.png")));
		back_btn.setBounds(546, 10, 40, 48);
		contentPane.add(back_btn);
		
		JButton stop_btn = new JButton(""); // 뉴스 중지 버튼
		stop_btn.setBorderPainted(false); 
		stop_btn.setContentAreaFilled(false); 
		stop_btn.setFocusPainted(false);
		stop_btn.setIcon(new ImageIcon(World_News.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		stop_btn.setBounds(518, 152, 50, 48);
		contentPane.add(stop_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시 textpane
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		main_news_textpane.setText("* \uBBF8\uAD6D-\uC911\uAD6D \uBB34\uC5ED \uD611\uC0C1 \uC7AC\uAC1C: \uAD00\uC138 \uC644\uD654 \uAE30\uB300 *\r\n\r\n\uBBF8\uAD6D\uACFC \uC911\uAD6D\uC774 \uBB34\uC5ED \uAC08\uB4F1\uC744 \uD574\uACB0\uD558\uAE30 \uC704\uD574 \uC0C8\uB85C\uC6B4 \uD611\uC0C1 \uB77C\uC6B4\uB4DC\uB97C \uC2DC\uC791\uD588\uC2B5\uB2C8\uB2E4. \uB450 \uB098\uB77C\uC758 \uB300\uD45C\uB2E8\uC740 \uC8FC\uC694 \uC7C1\uC810\uB4E4\uC5D0 \uB300\uD574 \uB17C\uC758\uD558\uBA70, \uC11C\uB85C\uC758 \uAD00\uC138 \uC815\uCC45\uC744 \uC644\uD654\uD560 \uAC00\uB2A5\uC131\uC744 \uAC80\uD1A0\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uBC88 \uD611\uC0C1\uC774 \uC131\uACF5\uC801\uC73C\uB85C \uB9C8\uBB34\uB9AC\uB41C\uB2E4\uBA74 \uAE00\uB85C\uBC8C \uACBD\uC81C\uC5D0 \uAE0D\uC815\uC801\uC778 \uC601\uD5A5\uC744 \uBBF8\uCE60 \uAC83\uC73C\uB85C \uAE30\uB300\uB429\uB2C8\uB2E4.\r\n\r\n* EU, \uAE30\uD6C4 \uBCC0\uD654 \uB300\uC751\uC744 \uC704\uD55C \uC0C8\uB85C\uC6B4 \uBC95\uC548 \uD1B5\uACFC *\r\n\r\n\uC720\uB7FD \uC5F0\uD569(EU)\uC774 \uAE30\uD6C4 \uBCC0\uD654\uC5D0 \uB300\uC751\uD558\uAE30 \uC704\uD55C \uC57C\uC2EC\uCC2C \uBC95\uC548\uC744 \uD1B5\uACFC\uC2DC\uCF30\uC2B5\uB2C8\uB2E4. \uC774 \uBC95\uC548\uC740 2030\uB144\uAE4C\uC9C0 \uD0C4\uC18C \uBC30\uCD9C\uB7C9\uC744 55% \uAC10\uCD95\uD558\uACE0, 2050\uB144\uAE4C\uC9C0 \uD0C4\uC18C \uC911\uB9BD\uC744 \uB2EC\uC131\uD558\uB294 \uAC83\uC744 \uBAA9\uD45C\uB85C \uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uB97C \uC704\uD574 \uC7AC\uC0DD \uAC00\uB2A5 \uC5D0\uB108\uC9C0 \uC0AC\uC6A9\uC744 \uD655\uB300\uD558\uACE0, \uD654\uC11D \uC5F0\uB8CC\uC5D0 \uB300\uD55C \uC758\uC874\uB3C4\uB97C \uC904\uC774\uAE30 \uC704\uD55C \uB2E4\uC591\uD55C \uC815\uCC45\uC774 \uD3EC\uD568\uB418\uC5B4 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC77C\uBCF8\uC758 \uC0C8\uB85C\uC6B4 \uCD1D\uB9AC: \uACBD\uC81C \uD68C\uBCF5\uACFC \uC678\uAD50 \uAC15\uD654 *\r\n\r\n\uC77C\uBCF8\uC5D0\uC11C \uC0C8\uB85C\uC6B4 \uCD1D\uB9AC\uAC00 \uC120\uCD9C\uB418\uC5C8\uC2B5\uB2C8\uB2E4. \uC2E0\uC784 \uCD1D\uB9AC\uB294 \uACBD\uC81C \uD68C\uBCF5\uACFC \uAD6D\uC81C \uAD00\uACC4 \uAC15\uD654, \uD2B9\uD788 \uD55C\uAD6D \uBC0F \uC911\uAD6D\uACFC\uC758 \uAD00\uACC4 \uAC1C\uC120\uC5D0 \uC8FC\uB825\uD560 \uAC83\uC774\uB77C\uACE0 \uBC1D\uD614\uC2B5\uB2C8\uB2E4. \uC774\uBC88 \uC120\uCD9C\uB85C \uC77C\uBCF8\uC758 \uC815\uCE58\uC801 \uBC29\uD5A5\uC131\uC774 \uC0C8\uB86D\uAC8C \uC124\uC815\uB420 \uAC83\uC73C\uB85C \uBCF4\uC785\uB2C8\uB2E4.\r\n\r\n* \uC544\uD504\uB9AC\uCE74 \uC5F0\uD569, \uC9C0\uC5ED \uBD84\uC7C1 \uD574\uACB0\uC744 \uC704\uD55C \uD2B9\uBCC4 \uD68C\uC758 \uAC1C\uCD5C *\r\n\r\n\uC544\uD504\uB9AC\uCE74 \uC5F0\uD569(AU)\uC774 \uC9C0\uC5ED \uB0B4 \uAC08\uB4F1\uC744 \uD574\uACB0\uD558\uAE30 \uC704\uD574 \uD2B9\uBCC4 \uD68C\uC758\uB97C \uAC1C\uCD5C\uD588\uC2B5\uB2C8\uB2E4. \uC774 \uD68C\uC758\uC5D0\uC11C\uB294 \uC5D0\uD2F0\uC624\uD53C\uC544, \uC218\uB2E8, \uB098\uC774\uC9C0\uB9AC\uC544 \uB4F1 \uC5EC\uB7EC \uAD6D\uAC00\uC5D0\uC11C \uBC1C\uC0DD\uD558\uB294 \uBD84\uC7C1\uC744 \uD574\uACB0\uD558\uAE30 \uC704\uD55C \uBC29\uC548\uB4E4\uC774 \uB17C\uC758\uB418\uC5C8\uC2B5\uB2C8\uB2E4. \uC544\uD504\uB9AC\uCE74 \uC5F0\uD569\uC740 \uD3C9\uD654 \uC720\uC9C0 \uBC0F \uC778\uB3C4\uC801 \uC9C0\uC6D0\uC744 \uAC15\uD654\uD558\uAE30 \uC704\uD55C \uC0C8\uB85C\uC6B4 \uC804\uB7B5\uC744 \uCC44\uD0DD\uD588\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uBE0C\uB77C\uC9C8, \uC544\uB9C8\uC874 \uBCF4\uD638 \uC704\uD55C \uAC15\uB825\uD55C \uADDC\uC81C \uB3C4\uC785 *\r\n\r\n\uBE0C\uB77C\uC9C8 \uC815\uBD80\uAC00 \uC544\uB9C8\uC874 \uC5F4\uB300\uC6B0\uB9BC \uBCF4\uD638\uB97C \uC704\uD574 \uC0C8\uB85C\uC6B4 \uADDC\uC81C\uB97C \uB3C4\uC785\uD588\uC2B5\uB2C8\uB2E4. \uC774\uBC88 \uC870\uCE58\uC5D0\uB294 \uBD88\uBC95 \uBC8C\uBAA9\uACFC \uC0B0\uBD88 \uBC29\uC9C0\uB97C \uC704\uD55C \uAC15\uB825\uD55C \uBC95\uC801 \uC870\uCE58\uC640 \uD568\uAED8, \uD604\uC9C0 \uC6D0\uC8FC\uBBFC\uC758 \uAD8C\uB9AC\uB97C \uBCF4\uD638\uD558\uB294 \uB0B4\uC6A9\uC774 \uD3EC\uD568\uB418\uC5B4 \uC788\uC2B5\uB2C8\uB2E4. \uAD6D\uC81C \uC0AC\uD68C\uB294 \uBE0C\uB77C\uC9C8\uC758 \uC774\uBC88 \uACB0\uC815\uC744 \uD658\uC601\uD558\uBA70, \uC9C0\uAD6C \uC0DD\uD0DC\uACC4 \uBCF4\uD638\uC5D0 \uC911\uC694\uD55C \uC9C4\uC804\uC774\uB77C\uACE0 \uD3C9\uAC00\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.");
		main_news_textpane.setBounds(38, 192, 530, 539);
		contentPane.add(main_news_textpane);
		
		JLabel titleimg = new JLabel("");
		titleimg.setIcon(new ImageIcon(World_News.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\" \uAE00\uB85C\uBC8C \uC8FC\uC694 \uC774\uC288: \uBB34\uC5ED \uD611\uC0C1, \uAE30\uD6C4 \uBCC0\uD654, \uC815\uCE58 \uBCC0\uD654, \r\n  \uC9C0\uC5ED \uBD84\uC7C1, \uD658\uACBD \uBCF4\uD638 \"");
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setBounds(38, 97, 530, 60);
		contentPane.add(textPane);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(38, 152, 170, 30);
		contentPane.add(date_label);
	}
	
    public void stop() { // mp3 파일 중단 Method
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