package firstjavaproj;

/**
 *
 * @author Akezhan
 */
public class Cat extends Pet {
    public Cat(String n) {
        super(n);
    }
    
    public void meow() {
        System.out.println("Meow...");
    }
    
    public void eat() {
        System.out.println("clurp, clurp...");
    }
    
    /**
     * @return the cat's name
     */
    public String toString() {
        return "Cat named " + getName();
    }
    
}
