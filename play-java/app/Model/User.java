package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;


@Entity
public class User extends Model {

    @Id
    public int userID;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String loginName;
	
	
	public User(){
	}
	
	public User(int userID ,String email,String loginName, String password){
		this.userID = userID;
		this.password = password;
		this.email = email;
		this.loginName = loginName;
	}


}