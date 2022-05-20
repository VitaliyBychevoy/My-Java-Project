import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame{
	
	private static final long serialVersionUID = -4465997357046781244L;
	
	private JTextField txtGuess;
	
	private JLabel lblOutput;
	
	private int theNumber;
	
	private int timeOfTryes =  0;
	
	private int tryes = 0; 
	
	JButton btnPlayAgain;

	public void checkGuess(){
		String guessText = txtGuess.getText();
		
		String message = "";
		
		try {
		
		int guess = Integer.parseInt(guessText);
		
		if( tryes > 1) {
			
		
		if( guess < theNumber) {
			
			tryes--;
			
			message = guess +" is too low. Try again.\nYou have " + tryes + " tryes.";
			
			timeOfTryes++;
			
		
		}else if( guess > theNumber){
			
			tryes--;
		
			message = guess + " is too high. Try again.\nYou have " + tryes + " tryes." ;
			
			timeOfTryes++;
			
			
		} else {
			
			message = guess + " is correct. You win after "+ timeOfTryes + " tres!";
					
			btnPlayAgain.setVisible(true);
		}
		}else {
			
			message = "You spend all tryes. Start again.\n The number is " + theNumber + " .";
			btnPlayAgain.setVisible(true);
		}
		}catch (Exception e) {
			
			message = "Enter a whole  number between 1 and 100";
			
		}finally{
		
		lblOutput.setText(message);
		
		txtGuess.requestFocus();
		
		txtGuess.selectAll();
		
		}
		
	}
	
	public void newGame() {
		
		theNumber = (int)(Math.random()*100+1);
		
		timeOfTryes =  1;
		
		tryes = 7; 
		
		btnPlayAgain.setVisible(false);
		
		
		String startMessage  = "You have 7 tryes.";
		
		lblOutput.setText(startMessage);
	}
	public GuessingGame() {
		getContentPane().setBackground(new Color(173, 255, 47));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vitalik's  Hi-Lo  Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vitalik's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 11, 351, 69);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 60, 290, 57);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBackground(new Color(51, 255, 255));
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(350, 80, 68, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				checkGuess();
			}
		});
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setFont(new Font("Showcard Gothic", Font.PLAIN, 14));
		btnGuess.setForeground(new Color(51, 51, 255));
		btnGuess.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			checkGuess();
			}
		});
		btnGuess.setBackground(new Color(255, 51, 255));
		btnGuess.setBounds(151, 143, 89, 42);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above click  Guess!");
		lblOutput.setFont(new Font("Script MT Bold", Font.PLAIN, 14));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(50, 180, 349, 57);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play again");
		btnPlayAgain.setFont(new Font("Hot Mustard BTN", Font.PLAIN, 13));
		btnPlayAgain.setBackground(Color.BLUE);
		btnPlayAgain.setForeground(Color.ORANGE);
		btnPlayAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
		btnPlayAgain.setBounds(262, 143, 137, 42);
		getContentPane().add(btnPlayAgain);
	}

	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
	       final  GuessingGame instance = new  GuessingGame();
	      
	        final String imgPath = "resourses/Guess.ico";
	        instance.setIconImage(
	                Toolkit.getDefaultToolkit().getImage( GuessingGame.class.getResource(imgPath)));

	        instance.setVisible(true);
		
		
		GuessingGame theGame = new GuessingGame();
		
		theGame.newGame();
		
		theGame.setSize( new Dimension (450, 300));
		
		theGame.setVisible(true);

	}
}
