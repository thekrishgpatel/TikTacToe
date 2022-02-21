package tiktactoe;
import java.util.*;
import tiktactoe.Game.*;

public class HumanPlayer extends Player
{

	public HumanPlayer(playerSymbol symbol) 
	{
		super(symbol);
	}

	
	@Override
	public int getMove() 
	{		
		System.out.print("Your Position: ");
		return (new Scanner(System.in)).nextInt();
	}


}
