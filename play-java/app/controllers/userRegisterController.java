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
       
        Form<User> registerForm = Form.form(User.class);
        
        return ok(login.render(registerForm));  
	}
	
	
	
	
	
	 public Result registerFormSubmit() {
		 
			Form<User> newRegisterForm = Form.form(User.class).bindFromRequest();
			
			
		   if (newRegisterForm.hasErrors()) {
				//Display the form again
				System.out.println("badRequest but we got to here we did outputting this to log");
			
				return badRequest(login.render(newRegisterForm));
			}else{
				User player = newRegisterForm.get();
				player.save();
			}
			return ok(login.render(newRegisterForm));
	 }
	
	
}