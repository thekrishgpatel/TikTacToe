package tiktactoe;

import tiktactoe.Game.playerSymbol;

public class Tester {

	public static void main(String[] args) 
	{
		Game g1 = new Game();
		RandomComputerPlayer p1 = new RandomComputerPlayer(playerSymbol.X);
		HumanPlayer h2 = new HumanPlayer(playerSymbol.O);
//		RandomComputerPlayer h2 = new RandomComputerPlayer(playerSymbol.O);
		
		while ( !g1.isWon(h2) && !g1.isWon(p1) )
		{
			g1.makeMove(p1, p1.getMove());
			g1.printBoard();
			g1.makeMove(h2, h2.getMove());
			g1.printBoard();
		}
		
		if ( g1.isWon(h2)  )
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
