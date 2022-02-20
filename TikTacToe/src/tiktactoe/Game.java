package tiktactoe;

public class Game 
{
	
	//Master GameBoard
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
		//find a piece of the player
		//index i, is the first piece of the player
		int i;
		for ( i = 0; i < 9 && gameBoard[i] != user ; i++ )
		{
			;
		}
		
		//All winning positions require the first located piece to be one of these (0,1,2,3,6)
		if ( i == 0 || i == 1 || i == 2 || i == 3 || i == 6 )
		{
			//check if a column is made
			if ( gameBoard[(i + 3) % 9] == user &&  gameBoard[(i + 6) % 9] == user )
			{
				return true;
			}
			
			//check if a row is made
			//TODO: The mod 3 does not work
			if ( gameBoard[i+1] == user && gameBoard[i+2] == user )
			{
				return true;
			}
			
			//check if a diagonal is made
			if( i == 0 || i== 8 )
			{
				if ( gameBoard[(i+4)%9] == user && gameBoard[(i+8)%9] == user )
				{
					return true;
				}
			}
			else
			{
				if ( gameBoard[(i+2)%9] == user && gameBoard[(i+4)%9] == user )
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
		gameBoard[position] = user;
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
		return (gameBoard[position] == Player.Empty) ? true : false;
	}
	
	/**
	 * This method prints the board, using a for loop to traverse through the gameBoard
	 * @param NullPointerException 
	 * @throws Exception 
	 */
	public void printBoard()
	{
		String board = "";
		
		for ( int i = 0; i < 9; i++ )
		{
			if ( gameBoard[i] == null )
			{
				throw new NullPointerException("GameBoard cannot be null");
			}
			switch (gameBoard[i]) 
			{
				case X: 
					board = board.concat("X");
					break;
				case O:
					board = board.concat("O");
					break;
				case Empty:
					board = board.concat(" ");
					break;
				default:
					System.out.println("Something Went Wrong");
			}
			
			if( i == 2 || i == 5 )
			{
				board = board.concat("\n");
				board = board.concat("--------\n");
			}
			
			if( i%3 != 2 )
			{
				board = board.concat(" | ");
			}
			

		}
		
		System.out.println(board);
		return;
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
