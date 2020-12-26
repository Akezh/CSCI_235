package firstjavaproj;

/**
 * @author Akezhan
 */
public class Pitbull extends Dog {
    public Pitbull(String n) {
        super(n, false); // Since pitbulls are generally small
    }
    
    public void bark() {
        System.out.println("YAVV, GAVV!!!");
    }
    
    public void sitCommand() {
        System.out.println("uav (sits)");
    }
    
    public String toString() {
        return "Pitbull's name is " + getName();
    }
}
