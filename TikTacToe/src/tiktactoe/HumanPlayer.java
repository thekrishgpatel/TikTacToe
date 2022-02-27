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
	public int getMove(GameBoard gameBoard) 
	{		
		System.out.print("Your Position: ");
		
		Scanner scanner = new Scanner(System.in);
		int move = scanner.nextInt();
		
		while ( move < 0 || move > 8)
		{
			System.out.print("Your Position: ");
			move = scanner.nextInt();
		}
		
		return move;
	}


}
