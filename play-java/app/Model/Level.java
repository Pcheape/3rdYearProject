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
	
	
	public static boolean authenticate(int id, String password) {
    
		System.out.println("the id is "+id);
		
		Level level = find.where().eq("id",id).findUnique();
		
		if(password.equals(level.password))
		{
        return true;
		}else{
			System.out.println("invalid auth");
			 return false;
			 }
		}
		
		
		
		public static Level getUserLevel(int id) {
        if (id == 0)
                return null;
        else
            
            return find.where().eq("id", id).findUnique();
		}
			
	

}