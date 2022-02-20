package tiktactoe;

public class Game 
{
	
	//Master GameBoard
	private GameBoard masterGameBoard;
	
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
		masterGameBoard = new GameBoard();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isWon(Player user)
	{
		//find a piece of the player
		//index i, is the first piece of the player
		int i;
		for ( i = 0; i < 9 && masterGameBoard.getAt(i) != user ; i++ )
		{
			;
		}
		
		//All winning positions require the first located piece to be one of these (0,1,2,3,6)
		if ( i == 0 || i == 1 || i == 2 || i == 3 || i == 6 )
		{
			//check if a column is made
			if ( masterGameBoard.getAt((i + 3) % 9) == user &&  masterGameBoard.getAt((i + 6) % 9) == user )
			{
				return true;
			}
			
			//check if a row is made
			//TODO: The mod 3 does not work
			if ( masterGameBoard.getAt(i+1) == user && masterGameBoard.getAt(i+2) == user )
			{
				return true;
			}
			
			//check if a diagonal is made
			if( i == 0 || i== 8 )
			{
				if ( masterGameBoard.getAt((i+4)%9) == user && masterGameBoard.getAt((i+8)%9) == user )
				{
					return true;
				}
			}
			else
			{
				if ( masterGameBoard.getAt((i+2)%9) == user && masterGameBoard.getAt((i+4)%9) == user )
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
	public void makeMove(Player user, int position)
	{
		if( validMove(position) )
		{
			masterGameBoard.placePiece(user, position);
		}
		else
		{
			System.out.println("This is not a valid move");
		}
		return;
	}
	
	/**
	 * This method returns a boolean telling whether a move at location 'position' is valid
	 * @param position
	 * @return
	 */
	private boolean validMove(int position)
	{
		//checks if a move at index 'position' is valid or not
		return (masterGameBoard.getAt(position) == Player.Empty) ? true : false;
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
	public int findNextMove(Player user)
	{
		return Integer.MIN_VALUE;
	}
	
	
	public static void main(String[] args) 
	{
		Game g1 = new Game();
		
		g1.makeMove(Player.X, 6);
		g1.makeMove(Player.X, 4);
		g1.makeMove(Player.X, 2);
		
		g1.printBoard();
 		System.out.println( g1.isWon(Player.X) );

	}

}
