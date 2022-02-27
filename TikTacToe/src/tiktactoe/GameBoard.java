package tiktactoe;

import java.util.ArrayList;

import tiktactoe.Game.playerSymbol;

public class GameBoard 
{
	public playerSymbol[] board;
	public int numEmptySpaces;
	//The usage of the below member data is not yet implemented 
	ArrayList<Integer> availablePositions;

	/**
	 * Generic Constructor
	 */
	public GameBoard() 
	{
		numEmptySpaces = 9;
		board = new playerSymbol[9];
		availablePositions = new ArrayList<>();
		
		for( int i = 0; i < 9; i++ )
		{
			availablePositions.add(i);
			board[i] = playerSymbol.Empty; 
		}
	}
	
	/**
	 * This method places a piece at the specified position
	 * @param symbol
	 * @param position
	 */
	public void placeSymbolAtPosition(playerSymbol symbol, int position)
	{

		board[position] = symbol;
		
		//removes the number position from the arraylist of available positions
		numEmptySpaces--;
	}
	
	/**
	 * This method returns the player symbol at the specified postion
	 * @param position
	 * @return
	 */
	public playerSymbol getSymbolAtPosition(int position)
	{
		return board[position];
	}
	
	/**
	 * This method removes the piece at the specified position
	 * @param position
	 */
	public void removeSymbolAtPosition( int position )
	{
		board[position] = playerSymbol.Empty;
		numEmptySpaces++;
	}
	
	
	/**
	 * This method returns a boolean telling whether a move at location 'position' is valid
	 * @param position
	 * @return
	 */
	public boolean isPositionEmpty(int position)
	{
		//checks if a move at index 'position' is valid or not
		return (getSymbolAtPosition(position) == playerSymbol.Empty) ? true : false;
	}
	
	
	
	/**
	 * This method returns the symbol of the player in a winning position. If no player is in a winning position an EMPTY player is returned
	 * @return
	 */
	public playerSymbol getWinningSymbol()
	{
		playerSymbol winner = playerSymbol.Empty;
		if (  isWon(playerSymbol.O) )
		{
			winner = playerSymbol.O;
		}
		else if(  isWon(playerSymbol.X) )
		{
			winner = playerSymbol.X;
		}
		
		return winner;
	}
	
	

	/**
	 * This method assists in the checking of the state of the game. This method returns true if the symbol, passed as a parameter, won and false otherwise
	 * @param symbol
	 * @return
	 */
	private boolean isWon( playerSymbol symbol )
	{
	
		if ( getSymbolAtPosition(0) == symbol && getSymbolAtPosition(1) == symbol && getSymbolAtPosition(2) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(3) == symbol && getSymbolAtPosition(4) == symbol && getSymbolAtPosition(5) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(6) == symbol && getSymbolAtPosition(7) == symbol && getSymbolAtPosition(8) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(0) == symbol && getSymbolAtPosition(3) == symbol && getSymbolAtPosition(6) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(1) == symbol && getSymbolAtPosition(4) == symbol && getSymbolAtPosition(7) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(2) == symbol && getSymbolAtPosition(5) == symbol && getSymbolAtPosition(8) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(0) == symbol && getSymbolAtPosition(4) == symbol && getSymbolAtPosition(8) == symbol )
		{
			return true;
		}
		if ( getSymbolAtPosition(2) == symbol && getSymbolAtPosition(4) == symbol && getSymbolAtPosition(6) == symbol )
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * This method assists in the checking of the state of the game, returning true if the game is a tie. A tie is a position in the game where there are
	 * no more viable moves and neither player is in a winning position
	 * @return
	 */
	public boolean isTie() 
	{
		return (numEmptySpaces <= 0 && getWinningSymbol() == playerSymbol.Empty) ? true : false;
	}
	
	
	/**
	 * This method returns a deep clone of a game object
	 */
	public GameBoard clone()
	{
		GameBoard clonedBoard = new GameBoard();
		
		for ( int i = 0 ; i < clonedBoard.board.length; i++ )
		{
			clonedBoard.board[i] = this.board[i]; 
		}
		
		clonedBoard.numEmptySpaces = this.numEmptySpaces;
		
		
		return clonedBoard;
	}
	
	
	/**
	 * This method overrides the existing toString method, to print the current state of the game
	 */
	@Override
	public String toString() 
	{
		String stringBoard = "\n";
		
		for ( int i = 0; i < 9; i++ )
		{
			if ( board[i] == null )
			{
				throw new NullPointerException("GameBoard cannot be null");
			}
			switch (board[i]) 
			{
				case X: 
					stringBoard = stringBoard.concat("X");
					break;
				case O:
					stringBoard = stringBoard.concat("O");
					break;
				case Empty:
					stringBoard = stringBoard.concat(" ");
					break;
				default:
					System.out.println("Something Went Wrong");
			}
			
			if( i == 2 || i == 5 )
			{
				stringBoard = stringBoard.concat("\n");
				stringBoard = stringBoard.concat("--------\n");
			}
			
			if( i%3 != 2 )
			{
				stringBoard = stringBoard.concat(" | ");
			}
			

		}
		
		return stringBoard + "\n";
	}
	
	

}
