package tiktactoe;

import java.util.ArrayList;

import tiktactoe.Game.*;

public class SmartComputerPlayer extends Player
{
	public SmartComputerPlayer(playerSymbol symbol) 
	{
		super(symbol);
	}

	//The below will implement the minimax algorithm
	@Override
	public int getMove(Game game, ArrayList<Integer> availableSpots) 
	{
		
		int bestScore = Integer.MIN_VALUE;
		int move = Integer.MIN_VALUE;
		
		for ( int i = 0; i < 9; i++ )
		{
			// is available 
			if ( game.isPositionValid(i) )
			{
				game.makeMove(this, i);
				int score = minimax(game.clone(), false);
				game.removePosition(i);
				
				if ( score > bestScore )
				{
					bestScore = score;
					move = i;
				}
				
			}
		}
		return move;
		
	}
	
	public int minimax(Game game, boolean isMaximizing)
	{
		//if isMaximizing is true, we are looking for computer players move
	
		playerSymbol winnerSymbol = game.getWinner();
		
		if ( winnerSymbol == this.symbol )
		{
			return 1 * game.masterGameBoard.numEmptySpaces; // if game is won
		}
		else if ( winnerSymbol != playerSymbol.Empty )
		{
			return -1 * game.masterGameBoard.numEmptySpaces; // if game is lost
		}
		else if(game.isTie()) //if game is a tie
		{
			return 0;
		}
		else
		{
			if (isMaximizing) // computer player
			{
				int bestScore = Integer.MIN_VALUE;
				
				for ( int i = 0; i < 9; i++ )
				{
					// is available 
					if ( game.isPositionValid(i) )
					{
						game.makeMove(this, i);
						int score = minimax(game.clone(), false); // subtract 1 also set to opposite Symbol
						game.removePosition(i);
						
						if ( score > bestScore )
						{
							bestScore = score;
						}
						
					}
				}
				
				return bestScore; 
			}
			
			else { // human player
				
				int bestScore = Integer.MAX_VALUE;
				
				for ( int i = 0; i < 9; i++ )
				{
					// is available 
					if ( game.isPositionValid(i) )
					{
						//find the opposite symbol
						if( this.symbol == playerSymbol.X )
						{
							game.makeMove(new HumanPlayer(playerSymbol.O), i);
						}
						else
						{
							game.makeMove(new HumanPlayer(playerSymbol.X), i);
						}
						
						
						int score = minimax(game.clone(), true); // subtract 1 also set to opposite Symbol
						game.removePosition(i);

						
						bestScore = Integer.min(score, bestScore);
						
					}
				}
				
				return bestScore; 
			}
		}
	}

	
}
