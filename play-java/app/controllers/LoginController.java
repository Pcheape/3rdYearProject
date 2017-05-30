package controllers;

import play.mvc.*;
import views.html.*;
import java.util.*;
import play.data.*;
import models.User;
import models.Login;
//handles the login logic . 
public class LoginController extends Controller {

 
    public Result login() {
		
		Form<Login> loginForm = Form.form(Login.class);
		User user = User.getLoggedIn(session().get("email"));
        return ok(login.render(user,loginForm));
    }

	  // Process the user login form
   public Result authenticate() {
   
      Form<Login> loginForm = Form.form(Login.class).bindFromRequest();		
      if (loginForm.hasErrors()) {
   
			flash("ERROR","Invalid Username/password");
			User user = User.getLoggedIn(session().get("email"));
            return badRequest(login.render(user,loginForm));
            }else {						
            // SuperUser Logged in sucessfully
            // Clear the existing session
            session().clear();
            // Store the logged in email in the session
            session("email", loginForm.get().email);
            
            // Check user type
            User u = User.getLoggedIn(loginForm.get().email);
            // If admin - go to admin section
            if (u != null && "admin".equals(u.getUserType())) {
                return redirect("/admin");
            }
            // Return to home page
            return redirect("/");
        }
    }
    
    public Result logout() {
        session().clear();
        return redirect("/");
}
}