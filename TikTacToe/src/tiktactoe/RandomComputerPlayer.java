package tiktactoe;
import tiktactoe.Game.*;
import java.util.Random;

public class RandomComputerPlayer extends Player 
{
	public RandomComputerPlayer(playerSymbol symbol)
	{
		super(symbol);
	}

	@Override
	public int getMove() 
	{
		Random rand = new Random();
		return rand.nextInt(9);
	}
}
