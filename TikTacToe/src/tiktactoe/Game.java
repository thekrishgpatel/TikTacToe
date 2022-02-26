package tiktactoe;

import tiktactoe.Game.playerSymbol;

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
	 * Generic Constructor
	 */
	public Game() 
	{
		masterGameBoard = new GameBoard();
	}
	

	/**
	 * This method assists in the checking of the state of the game. This method returns true if the symbol, passed as a parameter, won and false otherwise
	 * @param symbol
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
	 * This method assists in the checking of the state of the game, returning true if the game is a tie. A tie is a position in the game where there are
	 * no more viable moves and neither player is in a winning position
	 * @return
	 */
	public boolean isTie() 
	{
		return (masterGameBoard.numEmptySpaces <= 0 && isWon(playerSymbol.O) == false && isWon(playerSymbol.X) == false) ? true : false;
	}
	
	
	/**
	 * This method gets receives the intended move of the player and checks if that move would be valid. If so the method places a piece at that position
	 * @param player
	 * @param position
	 */
	public void makeMove(Player player, int position)
	{
		
		while ( !isPositionValid(position) )
		{
			position = player.getMove(this);
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
	 * This method returns the symbol of the player in a winning position. If no player is in a winning position an EMPTY player is returned
	 * @return
	 */
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
	
	
	/**
	 * This method returns a deep clone of a game object
	 */
	public Game clone()
	{
		Game clone = new Game();
		
		for ( int i = 0 ; i < this.masterGameBoard.board.length; i++ )
		{
			clone.masterGameBoard.board[i] = this.masterGameBoard.board[i]; 
		}
		
		clone.masterGameBoard.numEmptySpaces = this.masterGameBoard.numEmptySpaces;
		
		
		return clone;
	}
	
	/**
	 * This method is used as a helper function in the minimax method, by removing a piece once placed at a certain postion
	 * @param position
	 */
	public void removePosition( int position )
	{
		masterGameBoard.removePostion(position);
	}
	
	/**
	 * This method takes in two players and begins the game of tiktactoe
	 * @param p1
	 * @param p2
	 */
	public void play( Player p1, Player p2 )
	{
		while ( !isWon(p1.symbol) && !isWon(p2.symbol) && !isTie() )
		{
			makeMove(p1, p1.getMove(this));
			printBoard();
			
			if ( isWon(p1.symbol) || isTie() ) break;
			
			makeMove(p2, p2.getMove(this));
			printBoard();
		}
		
		if ( isWon(p1.symbol)  )
		{
			if( p1.symbol == playerSymbol.X )
				System.out.println("X has won" );
			else
				System.out.println("O has won" );	
		}
		else if ( isWon(p2.symbol) )
		{
			if( p2.symbol == playerSymbol.X )
				System.out.println("X has won" );
			else
				System.out.println("O has won" );
		}
		else
		{
			System.out.println("Game ended in a tie");
		}

	}

}
