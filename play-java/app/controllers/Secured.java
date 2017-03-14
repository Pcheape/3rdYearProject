package controllers;

import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Security;


public class Secured extends Security.Authenticator {


    
    public String getEmail(Context ctx) {
        return ctx.session().get("email");
    }


    
    public Result onUnauthorized(Context ctx) {
        return redirect("/login");
    }
    
}