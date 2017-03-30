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
public class AdminController extends Controller {
 // Display an empty form in the view
 //@Security.Authenticated(Secured.class)
 //@With(CheckIfAdmin.class)
 
    public Result index() {
		
		
       List<Player> player = Player.findAll();
        
        

        return ok(views.html.Admin.render(User.getLoggedIn(session().get("email")),player));

	}
	
	public Result getUsers(){
		
		List<User> user = User.findAllUsers();
        
        

        return ok(UserAdmin.render(User.getLoggedIn(session().get("email")),user));
		
	}
	
}