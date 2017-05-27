package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;


import akka.actor.*;
import play.libs.F.*;
import play.mvc.WebSocket;
import play.mvc.LegacyWebSocket;



/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ScoreBoardController extends Controller {
 
    public Result ScoreBoard() {
		
		
       List<Player> player = Player.findAll();
        
        Collections.sort(player);

        return ok(ScoreBoard.render(User.getLoggedIn(session().get("email")),player));

	}
	
	
	
}