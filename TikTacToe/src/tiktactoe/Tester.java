package tiktactoe;

import tiktactoe.Game.playerSymbol;

public class Tester {

	public static void main(String[] args) 
	{
		Game g1 = new Game();
		g1.playWithGraphics(new SmartComputerPlayer(playerSymbol.X), new HumanPlayer(playerSymbol.O), playerSymbol.Empty);
		
//		g1.play( new SmartComputerPlayer(playerSymbol.O), new HumanPlayer(playerSymbol.X) );
//		g1.play( new SmartComputerPlayer(playerSymbol.O), new SmartComputerPlayer(playerSymbol.X) );
//		g1.play( new SmartComputerPlayer(playerSymbol.O), new RandomComputerPlayer(playerSymbol.X) );
//		Graphics c = new Graphics();  
//		c.setButton(); 
//		g1.play( new SmartComputerPlayer(playerSymbol.O), new RandomComputerPlayer(playerSymbol.X) );;  
//		c.setButton(); 
	}

}
