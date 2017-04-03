package models ;

public class Game{
	
	public static boolean started;
	
	public Game(){
		started = false;
	}
	
	
	
	public static void startGame()
	{
		started = true;
	}		
}