package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;


import java.sql.*;
import java.sql.Connection;
import java.util.*;
import play.data.*;
import views.html.levels.*;
import models.*;
import play.db.jpa.*;
import play.db.jpa.JPAApi;
import com.avaje.ebean.*;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import play.mvc.*;
import play.db.jpa.Transactional;


//The Level model this will record all the aspects of the Level however will not be accessed by //vulnrable code. 

@Entity
@Table(name ="Level")
public class Level extends Model{
@Id 
public int id;
public String password;
public boolean firstSolved;
public boolean secondSolved;
public int points;
@Transient
public static boolean gameOn = false;



public static Finder<Long,Level> find = new Finder<Long,Level>(Level.class);
public Level(){
	id=0;
	password = "";
	firstSolved = false;
	secondSolved = false;
	points = 0;
}
public Level(int id , String password , boolean firstSolved , boolean secondSolved, int points ){
	this.id = id;
	this.password = password;
	this.firstSolved = firstSolved;
	this.secondSolved = secondSolved;
	this.points = points; 
	}
	
	
public static List<Level> findAllLevels(){
		return Level.find.all();
	}
	
	//This is the authenticate method to make sure the user has passed the level. 
	
	public static boolean authenticate(int id, String password) {
    
		
		Level level = find.where().eq("id",id).findUnique();
		
		if(password.equals(level.password))
		{
        return true;
		}else{
		
		return false;
			 }
		}
		
	//This is the method that gets the users level and returns the level object
		
		public static Level getUserLevel(int id) {
        if (id == 0)
                return null;
        else
            
            return find.where().eq("id", id).findUnique();
		}
			
	

}