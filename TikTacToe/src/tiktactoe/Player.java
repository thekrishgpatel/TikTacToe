package tiktactoe;
import java.util.ArrayList;

import tiktactoe.Game.*;

public abstract class Player 
{
	playerSymbol symbol;

	public Player(playerSymbol symbol) 
	{
		this.symbol = symbol;
	}
	
	public abstract int getMove(Game game);
}
