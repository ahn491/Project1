package WindowBuilder;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class News_Main extends JFrame { // 뉴스 메인 창
	
	private JPanel contentPane;
	private JTextField dateField;  // 오늘 날짜를 표시할 텍스트 필드
	
	Main_Page main = new Main_Page();

	public News_Main(String id) throws ClassNotFoundException, SQLException {
		setTitle("시각장애인을 위한 들리는 뉴스"); // 제목 설정
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	    
		JButton btn_today_main = new JButton("<HTML>정부는 중소기업의 경쟁력을 강화하고 경제 \r\n 회복을 지원하기 위해 새로운 지원책을 발표했습\r\r\n</HTML>"); // 오늘의 주요 뉴스 버튼
	    btn_today_main.setIcon(null);
	    
	    btn_today_main.setBorderPainted(true); // 버튼 테두리 설정
	    btn_today_main.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
	    btn_today_main.setFocusPainted(false); // 포커스 표시 설정
	    
	    btn_today_main.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Today_Headline news1 = new Today_Headline(id);
	    		
	    		dispose(); // 프레임 닫기(창을 닫음)
        		
				setVisible(false); // 창을 안 보이게 함
				
				news1.setVisible(true); // 새 창 띄우기
        	}
	    });
	    
	    btn_today_main.setFont(new Font("굴림", Font.PLAIN, 15));
	    btn_today_main.setBounds(222, 146, 333, 60);
	    contentPane.add(btn_today_main);
	       
	    JLabel title_label = new JLabel("\uC8FC\uC694\uB274\uC2A4 |  \uC81C\uB3C4 & \uC815\uCC45 | \uACBD\uC81C | \uC0AC\uD68C | IT/\uACFC\uD559 | \uC138\uACC4"); // 제목 Label
	    title_label.setBackground(Color.WHITE);
	    
	    title_label.setOpaque(true);
	    
	    title_label.setIcon(null);
	    title_label.setHorizontalAlignment(SwingConstants.CENTER);
	    title_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	    title_label.setForeground(SystemColor.textText);
	    title_label.setBounds(140, 47, 446, 60);
	    contentPane.add(title_label);
	    
	    dateField = new JTextField(); // 오늘 날짜 표시 Field
	    dateField.setBackground(new Color(255, 255, 255));
	    
	    dateField.setEditable(false);
	    dateField.setBorder(BorderFactory.createEmptyBorder());
	    dateField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	    dateField.setBounds(497, 9, 89, 28);
	    contentPane.add(dateField);
	    
	    updateDate(); // 오늘 날짜 표시 Method
		
		// 장애인 관련 뉴스
	    JButton btn_disabled_relative = new JButton("<HTML>장애인 기피 현상 해소를 위한 교육 프로그램 확대 정부는 장애인에 대한 사회적 인식 개선</HTML>");
		
		btn_disabled_relative.setBorderPainted(true); 
		btn_disabled_relative.setContentAreaFilled(false); 
		btn_disabled_relative.setFocusPainted(false); 
		
		btn_disabled_relative.setHorizontalAlignment(SwingConstants.LEFT);
		btn_disabled_relative.setIcon(null);
		btn_disabled_relative.setFont(new Font("굴림", Font.PLAIN, 15));
		
		btn_disabled_relative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disabled_Relative news2 = new Disabled_Relative(id);
				
        		dispose(); // 프레임 닫기(창을 닫음)
				
        		setVisible(false); // 창을 안 보이게 함
				
        		news2.setVisible(true); // 새 창 띄우기
			}
		});
		
		btn_disabled_relative.setBounds(222, 241, 333, 60);
		contentPane.add(btn_disabled_relative);
		
		JButton btn_world = new JButton("<HTML>미국과 중국이 무역 갈등을 해결하기 위해 새로운 협상 라운드를 시작했습니다. 두 나라의 대</HTMI>"); // 세계 뉴스 버튼
		
		btn_world.setBorderPainted(true); 
		btn_world.setContentAreaFilled(false); 
		btn_world.setFocusPainted(false);
		
		btn_world.setHorizontalAlignment(SwingConstants.LEFT);
		btn_world.setIcon(null);
		btn_world.setFont(new Font("굴림", Font.PLAIN, 15));
		
		btn_world.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				World_News news6 = new World_News(id);
				
		        dispose(); // 프레임 닫기(창을 닫음)
				
		        setVisible(false); // 창을 안 보이게 함
						
				news6.setVisible(true); // 새 창 띄우기
			}
		});
		
		btn_world.setBounds(222, 613, 333, 63);
		contentPane.add(btn_world);
		
		JButton btn_economy = new JButton("<HTML>최근 글로벌 경제는 코로나19 팬데믹 이후 회복세를 보이고 있습니다. 다수의 주요 경제 국가</HTML>"); // 경제 뉴스 버튼
		
		btn_economy.setBorderPainted(true); 
		btn_economy.setContentAreaFilled(false); 
		btn_economy.setFocusPainted(false);
		
		btn_economy.setHorizontalAlignment(SwingConstants.LEFT);
		btn_economy.setIcon(null);
		btn_economy.setFont(new Font("굴림", Font.PLAIN, 15));
		
		btn_economy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Economy_News news3 = new Economy_News(id);
				
        		dispose(); // 프레임 닫기(창을 닫음)
				
        		setVisible(false); //창을 안 보이게 함
				
				news3.setVisible(true);  // 새 창 띄우기
			}
		});
	
		btn_economy.setBounds(222, 333, 333, 60);
		contentPane.add(btn_economy);

		JButton btn_social = new JButton("<HTML>다양한 국가들이 디지털 시대의 도래로 인해 데이터 보호와 개인 정보 보호에 대한 법적 규제</HTML>"); // 사회 뉴스 버튼
		
		btn_social.setBorderPainted(true); 
		btn_social.setContentAreaFilled(false); 
		btn_social.setFocusPainted(false);
		
		btn_social.setHorizontalAlignment(SwingConstants.LEFT);
		btn_social.setIcon(null);
		btn_social.setFont(new Font("굴림", Font.PLAIN, 15));
		
		btn_social.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Social_News news4 = new Social_News(id);
				
				dispose();
				
				setVisible(false);
				
				news4.setVisible(true);
			}
		});
		
		btn_social.setBounds(222, 430, 333, 60);
		contentPane.add(btn_social);

		JButton btn_it_science = new JButton("<HTML>양자 컴퓨팅 기술은 점점 더 발전하고 있습니다. 구글, IBM 등 대기업들이 양자 컴퓨터의 성</HTML>"); // IT/과학 뉴스 버튼
		
		btn_it_science.setBorderPainted(true); 
		btn_it_science.setContentAreaFilled(false); 
		btn_it_science.setFocusPainted(false);
		
		btn_it_science.setHorizontalAlignment(SwingConstants.LEFT);
		btn_it_science.setIcon(null);
		btn_it_science.setFont(new Font("굴림", Font.PLAIN, 15));
		
		btn_it_science.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IT_Science_News news5 = new IT_Science_News(id);
				
				dispose();
				
				setVisible(false);
				
				news5.setVisible(true);
			}
		});
		
		btn_it_science.setBounds(222, 524, 333, 60);
		contentPane.add(btn_it_science);
		
		JButton close_btn = new JButton("\uC885\uB8CC");
		
		close_btn.setBorderPainted(false); 
		close_btn.setContentAreaFilled(false); 
		close_btn.setFocusPainted(false);
		close_btn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		close_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.welcome_label.setText(id + "님 환영합니다!");
    			
    			main.str = id;
				
				dispose();
				
				setVisible(false);
				
				main.setVisible(true);
			}
		});
		
		close_btn.setBackground(Color.WHITE);
		close_btn.setBounds(497, 686, 89, 33);
		contentPane.add(close_btn);
		
		JLabel today_main_img = new JLabel("\uC0AC\uC9C4");
		today_main_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/today_main.png")));
		today_main_img.setBackground(SystemColor.info);
		today_main_img.setBounds(35, 146, 175, 60);
		contentPane.add(today_main_img);
		
		JLabel today_main_Label = new JLabel("\uC624\uB298\uC758 \uC8FC\uC694\uB274\uC2A4");
		today_main_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		today_main_Label.setBounds(35, 116, 175, 20);
		contentPane.add(today_main_Label);
		
		JLabel disabled_Label = new JLabel("\uC81C\uB3C4 & \uC815\uCC45");
		disabled_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		disabled_Label.setBounds(35, 216, 175, 20);
		contentPane.add(disabled_Label);
		
		JLabel disabled_img = new JLabel("\uC0AC\uC9C4");
		disabled_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/disabled.jpg")));
		disabled_img.setBackground(SystemColor.info);
		disabled_img.setBounds(35, 241, 175, 60);
		contentPane.add(disabled_img);
		
		JLabel economy_Label = new JLabel("\uACBD\uC81C");
		economy_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		economy_Label.setBounds(35, 311, 175, 20);
		contentPane.add(economy_Label);
		
		JLabel economy_img = new JLabel("\uC0AC\uC9C4");
		economy_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/economy.jpg")));
		economy_img.setBackground(SystemColor.info);
		economy_img.setBounds(35, 333, 175, 60);
		contentPane.add(economy_img);
		
		JLabel social_Label = new JLabel("\uC0AC\uD68C");
		social_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		social_Label.setBounds(35, 403, 175, 20);
		contentPane.add(social_Label);
		
		JLabel social_img = new JLabel("\uC0AC\uC9C4");
		social_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/social.jpg")));
		social_img.setBackground(SystemColor.info);
		social_img.setBounds(35, 430, 175, 60);
		contentPane.add(social_img);
		
		JLabel science_Label = new JLabel("IT/\uACFC\uD559");
		science_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		science_Label.setBounds(35, 500, 175, 20);
		contentPane.add(science_Label);
		
		JLabel science_img = new JLabel("\uC0AC\uC9C4");
		science_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/science.jpg")));
		science_img.setBackground(SystemColor.info);
		science_img.setBounds(35, 524, 175, 60);
		contentPane.add(science_img);
		
		JLabel world_Label = new JLabel("세계");
		world_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		world_Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		world_Label.setBounds(35, 590, 175, 20);
		contentPane.add(world_Label);
		
		JLabel world_img = new JLabel("\uC0AC\uC9C4");
		world_img.setIcon(new ImageIcon(News_Main.class.getResource("/Image/world.jpg")));
		world_img.setBackground(SystemColor.info);
		world_img.setBounds(35, 613, 175, 60);
		contentPane.add(world_img);
		
		JLabel titleimg_Label = new JLabel("");
		titleimg_Label.setIcon(new ImageIcon(News_Main.class.getResource("/Image/titleimg.png")));
		titleimg_Label.setBounds(12, 17, 129, 89);
		contentPane.add(titleimg_Label);
	}
    
    private void updateDate() { // 오늘 날짜를 표시하는 Method
    	SimpleDateFormat date1 = new SimpleDateFormat("yy-MM-dd");
    	
    	Date now = new Date();
    	
    	dateField.setText(date1.format(now));
    }
}