package controllers;

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
		Form<Level> levelForm = Form.form(Level.class);
		Player play = (Player)User.getLoggedIn(session().get("email"));
		
		
		switch(play.level){
			case 1:
				return ok(level1.render(User.getLoggedIn(session().get("email")),levelForm));
			
			case 2:
			List<Vulndata> results = null;
				return ok(level2.render(User.getLoggedIn(session().get("email")),levelForm,results));
			
		}
		return ok();
			
	}
	

	
	
	 public Result authenticate() {
                    // Bind form instance to the values submitted from the form
                    Form<Level> levelForm = Form.form(Level.class).bindFromRequest();
                      // User user = User.getLoggedIn(session().get("email"))
                    if (levelForm.hasErrors()) {
                        // If errors, show the form again
						System.out.println("bad request Level");
                        return badRequest("/level");
                    }
                    
                    else {
						Player player = (Player)User.getLoggedIn(session().get("email"));
						Level level = Level.getUserLevel(player.level);
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
						System.out.println("level sucessfull ");
							
						return redirect("/level");
        }
    }
	
	
	@Transactional
	public Result Level2(){
		DynamicForm bindedQuery  = Form.form().bindFromRequest();
		String query = bindedQuery.get("query");
		System.out.println(query+"Query");
		Form<Level> levelForm = Form.form(Level.class);
		Player play = (Player)User.getLoggedIn(session().get("email"));
		List<Vulndata> results = this.sqlInjection(query);	
		
		return ok(level2.render(User.getLoggedIn(session().get("email")),levelForm,results));
	}
	
	
	
	@Transactional
	public  List sqlInjection(String input){
	
	
		EntityManager em = jpaApi.em();
	
		//List<VulnData> results = Ebean.find(VulnData.class).where().eq("UserName",input).findList();
		Query query = em.createQuery("Select username,password from Vulndata WHERE username = '" + input+"'");
		List  results = query.getResultList();
		System.out.println("RESULTS HERE"+input);
		for(int i = 0; i < results.size();i++){
			System.out.println(results.get(i));
		}
		//List<VulnData> results = JPA.em().createQuery("SELECT * from Stuff WHERE type= " + theType);

		return results;
	}
	
	public Result  hint(String email){
		Player player = (Player)User.getLoggedIn(session().get("email"));
		Level level = Level.getUserLevel(player.level);
		if(player.hint == 0){
		player.hint = 1;
		player.score -= (level.points/2);
		player.update();
		}
		
		return redirect("/level");
	}
	
		public Result  solution(String email){
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