package controllers;

import play.mvc.*;
import play.data.*;

import java.util.*;
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
		    boolean userFound = false;
			List<User> userList = User.find.all();
			Form<Player> newRegisterForm = Form.form(Player.class).bindFromRequest();
			User user = User.getLoggedIn(session().get("email"));
			
		   if (newRegisterForm.hasErrors()) {
				//Display the form again
				System.out.println("badRequest Outputting to log ");
			
				return badRequest(register.render(user,newRegisterForm));
				
			}else{
				Player player = newRegisterForm.get();
				for(int i = 0 ; i < userList.size();i++){
				        
						if(userList.get(i).getEmail().equals(player.getEmail())){
							
							userFound = true;
						}
					}
				if(!userFound){	
					Encrypt encryptDigest = new Encrypt();
					String newPassword = encryptDigest.calcPassword(player.getPassword());
					player.setPassword(newPassword);
					player.score=0;
					player.level=1;
					player.hint=0;
					player.solution=0;
					player.save();
				}else{
					return badRequest(register.render(user,newRegisterForm));
				}
			}
			Form<Login> loginForm = Form.form(Login.class);
			return ok(login.render(user,loginForm));
	 }
	 
	 
	
        
        

}