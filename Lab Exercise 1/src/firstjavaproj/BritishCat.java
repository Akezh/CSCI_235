package firstjavaproj;

/**
 *
 * @author Akezhan
 */
public class BritishCat extends Cat {
    
    /**
     * @param n means name of Cat
     */
    public BritishCat(String n) {
        super(n);
    }
    
    public void play() {
        System.out.println("Jumping, playing");
    }
    
    public void eat() {
        System.out.println("Nyam, nyam");
    }
    
    /**
     * @return the British cat's name
     */
    public String toString() {
        return "The British cat named " + getName();
    }
}
