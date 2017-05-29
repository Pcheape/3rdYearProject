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

 @Security.Authenticated(Secured.class)
 @With(CheckIfAdmin.class)
 
    public Result index() {
		
		
       List<Player> player = Player.findAll();
        
        

        return ok(views.html.Admin.render(User.getLoggedIn(session().get("email")),player));

	}
	
	public Result getUsers(){
		
		List<User> user = User.findAllUsers();
        
        

        return ok(UserAdmin.render(User.getLoggedIn(session().get("email")),user));
		
	}
	
	public Result getLevels(){
		List<Level> levels = Level.findAllLevels();
		return ok(LevelAdmin.render(User.getLoggedIn(session().get("email")),levels));
		
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
	
	public Result editPlayer(String email){		       
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
	
	public Result editLevel(int id){
		List<Level> levels = Level.find.all();
		for(int i = 0; i < levels.size();i++){
			if(levels.get(i).id == id){
				Form<Level> editLevelForm = Form.form(Level.class).fill(levels.get(i));
				return ok(editLevel.render(User.getLoggedIn(session().get("email")),editLevelForm,levels.get(i)));
			}
		}
		      return redirect("/admin");
	}
	
	public Result submitEditLevel(int id){
	Form<Level> editLevelForm = Form.form(Level.class).bindFromRequest();
	List<Level> levels = Level.find.all();
	Level curLevel = editLevelForm.get();
	if(editLevelForm.hasErrors()){
		flash("ERROR In Editing level");
		 return redirect("/admin");
	}else{
		
			for(int i = 0 ; i < levels.size();i++){
			if(levels.get(i).id == curLevel.id){
			levels.get(i).password = curLevel.password;
			levels.get(i).update();
			switch(levels.get(i).id){
				case 2: 
				Vulndata admin2 = Vulndata.getAdmin();
				admin2.password = curLevel.password;
				admin2.update();
				break;
				case 3: 
				Level3data admin3 = Level3data.getAdmin();
				admin3.password = curLevel.password;
				admin3.update();
				break;
				case 4: 
				Level4data admin4 = Level4data.getAdmin();
				admin4.password = curLevel.password;
				admin4.update();
				break;
				case 5: 
				Level5data admin5 = Level5data.getAdmin();
				admin5.password = curLevel.password;
				admin5.update();
				break;
				case 6: 
				Level6data admin6 = Level6data.getAdmin();
				admin6.password = curLevel.password;
				admin6.update();
				break;
			
				}
			}
		
		}
		return redirect("/admin");
	}
	}
	
	 public Result submitEditUser(String email) {
		
        Form<User> editPlayerForm = Form.form(User.class).bindFromRequest();
        //Creates a list of Users
        List<User> user = User.find.all();
	
        User curUser = editPlayerForm.get();
        if (editPlayerForm.hasErrors()) {
			flash("ERROR In Editing user ");
            return redirect("/admin");
			
        }else{
               
      
					for(int i = 0 ; i < user.size();i++)
					{
				        
						if(user.get(i).getEmail().equals(email))
						{
							
					Encrypt encryptDigest = new Encrypt();
					String newPassword = encryptDigest.calcPassword(curUser.password);
						
					
						
                        user.get(i).setUserEmail(curUser.email);
						user.get(i).setUserPassword(newPassword);
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
			
			public Result deletePlayers(){
				
				List<Player> player = Player.find.all();
				
				for(int i =0; i < player.size();i++)
				{
					player.get(i).delete();
				}
				return redirect("/admin");
			}
			
			public Result configGame(){
				return redirect("/getLevelAdmin");
			}
			
			public Result startGame(){
				Level.gameOn = true;
				return redirect("/admin");
			}
		}
	
