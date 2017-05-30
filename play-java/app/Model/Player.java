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

// The player model that will store all statistics and details of the player a type of user. 

public class Player extends User implements Comparable<Player>{
	
	public int score;
	public int level;
	public int hint;
	public int solution;
	public int firstSolve;
	public int secondSolve;
	
	@Constraints.Required
	public String loginName;
	
	
	
	
	public Player(String email,String loginName, String password){
		super(email, password);
		this.loginName = loginName;
		this.score=0;
		this.level=1;
		this.hint=0;
		this.solution=0;
		this.firstSolve=0;
		this.secondSolve=0;
		
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
   
   public int compareTo (Player play) {
        return play.score-this.score;
	}
	
	public void setPassword(String password)
	{
		super.password = password;
	}
	
	public String getPassword()
	{
		return super.password;
	}
}