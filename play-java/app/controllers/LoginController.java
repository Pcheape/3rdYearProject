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
        return ok(login.render(loginForm));
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
            return badRequest(login.render(loginForm));
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
                return redirect("/");
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