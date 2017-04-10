package models;

import java.util.*;
import java.sql.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;



public class VulnData  extends Model {
	
	@Id
	public long id;
	public String type;
	public String UserName;
	public String password;
	public List injectionReturn ;
	
	


public List sqlInjection(String query){
	
	
		//this.injectionReturn = Ebean.find(VulnData.class).where().eq("user",type).eq(query,UserName).findList();
		return this.injectionReturn;
	}
	
}