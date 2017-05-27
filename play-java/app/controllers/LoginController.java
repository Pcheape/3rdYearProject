package controllers;

import play.mvc.*;
import views.html.*;
import java.util.*;
import play.data.*;
import models.User;
import models.Login;

public class LoginController extends Controller {

 
    public Result login() {
		
		Form<Login> loginForm = Form.form(Login.class);
		User user = User.getLoggedIn(session().get("email"));
        return ok(login.render(user,loginForm));
    }

	  // Process the user login form
   public Result authenticate() {
   // Bind form instance to the values submitted from the form
      Form<Login> loginForm = Form.form(Login.class).bindFromRequest();		
					
  //User.getLoggedIn(session().get("email"));
			//the has Errors checks the validate function in login if it returns anything but null it has errors 		
      if (loginForm.hasErrors()) {
         // If errors, show the form again
			System.out.println("bad request Login ");
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
            System.out.println("login sucessfull");
            // Return to home page
            return redirect("/");
        }
    }
    
    public Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect("/");
}
}