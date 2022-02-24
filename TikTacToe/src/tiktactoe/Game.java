package tiktactoe;

public class Game 
{
	
	//Master GameBoard
	public GameBoard masterGameBoard;
	
	public enum playerSymbol
	{
		X,
		O,
		Empty
		
	}
	
	/**
	 * Generic Constructor of the Game class
	 */
	public Game() 
	{
		masterGameBoard = new GameBoard();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isWon( playerSymbol symbol )
	{
	
		if ( masterGameBoard.getAt(0) == symbol && masterGameBoard.getAt(1) == symbol && masterGameBoard.getAt(2) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(3) == symbol && masterGameBoard.getAt(4) == symbol && masterGameBoard.getAt(5) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(6) == symbol && masterGameBoard.getAt(7) == symbol && masterGameBoard.getAt(8) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(0) == symbol && masterGameBoard.getAt(3) == symbol && masterGameBoard.getAt(6) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(1) == symbol && masterGameBoard.getAt(4) == symbol && masterGameBoard.getAt(7) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(2) == symbol && masterGameBoard.getAt(5) == symbol && masterGameBoard.getAt(8) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(0) == symbol && masterGameBoard.getAt(4) == symbol && masterGameBoard.getAt(8) == symbol )
		{
			return true;
		}
		if ( masterGameBoard.getAt(2) == symbol && masterGameBoard.getAt(4) == symbol && masterGameBoard.getAt(6) == symbol )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method places a player at a location 'position'
	 * @param user
	 * @param position
	 * @return
	 */
	public void makeMove(Player player, int position)
	{
		
		while ( !isPositionValid(position) )
		{
			position = player.getMove(this, masterGameBoard.availablePositions);
		}

		masterGameBoard.placePiece(player.symbol, position);

		return;
	}
	
	/**
	 * This method returns a boolean telling whether a move at location 'position' is valid
	 * @param position
	 * @return
	 */
	public boolean isPositionValid(int position)
	{
		//checks if a move at index 'position' is valid or not
		return (masterGameBoard.getAt(position) == playerSymbol.Empty) ? true : false;
	}
	
	/**
	 * This method calls the GameBoard class' toString method, in order to print the current state of the board
	 */
	public void printBoard()
	{
		System.out.println(masterGameBoard);
	}

	
	/**
	 * Using a minimax tree, the method will return a integer representing the next best move for the computer
	 * @param user
	 * @return
	 */
	//TODO: Create the minimax tree, and means of move selection
	public int findNextMove(playerSymbol user)
	{
		return Integer.MIN_VALUE;
	}
	
	public playerSymbol getWinner()
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
	
	public void removePosition( int position )
	{
		masterGameBoard.removePostion(position);
	}

}
