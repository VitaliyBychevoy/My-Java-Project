import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MadLibsGUI extends JFrame{
	
	LocalDate date = LocalDate.now();
	private int year = date.getYear();
	private int month = date.getMonthValue();
	private int dayOfMonth = date.getDayOfMonth();
	private DayOfWeek day = date.getDayOfWeek(); 
	
	
	private JTextField txtAdjective;
	private JTextField txtColor;
	private JTextField txtPastTenseVerb;
	private JTextField txtNoun;
	private JTextArea txtResult;
	private JLabel txtDate;
	private String story;
	private String adjective;
	private String color;
	private String pastTenseVerb;
	private String noun;
	private boolean again;
	private JButton btnNewStory;
	private JButton btnChangeColor;
	private int color1 = 51;
	private int color2 = 153;
	private int color3 = 255;
	
	
	public void begin(){	
		story = "";
		color = "";
		adjective = "";
		noun = "";
		pastTenseVerb = "";
		again = false;
		btnNewStory.setVisible(false);
		txtResult.setVisible(false);
		
		
	}
	public void newStory() {
		adjective = txtAdjective.getText();
		color = txtColor.getText();
		pastTenseVerb = txtPastTenseVerb.getText();
		noun = txtNoun.getText();
		story = "The "+ color + " dragon " + pastTenseVerb + " at the " + adjective + " " + noun + " .\nAnd everyone lived happily ever after.\nThe end.";
		txtResult.setVisible(true);
		txtResult.setText(story);
		btnNewStory.setVisible(true);
		
	}
	
	public void changeColor() {
			
		color1 = (int)(Math.random()*1000 );
		while(color1 > 255) {
			color1 = (int)(Math.random()*1000 );
		}
		
		color2 = (int)(Math.random()*1000 );
		
		while(color2 > 255) {
			color2 = (int)(Math.random()*1000 );
		}

		color3 = (int)(Math.random()*1000 );
		
		while(color3 > 255) {
			color3 = (int)(Math.random()*1000 );
		}
		getContentPane().setBackground(new Color(color1, color2, color3));
	}
	public MadLibsGUI() {
		getContentPane().setBackground(new Color(205, 92, 92));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vitalka GUI MadLibsGUI");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VITALKA'S  WECKY MEDLIBS APP ");
		lblNewLabel.setBounds(80, 51, 441, 15);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(color1,color2, color3));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter an Adjective:");
		lblNewLabel_1.setFont(new Font("Humnst777 Blk BT", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(37, 94, 119, 27);
		getContentPane().add(lblNewLabel_1);
		
		txtAdjective = new JTextField();
		txtAdjective.setBounds(163, 98, 86, 20);
		getContentPane().add(txtAdjective);
		txtAdjective.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter a color:");
		lblNewLabel_2.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(303, 100, 84, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtColor = new JTextField();
		txtColor.setBounds(389, 98, 86, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter past tense verb:");
		lblNewLabel_3.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(21, 132, 135, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtPastTenseVerb = new JTextField();
		txtPastTenseVerb.setBounds(163, 133, 86, 20);
		getContentPane().add(txtPastTenseVerb);
		txtPastTenseVerb.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter a noun:");
		lblNewLabel_4.setFont(new Font("Humnst777 Blk BT", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(301, 132, 86, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtNoun = new JTextField();
		txtNoun.setBounds(389, 130, 86, 20);
		getContentPane().add(txtNoun);
		txtNoun.setColumns(10);
		
		JButton btnStory = new JButton("Press here to View Your  story!");
		btnStory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newStory();
			}
		});
		btnStory.setForeground(new Color(139, 0, 139));
		btnStory.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnStory.setBackground(new Color(152, 251, 152));
		btnStory.setBounds(194, 176, 209, 36);
		getContentPane().add(btnStory);
		
		txtResult = new JTextArea();
		txtResult.setForeground(new Color(255, 0, 0));
		txtResult.setFont(new Font("Script MT Bold", Font.BOLD, 14));
		txtResult.setBackground(new Color(255, 105, 180));
		txtResult.setBounds(80, 262, 441, 73);
		getContentPane().add(txtResult);
		
		btnNewStory = new JButton("New story");
		btnNewStory.setForeground(new Color(153, 50, 204));
		btnNewStory.setFont(new Font("Lucida Handwriting", Font.BOLD, 14));
		btnNewStory.setBackground(new Color(102, 205, 170));
		btnNewStory.setBounds(428, 183, 128, 23);
		getContentPane().add(btnNewStory);
		
		btnChangeColor = new JButton("Change Color");
		btnChangeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 changeColor();
			}
		});
		btnChangeColor.setForeground(new Color(106, 90, 205));
		btnChangeColor.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		btnChangeColor.setBackground(new Color(176, 196, 222));
		btnChangeColor.setBounds(21, 168, 119, 27);
		getContentPane().add(btnChangeColor);
		
		txtDate = new JLabel("");
		txtDate.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		txtDate.setText(  day + " " + dayOfMonth + " " +  month + "  "+ year);
		txtDate.setBounds(21, 11, 119, 20);
		
		getContentPane().add(txtDate);
		
		btnNewStory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtAdjective.setText("");
				txtColor.setText("");
				txtPastTenseVerb.setText("");
				txtNoun.setText("");
				txtResult.setText("");
				begin();
			}
		});
	}
	public static void main(String[] args){
		MadLibsGUI theGame = new MadLibsGUI();
		theGame.begin();
		theGame.setSize(new Dimension(800,600));
		theGame.setVisible(true);
	}
}
