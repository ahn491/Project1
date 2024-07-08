package WindowBuilder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class memoMain extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private File currentFile;
	private Font defaultFont;
	Main_Page main = new Main_Page();
	
	/**
	 * Create the frame.
	 */
	public memoMain(String id) throws ClassNotFoundException, SQLException {
		setTitle("발달 장애인을 위한 메모장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 494);
		setLocationRelativeTo(null);
		setResizable(false); // 메모장 크기 변경 불가하게 설정
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C");
		mnNewMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		// 메뉴 -> 새로만들기 초기화면
		JMenuItem 새로만들기 = new JMenuItem("\uC591\uC2DD\uCD08\uAE30\uD654");
		새로만들기.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		새로만들기.setHorizontalAlignment(SwingConstants.LEFT);
		새로만들기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("\u25CE \uD574\uC57C \uD560 \uC77C\r\n-\r\n-\r\n-\r\n-\r\n-\r\n\r\n\u25CE \uC0AC\uC57C \uD560 \uAC83\r\n-\r\n-\r\n-\r\n-\r\n-\r\n\r\n\u25CE \uAE30\uC5B5\uD574\uC57C \uD560 \uAC83\r\r\n-\r\n-\r\n-\r\n-\r\n-\r\n");
				
				currentFile = null;
			}
		});
		
		mnNewMenu.add(새로만들기);
		
		// 텍스트 파일 오픈	
		JMenuItem 열기 = new JMenuItem("\uD30C\uC77C\uC5F4\uAE30");
		열기.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		열기.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		
		// 화면 지우기		
		JMenuItem 빈화면 = new JMenuItem("\uD654\uBA74 \uC9C0\uC6B0\uAE30");
		빈화면.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		빈화면.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				currentFile = null;
				
			}
		});
		
		mnNewMenu.add(빈화면);
		mnNewMenu.add(열기);
		
		// 텍스트 파일로 저장		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uD30C\uC77C\uC800\uC7A5");
		mntmNewMenuItem_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\uC11C\uC2DD");
		mnNewMenu_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_1);
		
		// 글꼴		
		JMenuItem 글꼴 = new JMenuItem("\uAE00\uAF34\uD06C\uAE30");
		글꼴.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		글꼴.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String fontSizeStr = JOptionPane.showInputDialog(memoMain.this, "Font 크기를 입력하세요:\n현재 크기는 12입니다", "Font 크기 선택 ", JOptionPane.PLAIN_MESSAGE);
                try {
                    int fontSize = Integer.parseInt(fontSizeStr);
                    
                    if (fontSize > 0) {
                        Font currentFont = textArea.getFont();
                        Font newFont = currentFont.deriveFont((float) fontSize);
                        textArea.setFont(newFont);
                    } else {
                        JOptionPane.showMessageDialog(memoMain.this, "올바른 글꼴 크기를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(memoMain.this, "숫자를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
		});
		
		글꼴.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.add(글꼴);
		
		// 글꼴 초기화		
		JMenuItem 글꼴초기화 = new JMenuItem("\uAE00\uAF34\uCD08\uAE30\uD654");
		글꼴초기화.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		글꼴초기화.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(defaultFont);
			}
		});
		
		mnNewMenu_1.add(글꼴초기화);
		
		JMenu mnNewMenu_2 = new JMenu("\uCC3D");
		mnNewMenu_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		// 메인 화면 돌아가기		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uBA54\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		mntmNewMenuItem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.welcome_label.setText(id + "님 환영합니다!");
				
				main.str = id;
				
				dispose();
				
				setVisible(false);
				
				main.setVisible(true);
			}
		});
		
		mnNewMenu_2.add(mntmNewMenuItem);
	
		// 종료		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uC885\uB8CC");
		mntmNewMenuItem_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu Help = new JMenu("Help");
		Help.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(Help);
		
		// tip		
		JMenuItem 도움말 = new JMenuItem("\uB3C4\uC6C0\uB9D0");
		도움말.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		도움말.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(memoMain.this, 
						"이 프로그램은 발달장애인의 일상 생활을 더욱 편리하게 하기 위해 제작된 메모장입니다.\n "
								+ "쉽게 접근하고 사용할 수 있도록 디자인되었습니다. \n\n메모를 작성하고, 저장하고, 불러오는 기능은 물론, 글꼴 크기를 조절할 수 있는 기능이 제공됩니다."
								+ "\n 이 메모장이 발달장애인분들의 생활에 도움이 되기를 바랍니다.", "도움말", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		Help.add(도움말);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		// 초기 양식 화면		
		textArea = new JTextArea();
		
		textArea.setText("\u25CE \uD574\uC57C \uD560 \uC77C\r\n-\r\n-\r\n-\r\n-\r\n-\r\n\r\n\u25CE \uC0AC\uC57C \uD560 \uAC83\r\n-\r\n-\r\n-\r\n-\r\n-\r\n\r\n\u25CE \uAE30\uC5B5\uD574\uC57C \uD560 \uAC83\r\r\n-\r\n-\r\n-\r\n-\r\n-\r\n");
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		desktopPane.add(scrollPane);
		scrollPane.setBounds(0, 0, 413, 432);
	}
	
	// 파일 오픈 메소드	
	protected  void openFile() {
		JFileChooser  fileChooser = new JFileChooser ();
		int result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			currentFile = fileChooser.getSelectedFile();
			try(BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
				textArea.read(reader, null);
			} catch(IOException e) {
				
			}
		}
	}
	
	// 파일 저장 메소드	
	protected void saveFile() {
		if (currentFile != null) {
			try (FileWriter writer = new FileWriter(currentFile)) {
				textArea.write(writer);
			} catch(IOException e) {
				JOptionPane.showMessageDialog(this, "파일을 저장하는 동안 오류가 발생했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// 파일 저장 메소드(이름과 확장자를 지정하여 저장)	
	protected void saveAsFile() {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
	    int result = fileChooser.showSaveDialog(this);
	    
	    if (result == JFileChooser.APPROVE_OPTION) {
	        currentFile = fileChooser.getSelectedFile();
	        if (!currentFile.getName().toLowerCase().endsWith(".txt")) {
	            currentFile = new File(currentFile.getParentFile(), currentFile.getName() + ".txt");
	        }
	        saveFile();
	    }
	}
}
