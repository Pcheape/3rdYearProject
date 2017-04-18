package controllers;

import java.sql.*;
import java.sql.Connection;
import java.util.*;
import play.data.*;
import views.html.levels.*;
import models.*;
import play.db.jpa.*;
import play.db.jpa.JPAApi;
import com.avaje.ebean.*;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import play.mvc.*;
import play.db.jpa.Transactional;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class GameController extends Controller {
 // Display an empty form in the view
 //@Security.Authenticated(Secured.class)
 //@With(CheckIfAdmin.class)
  private JPAApi jpaApi;
 @Inject
	public GameController(JPAApi api) {
		this.jpaApi = api;
	}
    public Result Level() {
		
		
		Player play = (Player)User.getLoggedIn(session().get("email"));
		Level tempLevel = new Level();
		tempLevel.id = play.level;
		Form<Level> levelForm = Form.form(Level.class).fill(tempLevel);
		System.out.println("levelForm : "+levelForm.field("id").value());
		
		switch(play.level){
			case 1:
				return ok(level1.render(User.getLoggedIn(session().get("email")),levelForm));
			
			case 2:
			List<Vulndata> results = null;
			
				return ok(level2.render(User.getLoggedIn(session().get("email")),levelForm,results));
			case 3:
			List<Level3data> results3 = null;
				return ok(level3.render(User.getLoggedIn(session().get("email")),levelForm,results3));
			
		}
		return ok();
			
	}
	
	
	
	

	
	
	 public Result authenticate() {
					System.out.println("Hit auth I did ");
                    // Bind form instance to the values submitted from the form
                    Form<Level> levelForm = Form.form(Level.class).bindFromRequest();
                      System.out.println("checking for errors ");
					  Player player = (Player)User.getLoggedIn(session().get("email"));
					  Level level = Level.getUserLevel(player.level);
                    if (levelForm.hasErrors()) {
                        // If errors, show the form again
						System.out.println("bad request Level");
                        return redirect("/level");
                    }
					
					else if(level.authenticate(player.level,levelForm.get().password)){
                    
                    
						
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
						System.out.println("level sucessful");
							
						return redirect("/level");
        }
		return redirect("/level");
    }
	
	
	@Transactional
	public Result Level2(){
		
		
		List<Vulndata> results = null;
		DynamicForm bindedQuery  = Form.form().bindFromRequest();
		String query = bindedQuery.get("query");
		Form<Level> levelForm = Form.form(Level.class);
		Player play = (Player)User.getLoggedIn(session().get("email"));
		
		Level tempLevel = new Level();
		tempLevel.id = play.level;
		
		try{
		results = this.sqlInjection(query);	
		}catch(SQLException e){
			
			System.out.println("ERROR"+e);
		}
		
		return ok(level2.render(User.getLoggedIn(session().get("email")),levelForm,results));
	}
	@Transactional
	public Result Level3()  throws SQLException{
		
			List<Level3data> results = null;
			Form<Level> levelForm = Form.form(Level.class);
			DynamicForm bindedQuery  = Form.form().bindFromRequest();
			String query = bindedQuery.get("type");
			String stm = "";
			
			if(query.equals("admin")){
				System.out.println("this will be admin sql"+query);
				 stm = "Select * from Level3data WHERE type= 'admin'";	
			}else{
				System.out.println("this will be user sql"+query);
				stm = "Select * from Level3data WHERE type= 'user'";
			}
			
				EntityManager em = jpaApi.em();
				results = new ArrayList<Level3data>();
	
				Connection conn = play.db.DB.getConnection();
		
				
						
				System.out.println(stm);
				
				ResultSet answer = conn.createStatement().executeQuery(stm);
				
				
				while(answer.next()){
					int id = answer.getInt(1);
					String type = answer.getString(2);
					String username = answer.getString(3);
					String password = answer.getString(4);
					Level3data addNew = new Level3data(id,type,username,password);
					results.add(addNew);
				}
							
					conn.close();
			
			return ok (level3.render(User.getLoggedIn(session().get("email")),levelForm,results));
		
	}
	
	
	
	@Transactional
	public  List sqlInjection(String input) throws SQLException{
	
	
		EntityManager em = jpaApi.em();
		List<Vulndata> results = new ArrayList<Vulndata>();
	
				Connection conn = play.db.DB.getConnection();
		
				
				String stm = "Select * from Vulndata WHERE type= 'user' AND username = '"+input+"'";		
				System.out.println(stm);
				
				ResultSet query = conn.createStatement().executeQuery(stm);
				
				
				while(query.next()){
					int id = query.getInt(1);
					String type = query.getString(2);
					String username = query.getString(3);
					String password = query.getString(4);
					Vulndata addNew = new Vulndata(id,type,username,password);
					results.add(addNew);
				}
							
					conn.close();
		return results;
	}
	
	public Result hint(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		Level level = Level.getUserLevel(player.level);
		if(player.hint == 0){
		player.hint = 1;
		player.score -= (level.points/2);
		player.update();
		}
		
		return redirect("/level");
	}
	
		public Result solution(String email){
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