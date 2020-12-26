package firstjavaproj;

/**
 * @author Akezhan
 */
public class Duck extends Pet {
    private int age; // age field to see whether duck could fly or not
    
    /**
     * @param n means name of a duck
     * @param a means age of a duck
     */
    public Duck(String n, int a) {
        super(n);
        age = a;
    }
    
    public void swim() {
        if (age > 2) {
            System.out.println("Can swim");
        } else {
            System.out.println("Not able to swim");
        }
    }
    
    // New method since ducks could fly
    public void fly() {
        if (age > 3) {
            System.out.println("Can fly");
        } else {
            System.out.println("Can not fly");
        }
    }
    
    // Overrided method since ducks eat things in other way.
    public void eat() {
        System.out.println("Cua Cua...");
    }
    
    /**
     * @return duck's name
     */
    public String toString() {
        return "Duck's named " + getName() + " and aged " + age;
    }
}
