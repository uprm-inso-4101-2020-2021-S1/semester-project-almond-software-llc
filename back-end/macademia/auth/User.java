package macademia.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Holds a User in Macademia
 * @author Igtampe
 */
public class User{

	//-[Variables]----------------------------------------------------------------------
	
    private final String Username;
    private final String Password;
    
	//-[Constructors]----------------------------------------------------------------------
    
    /**
     * Creates a user using the following Username and Password.
     * @param Username
     * @param Password
     */
    public User(String Username, String Password) throws NoSuchAlgorithmException {
        this.Username=Username;
        this.Password=Hash(Password);
    }
	private static String Hash(String data) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		byte[] hash = digest.digest(data.getBytes());
		return bytesToStringHex(hash);
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	private static String bytesToStringHex(byte[] bytes) {

		char[] hexChars = new char[bytes.length*2];
		for (int i = 0; i < bytes.length; i++) {
			int j = bytes[i] & 0xFF;
			hexChars[i*2] = hexArray[j>>>4];
			hexChars[i*2+1] = hexArray[j & 0x0F];

		}
		return new String(hexChars);
	}

    /**
     * Creates a user using the given User
     * @param user
     */
    public User(User user) {
    	this.Username = user.Username;
    	this.Password = user.Password;
    }

	//-[Getters]----------------------------------------------------------------------
    
    /**
     * Gets the Username of this object
     * @return The username of this object
     */
    public String getUsername(){return Username;}

    /**
     * Gets the Password of this object
     * @return The Password of this object
     */
    public String getPassword(){return Password;}
    
    /**
     * Checks whether the password matches
     * @return True if the password matches, false otherwise.
     */
    public boolean checkPassword(String Password){return this.Password==Password;}
    
  //-[Overrides]----------------------------------------------------------------------
	
  	/**
  	 * Returns this username as a displayable string
  	 * @return Username
  	 */
  	public String toString() {return Username; 	}
  	
  	/**
  	 * Checks if an object is equal to this user
  	 * @param obj
  	 * @return True if and only if the object is not null, is an instance of User, and has the same Username
  	 */
  	public boolean equals(Object obj) {
  		if(obj==null) {return false;}
  		if(obj instanceof User) {
  			User OtherUser = (User)obj;
  			return OtherUser.Username==Username;
  		}
  		return false;
  	}
  	
}