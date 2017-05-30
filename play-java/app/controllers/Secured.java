package controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;
/**
 * This Controller handels user Authentication of both user and admins. 
 */

public class Secured extends Security.Authenticator {


    
    public String getUsername(Context ctx) {
		
		System.out.println("current user is " + ctx.session().get("email"));
		
        return ctx.session().get("email");
    }


    
    public Result onUnauthorized(Context ctx) {
        return redirect("/login");
    }
    
}