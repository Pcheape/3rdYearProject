package models;

import java.security.MessageDigest;

public class Encrypt {
	
	// code was a modified version of //https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java

    public String calcPassword(String password) {
		String salt = "Security in the game";
		password = password + salt;
        String output = "";
        try {
            MessageDigest encryptDigest = MessageDigest.getInstance("SHA-512");
            encryptDigest.update(password.getBytes());

            byte byteData[] = encryptDigest.digest();

//above just gives binary encoding now we need to convert to hex in order to save on database space. 


            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            output = hexString.toString();
        } catch (Exception e) {

          output="error";

        }
        return output;
    }

}