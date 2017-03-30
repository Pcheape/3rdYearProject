package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.*;


@Entity
@Table(name ="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
@DiscriminatorValue("user")


public class User extends Model {


    
	
    @Constraints.Required
    public String password;
	
	@Id
    @Constraints.Required
    public String email;
	
	public static Finder<Long,User> find = new Finder<Long,User>(User.class);
	
	public @Inject User(String email, String password){
		
		this.password = password;
		this.email = email;	
	}
	
	//List<User> user = User.find.all();
	
	public static User getLoggedIn(String email) {
        if (email == null)
                return null;
        else
            // Find user by id and return object
            return find.where().eq("email", email).findUnique();
}



    public String getUserType(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );
        return val == null ? null : val.value();
	}
	
	  public static User authenticate(String email, String password) {
        // If found return the user object with matching username and password
        return find.where().eq("email", email).eq("password", password).findUnique();
	}
	
	public static List<User> findAllUsers(){
		return User.find.all();
	}
	
   public String getEmail(){
	   
	   return this.email;
   }
   
   public void setUserEmail(String email){
	   
	   this.email = email;
   }
   
   public void setUserPassword(String password){
	   this.password = password;
   }




}