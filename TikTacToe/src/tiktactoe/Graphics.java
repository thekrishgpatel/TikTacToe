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
	JPanel buttonPanel = new JPanel();
    JLabel containerPanel = new JLabel();
    JPanel infoPanel = new JPanel(); 
	
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
        
    
        
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(255,255,255));
        
        for ( int i = 0; i < 9; i++ )
        {
        	button[i] = new JButton();
        	buttonPanel.add(button[i]); 
        	button[i].setFont(new Font("Arial", Font.PLAIN, 40));
        	button[i].addActionListener(this); 
        	
        }
        
        containerPanel.setBackground(new Color(150,150,150));
        containerPanel.setText("TicTacToe");
        containerPanel.setOpaque(true); 
        
        infoPanel.setLayout(new BorderLayout()); 
        infoPanel.setSize(500,300);
        //infoPanel.setBounds(0, 0, 500, 500); 
        
        infoPanel.add(containerPanel); 
        
        frame.add(infoPanel, BorderLayout.NORTH); 
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
		masterGameBoard.placeSymbolAtPosition(p2.symbol, computerPosition);
		checkWin(); 
		user = true; 
		
	}
	
	/*
	public void play(Player p1, Player p2, int i)
	{
		
		while ( masterGameBoard.getWinningSymbol() == playerSymbol.Empty  && !masterGameBoard.isTie() )
		{
			if (p1 instanceof HumanPlayer)
			{
				if (user = true)
				{
					if (button[i].getText() == "")
					{
						button[i].setText("X");
						masterGameBoard.placeSymbolAtPosition(p1.symbol, i);
						user = false; 
						if (check() != 0)
						{
							nextTurn(); 
						}
					}
				}
				
			}
			
			//makeMove(p1, p1.getMove(masterGameBoard));
			//printBoard();
			
			if ( masterGameBoard.getWinningSymbol() == p1.symbol || masterGameBoard.isTie() ) break;
			
			//makeMove(p2, p2.getMove(masterGameBoard));
			//printBoard();
		}
		
	}
	*/ 
	
	
	public void manualPlay(int i)
	{
		if (user = true)
		{
			if (button[i].getText() == "")
			{
				button[i].setText("X");
				masterGameBoard.placeSymbolAtPosition(p1.symbol, i);
				user = false; 
				checkWin(); 
				if (check() != 0)
				{
					nextTurn(); 
				}
			}
		}
	}
	
	public void checkWin()
	{
		if (masterGameBoard.getWinningSymbol() == playerSymbol.X)
		{
			for (int j = 0; j < 9; j++)
			{
				button[j].setEnabled(false);
			}
			System.out.println("X"); 
		}
		else if (masterGameBoard.getWinningSymbol() == playerSymbol.O)
		{
			for (int j = 0; j < 9; j++)
			{
				button[j].setEnabled(false);
			}
			containerPanel.setText("O Wins"); 
			System.out.println("O"); 
		}
		else if (masterGameBoard.isTie())
		{
			for (int j = 0; j < 9; j++)
			{
				button[j].setEnabled(false);
			}
			containerPanel.setText("Tie"); 
			System.out.println("Tie"); 
		}
			
	}

	@Override
	public void actionPerformed(ActionEvent click) 
	{
		for (int i = 0; i < 9; i++)
		{
			if (click.getSource() == button[i])
			{
				manualPlay(i); 
			}
		
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
