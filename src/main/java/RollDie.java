//import java.util.Random;
import javax.swing.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Random;


public class RollDie extends JPanel {
	
	private Random randomize; 
	private int rollValue; 
	
	// CREATE UI COMPONENTS
	JPanel diceRollPanel = new JPanel();  			// one way to do it 
	JButton diceButton = new JButton(""); 
	
	// Set JLabel to Hold Dice Button and Face Images 
	JLabel diceButtonImage = new JLabel();
	JLabel diceFaceImage = new JLabel(); 
	
	// Set ImageIcon Resource for Dice Button
	ImageIcon dice_button_image = new ImageIcon("dice_face_button.png");
	
	// Array to Hold Image Paths for Dice Faces
	String[] diceImagePaths = {"dice_face_1.png", "dice_face_2.png", "dice_face_3.png", 
								"dice_face_4.png", "dice_face_5.png", "dice_face_6.png", 
								"dice_face_7.png", "dice_face_8.png", "dice_face_9.png", 
								"_face_10.png", "dice_face_11.png", "dice_face_12.png", 
								"dice_face_13.png", "dice_face_14.png", "dice_face_15.png", 
								"dice_face_16.png", "dice_face_17.png", "dice_face_18.png", 
								"dice_face_19.png", "dice_face_20.png"}; 
	
	
	// CONSTRUCTOR
	public RollDie() {
		randomize = new Random();
    	rollValue = 1; 
    	diceButton.setIcon(dice_button_image); 							// Set image of RollDie button 
    	
    	//setLayout(new FlowLayout()); 
    	diceRollPanel.add(diceButton); 
    	diceRollPanel.add(diceButtonImage); 
    	diceRollPanel.add(diceFaceImage); 
    	
	
		// Action Listener for Dice Roll 
		diceButton.addActionListener(new ActionListener( ) {	
			public void actionPerformed(ActionEvent event) {
				
				if(event.getSource() == diceButton) {
					diceFaceImage.setIcon(null);
					
					// Set image corresponding with roll value 
					switch(rollDice()) {
						case 1:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[1]));
							break;
						case 2:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[2]));
							break;
						case 3:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[3]));
							break;
						case 4:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[4]));
							break;
						case 5:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[5]));
							break;
						case 6:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[6]));
							break;
						case 7:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[7]));
							break;
						case 8:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[8]));
							break;
						case 9:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[9]));
							break;
						case 10:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[10]));
							break;
						case 11:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[11]));
							break;
						case 12:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[12]));
							break;
						case 13:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[13]));
							break;
						case 14:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[14]));
							break;
						case 15:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[15]));
							break;
						case 16:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[16]));
							break;
						case 17:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[17]));
							break;
						case 18:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[18]));
							break;
						case 19:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[19]));
							break;
						case 20:  
							diceFaceImage.setIcon(new ImageIcon(diceImagePaths[20]));
							break;
					}
				}
			}
		}); 
	}
	
	
	// Roll Dice
		public int rollDice() {
			rollValue = randomize.nextInt(20) + 1; 
			return rollValue; 
	}

}

