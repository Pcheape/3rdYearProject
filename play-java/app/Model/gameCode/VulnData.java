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

public class Vulndata  extends Model {
	
	@Id
	public long id;
	public String type;
	public String username;
	public String password;
    
	
	

	
}