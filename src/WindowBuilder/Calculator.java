package WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class Calculator extends JFrame {
	private JPanel contentPane;
	private String func = "더하기";  // 기본 연산을 더하기로 초기화
	private double firstNumber; // 연산의 첫번째 숫자를 저장할 변수
	private JTextField textField;
	private MP3Player mp3Player;
	String resultnum;
	
	Main_Page main = new Main_Page();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Calculator(String id) throws ClassNotFoundException, SQLException { // 계산기 창
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 556);
		setLocationRelativeTo(null);
		
		main = new Main_Page();
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 화면에 결과값 표시되는 라벨 		
		JTextField answer = new JTextField("0"); // 결과를 표시할 라벨 생성(초깃값은 0)
		answer.setBackground(new Color(230, 230, 244));
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setFont(new Font("굴림", Font.PLAIN, 50));
		answer.setBounds(11, 71, 337, 81);
		answer.setEditable(false);
		answer.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(answer);
	
		// % 버튼		
		JButton percent_btn = new JButton("%");
		percent_btn.setBackground(new Color(236, 236, 236));		
		percent_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\percent.mp3");
				
				String curr = answer.getText();
				
				firstNumber = Integer.parseInt(curr);
				
				answer.setText("0");
				
				func = "나머지 구하기";
			}
		});

		percent_btn.setBounds(11, 164, 80, 63);
		percent_btn.setBorderPainted(false);
		percent_btn.setFocusPainted(false);
		
		contentPane.add(percent_btn);
	
		// CE 버튼		
		JButton btnCE = new JButton("CE");
		btnCE.setBackground(new Color(236, 236, 236));
		btnCE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // CE버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\지우기.mp3"); // 지우기.mp3 파일 재생
				
				answer.setText("0"); // 결과 초기화
				
		        firstNumber = 0; // firstNumber 초기화
			}
		});
		
		btnCE.setBounds(97, 164, 80, 63);
		btnCE.setBorderPainted(false);
		btnCE.setFocusPainted(false);
		contentPane.add(btnCE);
		
		// C버튼		
		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(236, 236, 236));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // C버튼 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\C.mp3"); // C.mp3 파일 재생
				
				String erase1 = answer.getText();
				int erase2 = Integer.parseInt(erase1);
				int erase3 = erase2 / 10;
				String erase4 = Integer.toString(erase3);
				
				answer.setText(erase4);
			}
		});
		btnC.setBounds(183, 164, 80, 63);
		btnC.setBorderPainted(false);
		btnC.setFocusPainted(false);
		contentPane.add(btnC);

		// OFF 버튼		
		JButton btnDelete = new JButton("OFF");
		btnDelete.setBackground(new Color(236, 236, 236));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // OFF 버튼 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\초기화면으로돌아갑니다.mp3");
				
				try {
					Thread.sleep(2000); // 버튼 클릭 후 2초 뒤에 창이 닫힘
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				main.welcome_label.setText(id + "님 환영합니다!");
                
                main.str = id;
				
				dispose();
				
				setVisible(false);
				
				main.setVisible(true);
			}
		});
		

		btnDelete.addActionListener(new NumberActionListener(answer,"9"));
		btnDelete.setBounds(183, 440, 80, 63);
		btnDelete.setBorderPainted(false);
		btnDelete.setFocusPainted(false);
		contentPane.add(btnDelete);	

		// 나누기 버튼			
		JButton btn_divide = new JButton("/");
		btn_divide.setBackground(new Color(236, 236, 236));
		btn_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 나누기 버튼 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\나누기.mp3");
				
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr); //curr 최신값을 넘버값으로 변경
				
				answer.setText("0");
				
				func = "나누기";
			}
		});
		
		btn_divide.setBounds(269, 233, 80, 63);
		btn_divide.setBorderPainted(false);
		btn_divide.setFocusPainted(false);
		contentPane.add(btn_divide);	
		
		// 9 버튼			
		JButton btn9 = new JButton("");
		btn9.setBackground(new Color(236, 236, 236));
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 9 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\9.mp3");
			}
		});
		
		btn9.setIcon(new ImageIcon(Calculator.class.getResource("/Image/9.png")));
		btn9.addActionListener(new NumberActionListener(answer,"9"));
		btn9.setBounds(183, 233, 80, 63);
		btn9.setBorderPainted(false);
		btn9.setFocusPainted(false);
		contentPane.add(btn9);
		
		// 8 버튼			
		JButton btn8 = new JButton("");
		btn8.setBackground(new Color(236, 236, 236));
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 8 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\8.mp3");
			}
		});
		
		btn8.setIcon(new ImageIcon(Calculator.class.getResource("/Image/8.png")));
		btn8.addActionListener(new NumberActionListener(answer,"8"));
		btn8.setBounds(97, 233, 80, 63);
		btn8.setBorderPainted(false);
		btn8.setFocusPainted(false);
		contentPane.add(btn8);	
		contentPane.add(btn8);
		
		// 7 버튼			
		JButton btn7 = new JButton("");
		btn7.setBackground(new Color(236, 236, 236));
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 7 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\7.mp3");
			}
		});
		
		btn7.setIcon(new ImageIcon(Calculator.class.getResource("/Image/7.png")));
		btn7.addActionListener(new NumberActionListener(answer,"7"));
		btn7.setBounds(11, 233, 80, 63);
		btn7.setBorderPainted(false);
		btn7.setFocusPainted(false);
		contentPane.add(btn7);	
		
		// X 버튼			
		JButton btnX = new JButton("X");
		btnX.setBackground(new Color(236, 236, 236));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // X 버튼 이벤트
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr); //curr 최신값을 넘버값으로 변경
				
				answer.setText("0");
				
				func = "곱하기";
				
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\X.mp3");
			}
		});
		
		btnX.setBounds(269, 302, 80, 63);
		btnX.setBorderPainted(false);
		btnX.setFocusPainted(false);
		contentPane.add(btnX);	
		
		// 6 버튼			
		JButton btn6 = new JButton("");
		btn6.setBackground(new Color(236, 236, 236));
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 6 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\6.mp3");
			}
		});
		
		btn6.setIcon(new ImageIcon(Calculator.class.getResource("/Image/6.png")));
		btn6.addActionListener(new NumberActionListener(answer,"6"));
		btn6.setBounds(183, 302, 80, 63);
		btn6.setBorderPainted(false);
		btn6.setFocusPainted(false);
		contentPane.add(btn6);
		
		// 5 버튼		
		JButton btn5 = new JButton("");
		btn5.setBackground(new Color(236, 236, 236));
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 5 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\5.mp3");
			}
		});
		
		btn5.setIcon(new ImageIcon(Calculator.class.getResource("/Image/5.png")));
		btn5.addActionListener(new NumberActionListener(answer,"5"));
		btn5.setBounds(97, 302, 80, 63);
		btn5.setBorderPainted(false);
		btn5.setFocusPainted(false);
		contentPane.add(btn5);
		
		// 4 버튼			
		JButton btn4 = new JButton("");
		btn4.setBackground(new Color(236, 236, 236));
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 4 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\4.mp3");
			}
		});
		
		btn4.setIcon(new ImageIcon(Calculator.class.getResource("/Image/4.png")));
		btn4.addActionListener(new NumberActionListener(answer,"4"));
		btn4.setBounds(11, 302, 80, 63);
		btn4.setBorderPainted(false);
		btn4.setFocusPainted(false);
		contentPane.add(btn4);
		
		// + 버튼			
		JButton btnPlus = new JButton("+");
		btnPlus.setBackground(new Color(236, 236, 236));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // + 버튼 이벤트
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr); //curr 최신값을 넘버값으로 변경
				answer.setText("0");
				func = "더하기";
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\+.mp3");
			}
		});
		
		btnPlus.setBounds(269, 371, 80, 63);
		btnPlus.setBorderPainted(false);
		btnPlus.setFocusPainted(false);
		contentPane.add(btnPlus);
		
		// 3 버튼			
		JButton btn3 = new JButton("");
		btn3.setBackground(new Color(236, 236, 236));
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 3 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\3.mp3");
			}
		});
		
		btn3.setIcon(new ImageIcon(Calculator.class.getResource("/Image/3.png")));
		btn3.addActionListener(new NumberActionListener(answer,"3"));
		btn3.setBounds(183, 371, 80, 63);
		btn3.setBorderPainted(false);
		btn3.setFocusPainted(false);
		contentPane.add(btn3);
		
		// 2 버튼			
		JButton btn2 = new JButton("");
		btn2.setBackground(new Color(236, 236, 236));
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 2 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\2.mp3");
			}
		});
		
		btn2.setBorderPainted(false);
		btn2.setIcon(new ImageIcon(Calculator.class.getResource("/Image/2.png")));
		btn2.addActionListener(new NumberActionListener(answer,"2"));
		btn2.setBounds(97, 371, 80, 63);
		btn2.setFocusPainted(false);
		contentPane.add(btn2);
		
		// 1 버튼			
		JButton btn1 = new JButton("");
		btn1.setBackground(new Color(236, 236, 236));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 1 버튼 클릭 이벤트
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\1.mp3");
			}
		});
		
		btn1.setIcon(new ImageIcon(Calculator.class.getResource("/Image/1.png")));
		btn1.addActionListener(new NumberActionListener(answer,"1"));
		btn1.setBounds(11, 371, 80, 63);
		btn1.setBorderPainted(false);
		btn1.setFocusPainted(false);
		contentPane.add(btn1);	
		
		// . 버튼			
		JButton btn_Jum = new JButton("");
		btn_Jum.setBackground(new Color(236, 236, 236));
		btn_Jum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\..mp3");
			}
		});
		
		btn_Jum.setIcon(new ImageIcon(Calculator.class.getResource("/Image/Circle.png")));
		btn_Jum.addActionListener(new NumberActionListener(answer,"."));
		btn_Jum.setBounds(11, 440, 80, 63);
		btn_Jum.setBorderPainted(false);
		btn_Jum.setFocusPainted(false);
		contentPane.add(btn_Jum);
		
		// 0 버튼			
		JButton btn0 = new JButton("");
		btn0.setBackground(new Color(236, 236, 236));
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\0.mp3");
			}
		});
		
		btn0.setIcon(new ImageIcon(Calculator.class.getResource("/Image/0.png")));
		btn0.addActionListener(new NumberActionListener(answer,"0"));
		btn0.setBounds(97, 440, 80, 63);
		btn0.setBorderPainted(false);
		btn0.setFocusPainted(false);
		contentPane.add(btn0);
		
		// -버튼			
		JButton btn_minus = new JButton("-");
		btn_minus.setBackground(new Color(236, 236, 236));
		btn_minus.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) { // - 버튼 이벤트
				String curr = answer.getText();
				firstNumber = Integer.parseInt(curr); //curr 최신값을 넘버값으로 변경
				
				answer.setText("0");
				
				func = "빼기";
				
				playTts("D:\\Data_Analysis\\Project1\\buttonSound\\-.mp3");
			}
		});
		
		btn_minus.setBounds(269, 164, 80, 63);
		btn_minus.setBorderPainted(false);
		btn_minus.setFocusPainted(false);
		contentPane.add(btn_minus);
		
		// 시각 장애인을 위한 계산기		
		textField = new JTextField();
		textField.setFont(new Font("나눔고딕", Font.BOLD, 22));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(236, 217, 255));
		textField.setText("\uC2DC\uAC01\uC7A5\uC560\uC778\uC744 \uC704\uD55C \uACC4\uC0B0\uAE30");
		textField.setBounds(65, 10, 281, 47);
		textField.setEditable(false);
		textField.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel logo_label = new JLabel("");
		logo_label.setIcon(new ImageIcon(Calculator.class.getResource("/Image/logo.png")));
		logo_label.setBounds(12, 10, 55, 47);
		contentPane.add(logo_label);
		
		// = 버튼		
		JButton btResult = new JButton("=");
		btResult.setBackground(new Color(236, 236, 236));
		btResult.setBorderPainted(false);
		btResult.setFocusPainted(false);
		btResult.setBounds(269, 440, 80, 63);
		contentPane.add(btResult);
		
		btResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // = 버튼 이벤트
				try {
		        	playTts("D:\\Data_Analysis\\Project1\\buttonSound\\=.mp3");
		        	
		        	Thread.sleep(900); // 0.9초 후 진행
		        	
					switch(func) { // 연산 진행 Method
						case "더하기": {
							double  currValue = Double.parseDouble(answer.getText());
							double result = (firstNumber+currValue);
							
							answer.setText((String.format("%.0f", result) + "")); // 숫자를 문자열로 변환
							
							break;
						}
						
						case "빼기": {
							double currValue = Double.parseDouble(answer.getText());
							double result = (firstNumber - currValue);
							
							answer.setText((String.format("%.0f", result) + "")); // 숫자를 문자열로 변환
							
							break;
						}
						
						case "곱하기": {
							double currValue = Double.parseDouble(answer.getText());
							double result = (firstNumber*currValue);
							
							answer.setText((String.format("%.0f", result) + "")); // 숫자를 문자열로 변환
							
							break;
						}
						
						case "나누기": {
							double currValue = Double.parseDouble(answer.getText());
							double result = (firstNumber/currValue);
							
							answer.setText((String.format("%.0f", result) + "")); // 숫자를 문자열로 변환
							
							break;
						}
						
						case "나머지 구하기" :
							double currValue = Double.parseDouble(answer.getText());
							double result = firstNumber % currValue;
							
							answer.setText((String.format("%.0f", result) + "")); // 숫자를 문자열로 변환
							
							break;
					}
					
					resultnum = answer.getText();
		        } catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				
				String line = resultnum;
				
				int[] numbersArray = new int[line.length()]; // 문자열의 길이만큼의 Integer 배열 생성
				
				for (int i =0; i < line.length(); i++) { // 문자열에서 문자를 한 개씩 추출하여 배열에 추가(문자열의 길이만큼 반복)
		            numbersArray[i] = Character.getNumericValue(line.charAt(i));
				}
				
				for (int i = 0; i < line.length(); i++) { // 연산 결과를 하나씩 출력
					switch (numbersArray[i]) {
					case 1:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\1.mp3");
						
						break;
		            
					case 2:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\2.mp3");
						
						break;
							
					case 3:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\3.mp3");
						
						break;
						
					case 4:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\4.mp3");
						
						break;
						
					case 5:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\5.mp3");
						
						break;
						
					case 6:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\6.mp3");
						
						break;
						
					case 7:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\7.mp3");
						
						break;
						
					case 8:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\8.mp3");
						
						break;
						
					case 9:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\9.mp3");
						
						break;
						
					case 0:
						playTts("D:\\Data_Analysis\\Project1\\buttonSound\\0.mp3");
						
						break;   
					}
					
					try { // 반복 전에 0.8초 간격을 줌
						Thread.sleep(800);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}       
			}
		});
	}
	
	public void playTts(String filename) {
		File ttsfile = new File(filename);
		if(mp3Player != null) {
			mp3Player.stop();
		}
		mp3Player = new MP3Player(ttsfile);
		mp3Player.play();
	}
}

class NumberActionListener implements ActionListener{
	
	private String text;
	private JTextField txtfield;
	public NumberActionListener(JTextField txt, String s) {
		txtfield = txt;
		text = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String curr = txtfield.getText();
		if(curr.equals("0")  && !text.equals(".") ) {
			txtfield.setText(text);
		}else if(curr.contains(".") && text.equals(".")) {
			
		} else {
			txtfield.setText(txtfield.getText() + text);
		}
	} 
}