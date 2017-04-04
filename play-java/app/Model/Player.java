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
@DiscriminatorValue("player")



public class Player extends User{
	
	public int score;
	
	@Constraints.Required
	public String loginName;
	public int level;
	public int hint;
	public int solution;
	
	
	
	public Player(String email,String loginName, String password){
		super(email, password);
		score = 0;
		this.loginName = loginName;
		level = 1;
		hint = 0;
		solution=1;
		
	}
	
	public static Finder<Long, Player> find = new Finder<Long,Player>(Player.class);
	
	
	public static List<Player> findAll(){
		return Player.find.all();
	}
	
	
	public void setPlayerEmail(String email){
	   
	   super.setUserEmail(email);
   }
   
   public void setPlayerPassword(String password){
	   super.setUserPassword(password);
   }
   
   public void setPlayerName(String loginName){
	   this.loginName = loginName;
   }
}