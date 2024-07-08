package WindowBuilder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Disabled_Relative extends JFrame {

	private JPanel contentPane;
	private MP3Player mp3Player;

	/**
	 * Create the frame.
	 */
	public Disabled_Relative(String id) { // 장애인 관련 뉴스
		setTitle("제도 & 정책 뉴스");
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
		
		play_btn.setIcon(new ImageIcon(Disabled_Relative.class.getResource("/Image/play.png")));
		play_btn.setBounds(460, 159, 50, 48);
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\장애관련.mp3");
			}
		});
		
		contentPane.add(play_btn);
		contentPane.setLayout(null);
		
		JButton back_btn = new JButton(""); // 뒤로 가기 버튼
		
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
		
		back_btn.setIcon(new ImageIcon(Disabled_Relative.class.getResource("/Image/back.png")));
		back_btn.setBounds(546, 10, 40, 48);
		contentPane.add(back_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시 textpane
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		main_news_textpane.setText("* \uC7A5\uC560\uC778 \uC778\uC2DD \uAC1C\uC120\uC744 \uC704\uD55C \uAD50\uC721 \uD504\uB85C\uADF8\uB7A8 \uD655\uB300 * \r\n\r\n\uC815\uBD80\uB294 \uC7A5\uC560\uC778\uC5D0 \uB300\uD55C \uC0AC\uD68C\uC801 \uC778\uC2DD \uAC1C\uC120\uC744 \uC704\uD574 \uAD50\uC721 \uD504\uB85C\uADF8\uB7A8\uC744 \uD655\uB300\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uCD5C\uADFC \uC870\uC0AC\uC5D0 \uB530\uB974\uBA74 \uC7A5\uC560\uC778\uC744 \uD5A5\uD55C \uD3B8\uACAC\uACFC \uCC28\uBCC4\uC774 \uC5EC\uC804\uD788 \uC874\uC7AC\uD558\uB294 \uAC83\uC73C\uB85C \uB098\uD0C0\uB0AC\uC2B5\uB2C8\uB2E4. \uC774\uC5D0 \uB530\uB77C \uAD50\uC721\uBD80\uB294 \uD559\uAD50 \uBC0F \uC0AC\uD68C \uB2E8\uCCB4\uB97C \uB300\uC0C1\uC73C\uB85C \uD55C \uC7A5\uC560\uC778 \uC774\uD574\uC640 \uC778\uC2DD \uAC1C\uC120 \uD504\uB85C\uADF8\uB7A8\uC744 \uC9C0\uC6D0\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uB514\uC9C0\uD138 \uC811\uADFC\uC131 \uD5A5\uC0C1 \uC815\uCC45 \uBC1C\uD45C *\r\n\r\n\uC815\uBD80\uB294 \uB514\uC9C0\uD138 \uC2DC\uB300\uC5D0 \uB9DE\uCDB0 \uBAA8\uB4E0 \uC7A5\uC560\uC778\uC774 \uC815\uBCF4\uC640 \uAE30\uC220\uC5D0 \uC27D\uAC8C \uC811\uADFC\uD560 \uC218 \uC788\uB3C4\uB85D \uB514\uC9C0\uD138 \uC811\uADFC\uC131\uC744 \uB192\uC774\uB294 \uC815\uCC45\uC744 \uBC1C\uD45C\uD588\uC2B5\uB2C8\uB2E4. \uC774\uC5D0 \uB530\uB77C \uACF5\uACF5\uAE30\uAD00\uACFC \uAE30\uC5C5\uC740 \uC6F9 \uC0AC\uC774\uD2B8\uC640 \uBAA8\uBC14\uC77C \uC560\uD50C\uB9AC\uCF00\uC774\uC158\uC758 \uC811\uADFC\uC131\uC744 \uAC1C\uC120\uD558\uACE0, \uC7A5\uC560\uC778\uC744 \uC704\uD55C \uBCF4\uC870 \uAE30\uC220 \uB3C4\uC785\uC744 \uCD09\uC9C4\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC7A5\uC560\uC778 \uACE0\uC6A9 \uCD09\uC9C4\uC744 \uC704\uD55C \uC138\uC81C \uD61C\uD0DD \uD655\uB300 *\r\n\r\n\uC815\uBD80\uB294 \uC7A5\uC560\uC778 \uACE0\uC6A9\uB960 \uD5A5\uC0C1\uC744 \uC704\uD574 \uAE30\uC5C5\uC5D0\uAC8C \uC138\uC81C \uD61C\uD0DD\uC744 \uD655\uB300\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4. \uC7A5\uC560\uC778\uC744 \uACE0\uC6A9\uD55C \uAE30\uC5C5\uC740 \uC7A5\uC560\uC778 \uC784\uAE08 \uC9C0\uC6D0, \uC2DC\uC124 \uAC1C\uC120 \uBE44\uC6A9 \uB4F1\uC744 \uC138\uAE08\uC5D0\uC11C \uACF5\uC81C\uBC1B\uC744 \uC218 \uC788\uC73C\uBA70, \uC774\uB294 \uC7A5\uC560\uC778\uC758 \uC0AC\uD68C\uC801 \uACBD\uC81C \uCC38\uC5EC\uB97C \uCD09\uC9C4\uD558\uB294 \uB370 \uAE30\uC5EC\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n* \uC7A5\uC560\uC778 \uC8FC\uAC70 \uD658\uACBD \uAC1C\uC120 \uC815\uBE44 \uC0AC\uC5C5 \uC2DC\uC791 *\r\n\r\n\uC9C0\uBC29 \uC815\uBD80\uB294 \uC7A5\uC560\uC778\uB4E4\uC774 \uCF8C\uC801\uD55C \uC8FC\uAC70 \uD658\uACBD\uC5D0\uC11C \uC0DD\uD65C\uD560 \uC218 \uC788\uB3C4\uB85D \uACF5\uACF5 \uC8FC\uD0DD \uBC0F \uC8FC\uAC70 \uC2DC\uC124\uC758 \uC811\uADFC\uC131\uC744 \uAC1C\uC120\uD558\uB294 \uC815\uBE44 \uC0AC\uC5C5\uC744 \uC2DC\uC791\uD588\uC2B5\uB2C8\uB2E4. \uC774 \uC0AC\uC5C5\uC740 \uC7A5\uC560\uC778\uB4E4\uC758 \uC77C\uC0C1 \uC0DD\uD65C \uD3B8\uC758\uC131\uC744 \uB192\uC774\uACE0, \uC0AC\uD68C\uC801 \uD3EC\uC6A9\uC744 \uC99D\uC9C4\uC2DC\uD0A4\uB294 \uB370 \uAE30\uC5EC\uD560 \uAC83\uC73C\uB85C \uAE30\uB300\uB429\uB2C8\uB2E4.\r\n\r\n* \uC7A5\uC560\uC778 \uAD50\uD1B5 \uD3B8\uC758 \uC99D\uC9C4\uC744 \uC704\uD55C \uC9C0\uC6D0 \uC815\uCC45 \uBC1C\uD45C *\r\n\r\n\uAD50\uD1B5\uBD80\uB294 \uC7A5\uC560\uC778\uB4E4\uC774 \uBCF4\uB2E4 \uC548\uC804\uD558\uACE0 \uD3B8\uB9AC\uD558\uAC8C \uAD50\uD1B5 \uC218\uB2E8\uC744 \uC774\uC6A9\uD560 \uC218 \uC788\uB3C4\uB85D \uC9C0\uC6D0 \uC815\uCC45\uC744 \uBC1C\uD45C\uD588\uC2B5\uB2C8\uB2E4. \uC774\uC5D0 \uB530\uB77C \uB300\uC911 \uAD50\uD1B5 \uC2DC\uC124\uC758 \uC811\uADFC\uC131\uC744 \uAC1C\uC120\uD558\uACE0, \uC7A5\uC560\uC778 \uC804\uC6A9 \uC8FC\uCC28 \uACF5\uAC04\uC744 \uD655\uB300\uD558\uB294 \uB4F1\uC758 \uAE30\uC874 \uC2DC\uC124 \uAC1C\uC120 \uBC0F \uC0C8\uB85C\uC6B4 \uC811\uADFC\uC131 \uAE30\uC900\uC744 \uB9C8\uB828\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.");
		main_news_textpane.setBounds(33, 215, 530, 516);
		contentPane.add(main_news_textpane);
		
		JButton stop_btn = new JButton(""); // 뉴스 읽기 중지 버튼
		
		stop_btn.setBorderPainted(false); 
		stop_btn.setContentAreaFilled(false); 
		stop_btn.setFocusPainted(false);
		
		stop_btn.setIcon(new ImageIcon(Disabled_Relative.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		stop_btn.setBounds(513, 159, 50, 48);
		contentPane.add(stop_btn);
		
		JLabel titleimg = new JLabel("");
		titleimg.setIcon(new ImageIcon(Disabled_Relative.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\" \uC7A5\uC560\uC778 \uC778\uC2DD \uAC1C\uC120\uC5D0\uC11C \uB514\uC9C0\uD138 \uC811\uADFC\uC131, \uACE0\uC6A9 \uCD09\uC9C4, \r\n  \uC8FC\uAC70 \uD658\uACBD, \uAD50\uD1B5 \uD3B8\uC758 \uC99D\uC9C4\uAE4C\uC9C0 \"");
		textPane.setBounds(33, 97, 530, 60);
		contentPane.add(textPane);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(33, 159, 170, 30);
		contentPane.add(date_label);
	}
	
    public void stop() { // 뉴스 중단 Method
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