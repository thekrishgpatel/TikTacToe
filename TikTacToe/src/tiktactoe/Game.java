package tiktactoe;

public class Game 
{
	
	//Master GameBoard
	private Player[] gameBoard;
	private boolean start = false;
	
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
			makeMove(Player.Empty, i);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isWon(Player user)
	{
		return true;
	}
	
	/**
	 * This method places a player at a location 'position'
	 * @param user
	 * @param position
	 * @return
	 */
	private void makeMove(Player user, int position)
	{
		return;
	}
	
	/**
	 * This method returns a boolean telling whether a move at location 'position' is valid
	 * @param position
	 * @return
	 */
	private boolean validMove(int position)
	{
		return false;
	}
	
	/**
	 * This method prints the board, using a for loop to traverse through the gameBoard
	 */
	public void printBoard()
	{
		return;
	}
	
	/**
	 * Using a minimax tree, the method will return a integer representing the next best move for the computer
	 * @param user
	 * @return
	 */
	public int findNextMove(Player user)
	{
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
