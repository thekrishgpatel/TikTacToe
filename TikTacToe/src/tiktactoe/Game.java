package tiktactoe;

public class Game 
{
	
	private Player[] gameBoard;
	
	public enum Player
	{
		X,
		O,
		Empty
		
	}
	
	/**
	 * Generic Constructor of the Game class, representing all squares as empty players to begin with
	 */
	public Game() 
	{
		gameBoard = new Player[9];
		
		for( int i = 0; i < 9; i++ )
		{
			gameBoard[i] = Player.Empty;
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
