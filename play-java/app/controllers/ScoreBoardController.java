package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.Player;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ScoreBoardController extends Controller {
 // Display an empty form in the view
 
    public Result ScoreBoard() {
		
		
       List<Player> player = Player.findAll();
        
        
        return ok(ScoreBoard.render(player));
	}
	
}