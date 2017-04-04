package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;
@Entity
@Table(name ="Level")
public class Level extends Model{
@Id 
public int id;
public String password;
public boolean firstSolved;
public boolean secondSolved;
public int points;



public static Finder<String,Level> find = new Finder<String,Level>(Level.class);

public Level(int id , String password , boolean firstSolved , boolean secondSolved, int points ){
	id = this.id;
	password = this.password;
	firstSolved = this.firstSolved;
	secondSolved = this.secondSolved;
	points = this.points;   
	}
	
	
	
	    public String validate() {
         
        /*CalcSHA cs = new CalcSHA();
        String md = cs.calcPassword(this.password);
        this.password = md;*/

        if (Level.authenticate(password) == null) {
            return "Invalid user or password";
        } else {
            return null;
        }
    }
	
	public static String authenticate(String password) {
        // If found return the user object with matching username and password
		if(password.equals("insecure"))
		{
        return "Sucess";
		}else{
			 return null;
			 }
		}
			
	

}