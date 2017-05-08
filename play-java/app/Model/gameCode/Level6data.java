package models;

import java.util.*;
import java.sql.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;


@Entity

public class Level6data  extends Model {
	
	@Id
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
	
	

	
}