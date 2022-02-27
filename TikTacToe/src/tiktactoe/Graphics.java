package tiktactoe;

import java.lang.Object;
import java.util.Random;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

import tiktactoe.Game.playerSymbol;  

public class Graphics extends JFrame implements ItemListener, ActionListener {
	
	JButton button[] = new JButton[9]; 
	JFrame frame; 
	GameBoard masterGameBoard;
	Player p1;
	Player p2;
	
	boolean user = true; 
	
	protected Graphics(GameBoard gameBoard, Player p1, Player p2) 
	{
		this.p1 = p1;
		this.p2 = p2;
		masterGameBoard = gameBoard;
		initialize(); 
		
	}
	
	private void initialize() {
		
		frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        JPanel buttonPanel = new JPanel();
        JLabel containerPanel = new JLabel();
        JPanel infoPanel = new JPanel(); 
        
        infoPanel.setLayout(new BorderLayout()); 
        infoPanel.setBounds(0, 0, 500, 200); 
        
        buttonPanel.setLayout(new GridLayout(3,3));
        
        for ( int i = 0; i < 9; i++ )
        {
        	button[i] = new JButton();
        	buttonPanel.add(button[i]); 
        	button[i].setFont(new Font("Arial", Font.PLAIN, 40));
        	button[i].addActionListener(this); 
        	
        }
        
        containerPanel.setBackground(new Color(255,0,0));
        infoPanel.add(containerPanel); 
        
        frame.add(infoPanel, BorderLayout.SOUTH); 
        frame.add(buttonPanel); 
        	
        //buttonPanel.setPreferredSize(new Dimension(300, 400));
        //containerPanel.add(buttonPanel);
        //frame.getContentPane().add(containerPanel);
        //frame.pack();
        
 
	}

	
	public void setButton() 
	
	{
		// redo 
	}
	
	public int check() {
		int count = 0; 
		
		for (int i = 0; i < 9; i++)
		{
			if (button[i].getText() == "")
			{
				count++; 
			}
		}
		
		return count; 
	}
	
	public void nextTurn() {
//		Random rand = new Random();
//		int computerPosition = rand.nextInt(9);
		
		int computerPosition = p1.getMove(masterGameBoard);
		
		while (button[computerPosition].getText() != "")
		{
			computerPosition = p1.getMove(masterGameBoard);
//			computerPosition = rand.nextInt(9);
		}
		
		button[computerPosition].setText("O");
		user = true; 
		
	}
	

	@Override
	public void actionPerformed(ActionEvent click) 
	{
		for (int i = 0; i < 9; i++)
		{
			if (click.getSource() == button[i])
			{
				if (user == true)
				{
					if (button[i].getText() == "")
					{
						button[i].setText("X");
						user = false; 
						if (check() != 0)
						{
							nextTurn(); 
						}
					}
				}
			}
		
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
