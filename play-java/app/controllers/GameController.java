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
public class GameController extends Controller {
 // Display an empty form in the view
 //@Security.Authenticated(Secured.class)
 //@With(CheckIfAdmin.class)
 
    public Result Level1() {
        return ok(views.html.level1.render(User.getLoggedIn(session().get("email"))));
	}
}