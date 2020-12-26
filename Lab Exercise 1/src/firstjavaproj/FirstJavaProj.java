package firstjavaproj;

/**
 *
 * @author Akezhan
 */
public class FirstJavaProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Duck norman = new Duck("Norman", 3);
        System.out.println(norman);
        norman.eat();
        norman.fly();
        norman.swim();
        
        System.out.println();
        
        Cat kity = new BritishCat("Kity");
        System.out.println(kity);
        kity.meow();
        kity.eat();
        
        System.out.println();
        
        Dog pit = new Pitbull("Pit"); //Pitbull set isBig = false by default in Pitbull class (Since they are small
        System.out.println(pit);
        pit.bark();
        pit.eat();
        
        System.out.println();
        
        Pitbull perry = new Pitbull("Perry");
        System.out.println(perry);
        perry.eat();
        perry.bark();
        perry.sitCommand();
        
        Dog cary = new Dog("Cary", true);        
        Cat gary = new Cat("Gary");
        BritishCat moki = new BritishCat("Moki");
        
        Pet[] animals = { pit, perry, kity, norman, cary, gary, moki };
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
            System.out.println(animals[i].getName());
            animals[i].eat();
            System.out.println();
        }
    }
}
