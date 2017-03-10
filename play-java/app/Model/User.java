package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;


@Entity
@Table(name ="user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
@DiscriminatorValue("user")


public class User extends Model {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userID;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String email;

    
 
	
	
	public User(){
	}
	
	public User(String email, String password){
		
		this.password = password;
		this.email = email;	
	}


}