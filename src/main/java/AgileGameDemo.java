import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AgileGameDemo {

	private JFrame frmAgileGame;
	private JTextField Team1Name;
	private JTextField Team1Number;
	private JTextField Team2Name;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgileGameDemo window = new AgileGameDemo();
					window.frmAgileGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgileGameDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgileGame = new JFrame();
		frmAgileGame.setTitle("Agile Game");
		frmAgileGame.setBounds(100, 100, 900, 760);
		frmAgileGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgileGame.getContentPane().setLayout(null);
		
		JPanel GameSetup = new JPanel();
		GameSetup.setBounds(0, 0, 878, 704);
		frmAgileGame.getContentPane().add(GameSetup);
		GameSetup.setLayout(null);
		
		JPanel panelTeam1 = new JPanel();
		panelTeam1.setBounds(15, 94, 360, 180);
		GameSetup.add(panelTeam1);
		panelTeam1.setLayout(null);
		
		JLabel lblTeam = new JLabel("Team 1");
		lblTeam.setBounds(154, 5, 54, 20);
		panelTeam1.add(lblTeam);
		
		JLabel lblNewLabel = new JLabel("Team Name:");
		lblNewLabel.setBounds(15, 40, 99, 39);
		panelTeam1.add(lblNewLabel);
		
		Team1Name = new JTextField();
		Team1Name.setText("Team 1");
		Team1Name.setBounds(129, 46, 146, 26);
		panelTeam1.add(Team1Name);
		Team1Name.setColumns(10);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(19, 102, 69, 20);
		panelTeam1.add(lblPlayer);
		
		Team1Number = new JTextField();
		Team1Number.setText("4");
		Team1Number.setBounds(129, 99, 150, 25);
		panelTeam1.add(Team1Number);
		Team1Number.setColumns(10);
		
		JPanel panelTeam2 = new JPanel();
		panelTeam2.setBounds(503, 94, 360, 180);
		GameSetup.add(panelTeam2);
		panelTeam2.setLayout(null);
		
		JLabel lblTeam_1 = new JLabel("Team 2");
		lblTeam_1.setBounds(153, 5, 54, 20);
		panelTeam2.add(lblTeam_1);
		
		JLabel lblTeamName = new JLabel("Team Name:");
		lblTeamName.setBounds(15, 49, 99, 20);
		panelTeam2.add(lblTeamName);
		
		Team2Name = new JTextField();
		Team2Name.setText("Team 2");
		Team2Name.setBounds(129, 46, 146, 26);
		panelTeam2.add(Team2Name);
		Team2Name.setColumns(10);
		
		JLabel lblPlayer_1 = new JLabel("Player:");
		lblPlayer_1.setBounds(21, 104, 69, 20);
		panelTeam2.add(lblPlayer_1);
		
		textField = new JTextField();
		textField.setText("4");
		textField.setBounds(129, 101, 146, 26);
		panelTeam2.add(textField);
		textField.setColumns(10);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAgileGame.dispose();
				AgileGame.main(null);
			}
		});
		btnStartGame.setBounds(327, 331, 200, 50);
		GameSetup.add(btnStartGame);
		
		JLabel lblGameSetup = new JLabel("Game Set Up");
		lblGameSetup.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblGameSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameSetup.setBounds(364, 16, 163, 44);
		GameSetup.add(lblGameSetup);
		
		JPanel panelTeamPlay = new JPanel();
		panelTeamPlay.setBounds(0, 0, 878, 688);
		frmAgileGame.getContentPane().add(panelTeamPlay);
		panelTeamPlay.setLayout(null);
	}
}
