package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class GameController extends Controller {
 // Display an empty form in the view
 //@Security.Authenticated(Secured.class)
 //@With(CheckIfAdmin.class)
 
    public Result Level1() {
		Form<Level> levelForm = Form.form(Level.class);
        return ok(views.html.level1.render(User.getLoggedIn(session().get("email")),levelForm));
	}
	
	
	 public Result authenticate() {
                    // Bind form instance to the values submitted from the form
                    Form<Level> levelForm = Form.form(Level.class).bindFromRequest();
                      // User user = User.getLoggedIn(session().get("email"))
                    if (levelForm.hasErrors()) {
                        // If errors, show the form again
						System.out.println("bad request Level1");
                        return badRequest(level1.render(User.getLoggedIn(session().get("email")),levelForm));
                    }
                    
                    else {
						Player play = (Player)User.getLoggedIn(session().get("email"));
						play.score += 10;
						play.update();
						System.out.println("level sucessfull ");
							
						return redirect("/level1");
        }
    }
	
	public Result  hint(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		if(player.hint == 0){
		player.hint = 1;
		player.score -= 5;
		player.update();
		}
		
		return redirect("/level1");
	}
	
		public Result  solution(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		if(player.solution == 0){
		player.solution = 1;
		player.score -= 10;
		player.update();
		}
		
		return redirect("/level1");
	}
}