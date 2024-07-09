package WindowBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.GameDAO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class gamepage extends JFrame {

	private JPanel contentPane;
	private JLabel lblSOL;
	private JLabel lblgameover;
	private JLabel lblsolutionmsg;
	private JLabel lblmsg;
	private JLabel lbl_picture;
	private JLabel question_label;
	private JLabel Label_try;
	private JTextField textField_oneletter;
	private String enteredLetter = ""; // 입력된 글자를 저장할 변수
    private StringBuilder underscores; // 인스턴스 변수로 선언
    JButton btninputscore;
    Main_Page main = new Main_Page();

	final int life = 10; // 시도할 수 있는 횟수
	int count = 0;
	Scanner sc = new Scanner(System.in);
	
	String[] words = {"computer", "word","bed","dog","flower", "arm","box","bat",
			"cab","cat","ceo","can","cow","cut","dad","dig","dot","egg","cold","come",
			"cook","copy","dark","exit","fact","fail","fast","drop","actor","after",
			"alarm","alone","charm","cloud","cloth","blond","black","berry","beauty", 
			"belief","belong","behind","betray","better","biking","bikini","bistro",
			"abandon","ability","abolish","absence","academy","account","actress",
			"address","hospital","position","minister","anything","together","everyone",
			"contract","response","property","industry","business","interest","building"
			};
	
	int index = (new Random()).nextInt(words.length);
	String solution = words[index]; 			// words 배열에서 랜덤한 인덱스의 문자열 지정
	char[] answer = new char[solution.length()];		

    // 이미지 파일 경로 배열 선언
	private String[] images = {
    "/Image/hang1.png",
    "/Image/hang2.png",
    "/Image/hang3.png",
    "/Image/hang4.png",
    "/Image/hang5.png",
    "/Image/hang6.png",
    "/Image/hang7.png",
    "/Image/hang8.png",
    "/Image/hang9.png",
    "/Image/hang10.png",
    "/Image/hang11.png"
};
	
	// 이미지 변경 메소드 // 
	private void setImageIcon(int count) {
		if (count >= 0 && count < images.length) {
			lbl_picture.setIcon(new ImageIcon(gamepage.class.getResource(images[count])));
		}
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public gamepage(String id) throws ClassNotFoundException, SQLException {
		System.out.println(id);
		
		GameDAO dao = new GameDAO();
		
		setTitle("Hangman Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 729);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 215, 207));
		panel.setBounds(0, 10, 875, 692);
		contentPane.add(panel);
		panel.setLayout(null);

		textField_oneletter = new JTextField();
		textField_oneletter.setBorder(null);
		textField_oneletter.setHorizontalAlignment(SwingConstants.CENTER);
		textField_oneletter.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		textField_oneletter.setColumns(1);
		textField_oneletter.setBounds(633, 395, 65, 45);
		textField_oneletter.setOpaque(false);
		panel.add(textField_oneletter);
		
		question_label = new JLabel("\u25BC \uBE48\uCE78\uC758 \uB2E8\uC5B4\uB97C \uB9DE\uCDB0\uBCF4\uC138\uC694 \u25BC");
		question_label.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		question_label.setHorizontalAlignment(SwingConstants.CENTER);
		question_label.setBounds(36, 10, 586, 47);
		panel.add(question_label);
		
		Label_try = new JLabel("");
		Label_try.setHorizontalAlignment(SwingConstants.CENTER);
		Label_try.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Label_try.setBounds(633, 519, 65, 45);
		panel.add(Label_try);
		
		lblmsg = new JLabel("");
		lblmsg.setFont(new Font("Ink Free", Font.BOLD, 30));
		lblmsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblmsg.setBounds(554, 199, 204, 62);
		panel.add(lblmsg);
		
		lblSOL = new JLabel();
        lblSOL.setHorizontalAlignment(SwingConstants.CENTER);
        lblSOL.setFont(new Font("Ink Free", Font.ITALIC, 50));
        lblSOL.setBounds(91, 67, 461, 47);
        panel.add(lblSOL);
        
        // solution의 글자 길이만큼 "_"를 lblSOL에 underscores로 설정
        underscores = new StringBuilder();
        for (int i = 0; i < solution.length(); i++) {
            underscores.append("□ ");
        }
        
        lblSOL.setText(underscores.toString().trim());
        
        lblgameover = new JLabel("");
        lblgameover.setFont(new Font("Ink Free", Font.BOLD, 30));
        lblgameover.setHorizontalAlignment(SwingConstants.CENTER);
        lblgameover.setBounds(544, 199, 204, 62);
        panel.add(lblgameover);
        
        lblsolutionmsg = new JLabel("");
        lblsolutionmsg.setFont(new Font("Ink Free", Font.BOLD, 25));
        lblsolutionmsg.setHorizontalAlignment(SwingConstants.CENTER);
        lblsolutionmsg.setBounds(554, 258, 204, 74);
        panel.add(lblsolutionmsg);
        
        lbl_picture = new JLabel(""); // 이미지가 표시되는 Label
        lbl_picture.setBounds(0, 0, 863, 682);
        panel.add(lbl_picture);
        
        // 초기 이미지를 설정
        lbl_picture.setIcon(new ImageIcon(gamepage.class.getResource(images[0])));
        
        JButton btnreplay = new JButton("");
        
        btnreplay.setContentAreaFilled(false);
        
        btnreplay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		restartGame();
        	}
        });
        
        btnreplay.setForeground(Color.BLACK);
        btnreplay.setBackground(new Color(226, 192, 215));
        btnreplay.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        btnreplay.setBounds(507, 614, 148, 36);
        btnreplay.setBorder(BorderFactory.createLineBorder(new Color(226, 192, 215), 2));
        panel.add(btnreplay);
        
        btninputscore = new JButton("");
        
        btninputscore.setContentAreaFilled(false);
        btninputscore.setVisible(false);
        
        btninputscore.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String id1 = id;
        		
        		int score = (life - count) * 10;
        		
        		if(dao.insert_score2(id, score)) {
        			JOptionPane.showMessageDialog(null, "점수 입력 완료!");
        			
        			main.welcome_label.setText(id1 + "님 환영합니다!");
        			
        			main.str = id1;
        			
        			dispose();
        			
        			setVisible(false);
        			
        			main.setVisible(true);
        		}
        	}
        });
        
        btninputscore.setForeground(Color.BLACK);
        btninputscore.setBackground(new Color(226, 192, 215));
        btninputscore.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        btninputscore.setBounds(684, 614, 119, 36);
        btninputscore.setBorder(BorderFactory.createLineBorder(new Color(226, 192, 215), 2));
        panel.add(btninputscore);
	
        // ActionListener를 추가하여 textField_oneletter에 엔터키 입력을 감지
        textField_oneletter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateEnteredLetter();
            }
        });
    }

	// textField_oneletter에 감지된 글자를 enteredLetter에 넣고 텍스트 필드를 비움
	private void updateEnteredLetter() {
        enteredLetter = textField_oneletter.getText();
        if (enteredLetter.length() == 1) {
            checkAndUpdateSolution();
            textField_oneletter.setText(""); 
        }
    }

	// solution과 letter이 동일할 경우 underscores의 인덱스를 조정하여 letter를 입력
	private void checkAndUpdateSolution() {
        char letter = enteredLetter.charAt(0);
        boolean found = false; 
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == letter) {
                underscores.setCharAt(i * 2, letter); // 공백을 포함하여 인덱스 조정
                found = true; // 글자가 일치할 경우
            }
        }
        
        // 글자가 일치할 경우
        if(found) {
            lblSOL.setText(underscores.toString());
            
        // 글자가 일치하지 않았을때 count + 1 추가 
        } else {
            count += 1;
            Label_try.setText(String.valueOf(life - count));
            System.out.println("Count: " + count); // count 값 출력
            
			setImageIcon(count); // count가 증가할 때마다 이미지를 변경

            System.out.println("Count2: " + count);
            if (count >= life) {
            	lblgameover.setText("GAME OVER");
            	lblsolutionmsg.setText("Answer: " + solution);
                textField_oneletter.setEditable(false); // 더 이상 입력할 수 없게 함
                btninputscore.setVisible(true);
            }
        }

        checkResult();
    }
	
	private void checkResult() {
        // lblSOL의 텍스트에서 공백을 제거하여 solution과 비교
        String displayedText = lblSOL.getText().replace("□", "").replace(" ", "");
        if (displayedText.equals(solution)) {
            lblmsg.setText(" YOU WIN ! ");
            textField_oneletter.setEditable(false); // 더 이상 입력할 수 없게 하기 위함
            btninputscore.setVisible(true);
        }
    }
	
	private void restartGame() {
        // 새 단어를 선택
        index = (new Random()).nextInt(words.length);
        solution = words[index];
        underscores.setLength(0); // 초기화
        for (int i = 0; i < solution.length(); i++) {
            underscores.append("□ ");
        }

        // 게임 상태 초기화
        count = 0;
        lblSOL.setText(underscores.toString().trim());
        lbl_picture.setIcon(new ImageIcon(gamepage.class.getResource(images[0])));
        Label_try.setText(String.valueOf(life));
        lblmsg.setText("");
        lblgameover.setText("");
        lblsolutionmsg.setText("");
        textField_oneletter.setEditable(true); // 입력 필드를 활성화
        textField_oneletter.setText("");
    }
}