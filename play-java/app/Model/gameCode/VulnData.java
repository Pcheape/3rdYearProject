package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;


@Entity
@Table(name="user")

Public class VulnData extends Model{
	
	@Id
	public long id;
	public String type;
	public String UserName;
	public String password;
	@Transient
	public List injectionReturn = Null;
	
	


public List sqlInjection(String query){
	
	try{
		this.injectionReturn = Ebean.find(Level2.class).where().eq("type",user).eq("UserName",query).findList();
	}catch(SQLException e){
		System.out.println("Sql injection"+e);
	}
	
}
	
}