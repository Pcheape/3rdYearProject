package models;

import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;
import com.avaje.ebean.*;
import models.User;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("player")



public class Player extends User{
	
	public int score;
	
	@Constraints.Required
	public String loginName;
	
	public Player(){
	}
	
	public Player(String email,String loginName, String password){
		super( email, password);
		score = 0;
		this.loginName = loginName;
		
	}
	
	public static Finder<Long, Player> find = new Finder<Long,Player>(Player.class);
	
	
	public static List<Player> findAll(){
		return Player.find.all();
	}
}