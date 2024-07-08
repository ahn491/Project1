package WindowBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NumberStart extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public NumberStart(String id) {
		setTitle("Math Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 796);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton StartButton = new JButton("Game Start");
		StartButton.setForeground(Color.BLACK);
		
		StartButton.setBorderPainted(false); 
		StartButton.setContentAreaFilled(false); 
		StartButton.setFocusPainted(false); 
		
		StartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NumberGame secondwindow;
				try {
					secondwindow = new NumberGame(id);
					
					dispose();
					
					setVisible(false);
					
					secondwindow.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		StartButton.setFont(new Font("Arial", Font.BOLD, 25));
		StartButton.setBounds(310, 372, 177, 60);
		contentPane.add(StartButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NumberStart.class.getResource("/Image/NumberGame.png")));
		lblNewLabel.setBounds(0, 0, 610, 757);
		contentPane.add(lblNewLabel);
	}
}