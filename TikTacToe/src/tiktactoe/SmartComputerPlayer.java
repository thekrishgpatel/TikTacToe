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
				int score = minimax(game, availableSpots);
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
	
	public int minimax(Game game, ArrayList<Integer> availableSpots)
	{
	
		playerSymbol winnerSymbol = game.getWinner();
		
		if ( winnerSymbol == this.symbol )
		{
			return 1; // * availiableSpots
		}
		else if ( winnerSymbol != playerSymbol.Empty )
		{
			return -1; // * availiableSpots
		}
		else
		{
			return 0;
		}
		
		if (isMax) // comnputer player
		{
			int bestScore = Integer.MIN_VALUE;
			
			for ( int i = 0; i < 9; i++ )
			{
				// is available 
				if ( game.isPositionValid(i) )
				{
					game.makeMove(this, i);
					int score = minimax(game, availableSpots); // subtract 1
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
					game.makeMove(this, i);
					int score = minimax(game, availableSpots); // subtract 1
					game.removePosition(i);
					
					if ( score < bestScore )
					{
						bestScore = score;
					}
					
				}
			}
			
			return bestScore; 
		}
		
//		
//		if ( winnerSymbol != null )
//		{
//			
//		}
//
//		boolean isWon = game.isWon(null);

	}

	
}
