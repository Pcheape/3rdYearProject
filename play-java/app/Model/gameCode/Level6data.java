package models;

import java.util.*;
import java.sql.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;
//Level 6 class so that vunrable code can access its own table and not get access to rest of database. 

@Entity

public class Level6data  extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String type;
	public String username;
	public String password;
    
	public Level6data(int id , String type, String username, String password){
		this.id = id;
		this.type = type;
		this.username = username; 
		this.password = password; 
	}
	
	
public static Level6data getAdmin()
	{
	  Level6data admin = Ebean.find(Level6data.class).where().eq("type","admin").findUnique();
	  return admin;
	}
	
	
}