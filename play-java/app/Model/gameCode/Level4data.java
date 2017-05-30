package models;

import java.util.*;
import java.sql.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;
//Level 4 class so that vunrable code can access its own table and not get access to rest of database. 
@Entity

public class Level4data  extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String type;
	public String username;
	public String password;
    
	public Level4data(int id , String type, String username, String password){
		this.id = id;
		this.type = type;
		this.username = username; 
		this.password = password; 
	}
	
	
public static Level4data getAdmin()
	{
	  Level4data admin = Ebean.find(Level4data.class).where().eq("type","admin").findUnique();
	  return admin;
	}
	
	
}