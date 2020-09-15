//please work
//I'm not quite sure how to organize this help me aaaaaaaaaAAAAAAAAAAAAAAAAAAAAAAAAAAAa

/**
 * Holds a User in Macademia
 * @author Igtampe
 */
public class User{

    private final String Username;
    private final String Password;
    
    public User(String Username, String Password){
        this.Username=Username;
        this.Password=Password;
    }

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

}