package models;

import models.*;

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