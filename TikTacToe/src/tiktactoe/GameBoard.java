package tiktactoe;

import tiktactoe.Game.Player;

public class GameBoard 
{
	private Player[] board;
	private int numEmptySpaces;

	
	public GameBoard() 
	{
		numEmptySpaces = 9;
		board = new Player[9];
		
		for( int i = 0; i < 9; i++ )
		{
			board[i] = Player.Empty; 
		}
	}
	
	public void placePiece(Player user, int position)
	{
		board[position] = user; 
	}
	
	public Player getAt(int position)
	{
		return board[position];
	}
	
	@Override
	public String toString() 
	{
		String stringBoard = "";
		
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
		
		return stringBoard;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
