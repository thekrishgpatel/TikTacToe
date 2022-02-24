package tiktactoe;

import tiktactoe.Game.playerSymbol;

public class Tester {

	public static void main(String[] args) 
	{
		Game g1 = new Game();
//		RandomComputerPlayer p1 = new RandomComputerPlayer(playerSymbol.X);
		HumanPlayer p1 = new HumanPlayer(playerSymbol.X);
		SmartComputerPlayer h2 = new SmartComputerPlayer(playerSymbol.O);
//		RandomComputerPlayer h2 = new RandomComputerPlayer(playerSymbol.O);
		
		while ( !g1.isWon(h2.symbol) && !g1.isWon(p1.symbol) )
		{
			g1.makeMove(p1, p1.getMove(g1,g1.masterGameBoard.availablePositions));
			g1.printBoard();
			g1.makeMove(h2, h2.getMove(g1,g1.masterGameBoard.availablePositions));
			g1.printBoard();
		}
		
		if ( g1.isWon(h2.symbol)  )
		{
			if( h2.symbol == playerSymbol.X )
				System.out.println("X has won" );
			else
				System.out.println("O has won" );	
		}
		else
		{
			if( p1.symbol == playerSymbol.X )
				System.out.println("X has won" );
			else
				System.out.println("O has won" );
		}

	}

}
