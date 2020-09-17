package macademia.backend.auth;

import macademia.backend.Student;

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
    public User(String Username, String Password){
        this.Username=Username;
        this.Password=Password;
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