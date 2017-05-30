package models;

import models.*;
//Login class that validates the user login details using sha215 encryption. 
public class Login {
    public String email;
    public String password;
	
	
	public Login(){
		
	}

    public String validate() {
         Encrypt encryptDigest = new Encrypt();
		String newPassword = encryptDigest.calcPassword(this.password);
					this.password = newPassword;
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        } else {
            return null;
        }
    }
}