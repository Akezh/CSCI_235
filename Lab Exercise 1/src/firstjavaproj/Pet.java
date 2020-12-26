package firstjavaproj;

/**
 * @author Akezhan
 */
public class Pet {
    private String name;
    
    /**
     * @param givenName means name of a pet
     */
    public Pet(String givenName) {
        name = givenName;
    }
    
    public String getName() {
        return name;
    }
    
    public void eat() {
        System.out.println("Nom, nom ...");
    }   
    
    /**
     * @return pet's name
     */
    public String toString() {
        return "Animal named " + name;
    }
}
