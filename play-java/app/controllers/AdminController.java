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
	
	public Result editPlayer(String email)//renders the edit user page for based in the user seleceted by the admin
	  {		       
		List<Player> player = Player.find.all();	
		for(int i = 0 ; i < player.size();i++)
		{
			if(player.get(i).getEmail().equals(email))
			{				
				Form<Player> editPlayerForm = Form.form(Player.class).fill(player.get(i));
				 return ok(editPlayer.render(User.getLoggedIn(session().get("email")),editPlayerForm,player.get(i)));
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
							
						// System.out.println("checking "+user.get(i).getEmail()+"equals"+email);
						
					
						
                        user.get(i).setUserEmail(curUser.email);
						user.get(i).setUserPassword(curUser.password);
                        user.get(i).update();

						}
					}
                }
				return redirect("/admin");
            }
			
			public Result submitEditPlayer(String email) {
				Form<Player> editPlayerForm = Form.form(Player.class).bindFromRequest();
        //Creates a list of Users
			
				List<Player> player = Player.find.all();
				Player curPlayer = editPlayerForm.get();
				if (editPlayerForm.hasErrors()) {
					System.out.println("ERROR In Editing user ");
				return redirect("/admin");
			
				}else{
               
      
					for(int i = 0 ; i < player.size();i++)
					{
				        
						if(player.get(i).getEmail().equals(email))
						{
							
						// System.out.println("checking "+user.get(i).getEmail()+"equals"+email);					
						player.get(i).setPlayerName(curPlayer.loginName);						
                        player.get(i).setUserEmail(curPlayer.email);
						player.get(i).setUserPassword(curPlayer.password);
                        player.get(i).update();
						}
					}
                }
				return redirect("/admin");
            }
			
			public Result resetScoreboard(){
				
				List<Player> player = Player.find.all();
				
				for(int i = 0 ; i < player.size();i++){
					System.out.println("reseting score of player"+player.get(i)+" current score is "+player.get(i).score);
					player.get(i).score = 0;
					System.out.println("reset  "+player.get(i)+" current score is "+player.get(i).score);
					player.get(i).update();
				}
				return redirect("/admin");
			}
		}
	
