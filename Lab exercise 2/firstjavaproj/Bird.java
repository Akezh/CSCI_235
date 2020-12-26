package firstjavaproj;

public class Bird extends Pet {

  public Bird(String name) {
    super(name);
  }

  public void eat() {
    System.out.println("puppy om nom nom");
  }

  public void sing() {
    System.out.println("singing: random Disney song");
  }

  public String toString() {
    return "Bird named " + getName();
  }

  public static void test() {
    System.out.println("Testing: Bird...");

    {
      Bird a = new Bird("Disney Bird");
      System.out.println(a);
      a.eat();
      a.sing();
    }

    {
      Pet a = new Bird("Disney Bird Pet");
      System.out.println(a);
      a.eat();
    }
  }
}