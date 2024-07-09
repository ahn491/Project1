package WindowBuilder;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import DAO.GameDAO;
import VO.GameVO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Page extends JFrame {

	private JPanel contentPane;
	JLabel welcome_label;
	String str;
	
	/**
	 * Create the frame.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Main_Page() throws ClassNotFoundException, SQLException { // 메인 페이지 화면
		GameDAO dao = new GameDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 780);
		setTitle("Fun & Easy Life");
		setLocationRelativeTo(null);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton news_btn = new JButton(""); // 뉴스 버튼
		news_btn.setBounds(220, 458, 135, 113);
		contentPane.add(news_btn);
		
		news_btn.setBorderPainted(false); // 버튼 테두리 설정
		news_btn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		news_btn.setFocusPainted(false); // 포커스 표시 설정
		
		news_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				String id = str;
				
				setVisible(false);
				
				try {
					new News_Main(id).setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton memo_btn = new JButton(""); // 메모장 버튼
		
		memo_btn.setBorderPainted(false); 
		memo_btn.setContentAreaFilled(false); 
		memo_btn.setFocusPainted(false); 
		
		memo_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 메모장 버튼 클릭 이벤트
				dispose();
				
				String id = str;
				
				setVisible(false);
				
				try {
					new memoMain(id).setVisible(true); // 메모장 표시
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		memo_btn.setBounds(45, 458, 135, 113);
		contentPane.add(memo_btn);
		
		JButton btn_game1 = new JButton(""); // 수학 연산 게임 버튼
		
		btn_game1.setBorderPainted(false); 
		btn_game1.setContentAreaFilled(false); 
		btn_game1.setFocusPainted(false); 
		
		btn_game1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 수학 연산 게임 버튼 클릭 이벤트
				dispose();
				
				String id = str;
				
				setVisible(false);
				
				new NumberStart(id).setVisible(true); // 수학 연산 게임 창 표시
			}
		});
		
		btn_game1.setBounds(55, 589, 135, 113);
		contentPane.add(btn_game1);
		
		JButton btn_game2 = new JButton(""); // Hangman 게임 버튼
		
		btn_game2.setBorderPainted(false); 
		btn_game2.setContentAreaFilled(false); 
		btn_game2.setFocusPainted(false);
		
		btn_game2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // Hangman 게임 버튼 클릭 이벤트
				dispose();
				
				String id = str;
				
				setVisible(false);
				
				try {
					new startpage(id).setVisible(true); // Hangman 게임 시작 페이지 표시
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btn_game2.setBounds(220, 589, 135, 113);
		contentPane.add(btn_game2);
		
		welcome_label = new JLabel(""); // "OO님 환영합니다!" 문구를 표시할 Label 
		welcome_label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		welcome_label.setBounds(428, 10, 122, 24);
		contentPane.add(welcome_label);
		
		JButton btn_chart = new JButton(""); // 게임 점수 합산 버튼
		
		btn_chart.setBorderPainted(false); 
		btn_chart.setContentAreaFilled(false); 
		btn_chart.setFocusPainted(false);
		
		btn_chart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 게임 점수 합산 버튼 클릭
				try {
					ArrayList<GameVO> list = dao.getSumScore(); // 총 점수 합산 결과를 List 형태로 받음
					
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
					for(GameVO game : list) { // 차트에 표시될 값을 저장
						dataset.addValue(game.getSum(), "합산 점수", game.getId()); // 차트 요소 설정(값, 범례, 항목)
					}
					
					PlotOrientation po = PlotOrientation.HORIZONTAL; // 차트 방향(HORIZONTAL : 가로축과 세로축을 그대로 유지, VERTICAL : 가로축과 세로축 변환)
					
					// 차트 생성(3D 막대형 차트 - 제목, 가로축 제목, 세로축 제목, 차트 요소, 차트 방향, ...)
					JFreeChart chart = ChartFactory.createBarChart3D("게임점수 순위", "유저", "점수", dataset, po, true,true,true);
					
					CategoryPlot plot = chart.getCategoryPlot();
					
					chart.getTitle().setFont(new Font("맑은 고딕", Font.BOLD, 15)); // 차트 제목 설정
					
					chart.getLegend().setItemFont(new Font("맑은 고딕", Font.BOLD, 15)); // 차트 범례 설정
					
					plot.getDomainAxis().setLabelFont(new Font("맑은 고딕", Font.BOLD, 15)); // X축 Label 설정
					
					plot.getRangeAxis().setLabelFont(new Font("맑은 고딕", Font.BOLD, 15)); // Y축 Label 설정
					
					chart.setBackgroundPaint(Color.WHITE); // 차트 배경색 지정
					
					ChartFrame cf = new ChartFrame("게임 점수 합산 결과", chart); // Chart Frame 생성 및 Chart Frame에 차트 추가
					
					cf.pack();
					cf.setSize(800, 500);
					cf.setLocationRelativeTo(null);
					cf.setVisible(true); // Chart Frame 표시
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "차트를 생성할 수 없습니다!");
					e1.printStackTrace();
				}
			}
		});
		
		btn_chart.setBounds(390, 594, 135, 108);
		contentPane.add(btn_chart);
		
		JButton caculator_btn = new JButton(); // 계산기 버튼
		
		caculator_btn.setBorderPainted(false); // 버튼 테두리 설정
		caculator_btn.setContentAreaFilled(false); // 버틍 영역 배경 표시 설정
		caculator_btn.setFocusPainted(false); // 포커스 표시 설정
		
		caculator_btn.setBounds(390, 458, 135, 113);
		contentPane.add(caculator_btn);
		caculator_btn.setIcon(null);
		
		caculator_btn.setHorizontalAlignment(SwingConstants.LEFT); // 수평 정렬: 왼쪽
		caculator_btn.setVerticalAlignment(SwingConstants.TOP);
		
		caculator_btn.setBorder(new EmptyBorder(15, 15, 0, 0));
		
		caculator_btn.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main_Page.class.getResource("/Image/main.png")));
		lblNewLabel.setBounds(0, 0, 598, 741);
		contentPane.add(lblNewLabel);
		
		caculator_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 계산기 버튼 클릭 이벤트
				String id = str;
				
				dispose();
				
				setVisible(false);
				try {
					new Calculator(id).setVisible(true); // 계산기 창 표시
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}