package models;

import java.util.*;
import java.sql.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;

//Level 2 class so that vunrable code can access its own table and not get access to rest of database. 

@Entity

public class Vulndata  extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String type;
	public String username;
	public String password;
    
	public Vulndata(int id , String type, String username, String password){
		this.id = id;
		this.type = type;
		this.username = username; 
		this.password = password; 
	}
	
	
	
	public static Vulndata getAdmin()
	{
	  Vulndata admin = Ebean.find(Vulndata.class).where().eq("type","admin").findUnique();
	  return admin;
	}
	

	
}