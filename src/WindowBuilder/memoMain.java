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
	private JTextArea input_textarea;
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
		
		JMenu file_menu = new JMenu("\uD30C\uC77C");
		file_menu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		file_menu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(file_menu);
		
		// 메뉴 -> 새로만들기 초기화면
		JMenuItem init_menuitem = new JMenuItem("\uC591\uC2DD\uCD08\uAE30\uD654");
		init_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		init_menuitem.setHorizontalAlignment(SwingConstants.LEFT);
		init_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_textarea.setText("\u25CE \uD574\uC57C \uD560 \uC77C\n-\n-\n-\n-\n-\n\n\u25CE \uC0AC\uC57C \uD560 \uAC83\n-\n-\n-\n-\n-\n\n\u25CE \uAE30\uC5B5\uD574\uC57C \uD560 \uAC83\n-\n-\n-\n-\n-\n");
				
				currentFile = null;
			}
		});
		
		file_menu.add(init_menuitem);
		
		// 텍스트 파일 오픈	
		JMenuItem open_menuitem = new JMenuItem("\uD30C\uC77C\uC5F4\uAE30");
		open_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		open_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		
		// 화면 지우기		
		JMenuItem clear_menuitem = new JMenuItem("\uD654\uBA74 \uC9C0\uC6B0\uAE30");
		clear_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		clear_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_textarea.setText("");
				currentFile = null;
				
			}
		});
		
		file_menu.add(clear_menuitem);
		file_menu.add(open_menuitem);
		
		// 텍스트 파일로 저장		
		JMenuItem save_menuitem = new JMenuItem("\uD30C\uC77C\uC800\uC7A5");
		save_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		save_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
		
		file_menu.add(save_menuitem);
		
		JMenu edit_menu = new JMenu("\uC11C\uC2DD");
		edit_menu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(edit_menu);
		
		// 글꼴		
		JMenuItem font_size_menuitem = new JMenuItem("\uAE00\uAF34\uD06C\uAE30");
		font_size_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		font_size_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String fontSizeStr = JOptionPane.showInputDialog(memoMain.this, "Font 크기를 입력하세요:\n현재 크기는 12입니다", "Font 크기 선택 ", JOptionPane.PLAIN_MESSAGE);
                try {
                    int fontSize = Integer.parseInt(fontSizeStr);
                    
                    if (fontSize > 0) {
                        Font currentFont = input_textarea.getFont();
                        Font newFont = currentFont.deriveFont((float) fontSize);
                        input_textarea.setFont(newFont);
                    } else {
                        JOptionPane.showMessageDialog(memoMain.this, "올바른 글꼴 크기를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(memoMain.this, "숫자를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
		});
		
		font_size_menuitem.setHorizontalAlignment(SwingConstants.LEFT);
		edit_menu.add(font_size_menuitem);
		
		// 글꼴 초기화		
		JMenuItem font_init_menuitem = new JMenuItem("\uAE00\uAF34\uCD08\uAE30\uD654");
		font_init_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		font_init_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_textarea.setFont(defaultFont);
			}
		});
		
		edit_menu.add(font_init_menuitem);
		
		JMenu window_menu = new JMenu("\uCC3D");
		window_menu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(window_menu);
		
		// 메인 화면 돌아가기		
		JMenuItem return_main_menuitem = new JMenuItem("\uBA54\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		return_main_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		return_main_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.welcome_label.setText(id + "님 환영합니다!");
				
				main.str = id;
				
				dispose();
				
				setVisible(false);
				
				main.setVisible(true);
			}
		});
		
		window_menu.add(return_main_menuitem);
	
		// 종료		
		JMenuItem exit_menuitem = new JMenuItem("\uC885\uB8CC");
		exit_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		exit_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		window_menu.add(exit_menuitem);
		
		JMenu help_menu = new JMenu("Help");
		help_menu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		menuBar.add(help_menu);
		
		// tip		
		JMenuItem help_menuitem = new JMenuItem("\uB3C4\uC6C0\uB9D0");
		help_menuitem.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		help_menuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(memoMain.this, 
						"이 프로그램은 발달장애인의 일상 생활을 더욱 편리하게 하기 위해 제작된 메모장입니다.\n "
								+ "쉽게 접근하고 사용할 수 있도록 디자인되었습니다. \n\n메모를 작성하고, 저장하고, 불러오는 기능은 물론, 글꼴 크기를 조절할 수 있는 기능이 제공됩니다."
								+ "\n 이 메모장이 발달장애인분들의 생활에 도움이 되기를 바랍니다.", "도움말", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		help_menu.add(help_menuitem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		// 초기 양식 화면		
		input_textarea = new JTextArea();
		
		input_textarea.setText("\u25CE \uD574\uC57C \uD560 \uC77C\n-\n-\n-\n-\n-\n\n\u25CE \uC0AC\uC57C \uD560 \uAC83\n-\n-\n-\n-\n-\n\n\u25CE \uAE30\uC5B5\uD574\uC57C \uD560 \uAC83\n-\n-\n-\n-\n-\n");
		
		JScrollPane scrollPane = new JScrollPane(input_textarea);
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
				input_textarea.read(reader, null);
			} catch(IOException e) {
				
			}
		}
	}
	
	// 파일 저장 메소드	
	protected void saveFile() {
		if (currentFile != null) {
			try (FileWriter writer = new FileWriter(currentFile)) {
				input_textarea.write(writer);
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
