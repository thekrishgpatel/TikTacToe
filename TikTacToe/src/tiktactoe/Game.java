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
	 * This method gets receives the intended move of the player and checks if that move would be valid. If so the method places a piece at that position
	 * @param player
	 * @param position
	 */
	public void makeMove(Player player, int position)
	{
		
		while ( !masterGameBoard.isPositionEmpty(position) )
		{
			position = player.getMove(masterGameBoard);
		}

		masterGameBoard.placeSymbolAtPosition(player.symbol, position);

		return;
	}
	
	/**
	 * This method calls the GameBoard class' toString method, in order to print the current state of the board
	 */
	public void printBoard()
	{
		System.out.println(masterGameBoard);
	}


	/**
	 * This method takes in two players and begins the game of tiktactoe
	 * @param p1
	 * @param p2
	 */
	public void play( Player p1, Player p2 )
	{
		while ( masterGameBoard.getWinningSymbol() == playerSymbol.Empty  && !masterGameBoard.isTie() )
		{
			makeMove(p1, p1.getMove(masterGameBoard));
			printBoard();
			
			if ( masterGameBoard.getWinningSymbol() == p1.symbol || masterGameBoard.isTie() ) break;
			
			makeMove(p2, p2.getMove(masterGameBoard));
			printBoard();
		}
		
		switch (masterGameBoard.getWinningSymbol()) 
		{
			case X:
				System.out.println("X has won" );
				break;
				
			case O:
				System.out.println("O has won" );
				break;
	
			case Empty:
				System.out.println("Game ended in a tie");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value");
		}
	}
	
	public void playWithGraphics(Player p1, Player p2, playerSymbol restart)
	{
		Graphics c = new Graphics(masterGameBoard, p1, p2, restart);  
	}
	

}
