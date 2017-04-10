package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;

import views.html.levels.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class GameController extends Controller {
 // Display an empty form in the view
 //@Security.Authenticated(Secured.class)
 //@With(CheckIfAdmin.class)
 
    public Result Level() {
		Form<Level> levelForm = Form.form(Level.class);
		Player play = (Player)User.getLoggedIn(session().get("email"));
		
		switch(play.level){
			case 1:
				return ok(level1.render(User.getLoggedIn(session().get("email")),levelForm));
			
			case 2:
				return ok(level2.render(User.getLoggedIn(session().get("email")),levelForm));
			
		}
		return ok();
			
	}
	
	
	 public Result authenticate() {
                    // Bind form instance to the values submitted from the form
                    Form<Level> levelForm = Form.form(Level.class).bindFromRequest();
                      // User user = User.getLoggedIn(session().get("email"))
                    if (levelForm.hasErrors()) {
                        // If errors, show the form again
						System.out.println("bad request Level");
                        return badRequest("/level");
                    }
                    
                    else {
						Player player = (Player)User.getLoggedIn(session().get("email"));
						Level level = Level.getUserLevel(player.level);
						player.score += level.points;
						if(!level.firstSolved){
							level.firstSolved = true;
							level.points --;
						}else if (level.firstSolved && !level.secondSolved){
							level.secondSolved = true;
							level.points --;
						}
					    level.update();		
						player.level++;
						player.update();
						System.out.println("level sucessfull ");
							
						return redirect("/level");
        }
    }
	
	public Result Level2(){
		
		System.out.println();
		
		return redirect("/level");
	}
	
	public Result  hint(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		Level level = Level.getUserLevel(player.level);
		if(player.hint == 0){
		player.hint = 1;
		player.score -= (level.points/2);
		player.update();
		}
		
		return redirect("/level");
	}
	
		public Result  solution(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		Level level = Level.getUserLevel(player.level);
		if(player.solution == 0){
		player.solution = 1;
		player.score -= level.points;
		player.update();
		}
		
		return redirect("/level");
	}
}