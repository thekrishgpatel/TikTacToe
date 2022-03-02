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
	public int getMove(GameBoard gameBoard) 
	{
		
		int bestScore = Integer.MIN_VALUE;
		int move = Integer.MIN_VALUE;
		
//		if( gameBoard.isPositionEmpty(4) )
//		{
//			System.out.println("called");
//			return 4;
//		}
		
		for ( int i = 0; i < 9; i++ )
		{
			// is available 
			if ( gameBoard.isPositionEmpty(i) )
			{
				gameBoard.placeSymbolAtPosition(symbol, i);
				//game.makeMove(this, i);
				int score = minimax(gameBoard.clone(), false);
				gameBoard.removeSymbolAtPosition(i);
				//game.removePosition(i);
				
				if ( score > bestScore )
				{
					bestScore = score;
					move = i;
				}
				
			}
		}
		return move;
		
	}
	
	public int minimax(GameBoard gameBoard, boolean isMaximizing)
	{
		//if isMaximizing is true, we are looking for computer players move
	
		playerSymbol winnerSymbol = gameBoard.getWinningSymbol();
		
		if ( winnerSymbol == this.symbol )
		{
			return 1 + gameBoard.numEmptySpaces; // if game is won
		}
		else if ( winnerSymbol != playerSymbol.Empty )
		{
			return -1 - gameBoard.numEmptySpaces; // if game is lost
		}
		else if(gameBoard.isTie()) //if game is a tie
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
					if ( gameBoard.isPositionEmpty(i) )
					{
						gameBoard.placeSymbolAtPosition(this.symbol,i);
						int score = minimax(gameBoard.clone(), false); // subtract 1 also set to opposite Symbol
						gameBoard.removeSymbolAtPosition(i);
						
						if ( score > bestScore )
						{
							bestScore = score;
						}
						
					}
				}
				
				return bestScore; 
			}
			else 
			{ // human player
				
				int bestScore = Integer.MAX_VALUE;
				
				for ( int i = 0; i < 9; i++ )
				{
					// is available 
					if ( gameBoard.isPositionEmpty(i) )
					{
						//find the opposite symbol
						if( this.symbol == playerSymbol.X )
						{
							gameBoard.placeSymbolAtPosition(playerSymbol.O, i);
						}
						else
						{
							gameBoard.placeSymbolAtPosition(playerSymbol.X, i);
						}
						
						
						int score = minimax(gameBoard.clone(), true); // subtract 1 also set to opposite Symbol
						gameBoard.removeSymbolAtPosition(i);
						
						bestScore = Integer.min(score, bestScore);
						
					}
				}
				
				return bestScore; 
			}
		}
	}

	
}
