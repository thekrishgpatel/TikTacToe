package tiktactoe;

import java.util.ArrayList;

import tiktactoe.Game.playerSymbol;

public class GameBoard 
{
	private playerSymbol[] board;
	private int numEmptySpaces;
	//The usage of the below member data is not yet implemented 
	ArrayList<Integer> availablePositions;

	
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
	
	public void placePiece(playerSymbol symbol, int position)
	{

		board[position] = symbol;
		
		//removes the number position from the arraylist of available positions
		for( int i = 0; i < availablePositions.size(); i++ )
		{
			if ( availablePositions.get(i) == position )
			{
				availablePositions.remove(i);
			}
		}
	}
	
	public playerSymbol getAt(int position)
	{
		return board[position];
	}
	
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
	
	public void removePostion( int position )
	{
		board[position] = playerSymbol.Empty;
	}
	

}
