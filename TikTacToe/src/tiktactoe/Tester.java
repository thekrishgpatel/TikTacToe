package tiktactoe;

import tiktactoe.Game.playerSymbol;

public class Tester {

	public static void main(String[] args) 
	{
		Game g1 = new Game();
		
		g1.play(new HumanPlayer(playerSymbol.O), new HumanPlayer(playerSymbol.X) );
	}

}
