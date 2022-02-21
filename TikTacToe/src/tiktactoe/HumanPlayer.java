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
		return (new Scanner(System.in)).nextInt();
	}


}
