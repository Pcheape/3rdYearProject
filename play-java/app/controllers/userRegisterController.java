package controllers;

import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class userRegisterController extends Controller {
 // Display an empty form in the view
    public Result register() {
       
        Form<Player> registerForm = Form.form(Player.class);
		User user = User.getLoggedIn(session().get("email"));
        
        return ok(register.render(user, registerForm));  
	}
	
	
	
	
	
	 public Result registerFormSubmit() {
		 
			Form<Player> newRegisterForm = Form.form(Player.class).bindFromRequest();
			User user = User.getLoggedIn(session().get("email"));
			
		   if (newRegisterForm.hasErrors()) {
				//Display the form again
				System.out.println("badRequest Outputting to log ");
			
				return badRequest(register.render(user,newRegisterForm));
			}else{
				Player player = newRegisterForm.get();
				player.save();
			}
			return ok(register.render(user,newRegisterForm));
	 }
	 
	 
	
        
        

}