package WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.GameDAO;

public class NumberGame extends JFrame {
   
   private JPanel contentPane;
   private JTextField AnswerInputField;
   int Answer;
   int num1;
   int num2;
   char operato;
   Random random;
   JTextField AnswerCnt_1;
   int totalAttempts = 0;
   int maxAttempts =10;
   int answercnt_1;
   int count = 1;
   JButton nextQuiz;
   JButton btn_input_score;
   
   Main_Page main = new Main_Page();

   /**
    * Create the frame.
 * @throws SQLException 
 * @throws ClassNotFoundException 
    */
   public NumberGame(String id) throws ClassNotFoundException, SQLException { // 수학 연산 게임 화면
	  GameDAO dao = new GameDAO();
	  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 630, 785);
      setLocationRelativeTo(null);
      setTitle("Math Quiz");
      
      contentPane = new JPanel();
      contentPane.setBackground(new Color(236, 251, 251));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel answer_cnt_label = new JLabel("정답 갯수");
      answer_cnt_label.setForeground(new Color(255, 255, 255));
      answer_cnt_label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      answer_cnt_label.setHorizontalAlignment(SwingConstants.CENTER);
      answer_cnt_label.setBounds(112, 420, 113, 27);
      contentPane.add(answer_cnt_label);
      
      JLabel QuizRandomLabel = new JLabel("QuizLabel"); // 연산 문제가 표시되는 Label
      QuizRandomLabel.setFont(new Font("굴림", Font.BOLD, 30));
      QuizRandomLabel.setHorizontalAlignment(SwingConstants.CENTER);
      QuizRandomLabel.setBounds(124, 253, 368, 84);
      contentPane.add(QuizRandomLabel);
      QuizRandomLabel.setOpaque(true); // 해당 Label을 전부 칠할지 여부를 설정
      QuizRandomLabel.setBackground(Color.WHITE);
      


      
      // 문제 질문지
      random = new Random();
      num1 = random.nextInt(9) +1; // 1 ~ 9 사이 숫자 저장
      num2 = random.nextInt(9) +1; // 1 ~ 9 사이 숫자 저장
      
      char[] operatos = {'+','-','*','/'};
      operato = operatos[random.nextInt(operatos.length)]; // 연산자 저장
      
      // 연산 수행
      if (operato == '+') {
         Answer = num1 + num2;
      } else if (operato == '-') {
         Answer = num1 - num2;
      } else if (operato == '*') {
         Answer = num1 * num2;
      } else if (operato == '/') {
         num1 = num1 * num2;
         Answer = num1 / num2;
      }
      
      QuizRandomLabel.setText(num1 + "     " + operato + "     " + num2 + "     " + "=" + "     " +"?");
      
      AnswerInputField = new JTextField(); // 정답 입력 TextField
      AnswerInputField.setBorder(null);
      AnswerInputField.setHorizontalAlignment(SwingConstants.CENTER);
      AnswerInputField.setFont(new Font("굴림", Font.BOLD, 20));
      AnswerInputField.setBounds(319, 365, 173, 64);
      contentPane.add(AnswerInputField);
      AnswerInputField.setColumns(10);
      
      JButton btn_answer_check = new JButton(""); // 정답 확인 버튼
      btn_answer_check.setHorizontalAlignment(SwingConstants.LEADING);
      
      btn_answer_check.setBorderPainted(true); // 버튼 테두리 설정
      btn_answer_check.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
      btn_answer_check.setFocusPainted(false); // 포커스 표시 설정
      
      btn_answer_check.setFont(new Font("굴림", Font.PLAIN, 12));
      btn_answer_check.setBackground(SystemColor.info);
      btn_answer_check.setFocusPainted(false);
      btn_answer_check.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) { // 정답 확인 버튼 Click Event
            
            try {
               int userInput = Integer.parseInt(AnswerInputField.getText()); // 정답 입력 필드의 값을 가져와서 저장
               int answer1 = Answer; // 연산된 결과를 저장
               
               // 연산된 결과와 입력한 값이 일치하는지 비교
               if (userInput == answer1) { // 일치하는 경우
                  answercnt_1 += 1;
                  AnswerCnt_1.setText(Integer.toString(answercnt_1));
                  JOptionPane.showMessageDialog(btn_answer_check, "정답입니다~!");
               }   else { // 일치하지 않는 경우
                  JOptionPane.showMessageDialog(btn_answer_check, "땡입니다ㅠㅠ");
               }
               
               AnswerInputField.setText("");
               AnswerInputField.setEditable(false);
               btn_answer_check.setEnabled(false);
            } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(btn_answer_check, "답을 적어주세요 ㅎㅎ");
            }
         }
      });
      
      btn_answer_check.setBounds(308, 439, 57, 66);
      contentPane.add(btn_answer_check);
      
      AnswerCnt_1 = new JTextField();
      AnswerCnt_1.setBorder(BorderFactory.createEmptyBorder());
      AnswerCnt_1.setHorizontalAlignment(SwingConstants.CENTER);
      AnswerCnt_1.setFont(new Font("굴림", Font.BOLD, 20));
      AnswerCnt_1.setBounds(112, 457, 113, 37);
      contentPane.add(AnswerCnt_1);
      AnswerCnt_1.setColumns(10);
      
      
      
      nextQuiz = new JButton("");
      
      nextQuiz.setBorderPainted(true); 
      nextQuiz.setContentAreaFilled(false); 
      nextQuiz.setFocusPainted(false);
      
      nextQuiz.setFont(new Font("굴림", Font.PLAIN, 12));
      nextQuiz.setBackground(SystemColor.info);
      nextQuiz.setFocusPainted(false);
      nextQuiz.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 AnswerInputField.setEditable(true);
            // 문제 질문지
            count += 1;
            random = new Random();
            num1 = random.nextInt(9) +1;
            num2 = random.nextInt(9) +1;
            
            char[] operatos = {'+','-','*','/'};
            operato = operatos[random.nextInt(operatos.length)]; 
            if(count == 11) {
               JOptionPane.showMessageDialog(null, "10문제 끝~!" + "\n점수는 : " + answercnt_1*10 );
               btn_answer_check.setEnabled(false);
               nextQuiz.setEnabled(false);
               btn_input_score.setVisible(true);
            } else {
               if (operato == '+') {
                  Answer = num1 + num2;
               } else if (operato == '-') {
                  Answer = num1 - num2;
               } else if (operato == '*') {
                  Answer = num1 * num2;
               } else if (operato == '/') {
                  num1 = num1 * num2;
                  Answer = num1 / num2;
               }
               QuizRandomLabel.setText(num1 + "     " + operato + "     " + num2 + "     " + "=" + "     " +"?");
               // 문제 질문지 - end
               btn_answer_check.setEnabled(true);
            }
         }
      });
      
      nextQuiz.setBounds(449, 439, 68, 66);
      contentPane.add(nextQuiz);
      
      btn_input_score = new JButton("Update");
      btn_input_score.setForeground(new Color(207, 182, 92));
      btn_input_score.setFont(new Font("Arial", Font.BOLD, 30));
      
      btn_input_score.setBorderPainted(false); 
      btn_input_score.setContentAreaFilled(false); 
      btn_input_score.setFocusPainted(false);
      btn_input_score.setVisible(false);
      
      btn_input_score.addMouseListener(new MouseAdapter() {
    	  @Override
          public void mouseClicked(MouseEvent e) {
    		  int score = answercnt_1 * 10;
              String id1 = id;
               
              if(dao.insert_score1(id1, score)) {
            	  JOptionPane.showMessageDialog(null, "Update 완료!");
                  
                  main.welcome_label.setText(id1 + "님 환영합니다!");
                  
                  main.str = id1;
                  
                  dispose();
                  
                  setVisible(false);
                  
                  main.setVisible(true);
              }
    	  }
      });
         
      btn_input_score.setBounds(383, 533, 150, 46);
      contentPane.add(btn_input_score);
         
      JLabel image_label = new JLabel("");
      image_label.setIcon(new ImageIcon(NumberGame.class.getResource("/Image/NumberGame1.png")));
      image_label.setBounds(0, 0, 614, 746);
      contentPane.add(image_label);
   }
}