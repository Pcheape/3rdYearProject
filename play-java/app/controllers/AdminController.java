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
	
	 public Result editUser(String email)//renders the edit user page for based in the user seleceted by the admin
	  {		       
		List<User> user = User.find.all();	
		for(int i = 0 ; i < user.size();i++)
		{
			if(user.get(i).getEmail().equals(email))
			{				
				Form<User> editUserForm = Form.form(User.class).fill(user.get(i));
				 return ok(editUser.render(User.getLoggedIn(session().get("email")),editUserForm,user.get(i)));
			}					
		}		
       return redirect("/admin");
	}
	
	
	 public Result submitEditUser(String email) {
		
        Form<User> editPlayerForm = Form.form(User.class).bindFromRequest();
        //Creates a list of Users
        List<User> user = User.find.all();
        User curUser = editPlayerForm.get();
        if (editPlayerForm.hasErrors()) {
			System.out.println("ERROR In Editing user ");
            return redirect("/admin");
			
        }else{
               
      
					for(int i = 0 ; i < user.size();i++)
					{
				        
						if(user.get(i).getEmail().equals(email))
						{
							System.out.println("checking "+user.get(i).getEmail()+"equals"+email);
                        user.get(i).setUserEmail(curUser.email);
						//User.get(i).setPlayerName(curUser.loginName);
						user.get(i).setUserPassword(curUser.password);
                        user.get(i).update();
						}
					}
                }
				return redirect("/admin");
            }
	
}