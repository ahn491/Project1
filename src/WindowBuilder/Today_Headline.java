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

public class Today_Headline extends JFrame {

	private JPanel contentPane;

	private MP3Player mp3Player;

	/**
	 * Create the frame.
	 */
	public Today_Headline(String id) { // 오늘의 주요 News
		setTitle("오늘의 주요 뉴스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton play_btn = new JButton(""); // 재생 버튼
		play_btn.setBounds(464, 157, 50, 48);
		
		play_btn.setBorderPainted(false); 
		play_btn.setContentAreaFilled(false); 
		play_btn.setFocusPainted(false);
		play_btn.setIcon(new ImageIcon(Today_Headline.class.getResource("/Image/play.png")));
		
		play_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playNews("D:\\Data_Analysis\\Project1\\newstts\\image\\주요뉴스.mp3");
			}
		});
		
		contentPane.add(play_btn);
		contentPane.setLayout(null);
		
		JButton back_btn = new JButton(""); // 뒤로 가기 버튼
		back_btn.setBounds(546, 0, 40, 48);
		
		back_btn.setBorderPainted(false); // 버튼 테두리 설정
		back_btn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		back_btn.setFocusPainted(false); // 포커스 표시 설정
		
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
		
		back_btn.setIcon(new ImageIcon(Today_Headline.class.getResource("/Image/back.png")));
		contentPane.add(back_btn);
		
		JTextPane main_news_textpane = new JTextPane(); // 주요 뉴스 표시하는 textpane
		main_news_textpane.setEditable(false);
		main_news_textpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		main_news_textpane.setBounds(31, 215, 538, 497);
		main_news_textpane.setText("* 정부, 중소기업 경쟁력 강화를 위한 새로운 지원책 발표 *\r\n\r\n정부는 중소기업의 경쟁력을 강화하고 경제 회복을 지원하기 위해 새로운 지원책을 발표했습니다. 이번 지원책은 세금 감면, 금융 지원, 기술 혁신 지원 등을 포함하고 있습니다.\r\n\r\r\n* 대학생 연구팀, AI 알고리즘 혁신으로 데이터 분석 정확도 대폭 향상 *\r\n\r\n한 대학 연구팀이 AI를 활용한 새로운 알고리즘을 개발하여 데이터 분석의 정확성을 크게 향상시켰습니다. 이 연구는 앞으로 다양한 산업 분야에서 큰 파급 효과를 미칠 것으로 기대됩니다.\r\n\r\r\n* 국제 유가 급등, 경제 전문가 인플레이션 및 경기 둔화 우려 *\r\n\r\n최근 국제 유가가 급등하면서 경제 전문가들은 인플레이션과 경기 둔화에 대한 우려를 표명하고 있습니다. 정부는 이에 대응하기 위해 에너지 정책을 재검토 중입니다.\r\n\r\r\n* 국회, 환경 보호 강화를 위한 새로운 법안 통과 *\r\n\r\n국회는 환경 보호를 강화하기 위한 새로운 법안을 통과시켰습니다. 이 법안은 탄소 배출을 줄이고 재생 에너지 사용을 촉진하기 위한 여러 가지 조치를 포함하고 있습니다.\r\n\r\r\n* 글로벌 IT 기업, 혁신적인 기능의 최신 스마트폰 출시로 소비자 관심 집중 *\r\n\r\n한 글로벌 IT 기업이 최신 스마트폰을 출시했습니다. 이 스마트폰은 혁신적인 기능과 디자인으로 소비자들의 큰 관심을 받고 있으며, 사전 예약 판매가 폭주하고 있습니다.\r\n\r\n\r\r\n");		contentPane.add(main_news_textpane);
		
		JButton stop_btn = new JButton(""); // 뉴스 중지 버튼
		stop_btn.setBounds(519, 157, 50, 48);
		
		stop_btn.setBorderPainted(false); 
		stop_btn.setContentAreaFilled(false); 
		stop_btn.setFocusPainted(false);
		stop_btn.setIcon(new ImageIcon(Today_Headline.class.getResource("/Image/stop.png")));
		
		stop_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop();
			}
		});
		
		contentPane.add(stop_btn);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\" \uC815\uBD80 \uC9C0\uC6D0\uCC45 \uBC1C\uD45C\uBD80\uD130 AI \uD601\uC2E0\uC131\uACFC, \uAD6D\uC81C \uC720\uAC00 \uC0C1\uC2B9\uACFC \r\n  \uD658\uACBD \uBCF4\uD638\uBC95\uC548, \uCD5C\uC2E0 \uC2A4\uB9C8\uD2B8\uD3F0 \uCD9C\uC2DC\uAE4C\uC9C0 \"");
		textPane.setBounds(31, 97, 538, 60);
		contentPane.add(textPane);
		
		JLabel titleimg = new JLabel("New label");
		titleimg.setIcon(new ImageIcon(Today_Headline.class.getResource("/Image/titleimg.png")));
		titleimg.setBounds(12, 10, 117, 77);
		contentPane.add(titleimg);
		
		JLabel date_label = new JLabel("  2024.07.15 \uC624\uC804 9:00");
		date_label.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		date_label.setBounds(31, 157, 170, 30);
		contentPane.add(date_label);
	}
	
    public void stop() { // 뉴스 읽기 중단 Method
    	if(mp3Player != null) {
    		mp3Player.stop();
    	}
    }
    
    public void playNews(String filename) { // 뉴스 재생 Method
		File newsfile = new File(filename);
		
		if(mp3Player != null) {
			mp3Player.stop();
		}
		
		mp3Player = new MP3Player(newsfile);
		mp3Player.play();
    }
}