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
        
        return ok(register.render(registerForm));  
	}
	
	
	
	
	
	 public Result registerFormSubmit() {
		 
			Form<Player> newRegisterForm = Form.form(Player.class).bindFromRequest();
			
			
		   if (newRegisterForm.hasErrors()) {
				//Display the form again
				System.out.println("badRequest Outputting to log ");
			
				return badRequest(register.render(newRegisterForm));
			}else{
				Player player = newRegisterForm.get();
				player.save();
			}
			return ok(register.render(newRegisterForm));
	 }
	 
	 
	
        
        

}