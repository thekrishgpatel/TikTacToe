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
	public boolean isWon( Player player )
	{
		//find a piece of the player
		//index i, is the first piece of the player
		int i;
		for ( i = 0; i < 9 && masterGameBoard.getAt(i) != player.symbol ; i++ )
		{
			;
		}
		
		//All winning positions require the first located piece to be one of these (0,1,2,3,6)
		if ( i == 0 || i == 1 || i == 2 || i == 3 || i == 6 )
		{
			//check if a column is made
			if ( masterGameBoard.getAt((i + 3) % 9) == player.symbol &&  masterGameBoard.getAt((i + 6) % 9) == player.symbol )
			{
				return true;
			}
			
			//check if a row is made
			if ( masterGameBoard.getAt(i+1) == player.symbol && masterGameBoard.getAt(i+2) == player.symbol )
			{
				return true;
			}
			
			//check if a diagonal is made
			if( i == 0 || i== 8 )
			{
				if ( masterGameBoard.getAt((i+4)%9) == player.symbol && masterGameBoard.getAt((i+8)%9) == player.symbol )
				{
					return true;
				}
			}
			else
			{
				if ( masterGameBoard.getAt((i+2)%9) == player.symbol && masterGameBoard.getAt((i+4)%9) == player.symbol )
				{
					return true;
				}
			}
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
		
		playerSymbol symbol = player.symbol; 
		
		while ( !isPositionValid(position) )
		{
			position = player.getMove();
		}

		masterGameBoard.placePiece(symbol, position);

		return;
	}
	
	/**
	 * This method returns a boolean telling whether a move at location 'position' is valid
	 * @param position
	 * @return
	 */
	private boolean isPositionValid(int position)
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


}
