package firstjavaproj;

public class Corgi extends Dog {

  public Corgi(String name) {
    super(name, false);
  }

  public void eat() {
    System.out.println("am corgi and am eat");
  }

  public void shakeBooty() {
    System.out.println("am corgi and am shakin my booty");
  }

  public String toString() {
    return "Corgi named " + getName();
  }

  public static void test() {
    System.out.println("Testing: Corgi...");

    {
      Corgi a = new Corgi("Fluffy Hot Corgi");
      System.out.println(a);
      a.eat();
      a.bark();
      a.shakeBooty();
    }

    {
      Dog a = new Corgi("Fluffy Hot CorgiDog");
      System.out.println(a);
      a.eat();
      a.bark();
    }
  }
}