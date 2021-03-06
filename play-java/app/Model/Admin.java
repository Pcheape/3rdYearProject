package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import models.*;
import com.google.inject.Inject;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("admin")
//this is the admin model that is a type of user



public class Admin extends User{
	
	
	public Admin(String email,String password){
		super(email, password);	
	}
	
	public static Finder<Long, Admin> find = new Finder<Long,Admin>(Admin.class);
	
	
	public static List<Admin> findAll(){
		return Admin.find.all();
	}
}